cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/cordova-plugin-device/www/device.js",
        "id": "cordova-plugin-device.device",
        "clobbers": [
            "device"
        ]
    },
    {
        "file": "plugins/cordova-plugin-splashscreen/www/splashscreen.js",
        "id": "cordova-plugin-splashscreen.SplashScreen",
        "clobbers": [
            "navigator.splashscreen"
        ]
    },
    {
        "file": "plugins/cordova-connectivity-monitor/www/connectivity.js",
        "id": "cordova-connectivity-monitor.connectivity",
        "clobbers": [
            "window.connectivity"
        ]
    },
    {
        "file": "plugins/cordova-admob/www/admob.js",
        "id": "cordova-admob.AdMobAds",
        "clobbers": [
            "window.admob",
            "window.tappx"
        ]
    },
    {
        "file": "plugins/intel.xdk.base/www/base.js",
        "id": "intel.xdk.base.base",
        "merges": [
            "intel.xdk"
        ]
    },
    {
        "file": "plugins/intel.xdk.base/www/device.js",
        "id": "intel.xdk.base.base-device",
        "merges": [
            "intel.xdk.device"
        ]
    },
    {
        "file": "plugins/intel.xdk.device/www/device.js",
        "id": "intel.xdk.device.device",
        "merges": [
            "intel.xdk.device"
        ]
    },
    {
        "file": "plugins/intel.xdk.device/www/RemoteDataParameters.js",
        "id": "intel.xdk.device.device-RemoteDataParameters",
        "merges": [
            "intel.xdk.device"
        ]
    },
    {
        "file": "plugins/intel.xdk.device/www/android/device.js",
        "id": "intel.xdk.device.android-device",
        "merges": [
            "intel.xdk.device"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-device": "1.1.2",
    "cordova-plugin-splashscreen": "3.2.2",
    "cordova-connectivity-monitor": "1.2.2",
    "cordova-admob": "4.1.16",
    "intel.xdk.base": "1.2.2",
    "intel.xdk.device": "3.0.1",
    "cordova-libgoogleadmobads": "7.13.1",
    "cordova-plugin-whitelist": "1.2.2",
    "cordova-plugin-crosswalk-webview": "1.8.0"
};
// BOTTOM OF METADATA
});