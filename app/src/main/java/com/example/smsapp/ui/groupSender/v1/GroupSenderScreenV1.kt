package com.example.smsapp.ui.groupSender.v1

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.remote.creation.first
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smsapp.ui.groupSender.viewmodel.GroupSenderViewModel

@Composable
fun GroupSenderScreen(vm: GroupSenderViewModel = viewModel()){
    val data by vm.grouped.collectAsState()
    LazyColumn { items(data.toList()){ Text("${it.first} : ${it.second}") } }
}