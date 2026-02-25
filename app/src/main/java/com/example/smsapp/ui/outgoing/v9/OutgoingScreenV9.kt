package com.example.smsapp.ui.outgoing.v9

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
import com.example.smsapp.contacts.data.loadContacts
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.data.SmsReaderRepository
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.incoming.common.IncomingPermission
import com.example.smsapp.ui.incoming.common.groupBySenderV1
import com.example.smsapp.ui.incoming.conversationtypes.groupbysenderV1.IncomingConversationListGroupSenderV1

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutgoingScreenV9(
    openDrawer: () -> Unit,
    navigateToThread: (String) -> Unit,
    inHeadLabel: String = "Outgoing V9"
) {
    val context = LocalContext.current
    var messages by remember { mutableStateOf<List<SmsMessage>>(emptyList()) }
    var contactsMap by remember { mutableStateOf<Map<String, String>>(emptyMap()) }
    val repository = remember { SmsReaderRepository(context) }

    val conversations = remember(messages, contactsMap) { groupBySenderV1(messages, contactsMap) }

    IncomingPermission(context) {
        messages = repository.getOutgoingMessages()
        contactsMap = loadContacts(context)
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
            IncomingConversationListGroupSenderV1(
                conversations = conversations,
                modifier = Modifier.fillMaxSize(),
                onOpenConversation = { convo ->
                    navigateToThread(convo.phoneNumber)
                }
            )
        }
    }
}