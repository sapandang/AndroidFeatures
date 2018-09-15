/*
 * Copyright © 2012-2015, Intel Corporation. All rights reserved.
 * Please see the included README.md file for license terms and conditions.
 */


/*jslint browser:true, devel:true, white:true, vars:true */
/*global $:false, intel:false app:false, dev:false, cordova:false */



// This file contains your event handlers, the center of your application.
// NOTE: see app.initEvents() in init-app.js for event handler initialization code.

// function myEventHandler() {
//     "use strict" ;
// // ...event handler code here...
// }


// ...additional event handlers here...


var onXDKReady = function () {
  intel.xdk.device.hideSplashScreen();
};
document.addEventListener("intel.xdk.device.ready", onXDKReady, false);

var onDeviceReady = function() {
  testAdMob_main();
};
document.addEventListener("deviceready", onDeviceReady, false);

var admobid = {
  banner: 'ca-app-pub-3940256099942544/6300978111',
  interstitial: ''
};

function testAdMob_main() {
  if (!window.admob) {
    alert('admob plugin not ready');
    return;
  }
 
  initAds();
  admob.createBannerView(function () {
  }, function (data) {
    alert(JSON.stringify(data));
  });
}

function initAds() {
  var defaultOptions = admob.options;
 
  defaultOptions.publisherId = admobid.banner;
  defaultOptions.interstitialId = admobid.interstitial;
  defaultOptions.isTesting = false;
  defaultOptions.bannerAtTop = true;
  defaultOptions.overlap = false;
 
  admob.setOptions(defaultOptions);
  registerAdEvents();
}

// optional, in case respond to events or handle error
function registerAdEvents() {
  document.addEventListener(admob.events.onAdFailedToLoad, function (data) {
  // alert(data.adType + ' failed. Error: ' + data.error + ', reason: ' + data.reason);
  });
  document.addEventListener(admob.events.onAdLoaded, function (e) {
    if (e.adType = admob.AD_TYPE.INTERSTITIAL) {
      var autoshow = document.getElementById('autoshow').checked;
      if (!autoshow) {
        alert("Interstital available, click show to view it");
      }
    }
  });
  document.addEventListener(admob.events.onAdOpened, function (e) {});
  document.addEventListener(admob.events.onAdLeftApplication, function (e) {});
  document.addEventListener(admob.events.onAdClosed, function (e) {});
  document.addEventListener(admob.events.onInAppPurchaseRequested, function (e) {});
}

// click button to call following functions
function getSelectedAdSize() {
  var i = document.getElementById("adSize").selectedIndex;
  var items = document.getElementById("adSize").options;
  return items[i].value;
}

function createSelectedBanner() {
  var overlap = document.getElementById('overlap').checked;
  var bannerAtTop = document.getElementById("bannerAtTop").checked;
  admob.createBannerView({
    adId:admobid.banner,
    bannerAtTop: bannerAtTop,
    overlap:overlap,
    adSize: getSelectedAdSize()
  }, function () {
  }, function (e) {
    alert(JSON.stringify(e));
  });
}

function prepareInterstitial() {
  var autoshow = document.getElementById('autoshow').checked;
  admob.requestInterstitialAd({
    adId:admobid.interstitial,
    autoShow:autoshow
  }, function () {
  }, function (e) {
    alert(JSON.stringify(e));
  });
}