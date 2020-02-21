@file:Suppress("unused")

package com.andruid.magic.eezetensions

import android.content.Intent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment

/**
 * Extension function to load color from resource
 * @param color id of the color resource
 * @receiver active fragment
 */
fun Fragment.color(@ColorRes color: Int) = requireContext().color(color)

/**
 * Extension function to load drawable from resource
 * @param res id of the drawable resource
 * @receiver active fragment
 */
fun Fragment.drawable(@DrawableRes res: Int) = requireContext().drawable(res)

/**
 * Extension function to start foreground service above API 26 else start background service
 * @param intent to launch the service
 * @receiver active fragment
 */
fun Fragment.startFgOrBgService(intent: Intent) {
    requireContext().startFgOrBgService(intent)
}

/**
 * Extension function to check whether device is connected to internet or not
 * @return true/false
 * @receiver active fragment
 */
@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
fun Fragment.hasInternet() = requireContext().hasInternet()