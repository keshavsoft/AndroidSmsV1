package com.example.smsapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.smsapp.AppScreen
import com.example.smsapp.ui.incoming.v1.IncomingScreenV1

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.incomingGraph(
    openDrawer: () -> Unit
) {

    composable(AppScreen.InboxIncomingV1.route) {
        IncomingScreenV1(openDrawer = openDrawer)
    }
}