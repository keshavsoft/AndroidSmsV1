package com.example.smsapp.ui.incoming.v4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.incoming.common.IncomingPermission
import com.example.smsapp.ui.incoming.common.IncomingTimeGroup
import com.example.smsapp.ui.incoming.common.groupIncoming
import com.example.smsapp.ui.incoming.common.loadIncomingSms

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomingScreenV4(
    openDrawer: () -> Unit,
    navigateToSend: (String, String) -> Unit,
    inHeadLabel: String = "Incoming V4"
)
{
    val context = LocalContext.current
    var messages by remember { mutableStateOf<List<SmsMessage>>(emptyList()) }
    var selectedGroup by remember { mutableStateOf(IncomingTimeGroup.TODAY) }
    val grouped = remember(messages) { groupIncoming(messages) }

    val filteredMessages = grouped[selectedGroup] ?: emptyList()

    IncomingPermission(context) {
        messages = loadIncomingSms(context)
    }

    Scaffold(
        topBar = {
            AppTopBar(title = inHeadLabel, showBack = false, onMenuClick = openDrawer)
        }
    )
    { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {

            IncomingTabsV4(
                selected = selectedGroup,
                onSelected = { selectedGroup = it },
                counts = grouped.mapValues { it.value.size }
            )

            IncomingListUIForV4(
                messages = filteredMessages,
                modifier = Modifier.fillMaxSize(),
                onOpenClick = { sms ->
                    navigateToSend(sms.address, sms.body)
                }
            )
        }
    }
}