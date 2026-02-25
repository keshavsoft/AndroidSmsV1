package com.example.smsapp.ui.outgoing.v8

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.data.SmsReaderRepository
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.outgoing.components.OutgoingMessageList

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutgoingScreenV8(
    openDrawer: () -> Unit,
    navigateToThread: (String) -> Unit,
    inHeadLabel: String = "Outgoing V8"
) {
    val context = LocalContext.current
    var messages by remember { mutableStateOf<List<SmsMessage>>(emptyList()) }
    val repository = remember { SmsReaderRepository(context) }

    LaunchedEffect(Unit) {
        messages = repository.getOutgoingMessages()
    }

    Scaffold(
        topBar = {
            AppTopBar(title = inHeadLabel, showBack = false, onMenuClick = openDrawer)
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            OutgoingMessageList(
                messages = messages,
                onItemClick = { message ->
                    navigateToThread(message.address)
                }
            )
        }
    }
}