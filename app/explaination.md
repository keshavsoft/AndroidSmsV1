# AndroidSmsV1

## Prerequisites
- Android Studio (latest version)
- Internet connection (for Gradle)
- Android SDK (installed via Android Studio)
- **Real Android device** (SMS does not work on emulator)

---

## Setup & Run Project

### Step 1: Clone Repository
```bash
git clone https://github.com/keshavsoft/AndroidSmsV1.git
```

### Step 2: Open in Android Studio
- Open Android Studio  
- Click **Open → Existing Project**  
- Select `AndroidSmsV1` folder

### Step 3: Gradle Sync
- Wait for **Gradle Build Finished**
- First build may take 5–10 minutes

### Step 4: Connect Device
- Enable **Developer Options**
- Enable **USB Debugging**
- Connect phone via USB

### Step 5: Permissions
Ensure these permissions exist in `AndroidManifest.xml`:
- READ_SMS
- SEND_SMS
- RECEIVE_SMS

### Step 6: Run App
- Select device
- Click ▶ **Run**
- Grant runtime permissions when prompted

---

## App Testing

### Inbox
- View received SMS
- Shows sender, message, date/time

### Send SMS
- Enter number and message
- Click **Send**

### Sent Messages
- View sent SMS history

---

## Architecture Flow
```
MainActivity
   ↓
UI Screens
   ↓
ViewModel
   ↓
Repository
   ↓
Android SMS Provider
```

---

## Troubleshooting
- File → Sync Project with Gradle Files
- Build → Clean Project
- Build → Rebuild Project

---

# Pull Request Process

### Step 1: Install Tools
- Visual Studio Code
- GitHub Pull Requests & Issues extension

### Step 2: GitHub Login
- `Ctrl + Shift + P` → GitHub: Sign In

### Step 3: Fork Repository
- Fork `AndroidSmsV1` to your account

### Step 4: Clone Fork
```bash
git clone https://github.com/yourusername/AndroidSmsV1.git
```

### Step 5: Make Changes
- Fix bugs / add features
- Save files

### Step 6: Commit
```bash
git commit -m "Improved SMS permission handling"
```

### Step 7: Push
```bash
git push origin feature-branch-name
```

### Step 8: Create PR
- Add title & description
- Submit Pull Request

---

✅ PR submitted successfully.
