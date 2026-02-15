package com.example.smsapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.smsapp.AppScreen
import com.example.smsapp.ui.sendsms.v1.SendSmsScreenV1
import com.example.smsapp.ui.inbox.v1.InboxScreenV1
import com.example.smsapp.ui.inbox.v2.InboxScreenV2
import com.example.smsapp.ui.incoming.v1.IncomingScreenV1
import com.example.smsapp.ui.outgoing.v1.OutgoingScreenV1
import com.example.smsapp.ui.outgoing.v2.OutgoingScreenV2
import com.example.smsapp.ui.outgoing.v3.OutgoingScreenV3
import com.example.smsapp.ui.outgoing.v4.OutgoingScreenV4
import com.example.smsapp.ui.sendsms.v2.SendSmsScreenV2
import com.example.smsapp.ui.sendsms.v3.SendSmsScreenV3

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

        composable(AppScreen.SendV1.route) {
            SendSmsScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.SendV2.route) {
            SendSmsScreenV2(openDrawer = openDrawer)
        }

        composable(
            route = AppScreen.SendV3.route + "?phone={phone}&msg={msg}",
            arguments = listOf(
                navArgument("phone") { defaultValue = "" },
                navArgument("msg") { defaultValue = "" }
            )
        ) { backStack ->

            val phone = backStack.arguments?.getString("phone") ?: ""
            val msg = backStack.arguments?.getString("msg") ?: ""

            SendSmsScreenV3(
                openDrawer = openDrawer,
                prefillPhone = phone,
                prefillMessage = msg
            )
        }

        composable(AppScreen.InboxV1.route) {
            InboxScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.InboxV2.route) {
            InboxScreenV2(openDrawer = openDrawer)
        }

        composable(AppScreen.InboxIncomingV1.route) {
            IncomingScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.OutgoingV1.route) {
            OutgoingScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.OutgoingV2.route) {
            OutgoingScreenV2(openDrawer = openDrawer)
        }

        composable(AppScreen.OutgoingV3.route) {

            OutgoingScreenV3(
                openDrawer = openDrawer,
                navigateToSend = { phone, msg ->
                    navController.navigate(
                        AppScreen.SendV3.route + "?phone=$phone&msg=$msg"
                    )
                }
            )
        }

        composable(AppScreen.OutgoingV4.route) {
            OutgoingScreenV4(
                openDrawer = openDrawer,
                navigateToSend = { phone, msg ->
                    navController.navigate(
                        AppScreen.SendV3.route + "?phone=$phone&msg=$msg"
                    )
                }
            )
        }
    }
}