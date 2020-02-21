@file:Suppress("unused")

package com.andruid.magic.eezetensions

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

/**
 * Extension function to load color from resource
 * @param color id of the color resource
 * @receiver context of the calling component
 */
fun Context.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)

/**
 * Extension function to load drawable from resource
 * @param res id of the drawable resource
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
@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.hasInternet(): Boolean {
    return getSystemService<ConnectivityManager>()?.let { cm ->
        cm.getNetworkCapabilities(cm.activeNetwork)?.let { nc ->
            return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
    } ?: false
}