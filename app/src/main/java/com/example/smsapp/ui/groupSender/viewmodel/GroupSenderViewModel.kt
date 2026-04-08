package com.example.smsapp.ui.groupSender.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.smsapp.data.SmsReaderRepository
import kotlinx.coroutines.flow.MutableStateFlow

class GroupSenderViewModel : ViewModel() {
    val grouped = MutableStateFlow<Map<String, Int>>(emptyMap())

    fun load(context: Context) {
        val msgs = SmsReaderRepository(context).getInboxMessages()
        grouped.value = msgs.groupBy { it.address }
            .mapValues { it.value.size }
    }
}