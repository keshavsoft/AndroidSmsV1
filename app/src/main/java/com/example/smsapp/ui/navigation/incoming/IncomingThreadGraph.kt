package com.example.smsapp.ui.navigation.incoming

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.smsapp.ui.incoming.v7.IncomingConversationThreadScreenV7
import com.example.smsapp.ui.incoming.v8.IncomingConversationThreadScreenV8

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.incomingThreadGraph(
    navController: NavController
) {
    composable(
        route = "incoming_v7_thread?address={address}",
        arguments = listOf(
            navArgument("address") { defaultValue = "" }
        )
    ) { backStack ->

        val address = backStack.arguments?.getString("address") ?: ""

        IncomingConversationThreadScreenV7(
            address = address,
            openDrawer = { navController.popBackStack() }
        )
    }

    composable(
        route = "incoming_v8_thread?number={number}&name={name}",
        arguments = listOf(
            navArgument("number") { defaultValue = "" },
            navArgument("name") { defaultValue = "" }
        )
    ) { backStack ->
        val number = backStack.arguments?.getString("number") ?: ""
        val name = backStack.arguments?.getString("name") ?: ""
        IncomingConversationThreadScreenV8(number, name) { navController.popBackStack() }
    }

}