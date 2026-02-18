package com.example.smsapp.ui.outgoing.v7

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smsapp.ui.common.SmsPermissionLoader
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.outgoing.components.OutgoingTabs
import com.example.smsapp.viewmodel.InboxViewModel
import com.example.smsapp.viewmodel.SmsViewModel
import com.example.smsapp.viewmodel.TimeGroup

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutgoingScreenV7(
    viewModel: InboxViewModel = viewModel(),
    smsViewModel: SmsViewModel = viewModel(),
    openDrawer: () -> Unit,
    navigateToSend: (String, String) -> Unit
) {
    val grouped by viewModel.grouped.collectAsState()
    var tab by remember { mutableStateOf(TimeGroup.TODAY) }

    SmsPermissionLoader(onGranted = { viewModel.loadOutgoingMessages(it) }) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = "Outgoing V7",
                    showBack = false,
                    onMenuClick = openDrawer
                )
            }
        ) { padding ->

            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                val counts = grouped.mapValues { it.value.size }

                OutgoingTabs(
                    selected = tab,
                    counts = counts,
                    onSelected = { tab = it }
                )

                OutgoingMessageListV7(
                    messages = grouped[tab] ?: emptyList(),
                    onItemClick = { sms ->
                        smsViewModel.prepareResend(sms)
                        navigateToSend(sms.address, sms.body)
                    }
                )
            }
        }
    }
}