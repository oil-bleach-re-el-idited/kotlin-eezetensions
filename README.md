# kotlin-eezetensions
Extension functions which I found can be useful and save time and code

## Use
Add to your build.gradle (Module) file in dependencies:

```implementation 'com.andruid.magic:eezetensions:1.0.0'```

### android.content.Context

- color(@ColorRes color: Int): Int
- drawable(@DrawableRes res: Int): Drawable?
- startFgOrBgService(intent: Intent)
- hasInternet(): Boolean (requires Manifest.permission.ACCESS_NETWORK_STATE)
- buildSettingsIntent(): Intent 

### androidx.fragment.app.Fragment

- color(@ColorRes color: Int): Int
- drawable(@DrawableRes res: Int): Drawable?
- startFgOrBgService(intent: Intent)
- hasInternet(): Boolean (requires Manifest.permission.ACCESS_NETWORK_STATE)

### android.location.Location

- getMapsUrl(): String


### android.view.View

- hide()
- show()
