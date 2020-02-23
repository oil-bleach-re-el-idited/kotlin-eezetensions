@file:Suppress("unused")

package com.andruid.magic.eezetensions

import android.location.Location

/**
 * Extension function to get Google Maps URL for a location
 * @return Google Maps URL
 * @receiver location to be shown in maps
 */
fun Location.getMapsUrl() = "http://maps.google.com/?q=${latitude},$longitude"