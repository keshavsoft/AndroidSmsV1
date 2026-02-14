package com.example.smsapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.*
import com.example.smsapp.ui.SmsScreen
import com.example.smsapp.ui.inbox.v1.InboxScreenV1
import com.example.smsapp.ui.inbox.v2.InboxScreenV2
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestSmsPermission()

        setContent {

            MaterialTheme {

                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                var inboxExpanded by remember { mutableStateOf(false) }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {

                            // Header
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primary)
                                    .padding(24.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(64.dp)
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "KeshavSoft",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )

                                Text(
                                    text = "+91 98481 63021",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            val currentRoute =
                                navController.currentBackStackEntryAsState().value
                                    ?.destination?.route ?: ""

                            LaunchedEffect(currentRoute) {
                                if (currentRoute == AppScreen.Send.route) {
                                    inboxExpanded = false
                                }
                            }
                            // Send SMS
                            NavigationDrawerItem(
                                label = { Text("Send SMS") },
                                selected = currentRoute == AppScreen.Send.route,
                                onClick = {
                                    navController.navigate(AppScreen.Send.route)
                                    scope.launch { drawerState.close() }
                                }
                            )

                            // Inbox Parent
                            NavigationDrawerItem(
                                label = { Text("Inbox") },
                                selected = false,
                                onClick = { inboxExpanded = !inboxExpanded },
                                icon = {
                                    Icon(
                                        imageVector = if (inboxExpanded)
                                            Icons.Default.ExpandLess
                                        else
                                            Icons.Default.ExpandMore,
                                        contentDescription = null
                                    )
                                }
                            )

                            // Inbox Children
                            if (inboxExpanded) {

                                NavigationDrawerItem(
                                    label = { Text("Inbox V1") },
                                    selected = currentRoute == AppScreen.InboxV1.route,
                                    onClick = {
                                        navController.navigate(AppScreen.InboxV1.route)
                                        scope.launch { drawerState.close() }
                                    },
                                    modifier = Modifier.padding(start = 24.dp)
                                )

                                NavigationDrawerItem(
                                    label = { Text("Inbox V2") },
                                    selected = currentRoute == AppScreen.InboxV2.route,
                                    onClick = {
                                        navController.navigate(AppScreen.InboxV2.route)
                                        scope.launch { drawerState.close() }
                                    },
                                    modifier = Modifier.padding(start = 24.dp)
                                )
                            }
                        }
                    }
                ) {

                    NavHost(
                        navController = navController,
                        startDestination = AppScreen.Send.route
                    ) {

                        composable(AppScreen.Send.route) {
                            SmsScreen(
                                openDrawer = {
                                    scope.launch { drawerState.open() }
                                }
                            )
                        }

                        composable(AppScreen.InboxV1.route) {
                            InboxScreenV1(
                                openDrawer = {
                                    scope.launch { drawerState.open() }
                                }
                            )
                        }

                        composable(AppScreen.InboxV2.route) {
                            InboxScreenV2(
                                openDrawer = {
                                    scope.launch { drawerState.open() }
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun requestSmsPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)
        }
    }
}