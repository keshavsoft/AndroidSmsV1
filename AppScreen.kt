package com.example.smsapp

sealed class AppScreen(
    val route: String,
    val title: String
) {

    // Send Screens
    object SendV1 : AppScreen("send_v1","Send V1")
    object SendV2 : AppScreen("send_v2","Send V2")
    object SendV3 : AppScreen("send_v3","Send V3")
    object SendV4 : AppScreen("send_v4","Send V4")

    // Inbox Screens
    object InboxV1 : AppScreen("inbox_v1","Inbox V1")
    object InboxV2 : AppScreen("inbox_v2","Inbox V2")

    // Incoming Screens
    object InboxIncomingV1 : AppScreen("Inbox_incoming_v1","Incoming V1")
    object InboxIncomingV2 : AppScreen("Inbox_incoming_v2","Incoming V2")
    object InboxIncomingV3 : AppScreen("Inbox_incoming_v3","Incoming V3")
    object InboxIncomingV4 : AppScreen("Inbox_incoming_v4","Incoming V4")
    object InboxIncomingV5 : AppScreen("Inbox_incoming_v5","Incoming V5")
    object InboxIncomingV6 : AppScreen("Inbox_incoming_v6","Incoming V6")
    object InboxIncomingV7 : AppScreen("Inbox_incoming_v7","Incoming V7")
    object InboxIncomingV8 : AppScreen("Inbox_incoming_v8","Incoming V8")
    object InboxIncomingV9 : AppScreen("Inbox_incoming_v9","Incoming V9")

    // Outgoing Screens
    object OutgoingV1 : AppScreen("outgoing_v1","Outgoing V1")
    object OutgoingV2 : AppScreen("outgoing_v2","Outgoing V2")
    object OutgoingV3 : AppScreen("outgoing_v3","Outgoing V3")
    object OutgoingV4 : AppScreen("outgoing_v4","Outgoing V4")
    object OutgoingV5 : AppScreen("outgoing_v5","Outgoing V5")
    object OutgoingV6 : AppScreen("outgoing_v6","Outgoing V6")
    object OutgoingV7 : AppScreen("outgoing_v7","Outgoing V7")

    // Sent
    object SentV1 : AppScreen("sent_v1", "Sent V1")

    companion object {

        val drawerStructure = listOf(

            DrawerSection(
                "Send",
                listOf(SendV1,SendV2,SendV3,SendV4)
            ),

            DrawerSection(
                "Inbox",
                listOf(InboxV1,InboxV2)
            ),

            DrawerSection(
                "Incoming",
                listOf(
                    InboxIncomingV1,
                    InboxIncomingV2,
                    InboxIncomingV3,
                    InboxIncomingV4,
                    InboxIncomingV5,
                    InboxIncomingV6,
                    InboxIncomingV7,
                    InboxIncomingV8,
                    InboxIncomingV9
                ),
                scrollable = true
            ),

            DrawerSection(
                "Outgoing",
                listOf(
                    OutgoingV1,
                    OutgoingV2,
                    OutgoingV3,
                    OutgoingV4,
                    OutgoingV5,
                    OutgoingV6,
                    OutgoingV7
                ),
                scrollable = true
            ),

            DrawerSection(
                "Sent",
                listOf(SentV1)
            )
        )
    }
}

data class DrawerSection(

    val title:String,

    val children:List<AppScreen>,

    val scrollable:Boolean=false

)