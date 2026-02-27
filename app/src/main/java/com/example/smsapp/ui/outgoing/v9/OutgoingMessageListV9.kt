package com.example.smsapp.ui.outgoing.v9

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.outgoing.components.formatTimeAgoWithTick

@Composable
fun OutgoingMessageListV9(
    messages: List<SmsMessage>,
    tick: Int,
    onItemClick: (SmsMessage) -> Unit
) {
    if (messages.isEmpty()) {
        OutgoingEmptyStateV9()
        return
    }

    LazyColumn {
        items(messages) { sms ->
            OutgoingMessageItemV9(
                sms = sms,
                timeAgo = formatTimeAgoWithTick(sms.date, tick),
                onClick = onItemClick
            )
        }
    }
}
