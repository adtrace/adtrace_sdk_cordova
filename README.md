<p align="center"><a href="https://adtrace.io" target="_blank" rel="noopener noreferrer"><img width="100" src="http://adtrace.io/fa/wp-content/uploads/2019/02/logo.png" alt="Adtrace logo"></a></p>

<p align="center">
  <a href='https://www.npmjs.com/package/cordova-adtrace'><img src='https://img.shields.io/npm/v/cordova-adtrace.svg'></a>
  <a href='https://opensource.org/licenses/MIT'><img src='https://img.shields.io/badge/License-MIT-green.svg'></a>
</p>

## Summary

This is the Cordova SDK of AdTrace. You can read more about AdTrace™ at [adtrace.io].

N.B. At the moment, SDK 0.0.6 for Cordova supports Android platform version `4.0.0 and higher` and iOS platform version `3.0.0 and higher`.


## Table of contents

### Quick start   

* [Example app](#qs-example-app)
* [Getting started](#qs-getting-started)
  * [Add the SDK to your project](#qs-sdk-add) 
  * [AdTrace project settings](#qs-adtrace-project-settings)
    * [Android permissions](#qs-android-permissions)
    * [Google Play Services](#qs-android-gps)
    * [Proguard settings](#qs-android-proguard)
    * [Install referrer](#qs-android-referrer)
      * [Google Play Referrer API](#qs-android-referrer-gpr-api)
      * [Google Play Store intent](#qs-android-referrer-gps-intent)
    * [iOS frameworks](#qs-ios-frameworks)
* [Integrate the SDK into your app](#qs-sdk-integrate)
  * [SDK signature](#qs-sdk-signature)
  * [AdTrace logging](#qs-sdk-logging)

### Deep linking

* [Deep linking overview](#dl-overview) 
* [Standard deep linking](#dl-standard) 
* [Deep linking on Android &  iOS 8 & earlier](#dl-android-ios-old) 
* [Deep linking on iOS 9 & later](#dl-ios-new) 
* [Deferred deep linking](#dl-deferred) 
* [Reattribution via deep links](#dl-reattribution) 

### Event tracking

* [Track event](#et-event) 
* [Track revenue](#et-revenue) 

### Custom parameters

* [Custom parameters overview](#cp-overview) 
* [Event parameters](#cp-event) 
  * [Event callback parameters](#cp-event-callback) 
  * [Event partner parameters](#cp-event-partner) 
  * [Event callback identifier](#cp-event-identifier) 
  * [Event value](#cp-event-value)  
* [Session parameters](#cp-session) 
  * [Session callback parameters](#cp-session-callback) 
  * [Session partner parameters](#cp-session-partner)
  * [Delay start](#cp-delay-start)

### Additional features

* [Push token (uninstall tracking)](#af-push-token)
* [Attribution callback](#af-attribution-callback)
* [Session and event callbacks](#af-session-event-callbacks)
* [User attribution](#af-user-attribution) 
* [Send installed apps](#af-send-installed-apps) 
* [Device IDs](#af-di) 
  * [iOS advertising identifier](#af-di-idfa)
  * [Google Play Services advertising identifier](#af-di-gps-adid)
  * [Amazon advertising identifier](#af-di-fire-adid)
  * [AdTrace device identifier](#af-di-adid)
* [Pre-installed trackers](#af-pre-installed-trackers)
* [Offline mode](#af-offline-mode)
* [Disable tracking](#af-disable-tracking)
* [Event buffering](#af-event-buffering)
* [Background tracking](#af-background-tracking)
* [GDPR right to be forgotten](#af-gdpr-forget-me)


## Quick start   

### <a id="qs-example-app"></a>Example app

There is Cordova example app inside the [`example-cordova` directory][example-cordova] . In there you can check how to integrate the AdTrace SDK into your app.

### <a id="qs-getting-started"></a>Getting started

To integrate the Adtrace SDK into your Cordova project, follow these steps.

### <a id="qs-sdk-add"></a>Add the SDK to your project

You can download our SDK directly as the plugin from `npm` repository. In order to do that, just execute this command in your project folder:

```
> cordova plugin add cordova-adtrace
Fetching plugin "cordova-adtrace" via npm
Installing "cordova-adtrace" for android
Installing "cordova-adtrace" for ios
```

Alternatively, if you have downloaded our SDK from the [releases] page, extract the archive to the folder of your choice and execute the following command in your project folder:

```
> cordova plugin add path_to_folder/cordova_sdk/plugin
Installing "cordova-adtrace" for android
Installing "cordova-adtrace" for ios
```

**Important:** If your target android platform is **28** or higher (using **androidX**), execute the following command in your project folder:

```
cordova plugin add cordova.plugins.diagnostic
cordova plugin add cordova-plugin-androidx
cordova plugin add cordova-plugin-androidx-adapter
cordova build android
```

### <a id="qs-adtrace-project-settings"></a>AdTrace project settings

Once the AdTrace SDK has been added to your app, certain tweeks are being performed so that the AdTrace SDK can work properly. Everything that is being done in this process is written in the `plugin.xml` file of the AdTrace SDK plugin. Below you can find a description of every additional thing that the AdTrace SDK performs after you've added it to your app.

### <a id="qs-android-permissions"></a>Android permissions

The AdTrace SDK adds three permissions to your Android manifest file: `INTERNET`, `ACCESS_WIFI_STATE` and `ACCESS_NETWORK_STATE`. You can find this setting in the `plugin.xml` file of the AdTrace SDK plugin:

```xml
<config-file target="AndroidManifest.xml" parent="/manifest">
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
</config-file>
```

`INTERNET` permission is the permission that our SDK might need at any point in time. `ACCESS_WIFI_STATE` is the permission which the AdTrace SDK needs in case your app is not targetting the Google Play Store and doesn't use Google Play Services. If you are targetting the Google Play Store and you are using Google Play Services, the AdTrace SDK doesn't need this permission and, if you don't need it anywhere else in your app, you can remove it. `ACCESS_NETWORK_STATE` is needed for reading MMC and MNC parameters.

### <a id="qs-android-gps"></a>Google Play Services

Since the August 1, 2014, apps in the Google Play Store must use the [Google Advertising ID][google-ad-id] to uniquely identify each device. To allow the AdTrace SDK to use the Google Advertising ID, you must integrate [Google Play Services][google-play-services].

The AdTrace SDK adds Google Play Services by default to your app. This is done with this line in the `plugin.xml` file:

```xml
<framework src="com.google.android.gms:play-services-ads-identifier:17.0.0" />
```

If you are using other Cordova plugins, they might also be importing Google Play Services by default into your app. If this is the case, Google Play Services from our SDK and other plugins can conflict and cause build time errors. Google Play Services does not have to be present in your app as part of our SDK exclusively. As long as you have the **analytics part of the Google Play Services library integrated in your app**, our SDK will be able to read all the necessary information. In case you choose to add Google Play Services into your app as part of another Cordova plugin, you can simply remove the above line from the `plugin.xml` file of our SDK.

To check whether the analytics part of the Google Play Services library has been successfully added to your app so that the AdTrace SDK can read it properly, you should start your app by configuring the SDK to run in `sandbox` mode and set the log level to `verbose`. After that, track a session or some events in your app and observe the list of parameters in the verbose logs which are being read once the session or event has been tracked. If you see a parameter called `gps_adid` in there, you have successfully added the analytics part of the Google Play Services library to your app and our SDK is reading the necessary information from it.

### <a id="qs-android-proguard"></a>Proguard settings

If you are using Proguard, add these lines to your Proguard file:

```
-keep public class io.adtrace.sdk.** { *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep public class com.android.installreferrer.** { *; }
```

### <a id="qs-android-referrer"></a>Install referrer

In order to correctly attribute an install of your Android app to its source, AdTrace needs information about the **install referrer**. This can be obtained by using the **Google Play Referrer API** or by catching the **Google Play Store intent** with a broadcast receiver.

**Important**: The Google Play Referrer API is newly introduced by Google with the express purpose of providing a more reliable and secure way of obtaining install referrer information and to aid attribution providers in the fight against click injection. It is **strongly advised** that you support this in your application. The Google Play Store intent is a less secure way of obtaining install referrer information. It will continue to exist in parallel with the new Google Play Referrer API temporarily, but it is set to be deprecated in future.

#### <a id="qs-android-referrer-gpr-api"></a>Google Play Referrer API

In order to support this in your app, the AdTrace SDK adds support for it by default to your app. This is done with this line in the `plugin.xml` file:

```xml
<framework src="com.android.installreferrer:installreferrer:1.1.2" />
```

Also, make sure that you have paid attention to the [Proguard settings](#android-proguard) chapter and that you have added all the rules mentioned in it, especially the one needed for this feature:

```
-keep public class com.android.installreferrer.** { *; }
```

#### <a id="qs-android-referrer-gps-intent"></a>Google Play Store intent

The Google Play Store `INSTALL_REFERRER` intent should be captured with a broadcast receiver. The AdTrace install referrer broadcast receiver is added to your app by default. For more information, you can check our native [Android SDK README][broadcast-receiver]. You can find this setting in the `plugin.xml` file of the the AdTrace SDK plugin:

```xml
<config-file target="AndroidManifest.xml" parent="/manifest/application">
    <receiver
        android:name="io.adtrace.sdk.AdTraceReferrerReceiver"
        android:exported="true">
        <intent-filter>
            <action android:name="com.android.vending.INSTALL_REFERRER" />
        </intent-filter>
    </receiver>
</config-file>
```

Please bear in mind that, if you are using your own broadcast receiver which handles the INSTALL_REFERRER intent, you don't need the AdTrace broadcast receiver to be added to your manifest file. You can remove it, but inside your own receiver add the call to the AdTrace broadcast receiver as described in our [Android guide][broadcast-receiver-custom].

### <a id="qs-ios-frameworks"></a>iOS frameworks

AdTrace SDK plugin adds three iOS frameworks to your generated Xcode project:

* `iAd.framework` - in case you are running iAd campaigns
* `AdSupport.framework` - for reading iOS Advertising Id (IDFA)
* `CoreTelephony.framework` - for reading MCC and MNC information
* `AdTraceSdk.framework` - our native iOS SDK framework

Settings for this can also be found in `plugin.xml` file of the AdTrace SDK plugin:

```xml
<framework src="src/ios/AdTraceSdk.framework" custom="true" />
<framework src="AdSupport.framework" weak="true" />
<framework src="iAd.framework" weak="true" />
<framework src="CoreTelephony.framework" weak="true" />
```

If you are not running any iAd campaigns, you can feel free to remove the `iAd.framework` dependency.

### <a id="qs-sdk-integrate"></a>Integrate the SDK into your app

The AdTrace SDK automatically registers with the Cordova events `deviceready`, `resume` and `pause`.

In your `index.js` file after you have received the `deviceready` event, add the following code to initialize the AdTrace SDK:

```js
var adtraceConfig = new AdTraceConfig("{YourAppToken}", AdTraceConfig.EnvironmentSandbox);
AdTrace.create(adtraceConfig);
```

Replace `{YourAppToken}` with your app token. You can find this in your [panel].

Depending on whether you build your app for testing or for production, you must set `environment` with one of these values:

```javascript
AdTraceConfig.EnvironmentSandbox
AdTraceConfig.EnvironmentProduction
```

**Important:** This value should be set to `AdTraceConfig.EnvironmentSandbox` if and only if you or someone else is testing your app. Make sure to set the environment to `AdTraceConfig.EnvironmentProduction` just before you publish the app. Set it back to `AdTraceConfig.EnvironmentSandbox` when you start developing and testing it again.

We use this environment to distinguish between real traffic and test traffic from test devices. It is very important that you keep this value meaningful at all times! This is especially important if you are tracking revenue.

### <a id="qs-sdk-signature"></a>SDK signature

If the SDK signature has already been enabled on your account and you have access to App Secrets in your AdTrace panel, please use the method below to integrate the SDK signature into your app.

An App Secret is set by passing all secret parameters (`secretId`, `info1`, `info2`, `info3`, `info4`) to `setAppSecret` method of `AdTraceConfig` instance:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);
adtraceConfig.setAppSecret(secretId, info1, info2, info3, info4);
AdTrace.create(adtraceConfig);
```

### <a id="qs-sdk-logging"></a>AdTrace logging

You can increase or decrease the amount of logs you see in tests by calling `setLogLevel` on your `AdTraceConfig` instance with one of the following parameters:

```js
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelVerbose);   // enable all logging
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelDebug);     // enable more logging
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelInfo);      // the default
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelWarn);      // disable info logging
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelError);     // disable warnings as well
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelAssert);    // disable errors as well
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelSuppress);  // disable all logging
```

## Deep linking

### <a id="dl-overview"></a>Deep linking overview

If you are using the AdTrace tracker URL with an option to deep link into your app from the URL, there is the possibility to get info about the deep link URL and its content. Hitting the URL can happen when the user has your app already installed (standard deep linking scenario) or if they don't have the app on their device (deferred deep linking scenario).

### <a id="dl-standard"></a>Standard deep linking scenario

Standard deep linking scenario is a platform specific feature and in order to support it, you need to add some additional settings to your app. If your user already has the app installed and hits the tracker URL with deep link information in it, your application will be opened and the content of the deep link will be sent to your app so that you can parse it and decide what to do next. 

**Note for iOS**: With the introduction of iOS 9, Apple has changed the way deep linking is handled in the app. Depending on which scenario you want to use for your app (or if you want to use them both to support a wide range of devices), you need to set up your app to handle one or both of the following scenarios.

### <a id="dl-android-ios-old"></a>Deep linking on Android & iOS 8 and earlier

To support deep linking handling in your app for Android and iOS 8 and earlier versions, you can use the `Custom URL Scheme` plugin which can be found [here][custom-url-scheme].

After you successfully integrate this plugin, in the callback method used with the plugin described in this [section][custom-url-scheme-usage] you will have an access to the content of the URL which opened your app on user's device:

```js
function handleOpenURL(url) {
    setTimeout(function () {
        // Check content of the url object and get information about the URL.
    }, 300);
};
```

By completing integration of this plugin, you should be able to handle deep linking in **Android and iOS 8 and lower**.

### <a id="dl-ios-new"></a>Deep linking on iOS 9 and later

Starting from **iOS 9**, Apple has introduced suppressed support for old style deep linking with custom URL schemes like described above in favour of `universal links`. If you want to support deep linking in your app for iOS 9 and higher, you need to add support for universal links handling.

After you have enabled universal links handling for your app in your panel, you need to add support for it in your app as well. You can achieve this by adding this [plugin][plugin-ulinks] to your cordova app. Please, read the README of this plugin, because it precisely describes what should be done in order to properly integrate it.

**Note**: You can disregard any information in the README that states that you need to have a domain and website or you need to upload a file to the root of your domain. AdTrace is taking care of this instead of you and you can skip these parts of the README. Also, you don't need to follow the instructions of this plugin for the Android platform, because deep linking in Android is still being handled with `Custom URL scheme` plugin.

To complete the integration of `Cordova Universal Links Plugin` after successfully enabling universal links for your app in the AdTrace panel you must:

#### Edit your `config.xml` file

You need to add following entry to your `config.xml` file:

```xml
<widget>
    <universal-links>
        <host name="[hash].adt.st" scheme="https" event="adtraceDeepLinking" />
    </universal-links>
</widget>
```

You should replace the `[hash]` value with the value you generated on the AdTrace panel. You can name the event also how ever you like.

#### Check `ul_web_hooks/ios/` content of the plugin

Go to the `Cordova Universal Links Plugin` install directory in your app and check the `ul_web_hooks/ios/` folder content. In there, you should see a generated file with the name `[hash].ulink.adtrace.io#apple-app-site-association`. The content of that file should look like this:

```
{
  "applinks": {
    "apps": [],
    "details": [
      {
        "appID": "<YOUR_TEAM_ID_FROM_MEMBER_CENTER>.io.adtrace.example",
        "paths": [
          "/ulink/*"
        ]
      }
    ]
  }
}
```

#### Integrate plugin to your `index.js` file

After the `deviceready` event gets fired, you should subscribe to the event you have defined in your `config.xml` file, and define the callback method which gets fired once the event is triggered. Because you don't need this plugin to handle deep linking in Android, you can only need to subscribe to it if your app is running on an iOS device.

```js
// ...

var app = {
    initialize: function() {
        this.bindEvents();
    },

    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },

    onDeviceReady: function() {
        if (device.platform == "iOS") {
            universalLinks.subscribe('adtraceDeepLinking', app.didLaunchAppFromLink);
        }
    },

    didLaunchAppFromLink: function(eventData) {
        // Check content of the eventData.url object and get information about the URL.
    }
}
// ...
```

By completing these steps, you have successfully added support for deep linking for iOS 9 and above as well.

### <a id="dl-deferred"></a>Deferred deep linking scenario

While deferred deep linking is not supported out of the box on Android and iOS, our AdTrace SDK makes it possible.
 
In order to get info about the URL content in a deferred deep linking scenario, you should set a callback method on the `AdTraceConfig` object which will receive one parameter where the content of the URL will be delivered. You should set this method on the config object by calling the method `setDeeplinkCallbackListener`:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setDeferredDeeplinkCallbackListener(function(deeplink) {
    console.log("Deferred deep link URL content: " + deeplink);
});

AdTrace.create(adtraceConfig);
```

In deferred deep linking scenario, there is one additional setting which can be set on the `AdTraceConfig` object. Once the AdTrace SDK gets the deferred deep link info, we are offering you the possibility to choose whether our SDK should open this URL or not. You can choose to set this option by calling the `setShouldLaunchDeeplink` method on the config object:


```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setShouldLaunchDeeplink(true);
// or adtraceConfig.setShouldLaunchDeeplink(false);

adtraceConfig.setDeeplinkCallbackListener(function(deeplink) {
    console.log("Deferred deep link URL content: " + deeplink);
});

AdTrace.create(adtraceConfig);
```

If nothing is set, **the AdTrace SDK will always try to launch the URL by default**.

### <a id="dl-reattribution"></a>Reattribution via deep links

If you are using this feature, in order for your user to be properly reattributed, you need to make one additional call to the AdTrace SDK in your app.

Once you have received deep link content information in your app, add a call to `appWillOpenUrl` method of the `AdTrace` instance. By making this call, the AdTrace SDK will try to find if there is any new attribution info inside of the deep link and if any, it will be sent to the AdTrace backend. If your user should be reattributed due to a click on the AdTrace tracker URL with deep link content in it, you will see the [attribution callback](#attribution-callback) in your app being triggered with new attribution info for this user.

In the code examples described above, a call to the `appWillOpenUrl` method should be done like this:

```js
function handleOpenURL(url) {
    setTimeout(function () {
        // Check content of the url object and get information about the URL.
        AdTrace.appWillOpenUrl(url);
    }, 300);
};
```

```js
// ...

var app = {
    initialize: function() {
        this.bindEvents();
    },

    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },

    onDeviceReady: function() {
        if (device.platform == "iOS") {
            universalLinks.subscribe('adtraceDeepLinking', app.didLaunchAppFromLink);
        }
    },

    didLaunchAppFromLink: function(eventData) {
        // Check content of the eventData.url object and get information about the URL.
        AdTrace.appWillOpenUrl(eventData.url);
    }
}
// ...
```

## Event tracking

### <a id="et-event"></a>Track event

You can use AdTrace to track all kinds of events. Let's say you want to track every tap on a button. Simply create a new event token in your [panel]. Let's say that event token is `abc123`. You can add the following line in your button’s click handler method to track the click:

```js
var adtraceEvent = new AdTraceEvent("abc123");
AdTrace.trackEvent(adtraceEvent);
```

### <a id="et-revenue"></a>Track revenue

If your users can generate revenue by tapping on advertisements or making In-App Purchases, then you can track those revenues with events. Let's say a tap is worth €0.01. You could track the revenue event like this:

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.setRevenue(0.01, "EUR");
AdTrace.trackEvent(adtraceEvent);
```

When you set a currency token, AdTrace will automatically convert the incoming revenues into a reporting revenue of your choice.

## Custom parameters

### <a id="cp-overview"></a>Custom parameters overview

In addition to the data points the AdTrace SDK collects by default, you can use the AdTrace SDK to track and add as many custom values as you need (user IDs, product IDs, etc.) to the event or session. Custom parameters are only available as raw data and will  **not**  appear in your AdTrace panel.

Use callback parameters for the values you collect for your own internal use, and partner parameters for those you share with external partners. If a value (e.g. product ID) is tracked both for internal use and external partner use, we recommend using both callback and partner parameters.

### <a id="cp-event"></a>Event parameters

### <a id="cp-event-callback"></a>Event callback parameters

You can also register a callback URL for that event in your [panel] and we will send a GET request to that URL whenever the event gets tracked. In that case you can also put some key-value pairs in an object and pass it to the `trackEvent` method. We will then append these named parameters to your callback URL.

For example, suppose you have registered the URL `http://www.adtrace.io/callback` for your event with event token `abc123` and execute the following lines:

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.addCallbackParameter("key", "value");
adtraceEvent.addCallbackParameter("foo", "bar");
AdTrace.trackEvent(adtraceEvent);
```

In that case we would track the event and send a request to:

```
http://www.adtrace.io/callback?key=value&foo=bar
```

### <a id="cp-event-partner"></a>Event partner parameters

Similarly to the callback parameters mentioned above, you can also add parameters that AdTrace will transmit to the network partners of your choice. You can activate these networks in your AdTrace panel.

This works similarly to the callback parameters mentioned above, but can be added by calling the `addPartnerParameter` method on your `AdTraceEvent` instance.

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.addPartnerParameter("key", "value");
adtraceEvent.addPartnerParameter("foo", "bar");
AdTrace.trackEvent(adtraceEvent);
```


### <a id="cp-event-identifier"></a>Event callback identifier

You can also add custom string identifier to each event you want to track. This identifier will later be reported in event success and/or event failure callbacks to enable you to keep track on which event was successfully tracked or not. You can set this identifier by calling the `setCallbackId` method on your `AdTraceEvent` instance:

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.setCallbackId("Your-Custom-Id");
AdTrace.trackEvent(adtraceEvent);
```

### <a id="cp-event-value"></a>Event value

You can also add custom string value to event. You can set this value by calling the `setEventValue` method on your `AdTraceEvent` instance:

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.setEventValue("Your-Value");
AdTrace.trackEvent(adtraceEvent);
```

### <a id="cp-session"></a>Session parameters

Some parameters are saved to be sent in every event and session of the AdTrace SDK. Once you have added any of these parameters, you don't need to add them every time, since they will be saved locally. If you add the same parameter twice, there will be no effect.

These session parameters can be called before the AdTrace SDK is launched to make sure they are sent even on install. If you need to send them with an install, but can only obtain the needed values after launch, it's possible to [delay](#cp-delay-start) the first launch of the AdTrace SDK to allow this behaviour.

### <a id="cp-session-callback"></a>Session callback parameters

The same callback parameters that are registered for [events](#cp-event-callback) can be also saved to be sent in every event or session of the AdTrace SDK.

The session callback parameters have a similar interface of the event callback parameters. Instead of adding the key and its value to an event, it's added through a call to method `addSessionCallbackParameter` of the `AdTrace` instance:

```js
AdTrace.addSessionCallbackParameter("foo", "bar");
```

The session callback parameters will be merged with the callback parameters added to an event. The callback parameters added to an event have precedence over the session callback parameters. Meaning that, when adding a callback parameter to an event with the same key to one added from the session, the value that prevails is the callback parameter added to the event.

It's possible to remove a specific session callback parameter by passing the desiring key to the method `removeSessionCallbackParameter` of the `AdTrace` instance:

```js
AdTrace.removeSessionCallbackParameter("foo");
```

If you wish to remove all key and values from the session callback parameters, you can reset it with the method `resetSessionCallbackParameters` of the `AdTrace` instance:

```js
AdTrace.resetSessionCallbackParameters();
```

### <a id="cp-session-partner"></a>Session partner parameters

In the same way that there are [session callback parameters](#cp-session-callback) that are sent for every event or session of the AdTrace SDK, there are also session partner parameters.

These will be transmitted to network partners, for the integrations that have been activated in your AdTrace [panel].

The session partner parameters have a similar interface to the event partner parameters. Instead of adding the key and its value to an event, it's added through a call to method `addSessionPartnerParameter` of the `AdTrace` instance:

```js
AdTrace.addSessionPartnerParameter("foo", "bar");
```

The session partner parameters will be merged with the partner parameters added to an event. The partner parameters added to an event have precedence over the session partner parameters. Meaning that, when adding a partner parameter to an event with the same key to one added from the session, the value that prevails is the partner parameter added to the event.

It's possible to remove a specific session partner parameter by passing the desiring key to the method `removeSessionPartnerParameter` of the `AdTrace` instance:

```js
AdTrace.removeSessionPartnerParameter("foo");
```

If you wish to remove all keys and values from the session partner parameters, you can reset it with the method `resetSessionPartnerParameters` of the `AdTrace` instance:

```js
AdTrace.resetSessionPartnerParameters();
```


### <a id="cp-delay-start"></a>Delay start

Delaying the start of the AdTrace SDK allows your app some time to obtain session parameters, such as unique identifiers, to be sent on install.

Set the initial delay time in seconds with the `setDelayStart` field of the `AdTraceConfig` instance:

```js
adtraceConfig.setDelayStart(5.5);
```

In this case this will make the AdTrace SDK not send the initial install session and any event created for 5.5 seconds. After this time is expired or if you call `sendFirstPackages()` of the `AdTrace` instance in the meanwhile, every session parameter will be added to the delayed install session and events and the AdTrace SDK will resume as usual.

**The maximum delay start time of the AdTrace SDK is 10 seconds**.


## Additional features

You can take advantage of the following features once the AdTrace SDK is integrated into your project.

### <a id="af-push-token"></a>Push token (uninstall tracking)

Push tokens are used for Audience Builder and client callbacks; they are also required for uninstall and reinstall tracking.

To send us a push notification token, call the  `setPushToken`  method on the  `AdTrace`  instance when you obtain your app's push notification token (or whenever its value changes):
```js
AdTrace.setPushToken("YourPushNotificationsToken");
```

### <a id="af-attribution-callback"></a>Attribution callback

You can register a listener to be notified of tracker attribution changes. Due to the different sources considered for attribution, this information cannot by provided synchronously. The simplest way is to create a single anonymous listener which is going to be called **each time your user's attribution value changes**:

With the `AdTraceConfig` instance, before starting the SDK, add the anonymous listener:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setAttributionCallbackListener(function(attribution) {
    //
});

AdTrace.create(adtraceConfig);
```

Within the listener function you have access to the `attribution` parameters. Here is a quick summary of its properties:

- `trackerToken`    the tracker token of the current attribution.
- `trackerName`     the tracker name of the current attribution.
- `network`         the network grouping level of the current attribution.
- `campaign`        the campaign grouping level of the current attribution.
- `adgroup`         the ad group grouping level of the current attribution.
- `creative`        the creative grouping level of the current attribution.
- `clickLabel`      the click label of the current attribution.
- `adid`            the AdTrace device identifier.

### <a id="af-session-event-callbacks"></a>Session and event callbacks

You can register a callback to be notified of successful and failed tracked events and/or sessions.

Follow the same steps as for attribution callback to implement the following callback function for successfully tracked events:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setEventTrackingSucceededCallbackListener(function(eventSuccess) {
    //
});

AdTrace.create(adtraceConfig);
```

The following callback function for failed tracked events:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setEventTrackingFailedCallbackListener(function(eventFailure) {
    //
});

AdTrace.create(adtraceConfig);
```

For successfully tracked sessions:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setSessionTrackingSucceededCallbackListener(function(sessionSuccess) {
    //
});

AdTrace.create(adtraceConfig);
```

And for failed tracked sessions:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setSessionTrackingFailedCallbackListener(function(sessionFailure) {
    //
});

AdTrace.create(adtraceConfig);
```

The callback functions will be called after the SDK tries to send a package to the server. Within the callback you have access to a response data object specifically for the callback. Here is a quick summary of the session response data properties:

- `var message` the message from the server or the error logged by the SDK.
- `var timestamp` timestamp from the server.
- `var adid` a unique device identifier provided by AdTrace.
- `var jsonResponse` the JSON object with the response from the server.

Both event response data objects contain:

- `var eventToken` the event token, if the package tracked was an event.
- `var callbackId` the custom defined callback ID set on event object.

And both event and session failed objects also contain:

- `var willRetry` indicates there will be an attempt to resend the package at a later time.

### <a id="af-user-attribution"></a>User attribution

As described in the [attribution callback section](#af-attribution-callback), this callback is triggered, providing you with information about a new attribution whenever it changes. If you want to access information about a user's current attribution whenever you need it, you can make a call to the `getAttribution` method of the `AdTrace` instance:

```js
AdTrace.getAttribution(function(attribution) {
    // Use attribution object in same way like in attribution callback.
});
```

**Note**: Information about current attribution is only available after an app installation has been tracked by the AdTrace backend and the attribution callback has been triggered. From that moment on, the AdTrace SDK has information about a user's attribution and you can access it with this method. So, **it is not possible** to access a user's attribution value before the SDK has been initialised and an attribution callback has been triggered.

### <a id="af-send-installed-apps"></a>Send installed apps

To increase the accuracy and security in fraud detection, you can enable the sending of installed applications on user's device as follows:

```js
adtraceConfig.setEnableSendInstalledApps(true);
```

**Note**: This option is  **disabled**  by default.

### <a id="af-di"></a>Device IDs

The AdTrace SDK lets you receive device identifiers.

### <a id="af-di-idfa"></a>iOS Advertising Identifier

To obtain the IDFA, call the `getIdfa` method of the `AdTrace` instance. You need to pass a callback to that method in order to obtain the value:

```js
AdTrace.getIdfa(function(idfa) {
    // Use idfa value.
});
```


### <a id="af-di-gps-adid"></a>Google Play Services advertising identifier

If you need to obtain the Google Advertising ID, you can call the `getGoogleAdId` method of the `AdTrace` instance. You need to pass a callback to that method in order to obtain the value:

```js
AdTrace.getGoogleAdId(function(googleAdId) {
    // Use googleAdId value.
});
```

Inside the callback method you will have access to the Google Advertising ID as the variable `googleAdId`.

### <a id="af-di-fire-adid"></a>Amazon advertising identifier

If you need to obtain the Amazon advertising ID, you can call the `getAmazonAdId` method on `AdTrace` instance:

```js
AdTrace.getAmazonAdId(function(amazonAdId) {
    // Use amazonAdId value.
});
```

Inside the callback method you will have access to the Amazon Advertising ID as the variable `amazonAdId`.

### <a id="af-di-adid"></a>AdTrace device identifier

For every device with your app installed on it, the AdTrace backend generates a unique **AdTrace device identifier** (**adid**). In order to obtain this identifier, call the `getAdid` method of the `AdTrace` instance. You need to pass a callback to that method in order to obtain the value:

```js
AdTrace.getAdid(function(adid) {
    // Use adid value.
});
```

**Note**: Information about the **adid** is only available after an app installation has been tracked by the AdTrace backend. From that moment on, the AdTrace SDK has information about the device **adid** and you can access it with this method. So, **it is not possible** to access the **adid** value before the SDK has been initialised and installation of your app has been successfully tracked.

### <a id="af-pre-installed-trackers"></a>Pre-installed trackers

If you want to use the AdTrace SDK to recognize users that found your app pre-installed on their device, follow these steps.

1. Create a new tracker in your [panel].
2. Open your app delegate and add set the default tracker of your `AdTraceConfig` instance:

    ```js
    var adtraceConfig = new AdTraceConfig(appToken, environment);
    adtraceConfig.setDefaultTracker("{TrackerToken}");
    AdTrace.create(adtraceConfig);
    ```

  Replace `{TrackerToken}` with the tracker token you created in step 2. Please note that the panel displays a tracker 
  URL (including `http://app.adtrace.io/`). In your source code, you should specify only the six-character token and not the
  entire URL.

3. Build and run your app. You should see a line like the following in the app's log output:

    ```
    Default tracker: 'abc123'
    ```

### <a id="af-offline-mode"></a>Offline mode

You can put the AdTrace SDK in offline mode to suspend transmission to our servers while retaining tracked data to be sent later. When in offline mode, all information is saved in a file, so be careful not to trigger too many events while in offline mode.

You can activate offline mode by calling the method `setOfflineMode` of the `AdTrace` instance with the parameter `true`.

```js
AdTrace.setOfflineMode(true);
```

Conversely, you can deactivate offline mode by calling `setOfflineMode` with `false`. When the AdTrace SDK is put back in online mode, all saved information is send to our servers with the correct time information.

Unlike disabling tracking, **this setting is not remembered** between sessions. This means that the SDK is in online mode whenever it is started, even if the app was terminated in offline mode.


### <a id="af-disable-tracking"></a>Disable tracking

You can disable the AdTrace SDK from tracking by invoking the method `setEnabled` of the `AdTrace` instance with the enabled parameter as `false`. This setting is **remembered between sessions**, but it can only be activated after the first session.

```js
AdTrace.setEnabled(false);
```

You can verify if the AdTrace SDK is currently active with the method `isEnabled` of the `AdTrace` instance. It is always possible to activate the AdTrace SDK by invoking `setEnabled` with the parameter set to `true`.

### <a id="af-event-buffering"></a>Event buffering

If your app makes heavy use of event tracking, you might want to delay some HTTP requests in order to send them in one batch every minute. You can enable event buffering with your `AdTraceConfig` instance by calling `setEventBufferingEnabled` method:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);
adtraceConfig.setEventBufferingEnabled(true);
AdTrace.create(adtraceConfig);
```

### <a id="af-background-tracking"></a>Background tracking

The default behaviour of the AdTrace SDK is to **pause sending HTTP requests while the app is in the background**. You can change this in your `AdTraceConfig` instance by calling `setSendInBackground` method:

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);
adtraceConfig.setSendInBackground(true);
AdTrace.create(adtraceConfig);
```

If nothing is set, sending in background is **disabled by default**.


### <a id="af-gdpr-forget-me"></a>GDPR right to be forgotten

In accordance with article 17 of the EU's General Data Protection Regulation (GDPR), you can notify AdTrace when a user has exercised their right to be forgotten. Calling the following method will instruct the AdTrace SDK to communicate the user's choice to be forgotten to the AdTrace backend:

```js
AdTrace.gdprForgetMe();
```

Upon receiving this information, AdTrace will erase the user's data and the AdTrace SDK will stop tracking the user. No requests from this device will be sent to AdTrace in the future.

[panel]:    http://panel.adtrace.io
[adtrace.io]:   http://adtrace.io

[releases]:         https://github.com/adtrace/adtrace_sdk_cordova/releases
[example-cordova]:  ./example-cordova

[google-ad-id]:         https://developer.android.com/google/play-services/id.html
[plugin-ulinks]:        https://github.com/nordnet/cordova-universal-links-plugin
[custom-url-scheme]:    https://github.com/EddyVerbruggen/Custom-URL-scheme
[broadcast-receiver]:   https://github.com/adtrace/adtrace_sdk_android#gps-intent

[google-launch-modes]:    http://developer.android.com/guide/topics/manifest/activity-element.html#lmode
[google-play-services]:   http://developer.android.com/google/play-services/index.html

[custom-url-scheme-usage]:      https://github.com/EddyVerbruggen/Custom-URL-scheme#3-usage
[broadcast-receiver-custom]:    https://github.com/adtrace/adtrace_sdk_android/blob/master/doc/english/multiple-receivers.md
