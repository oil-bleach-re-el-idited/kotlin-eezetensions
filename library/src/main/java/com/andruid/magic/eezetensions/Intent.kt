package com.andruid.magic.eezetensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

/**
 * Get intent to show the settings screen of the app for permissions and other settings
 * @return intent to launch settings page
 * @receiver context of the component
 */
fun Context.buildSettingsIntent(): Intent {
    val uri = Uri.fromParts("package", packageName, null)
    return Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        .setData(uri)
}

/**
 * Get intent to show tether settings screen (Hotspot, Bluetooth and USB Tethering)
 * @return intent to launch tether settings
 */
fun buildTetherSettingsIntent(): Intent {
    return Intent()
        .setClassName("com.android.settings", "com.android.settings.TetherSettings")
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
}