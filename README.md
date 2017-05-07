Cordova plugin to start Android intent action

Install:

```
cordova plugin add https://github.com/ngocdaothanh/cordova-plugin-intent-action.git
```

Usage:

```
intentActionPlugin.startIntentAction('android.app.action.SET_NEW_PASSWORD');

intentActionPlugin.startIntentAction('android.net.wifi.PICK_WIFI_NETWORK');
```

To start an action with extra data (the example displays Wifi settings activity
[without the button to other settings](http://stackoverflow.com/questions/10773188/show-only-wireless-system-settings-on-android-3)):

```
intentActionPlugin.startIntentAction(
  'android.settings.WIRELESS_SETTINGS',
  {
    ':android:show_fragment': 'com.android.settings.wifi.WifiSettings',
    ':android:no_headers': true
  }
);
```

See also:

* Start intent component: https://github.com/ahmadaghazadeh/sevensky-cordova-plugin-intent
* Write your own intent: https://github.com/napolitano/cordova-plugin-intent
