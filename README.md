# kotlin-eezetensions
Extension functions which I found can be useful and save time and code [ ![Download](https://api.bintray.com/packages/death14stroke/libraries/com.andruid.magic.eezetensions/images/download.svg) ](https://bintray.com/death14stroke/libraries/com.andruid.magic.eezetensions/_latestVersion)

## Use
Add to your build.gradle (Module) file in dependencies: [![version](https://img.shields.io/badge/version-latest-blue.svg)](https://github.com/Death14Stroke/kotlin-eezetensions/releases/latest)

```implementation 'com.andruid.magic:eezetensions:1.0.2'```

### android.content.Context

- color(@ColorRes color: Int): Int
- drawable(@DrawableRes res: Int): Drawable?
- startFgOrBgService(intent: Intent)
- hasInternet(): Boolean (requires Manifest.permission.ACCESS_NETWORK_STATE)
- getPackageVersion(): String?
- toast(msg: String, duration: Int = Toast.LENGTH_SHORT, fromBg: Boolean = false)
- toast(@StringRes msgRes: Int, duration: Int = Toast.LENGTH_SHORT, fromBg: Boolean = false)
- getUserDeviceName(): String
- buildSettingsIntent(): Intent 

### androidx.fragment.app.Fragment

- color(@ColorRes color: Int): Int
- drawable(@DrawableRes res: Int): Drawable?
- startFgOrBgService(intent: Intent)
- hasInternet(): Boolean (requires Manifest.permission.ACCESS_NETWORK_STATE)
- toast(msg: String, duration: Int = Toast.LENGTH_SHORT, fromBg: Boolean = false)
- toast(@StringRes msgRes: Int, duration: Int = Toast.LENGTH_SHORT, fromBg: Boolean = false)

### android.location.Location

- getMapsUrl(): String


### android.view.View

- hide()
- show()

<a href='https://bintray.com/death14stroke/libraries/com.andruid.magic.eezetensions?source=watch' alt='Get automatic notifications about new "com.andruid.magic.eezetensions" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>
