package com.example.smsapp.ui.outgoing.v8

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.smsapp.data.SmsMessage

@Composable
fun OutgoingMessageListV7(
    messages: List<SmsMessage>,
    onItemClick: (SmsMessage) -> Unit
) {

    if (messages.isEmpty()) {
        // You can create a new empty state composable for V7 if you want
        // OutgoingEmptyStateV7()
        return
    }

    LazyColumn {
        items(messages) { sms ->
            OutgoingMessageItemV7(
                sms = sms,
                onClick = onItemClick
            )
        }
    }
}