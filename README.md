# kotlin-eezetensions
Extension functions which I found can be useful and save time and code

## android.content.Context

- color(@ColorRes color: Int): Int
- drawable(@DrawableRes res: Int): Drawable?
- startFgOrBgService(intent: Intent)
- hasInternet(): Boolean (requires Manifest.permission.ACCESS_NETWORK_STATE)
- buildSettingsIntent(): Intent 

## androidx.fragment.app.Fragment

- color(@ColorRes color: Int): Int
- drawable(@DrawableRes res: Int): Drawable?
- startFgOrBgService(intent: Intent)
- hasInternet(): Boolean (requires Manifest.permission.ACCESS_NETWORK_STATE)

## android.location.Location

- getMapsUrl(): String


## android.view.View

- hide()
- show()
