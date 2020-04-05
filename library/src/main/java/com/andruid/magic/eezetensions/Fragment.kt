package com.andruid.magic.eezetensions

import android.content.Intent
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
 * Extension function to load color from resource
 * @param color id of the color resource
 * @return color from color resource
 * @receiver calling fragment
 */
fun Fragment.color(@ColorRes color: Int) = requireContext().color(color)

/**
 * Extension function to load drawable from resource
 * @param res id of the drawable resource
 * @return drawable from drawable resource
 * @receiver calling fragment
 */
fun Fragment.drawable(@DrawableRes res: Int) = requireContext().drawable(res)

/**
 * Extension function to start foreground service above API 26 else start background service
 * @param intent to launch the service
 * @receiver calling fragment
 */
fun Fragment.startFgOrBgService(intent: Intent) {
    requireContext().startFgOrBgService(intent)
}

/**
 * Extension function to show toast from background threads
 * @param msg toast message
 * @param duration toast duration (default = [Toast.LENGTH_SHORT]
 * @param fromBg toast from background (default = false)
 * @receiver calling fragment
 */
fun Fragment.toast(msg: String, duration: Int = Toast.LENGTH_SHORT, fromBg: Boolean = false) {
    requireContext().toast(msg, duration, fromBg)
}

/**
 * Extension function to show toast from background threads
 * @param msgRes string resource for toast message
 * @param duration toast duration (default = [Toast.LENGTH_SHORT]
 * @param fromBg toast from background (default = false)
 * @receiver calling fragment
 */
fun Fragment.toast(
    @StringRes msgRes: Int,
    duration: Int = Toast.LENGTH_SHORT,
    fromBg: Boolean = false
) {
    requireContext().toast(msgRes, duration, fromBg)
}