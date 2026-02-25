package com.example.smsapp.ui.navigation.incoming

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.smsapp.AppScreen
import com.example.smsapp.ui.incoming.v1.IncomingScreenV1
import com.example.smsapp.ui.incoming.v2.IncomingScreenV2
import com.example.smsapp.ui.incoming.v3.IncomingScreenV3
import com.example.smsapp.ui.incoming.v4.IncomingScreenV4
import com.example.smsapp.ui.incoming.v5.IncomingScreenV5
import com.example.smsapp.ui.incoming.v6.IncomingScreenV6
import com.example.smsapp.ui.incoming.v7.IncomingScreenV7
import com.example.smsapp.ui.incoming.v8.IncomingScreenV8
import android.net.Uri
import com.example.smsapp.ui.incoming.v9.IncomingScreenV9

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.incomingListGraph(
    navController: NavController,
    openDrawer: () -> Unit
) {
    composable(AppScreen.InboxIncomingV1.route) {
        IncomingScreenV1(openDrawer = openDrawer)
    }

    composable(AppScreen.InboxIncomingV2.route) {
        IncomingScreenV2(openDrawer = openDrawer)
    }

    composable(AppScreen.InboxIncomingV3.route) {
        IncomingScreenV3(
            openDrawer = openDrawer,
            navigateToSend = { phone, msg ->
                navController.navigate(
                    AppScreen.SendV3.route + "?phone=$phone&msg=$msg"
                )
            }
        )
    }

    composable(AppScreen.InboxIncomingV4.route) {
        IncomingScreenV4(
            openDrawer = openDrawer,
            navigateToSend = { phone, msg ->
                navController.navigate(
                    AppScreen.SendV3.route + "?phone=$phone&msg=$msg"
                )
            }
        )
    }

    composable(AppScreen.InboxIncomingV5.route) {
        IncomingScreenV5(
            openDrawer = openDrawer,
            navigateToThread = { address ->
                navController.navigate("incoming_v5_thread?address=$address")
            }
        )
    }

    composable(AppScreen.InboxIncomingV6.route) {
        IncomingScreenV6(
            openDrawer = openDrawer,
            navigateToThread = { address ->
                navController.navigate("incoming_v6_thread?address=$address")
            }
        )
    }

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
    composable(AppScreen.InboxIncomingV9.route) {
        IncomingScreenV9(
            openDrawer = openDrawer,
            navigateToThread = { number, name ->
                val n = Uri.encode(number)
                val t = Uri.encode(name)
                navController.navigate("incoming_v8_thread?number=$n&name=$t")
            }
        )
    }


}