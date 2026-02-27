package com.example.smsapp.ui.outgoing.v9

import android.os.Build
<<<<<<< HEAD
import android.widget.Toast
=======
>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
<<<<<<< HEAD
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
=======
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smsapp.ui.common.SmsPermissionLoader
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.outgoing.components.OutgoingTabs
import com.example.smsapp.viewmodel.InboxViewModel
import com.example.smsapp.viewmodel.SmsViewModel
import com.example.smsapp.viewmodel.TimeGroup
<<<<<<< HEAD
import kotlinx.coroutines.delay
=======
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.smsapp.ui.outgoing.v7.OutgoingMessageListV7
>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutgoingScreenV9(
    viewModel: InboxViewModel = viewModel(),
    smsViewModel: SmsViewModel = viewModel(),
    openDrawer: () -> Unit,
    navigateToSend: (String, String) -> Unit,
    inHeadLabel: String = "Outgoing V9"
) {
    val grouped by viewModel.grouped.collectAsState()
    var tab by remember { mutableStateOf(TimeGroup.TODAY) }
<<<<<<< HEAD
=======
    val smsViewModel: SmsViewModel = viewModel()
>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538
    var tick by remember { mutableStateOf(0) }
    val context = LocalContext.current

    SmsPermissionLoader(onGranted = { viewModel.loadOutgoingMessages(it) }) {
<<<<<<< HEAD
=======
        // existing Scaffold here
>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538
        LaunchedEffect(Unit) {
            while (true) {
                delay(60000)
                tick++
            }
        }

        Scaffold(
            topBar = {
                AppTopBar(
                    title = inHeadLabel,
                    showBack = false,
                    onMenuClick = openDrawer
                )
            }
        ) { padding ->
<<<<<<< HEAD
=======

>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538
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

<<<<<<< HEAD
                OutgoingMessageListV9(
=======
                OutgoingMessageListV7(
>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538
                    messages = grouped[tab] ?: emptyList(),
                    tick = tick,
                    onItemClick = { sms ->
                        smsViewModel.prepareResend(sms)
                        navigateToSend(sms.address, sms.body)
                    }
                )

                LaunchedEffect(tick, grouped[tab]) {
<<<<<<< HEAD
                    if (tick > 0) {
                        Toast.makeText(context, "UI Refreshed V9", Toast.LENGTH_SHORT).show()
                    }
                }
=======
                    Toast.makeText(context, "UI Refreshed", Toast.LENGTH_SHORT).show()
                }

                tick

>>>>>>> 44add2766ff4005ef8fe3e3afbd2915edf269538
            }
        }
    }
}
