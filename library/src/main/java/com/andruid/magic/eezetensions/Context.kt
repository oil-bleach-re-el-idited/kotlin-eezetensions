package com.andruid.magic.eezetensions

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresPermission
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

/**
 * Extension function to load color from resource
 * @param color id of the color resource
 * @return color from color resource
 * @receiver context of the calling component
 */
fun Context.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)

/**
 * Extension function to load drawable from resource
 * @param res id of the drawable resource
 * @return drawable from drawable resource
 * @receiver context of the calling component
 */
fun Context.drawable(@DrawableRes res: Int) = ContextCompat.getDrawable(this, res)

/**
 * Extension function to start foreground service above API 26 else start background service
 * @param intent to launch the service
 * @receiver context of the calling component
 */
fun Context.startFgOrBgService(intent: Intent) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        startForegroundService(intent)
    else
        startService(intent)
}

/**
 * Extension function to check whether device is connected to internet or not
 * @return true/false
 * @receiver context of the calling component
 */
@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.hasInternet(): Boolean {
    return getSystemService<ConnectivityManager>()?.let { cm ->
        cm.getNetworkCapabilities(cm.activeNetwork)?.let { nc ->
            return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
    } ?: false
}

/**
 * Extension function to get package version name for the application
 * @return package version string
 * @receiver context of the calling component
 */
fun Context.getPackageVersion(): String? {
    return try {
        packageManager.getPackageInfo(applicationContext.packageName, 0).versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }
}

/**
 * Extension function to show toast from background threads
 * @param msg toast message
 * @param duration toast duration (default = [Toast.LENGTH_SHORT]
 * @param fromBg toast from background (default = false)
 * @receiver context of the calling component
 */
fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT, fromBg: Boolean = false) {
    if (fromBg) {
        Handler(Looper.getMainLooper()).post {
            toast(msg, duration, false)
        }
    } else
        Toast.makeText(this, msg, duration).show()
}

/**
 * Extension function to show toast from background threads
 * @param msgRes string resource for toast message
 * @param duration toast duration (default = [Toast.LENGTH_SHORT]
 * @param fromBg toast from background (default = false)
 * @receiver context of the calling component
 */
fun Context.toast(@StringRes msgRes: Int, duration: Int = Toast.LENGTH_SHORT, fromBg: Boolean = false) {
    toast(getString(msgRes), duration, fromBg)
}

/**
 * Extension function to get device name set in settings
 * @return user set device name
 * @receiver context of the calling component
 */
fun Context.getUserDeviceName(): String =
        Settings.Global.getString(contentResolver, "device_name")

/**
 * Get the application name
 * @return application name
 * @receiver context of the calling component
 */
fun Context.getApplicationName(): String {
    val stringId = applicationInfo.labelRes
    return if (stringId == 0)
        applicationInfo.nonLocalizedLabel.toString()
    else
        getString(stringId)
}

/**
 * Check whether mobile data is enabled
 * @return true/false
 * @receiver context of the calling component
 */
fun Context.isMobileDataEnabled() =
    Settings.Global.getInt(contentResolver, "mobile_data", 1) == 1