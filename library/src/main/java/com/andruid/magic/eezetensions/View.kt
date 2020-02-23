@file:Suppress("unused")

package com.andruid.magic.eezetensions

import android.view.View

/**
 * Extension function to make the view gone
 * @receiver view in the layout
 */
fun View.hide() {
    visibility = View.GONE
}

/**
 * Extension function to make the view visible
 * @receiver view in the layout
 */
fun View.show() {
    visibility = View.VISIBLE
}