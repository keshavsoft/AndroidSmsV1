Below is a **single README.md** that covers **both Incoming & Outgoing (V8)** clearly.
You can **copy-paste** this directly into your project root.

---

# 📩 SMS App – Incoming & Outgoing V8 README

This README explains how to **create Incoming V8 and Outgoing V8** screens in Android Studio by **copying the V7 structure** and updating routes, drawer items, packages, and navigation.

---

## 📂 Project Structure (After V8)

```
ui/
 ├─ incoming/
 │   ├─ v7/
 │   └─ v8/
 │       └─ IncomingScreenV8.kt
 └─ outgoing/
     ├─ v7/
     └─ v8/
         └─ OutgoingScreenV8.kt
```

---

## 1️⃣ AppScreen Configuration

**File:** `AppScreen.kt`

Add new routes for V8.

```kotlin
sealed class AppScreen(val route: String, val title: String) {

    // Incoming
    object IncomingV7 : AppScreen("incoming_v7", "V7")
    object IncomingV8 : AppScreen("incoming_v8", "V8")

    // Outgoing
    object OutgoingV7 : AppScreen("outgoing_v7", "V7")
    object OutgoingV8 : AppScreen("outgoing_v8", "V8")
}
```

---

## 2️⃣ Drawer Menu Update

**File:** `DrawerStructure.kt` (or `AppDrawer.kt`)

### Incoming Section

```kotlin
DrawerSection(
    title = "Incoming",
    children = listOf(
        IncomingV1, IncomingV2, IncomingV3,
        IncomingV4, IncomingV5, IncomingV6,
        IncomingV7, IncomingV8
    )
)
```

### Outgoing Section

```kotlin
DrawerSection(
    title = "Outgoing",
    children = listOf(
        OutgoingV1, OutgoingV2, OutgoingV3,
        OutgoingV4, OutgoingV5, OutgoingV6,
        OutgoingV7, OutgoingV8
    )
)
```

---

## 3️⃣ Create Incoming V8 Screen

### Steps

1. Copy folder

   ```
   ui/incoming/v7 → ui/incoming/v8
   ```
2. Rename file

   ```
   IncomingScreenV7.kt → IncomingScreenV8.kt
   ```

### `IncomingScreenV8.kt`

```kotlin
package com.example.smsapp.ui.incoming.v8

import androidx.compose.runtime.Composable

@Composable
fun IncomingScreenV8(
    openDrawer: () -> Unit,
    navigateToSend: (String, String) -> Unit
) {
    // Same UI & logic as Incoming V7
}
```

---

## 4️⃣ Create Outgoing V8 Screen

### Steps

1. Copy folder

   ```
   ui/outgoing/v7 → ui/outgoing/v8
   ```
2. Rename file

   ```
   OutgoingScreenV7.kt → OutgoingScreenV8.kt
   ```

### `OutgoingScreenV8.kt`

```kotlin
package com.example.smsapp.ui.outgoing.v8

import androidx.compose.runtime.Composable

@Composable
fun OutgoingScreenV8(
    openDrawer: () -> Unit,
    navigateToSend: (String, String) -> Unit
) {
    // Same UI & logic as Outgoing V7
}
```

---

## 5️⃣ Navigation Graph Setup

**File:** `NavGraph.kt`

### Imports

```kotlin
import com.example.smsapp.ui.incoming.v7.IncomingScreenV7
import com.example.smsapp.ui.incoming.v8.IncomingScreenV8
import com.example.smsapp.ui.outgoing.v7.OutgoingScreenV7
import com.example.smsapp.ui.outgoing.v8.OutgoingScreenV8
```

### Incoming Routes

```kotlin
composable(AppScreen.IncomingV7.route) {
    IncomingScreenV7(openDrawer, navigateToSend)
}

composable(AppScreen.IncomingV8.route) {
    IncomingScreenV8(openDrawer, navigateToSend)
}
```

### Outgoing Routes

```kotlin
composable(AppScreen.OutgoingV7.route) {
    OutgoingScreenV7(openDrawer, navigateToSend)
}

composable(AppScreen.OutgoingV8.route) {
    OutgoingScreenV8(openDrawer, navigateToSend)
}
```

---

## 6️⃣ Run the App

1. **Build → Rebuild Project**
2. Click **Run ▶**
3. Open **Navigation Drawer**
4. Test:

   * Incoming → **V8**
   * Outgoing → **V8**

---

## 🔁 Creating V9, V10, etc.

Repeat the same steps:

* Copy `v8 → v9`
* Rename file & function
* Add new `AppScreen` object
* Update Drawer & NavGraph

---

## ✅ Summary

* ✔ Same UI logic reused
* ✔ Only names, routes, and packages changed
* ✔ Clean version-based structure
* ✔ Easy to scale (V9, V10…)

---

If you want, I can also:

* Add **Inbox & Sent** to this README
* Refactor to **single reusable composable**
* Create **architecture diagram**

Just tell me 👍
