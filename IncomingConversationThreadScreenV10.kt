package com.example.smsapp.ui.incoming.v10

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.incoming.common.ChatBubbleIncoming
import com.example.smsapp.ui.incoming.common.loadIncomingSms

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomingConversationThreadScreenV10(
    address: String,
    threadId: String,
    onBackClick: () -> Unit
) {

    val context = LocalContext.current
    var messages by remember { mutableStateOf<List<SmsMessage>>(emptyList()) }

    LaunchedEffect(address, threadId) {
        messages = loadIncomingSms(context)
            .filter { it.threadId.toString() == threadId }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = address,
                showBack = true,
                onBackClick = onBackClick
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            reverseLayout = true
        ) {
            items(messages) { sms ->
                ChatBubbleIncoming(sms.body)
            }
        }
    }
}