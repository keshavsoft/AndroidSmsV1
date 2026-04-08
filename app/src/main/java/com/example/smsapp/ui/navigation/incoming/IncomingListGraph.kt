package com.example.smsapp.ui.navigation.incoming

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.smsapp.AppScreen
import com.example.smsapp.ui.incoming.v7.IncomingScreenV7
import com.example.smsapp.ui.incoming.v8.IncomingScreenV8
import android.net.Uri

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.incomingListGraph(
    navController: NavController,
    openDrawer: () -> Unit
) {
    composable(AppScreen.InboxIncomingV7.route) {
        IncomingScreenV7(
            openDrawer = openDrawer,
            navigateToThread = { address ->
                navController.navigate("incoming_v6_thread?address=$address")
            }
        )
    }

    composable(AppScreen.InboxIncomingV8.route) {
        IncomingScreenV8(
            openDrawer = openDrawer,
            navigateToThread = { number, name ->
                val n = Uri.encode(number)
                val t = Uri.encode(name)
                navController.navigate("incoming_v8_thread?number=$n&name=$t")
            }
        )
    }

}