@file:Suppress("unused")

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
 * Get intent to show hotspot settings screen
 * @return intent to launch hotspot settings
 * @receiver context of the calling component
 */
fun Context.buildHotspotSettingsIntent(): Intent {
    return Intent()
        .setClassName("com.android.settings", "com.android.settings.wifi.mobileap.WifiApSettings")
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
}