package com.example.smsapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.smsapp.AppScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost(
    navController: NavHostController,
    openDrawer: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.SendV1.route
    ) {
        sendGraph(            openDrawer = openDrawer        )

        InboxGraph(            openDrawer = openDrawer        )

        incomingGraph(            openDrawer = openDrawer        )

        outgoingGraph(
            navController = navController,
            openDrawer = openDrawer
        )
    }
}