Cordova plugin to start Android intent action

## Install

```
cordova plugin add https://github.com/ngocdaothanh/cordova-plugin-intent-action.git
```

## Usage

```
intentActionPlugin.startIntentAction('<action name>', options)
```

`options` is optional:

```
{
  data: '<URI>',
  type: '<data type>',
  extras: {
    key1: value1,
    key2: value2
  }
}
```

Examples:

```
intentActionPlugin.startIntentAction('android.app.action.SET_NEW_PASSWORD')

intentActionPlugin.startIntentAction('android.net.wifi.PICK_WIFI_NETWORK')

// Display Wifi settings activity without the button to other settings
// http://stackoverflow.com/questions/10773188/show-only-wireless-system-settings-on-android-3
intentActionPlugin.startIntentAction('android.settings.WIRELESS_SETTINGS', {
  extras: {
    ':android:show_fragment': 'com.android.settings.wifi.WifiSettings',
    ':android:no_headers': true
  }
})

// Install APK file (Android 6+ needs content:///...)
intentActionPlugin.startIntentAction('android.intent.action.INSTALL_PACKAGE', {
  data: 'file:///storage/sdcard/Android/data/com.mycompany.myapp/cache/file.apk'
})

// Other way to install APK file
intentActionPlugin.startIntentAction('android.intent.action.VIEW', {
  data: 'file:///storage/sdcard/Android/data/com.mycompany.myapp/cache/file.apk',
  type: 'application/vnd.android.package-archive'
})
```

See also:

* Start intent component: https://github.com/ahmadaghazadeh/sevensky-cordova-plugin-intent
* Write your own intent: https://github.com/napolitano/cordova-plugin-intent
