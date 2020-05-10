
<div dir="rtl" align='right'>فارسی | <a href="../../README.md">English</a></div>


<p align="center"><a href="https://adtrace.io" target="_blank" rel="noopener noreferrer"><img width="100" src="http://adtrace.io/fa/wp-content/uploads/2019/02/logo.png" alt="Adtrace logo"></a></p>

<p align="center">
  <a href='https://www.npmjs.com/package/cordova-adtrace'><img src='https://img.shields.io/npm/v/cordova-adtrace.svg'></a>
  <a href='https://opensource.org/licenses/MIT'><img src='https://img.shields.io/badge/License-MIT-green.svg'></a>
</p>

## <div dir="rtl" align='right'>خلاصه</div>

<div dir="rtl" align='right'>
SDK کوردوا ادتریس. شما برای اطلاعات بیشتر میتوانید به <a href="adtrace.io">adtrace.io</a>  مراجعه کنید.
</div>

## <div dir="rtl" align='right'>فهرست محتوا</div>

### <div dir="rtl" align='right'>پیاده سازی فوری</div>

<div dir="rtl" align='right'>
<ul>
  <li><a href="#qs-example-app">برنامه نمونه</a></li>
  <li><a href="#qs-getting-started">شروع پیاده سازی</a></li>
    <ul>
      <li><a href="#qs-sdk-add">افزودن SDK به پروژه</a></li>
      <li><a href="#qs-adtrace-project-settings">تنظیمات پیاده سازی</a></li>
      <ul>
        <li><a href="#qs-android-permissions">مجوزهای اندروید</a></li>
        <li><a href="#qs-android-gps">سرویس های گوگل پلی</a></li>
        <li><a href="#qs-android-proguard">تنظیمات Proguard</a></li>
        <li><a href="#qs-android-referrer">تنظیمات Install referrer</a></li>
          <ul>
                  <li><a href="#qs-android-referrer-gpr-api">Google Play Referrer API</a></li>
                  <li><a href="#qs-android-referrer-gps-intent">Google Play Store intent</a></li>
          </ul>
      <li><a href="#qs-ios-frameworks">فریم ورک های  iOS</a></li>
      </ul>
    </ul>
  <li><a href="#qs-integ-sdk">پیاده سازی SDK داخل برنامه</a></li>
  <ul>
      <li><a href="#qs-sdk-signature">امضا SDK</a></li>                 
      <li><a href="#qs-adtrace-logging">لاگ ادتریس</a></li>
  </ul>
  </ul>
</div>

### <div dir="rtl" align='right'>لینک دهی عمیق</div>

<div dir="rtl" align='right'>
<ul>
  <li><a href="#dl-overview">نمای کلی لینک دهی عمیق</a></li>                  
  <li><a href="#dl-standard">سناریو لینک دهی عمیق استاندار</a></li>
  <li><a href="#dl-android-ios-old">لینک دهی عمیق در اندروید و iOS 8 به قبل</a></li>
  <li><a href="#dl-ios-new">لینک دهی عمیق در iOS 9 به بعد</a></li>
  <li><a href="#dl-deferred">سناریو لینک دهی عمیق به تعویق افتاده</a></li>
  <li><a href="#dl-reattribution">اتریبیوت مجدد از طریق لینک عمیق</a></li>
</ul>
</div>

### <div dir="rtl" align='right'>ردیابی رویداد</div>

<div dir="rtl" align='right'>
<ul>
  <li><a href="#et-track-event">ردیابی رویداد معمولی</a></li>                 
  <li><a href="#et-track-revenue">ردیابی رویداد درآمدی</a></li>
</ul>
</div>

### <div dir="rtl" align='right'>پارامترهای سفارشی</div>

<div dir="rtl" align='right'>
<ul>
  <li><a href="#cp-overview">نمای کلی پارامترهای سفارشی</a></li>
  <li><a href="#cp-ep">پارامترهای رویداد</a>
    <ul>
      <li><a href="#cp-ep-callback">پارامترهای callback رویداد</a></li>                 
      <li><a href="#cp-ep-partner">پارامترهای partner رویداد</a></li>
      <li><a href="#cp-ep-id">شناسه callback رویداد</a></li>
      <li><a href="#cp-ep-value">مقدار رویداد</a></li>
    </ul>
  </li>                 
  <li><a href="#cp-sp" >پارامترهای نشست</a>
    <ul>
      <li><a href="#cp-sp-callback">پارامترهای callback نشست</a></li>                 
      <li><a href="#cp-sp-partner">پارامترهای partner نشست</a></li>
      <li><a href="#cp-sp-delay-start">شروع با تاخیر</a></li>
    </ul>
  </li>
</ul>
</div>

### <div dir="rtl" align='right'>ویژگی های بیشتر</div>

<div dir="rtl" align='right'>
<ul>
  <li><a href="#af-push-token">توکن push (ردیابی تعداد حذف برنامه)</a></li> 
  <li><a href="#af-attribution-callback">callback اتریبیوشن</a></li>
  <li><a href="#af-session-event-callbacks">callback های رویداد و نشست</a></li>
  <li><a href="#af-user-attribution">اتریبیوشن کاربر</a></li>                 
  <li><a href="#af-send-installed-apps">ارسال برنامه های نصب شده دستگاه</a></li>                  
  <li><a href="#af-di">شناسه های دستگاه</a>
    <ul>
      <li><a href="#af-di-idfa">شناسه تبلیغات iOS</a></li>
      <li><a href="#af-di-gps-adid">شناسه تبلیغات سرویس های گوگل پلی</a></li>                 
      <li><a href="#af-di-amz-adid">شناسه تبلیغات آمازون</a></li>
      <li><a href="#af-di-adid">شناسه دستگاه ادتریس</a></li>
    </ul>
  </li>                 
  <li><a href="#af-pre-installed-trackers">ردیابی قبل از نصب</a></li>                 
  <li><a href="#af-offline-mode">حالت آفلاین</a></li>                 
  <li><a href="#af-disable-tracking">غیرفعال کردن ردیابی</a></li>                 
  <li><a href="#af-event-buffering">بافرکردن رویدادها</a></li>                  
  <li><a href="#af-background-tracking">ردیابی در پس زمینه</a></li>                             
  <li><a href="#af-gdpr-forget-me">GPDR</a></li>                  
</ul>
</div>

## <div dir="rtl" align='right'>پیاده سازی فوری</div>

### <div id="qs-example-app" dir="rtl" align='right'>برنامه نمونه</div>

<div dir="rtl" align='right'>
درون <a href="/example-cordova">پوشه <code>example-cordova</code></a> یک برنامه کوردوا نمونه وجود دارد که میتوانید بررسی کنید SDK ادتریس چگونه پیاده سازی شده است.
</div>

### <div id="qs-getting-started" dir="rtl" align='right'>شروع پیاده سازی</div>

<div dir="rtl" align='right'>
برای پیاده سازی SDK ادتریس قدم به قدم مراحل زیر را دنبال کنید.
</div>

### <div id="qs-sdk-add" dir="rtl" align='right'>افزودن SDK به پروژه</div>

<div dir="rtl" align='right'>
شما میتوانید SDK را از طریق <code>npm</code> به روش زیر دریافت نمایید. کافیست دستور زیر را در محل پروژه ران کنید:
</div>
<br/>

```
> cordova plugin add cordova-adtrace
Fetching plugin "cordova-adtrace" via npm
Installing "cordova-adtrace" for android
Installing "cordova-adtrace" for ios
```

<br/>
<div dir="rtl" align='right'>
به عنوان جایگزین میتوانید SDK را در قسمت <a href="">رلیز</a> دریافت نمایید و بعد از extract کنید و کد زیر را در محل پروژه خود ران کنید:
</div>
<br/>

```
> cordova plugin add path_to_folder/cordova_sdk/plugin
Installing "cordova-adtrace" for android
Installing "cordova-adtrace" for ios
```

<br/>
<div dir="rtl" align='right'>
<strong>نکته</strong>: اگر در پلتفرم اندروید، نسخه بیلد آن <strong>28 و یا بالاتر</strong> میباشد، (قابل پشتیبانی از <strong>AndroidX</strong> است) بایستی دستورات زیر را نیز اجرا نمایید.
</div>
<br/>

```
cordova plugin add cordova.plugins.diagnostic
cordova plugin add cordova-plugin-androidx
cordova plugin add cordova-plugin-androidx-adapter
cordova build android
```

### <div id="qs-adtrace-project-settings" dir="rtl" align='right'>تنظیمات پیاده سازی</div>

<div dir="rtl" align='right'>
هنگامی که SDK ادتریس را به برنامه خود اضافه کردید، مواردی دیگر لازم است تا ادتریس به درستی کار کند که در زیر به این موارد میپردازیم.
</div>

### <div id="qs-android-permissions" dir="rtl" align='right'>مجوزهای اندروید</div>

<div dir="rtl" align='right'>
SDK ادتریس سه مجوز را در فایل AndroidManifest.xml اضافه خواهد کرد: <code>INTERNET</code>، <code>ACCESS_WIFI_STATE</code>، <code>ACCESS_NETWORK_STATE</code>. شما این تنظیمات را در فایل <code>plugin.xml</code> که پلاگین SDK ادتریس میباشد.
</div>

<br/>
<div dir="rtl" align='right'>
مجوز <code>ACCESS_WIFI_STATE</code> برای استورهایی به جز گوگل پلی استفاده میشود و اگر برنامه شما فقط درون گوگل پلی بخواهد بکار برده شود، به این مجوز نیازی ندارید.
</div>

### <div id="qs-android-gps" dir="rtl" align='right'>سرویس های گوگل پلی</div>

<div dir="rtl" align='right'>
از تاریخ 1 آگوست 2014، برنامه های داخل گوگل پلی بایستی از <a href="https://support.google.com/googleplay/android-developer/answer/6048248?hl=en">شناسه تبلیغاتی گوگل</a> برای شناسایی یکتابودن دستگاه استفاده کنند.
</div>
<br/>
<div dir="rtl" align='right'>
SDK ادتریس به صورت خودکار سرویس های گوگل را اضافه میکند که این کار از طریق <code>plugin.xml</code> انجام خواهد شد.
</div>
<br/>

```xml
<framework src="com.google.android.gms:play-services-ads-identifier:17.0.0" />
```

<br/>
<div dir="rtl" align='right'>
اگر شما از پلاگین های دیگر کوردوا استفاده میکنید، شاید آن پلاگین ها نیز سرویس های گوگل پلی را به صورت پیشفرض داخل پروژه شما اضافه کنند، که در این صورت به دلیل تداخل و داشتن چندین نوع از کتابخانه سرویس های گوگل پلی، برنامه شما دچار ارور شود. لازم نیست که وقتی پروژه شما از این سرویس پشتیبانی میکند، ادتریس نیز این سرویس را اضافه نماید. تا زمانی که <strong>پروژه شما سرویس های گوگل پلی</strong> را پشتیبانی میکند، ادتریس میتواند اطلاعات ضروری را دریافت نماید. در این صورت شما بایستی در قسمت <code>plugin.xml</code> ادتریس، این خط سرویس های گوگل را پاک کنید.
</div>
<br/>
<div dir="rtl" align='right'>
برای مشاهده اینکه سرویس گوگل پلی به درستی اضافه شده است، ادتریس را در حالت <code>sandbox</code> و لاگ را در سطح <code>verbose</code> قرار دهید. اگر بعد از ارسال تعدادی رویداد یا نشست، پارامتر <code>gps_adid</code> را مشاهده نمودید، پیاده سازی این بخش به درستی انجام شده است.
</div>

### <div id="qs-android-proguard" dir="rtl" align='right'>تنظیمات Proguard</div>

<div dir="rtl" align='right'>
اگر از Progaurd استفاده میکنید، دستورهای زیر را در فایل Progaurd خود اضافه کنید:
</div>
<br/>

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

### <div id="qs-android-referrer" dir="rtl" align='right'>تنظیمات Install referrer</div>

<div dir="rtl" align='right'>
برای آنکه به درستی نصب یک برنامه به سورس خودش اتریبیوت شود، ادتریس به اطلاعاتی درمورد <strong>install referrer</strong> نیاز دارد. این مورد با استفاده از <strong>Google Play Referrer API</strong> یا توسط <strong>Google Play Store intent</strong> بواسطه یک broadcast receiver دریافت میشود.
</div>
<br/>
<div dir="rtl" align='right'>
<strong>نکته مهم:</strong> Google Play Referrer API جدیدا راه حلی قابل اعتمادتر و با امنیت بیشتر برای جلو گیری از تقلب click injection  توسط گوگل  جدیدا معرفی شده است. <strong>به صورت اکید</strong> توصیه میشود که از این مورد در برنامه های خود استفاده کنید. Google Play Store intent امنیت کمتری در این مورد دارد و در آینده deprecate خواهد شد.
</div>

#### <div id="qs-android-referrer-gpr-api" dir="rtl" align='right'>Google Play Referrer API</div>

<div dir="rtl" align='right'>
به جهت اینکه این سرویس در برنامه شما پشتیبانی شود، SDK ادتریس به صورت خودکار این را در برنامه شما اضافه خواهد کرد. این از طریق یک خط در فایل <code>plugin.xml</code> اضافه خواهد شد:
</div>
<br/>

```xml
<framework src="com.android.installreferrer:installreferrer:1.1.2" />
```

<br/>
<div dir="rtl" align='right'>
همچنین مطمئن شوید که درصورت داشتن Progaurd، بخش <a href="qs-proguard-settings">تنظیمات Progaurd</a> به صورت کامل اضافه شده است، مخصوصا دستور زیر:
</div>
<br/>

```
-keep public class com.android.installreferrer.** { *; }
```

#### <div id="qs-android-referrer-gps-intent" dir="rtl" align='right'>Google Play Store intent</div>

<div dir="rtl" align='right'>
گوگل طی <a href="https://android-developers.googleblog.com/2019/11/still-using-installbroadcast-switch-to.html">بیانیه ای</a> اعلام کرد که از 1 مارچ 2020 دیگر اطلاعات <code>INSTALL_REFERRER</code> را به صورت broadcast ارسال نمیکند، برای همین به رویکرد <a href="#qs-android-referrer-gpr-api">Google Play Referrer API</a> مراجعه کنید.
</div>
<br/>
<div dir="rtl" align='right'>
ادتریس اطلاعات <code>INSTALL_REFERRER</code> گوگل پلی را توسط یک broadcast receiver دریافت میکند. که این broadcast receiver به برنامه شما به صورت خودکار اضافه خواهد شد. برای اطلاعات بیشتر میتوانید به <a href="https://github.com/adtrace/adtrace_sdk_android#gps-intent">SDK اندروید</a> مراجعه نمایید.
</div>
<br/>

```xml
<receiver
    android:name="io.adtrace.sdk.AdTraceReferrerReceiver"
    android:permission="android.permission.INSTALL_PACKAGES"
    android:exported="true" >
    <intent-filter>
        <action android:name="com.android.vending.INSTALL_REFERRER" />
    </intent-filter>
</receiver>
```

<br/>
<div dir="rtl" align='right'>
اگر قبلا از یک broadcast receiver برای دریافت اطلاعات <code>INSTALL_REFERRER</code> استفاده میکرده اید، از <a href="https://github.com/adtrace/adtrace_sdk_android/blob/master/doc/english/multiple-receivers.md">این دستورالعمل</a>  برای اضافه نمودن broadcast receiver ادتریس استفاده کنید. این تنظیمات در قسمت <code>plugin.xml</code> ادتریس موجود است.
</div>
<br/>

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

<br/>
<div dir="rtl" align='right'>
لطفا این نکته را توجه کنید که اگر از broadcast receiver شخصی خود استفاده میکنید، نیازی نیست که ادتریس این تغییرات بالا را در AndroidManifest شما انجام دهد. این قسمت کد را در قسمت پلاگین ادتریس حذف نمایید و از طریق <a href="https://github.com/adtrace/adtrace_sdk_android/blob/master/doc/english/multiple-receivers.md">این لینک</a> اقدام به اضافه نمودن broadcast receiver ادتریس در receiver خود نمایید.
</div>

### <div id="qs-ios-frameworks" dir="rtl" align='right'>فریم ورک های  iOS</div>

<div dir="rtl" align='right'>
داخل قسمت Project Navigator، در قسمت چپ ویو اصلی، هدف خود را انتخاب کنید. در تب <code>Build Phases</code>، گروه <code>Link Binary with Libraries</code> را باز کنید. در قسمت انتهایی دکمه <code>+</code> را کلیک کنید. قسمت <code>AdSupport.framework</code> را انتخاب کنید و گزینه <code>Add</code> را کلیک کنید. اگر در صورتی که برای <code>tvOS</code> استفاده نمیکنید، مراحل بالا را برای <code>iAd.framework</code> و <code>CoreTelephony.framework</code> را اضافه نمایید. مقدار <code>Status</code> هر دو فریم ورک را به <code>Optional</code> تغییر دهید. SDK ادتریس این فریم ورک ها را برای اهداف زیر استفاده میکند:
</div>
<br/>
<div dir="rtl" align='right'>
<ul>
  <li><code>iAd.framework</code> برای هنگامی که  کمپین iAd اجرا میکنید.</li>
  <li><code>AdSupport.framework</code> برای خواندن شناسه تبلیغاتی iOS یا همان IDFA</li>
  <li><code>CoreTelephony.framework</code> برای خواندن اطلاعات MNC و MCC</li>
</ul>
</div>
<br/>
<div dir="rtl" align='right'>
اگر شما مایل به اجرای کمپین iAd نیستید، میتوانید <code>iAd.framework</code> را پاک کنید.
</div>

### <div id="qs-integ-sdk" dir="rtl" align='right'>پیاده سازی SDK داخل برنامه</div>

<div dir="rtl" align='right'>
SDK ادتریس به صورت خودکاربا  رویدادهای <code>deviceready</code>، <code>resume</code>، <code>pause</code> کوردوا همگام سازی میشود.
</div>
<br/>
<div dir="rtl" align='right'>
درون فایل <code>index.js</code> بعد از اینکه رویداد <code>deviceready</code> دریافت شد، کد زیر را برای راه اندازی SDK ادتریس اضافه نمایید:
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig("{YourAppToken}", AdTraceConfig.EnvironmentSandbox);
AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
مقدار <code>{YourAppToken}</code> را با توکن اپ خود جایگزین نمایید. این مقدار را درون پنل ادتریس خود میتوانید مشاهده کنید.
</div>
<br/>
<div dir="rtl" align='right'>
وابسته به نوع خروجی اپ شما که درحالت تست یا تجاری میباشد، بایستی مقدار environment را یکی از مقادیر زیر انتخاب نمایید:
</div>
<br/>

```js
AdTraceConfig.EnvironmentSandbox
AdTraceConfig.EnvironmentProduction
```

<br/>
<div dir="rtl" align='right'>
<strong>نکته:</strong> این مقدار تنها در زمان تست برنامه شما بایستی مقدار <code> AdTraceConfig.EnvironmentSandbox</code> قرار بگیرد. این پارامتر را به <code>AdTraceConfig.EnvironmentProduction</code> قبل از انتشار برنامه خود تغییر دهید.
</div>
<br/>
<div dir="rtl" align='right'>
ادتریس enviroment را برای تفکیک ترافیک داده واقعی و آزمایشی بکار میبرد.
</div>

### <div id="qs-sdk-signature" dir="rtl" align='right'>امضا SDK</div>

<div dir="rtl" align='right'>
اگر امضا SDK فعال شده است، از متد زیر برای پیاده سازی استفاده کنید:
</div>
<br/>
<div dir="rtl" align='right'>
یک App Secret توسط متد <code>setAppSecret</code> داخل <code>AdTraceConfig</code> فراخوانی میشود:
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);
adtraceConfig.setAppSecret(secretId, info1, info2, info3, info4);
AdTrace.create(adtraceConfig);
```

### <div id="qs-adtrace-logging" dir="rtl" align='right'>لاگ ادتریس</div>

<div dir="rtl" align='right'>
شما میتوانید در حین تست لاگ ادتریس را از طریق <code>setLogLevel</code> که در <code>AdTraceConfig</code> قرار دارد کنترل کنید:
</div>
<br/>

```js
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelVerbose);   // enable all logging
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelDebug);     // enable more logging
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelInfo);      // the default
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelWarn);      // disable info logging
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelError);     // disable warnings as well
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelAssert);    // disable errors as well
adtraceConfig.setLogLevel(AdTraceConfig.LogLevelSuppress);  // disable all logging
```

## <div dir="rtl" align='right'>لینک دهی عمیق</div>

### <div id="dl-overview" dir="rtl" align='right'>نمای کلی لینک دهی عمیق</div>

<div dir="rtl" align='right'>
اگر از url ادتریس با تنظیمات deep link برای ترک کردن استفاده میکنید، امکان دریافت اطلاعات و محتوا دیپ لینک از طریق ادتریس فراهم میباشد. با کلیک کردن لینک کاربر ممکن است که قبلا برنامه را داشته باشد(سناریو لینک دهی عمیق استاندارد) یا اگر برنامه را نصب نداشته باشد(سناریو لینک دهی عمیق به تعویق افتاده) به کار برده شود. 
</div>

### <div id="dl-standard" dir="rtl" align='right'>سناریو لینک دهی عمیق استاندار</div>

<div dir="rtl" align='right'>
لینک دهی عمیق استاندارد یک ویژگی ای است که اگر میخواهید برنامه شما آن را پشتیبانی کند، نیاز به یک سری تغییراتی در برنامه خود دارید. اگر کاربر برنامه شما را نصب داشته باشد و آدرس ترکر را وارد نماید، برنامه شما باز خواهد شد  و اطلاعات لینک عمیق به برنامه شما ارسال خواهد  شد و این به تصمیم شما بستگی دارد که میخواهید چه کاری انجام دهید.
</div>
<br/>
<div dir="rtl" align='right'>
<strong>نکته ای برای پلتفرم iOS</strong>: در iOS 9 به بعد رفتار لینک دهی عمیق تغییر پیدا کرده است. بر اساس این که شما کدام سناریو را میخواهید اجراکنید (یا برای پشتیبانی تعداد بیشتری از دستگاه ها میخواهید هر دو را اجرا کنید)، نیاز دارید یکی از این سناریوها و یا هردو سناریو زیر را پیاده سازی کنید.
</div>

### <div id="dl-android-ios-old" dir="rtl" align='right'>لینک دهی عمیق در اندروید و iOS 8 به قبل</div>

<div dir="rtl" align='right'>
برای پشتیبانی لینک دهی عمیق در اندروید و یا iOS 8 یا به قبل، میتوانید از طریق <a href="https://github.com/EddyVerbruggen/Custom-URL-scheme">این لینک</a> پلاگین <code>Custom URL Scheme</code> را در برنامه خود استفاده کنید.
</div>
<br/>
<div dir="rtl" align='right'>
بعد از اینکه به طور موفقیت آمیز پلاگین را پیاده سازی کردید، در متد کالبکی که در <a href="https://github.com/EddyVerbruggen/Custom-URL-scheme#3-usage">این بخش</a> پلاگین توضیح داده شد امکان دریافت محتوای URL ای که باعث باز شدن برنامه شما شده است، وجود دارد:
</div>
<br/>

```js
function handleOpenURL(url) {
    setTimeout(function () {
        // Check content of the url object and get information about the URL.
    }, 300);
};
```

<br/>
<div dir="rtl" align='right'>
به دلیل پیاده سازی این پلاگین شما امکان استفاده از لینک دهی عمیق را در <strong>اندروید و iOS 8 به پایین تر</strong> را خواهید داشت.
</div>

### <div id="dl-ios-new" dir="rtl" align='right'>لینک دهی عمیق در iOS 9 به بعد</div>

<div dir="rtl" align='right'>
برای پشتیبانی لینک دهی عمیق در iOS 9 به بعد شما نیاز به استفاده از <code>universal links</code> در برنامه خود دارید.
</div>
<br/>
<div dir="rtl" align='right'>
برای فعالسازی universal links میتوانید به <a href="https://github.com/nordnet/cordova-universal-links-plugin">این لینک</a> مراجعه کنید. لطفا README پلاگین را بخوانید تا به درستی این قسمت را پیاده سازی نمایید.
</div>
<br/>
<div dir="rtl" align='right'>
<strong>نکته</strong>: شما قسمتی از README را که گفته شده بایستی یک فایلی در root دامنه شما آپلود شود، میتوانید نادیده بگیرید. ادتریس به این قسمت رسیدگی میکند و شما میتوانید این قسمت را درنظر نگیرید. همچنین لازم نیست دستورالعمل مربوط به پلتفرم اندروید را دنبال کنید زیرا لینک دهی عمیق در اندروید از طریق <code>Custom URL Scheme</code> انجام میشود.
</div>
<br/>
<div dir="rtl" align='right'>
برای پیاده سازی قسمت <code>Cordova Universal Links Plugin</code> بایستی موارد زیر را انجام دهید:
</div>

#### <div dir="rtl" align='right'>فایل <code>config.xml</code> را تغییر دهید</div>

<div dir="rtl" align='right'>
بایستی موارد زیر را به فایل <code>config.xml</code> خود اضافه نمایید:
</div>
<br/>

```xml
<widget>
    <universal-links>
        <host name="[hash].adt.st" scheme="https" event="adtraceDeepLinking" />
    </universal-links>
</widget>
```

<br/>
<div dir="rtl" align='right'>
بایستی مقدار <code>[hash]</code> با مقداری که در پنل ادتریس دریافت کرده اید جایگزین شود. شما میتوانید اسم رویداد را هرچه میخواهید قرار دهید.
</div>

#### <div dir="rtl" align='right'>محتوا <code>/ul_web_hooks/ios</code> پلاگین را بررسی کنید.</div>

<div dir="rtl" align='right'>
به پوشه نصب شده <code>Cordova Universal Links Plugin</code> که در برنامه شما قرار دارد رفته و محتوا پوشه <code>/ul_web_hooks/ios</code> را بررسی کرده. بایستی یک فایل تولید شده به اسم <code>[hash].ulink.adtrace.io#apple-app-site-association</code> رفته و محتوا آن بایستی به صورت زیر باشد:
</div>
<br/>

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

#### <div dir="rtl" align='right'>پلاگین را درون <code>index.js</code> پیاده سازی کنید</div>

<div dir="rtl" align='right'>
بعد از <code>deviceready</code> رویداد فراخوانی خواهد شد، بایستی این به رویدادی که در فایل <code>config.xml</code> تعریف شده است، نام نویسی شود. برای اینکه این پلاگین در اندروید مورد استفاده قرار نمیگیرد، فقط کافیست برای دستگاه درحال اجرا iOS نام نویسی شود.
</div>
<br/>

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

<br/>
<div dir="rtl" align='right'>
به وسیله آموزش بالا امکان لینک دهی عمیق برای iOS 9 به بالا را خواهید داشت.
</div>

### <div id="dl-deferred" dir="rtl" align='right'>سناریو لینک دهی عمیق به تعویق افتاده</div>

<div dir="rtl" align='right'>
درحالیکه لینک دهی عمیق به تعویق افتاده به خودی خود در پلتفرم های اندروید و  iOS قابل پشتیبانی نیست، با استفاده از SDK ادتریس شما قابلیت پیاده سازی این سناریو را خواهید داشت.
</div>
<br/>
<div dir="rtl" align='right'>
برای آنکه در این سناریو اطلاعات محتوای آدرس را بدست آورید نیاز به ایجاد یک متد به صورت callback در <code>AdTraceConfig</code> دارید که اطلاعات URL به دست شما خواهد رسید. شما از طریق متد <code>setDeeplinkCallbackListener</code> میتوانید متد خودتان را فراخوانی کنید:
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setDeferredDeeplinkCallbackListener(function(deeplink) {
    console.log("Deferred deep link URL content: " + deeplink);
});

AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
در این سناریو به تعویق افتاده، یک مورد اضافی بایستی به تنظیمات اضافه شود. هنگامی که SDK ادتریس اطاعات دیپ لینک را دریافت کرد، شما امکان این را دارید که SDK، با استفاده از این اطلاعات باز شود یا خیر که از طریق  متد <code>setShouldLaunchDeeplink</code> قابل استفاده است:
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setShouldLaunchDeeplink(true);
// or adtraceConfig.setShouldLaunchDeeplink(false);

adtraceConfig.setDeeplinkCallbackListener(function(deeplink) {
    console.log("Deferred deep link URL content: " + deeplink);
});

AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
توجه فرمایید که اگر کالبکی تنظیم نشود، <strong>SDK ادتدریس در حالت پیشفرض تلاش میکند تا URL را اجرا کند</strong>.
</div>

### <div id="dl-reattribution" dir="rtl" align='right'>اتریبیوت مجدد از طریق لینک عمیق</div>

<div dir="rtl" align='right'>
اگر شما از این ویژگی استفاده میکنید، برای اینکه کاربر به درستی مجددا اتریبیوت شود، نیاز دارید یک دستور اضافی به برنامه خود اضافه کنید.
</div>
<br/>
<div dir="rtl" align='right'>
هنگامی که اطلاعات دیپ لینک را دریافت میکنید، متد <code>AdTrace.appWillOpenUrl(Uri, Context)</code>  را فراخوانی کنید. از طریق این SDK تلاش میکند تا ببیند اطلاعات جدیدی درون دیپ لینک برای اتریبیوت کردن قرار دارد یا خیر. اگر وجود داشت، این اطلاعات به سرور ارسال میشود.  اگر کاربر از طریق کلیک بر ترکر ادتریس مجددا اتریبیوت شود، میتوانید از قسمت <a href="#af-attribution-callback">اتریبیوشن کالبک</a> اطلاعات جدید را برای این کاربر دریافت کنید.
</div>
<br/>
<div dir="rtl" align='right'>
فراخوانی متد <code>AdTrace.appWillOpenUrl(Uri, Context)</code> بایستی مثل زیر باشد:
</div>
<br/>

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

## <div dir="rtl" align='right'>ردیابی رویداد</div>

### <div id="et-track-event" dir="rtl" align='right'>ردیابی رویداد معمولی</div>

<div dir="rtl" align='right'>
شما برای یک رویداد میتوانید از انواع رویدادها درون برنامه خود استفاده کنید. فرض کنید که میخواهید لمس یک دکمه را رصد کنید. بایستی ابتدا یک رویداد درون پنل خود ایجاد کنید. اگر فرض کنیم که توکن رویداد شما <code>abc123</code> باشد، سپس در قسمت کلیک کردن دکمه مربوطه کد زیر را برای ردیابی لمس دکمه اضافه کنید:
</div>
<br/>

```js
var adtraceEvent = new AdTraceEvent("abc123");
AdTrace.trackEvent(adtraceEvent);
```

### <div id="et-track-revenue" dir="rtl" align='right'>ردیابی رویداد درآمدی</div>

<div dir="rtl" align='right'>
اگر کاربران شما از طریق کلیک بر روی تبلیغات یا پرداخت درون برنامه ای، رویدادی میتوانند ایجاد کنند، شما میتوانید آن درآمد را از طریق رویدادی مشخص رصد کنید. اگر فرض کنیم که یک ضربه به ارزش یک سنت از واحد یورو باشد، کد شما برای ردیابی این رویداد به صورت زیر میباشد:
</div>
<br/>

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.setRevenue(0.01, "EUR");
AdTrace.trackEvent(adtraceEvent);
```

<br/>
<div dir="rtl" align='right'>
این ویژگی میتواند با پارامترهای callback نیز ترکیب شود.
</div>
<br/>
<div dir="rtl" align='right'>
هنگامی که واحد پول را تنظیم کردید، ادتریس به صورت خودکار درآمدهای ورودی را به صورت خودکار به انتخاب شما تبدیل میکند.
</div>

## <div dir="rtl" align='right'>پارامترهای سفارشی</div>

### <div id="cp-overview" dir="rtl" align='right'>نمای کلی پارامترهای سفارشی</div>

<div dir="rtl" align='right'>
علاوه بر داده هایی که SDK ادتریس به صورت خودکار جمع آوری میکند، شما از ادتریس میتوانید مقدارهای سفارشی زیادی را با توجه به نیاز خود (شناسه کاربر، شناسه محصول و ...) به رویداد یا نشست خود اضافه کنید. پارامترهای سفارشی تنها به صورت خام و export شده قابل دسترسی میباشد و در پنل ادتریس قابل نمایش <strong>نمیباشد</strong>.</div> 
<br/>
<div dir="rtl" align='right'>
شما از <strong>پارامترهای callback</strong> برای استفاده داخلی خود بکار میبرید و از <strong>پارامترهای partner</strong> برای به اشتراک گذاری به شریکان خارج از برنامه استفاده میکنید. اگر یک مقدار (مثل شناسه محصول) برای خود و شریکان خارجی استفاده میشود، ما پیشنهاد میکنیم که از هر دو پارامتر partner و callback استفاده کنید.
</div>

### <div id="cp-ep" dir="rtl" align='right'>پارامترهای رویداد</div>

### <div id="cp-ep-callback" dir="rtl" align='right'>پارامترهای callback رویداد</div>

<div dir="rtl" align='right'>
شما میتوانید یک آدرس callback برای رویداد خود داخل پنل اضافه کنید. ادرتیس یک درخواست GET به آن آدرسی که اضافه نموده اید، ارسال خواهد کرد. همچنین پارامترهای callback برای آن رویداد را از طریق متد <code>addCallbackParameter</code> برای آن رویداد قبل از ترک آن استفاده کنید. ما این پارامترها را به آخر آدرس callback شما اضافه خواهیم کرد.
</div>
<br/>
<div dir="rtl" align='right'>
به عنوان مثال اگر شما آدرس <code>http://www.example.com/callback</code> را به رویداد خود اضافه نموده اید، ردیابی رویداد به صورت زیر خواهد بود:
</div>
<br/>

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.addCallbackParameter("key", "value");
adtraceEvent.addCallbackParameter("foo", "bar");
AdTrace.trackEvent(adtraceEvent);
```

<br/>
<div dir="rtl" align='right'>
در اینصورت ما رویداد شما را رصد خواهیم کرد و یک درخواست به صورت زیر ارسال خواهیم کرد:
</div>
<br/>

```
http://www.example.com/callback?key=value&foo=bar
```

### <div id="cp-ep-partner" dir="rtl" align='right'>پارامترهای partner رویداد</div>

<div dir="rtl" align='right'>
شما همچنین پارامترهایی را برای شریکان خود تنظیم کنید که درون پنل ادتریس فعالسازی میشود.
</div>
<br/>
<div dir="rtl" align='right'>
این پارامترها به صورت callback که در بالا مشاهده میکنید استفاده میشود، فقط از طریق متد <code>addPartnerParameter</code> درون یک شی از <code>AdTraceEvent</code> فراخوانی میشود.
</div>
<br/>

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.addPartnerParameter("key", "value");
adtraceEvent.addPartnerParameter("foo", "bar");
AdTrace.trackEvent(adtraceEvent);
```

### <div id="cp-ep-id" dir="rtl" align='right'>شناسه callback رویداد</div>

<div dir="rtl" align='right'>
شما همچنین میتوانید یک شناسه به صورت رشته برای هریک از رویدادهایی که رصد کردید اضافه کنید. این شناسه بعدا در callback موفق یا رد شدن آن رویداد به دست شما خواهد رسید که متوجه شوید این ردیابی به صورت موفق انجام شده است یا خیر. این مقدار از طریق متد <code>setCallbackId</code> درون شی  از <code>AdTraceEvent</code> قابل تنظیم است.
</div>
<br/>

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.setCallbackId("Your-Custom-Id");
AdTrace.trackEvent(adtraceEvent);
```

### <div id="cp-ep-value" dir="rtl" align='right'>مقدار رویداد</div>

<div dir="rtl" align='right'>
شما همچنین یک رشته دلخواه به رویداد خود میتوانید اضافه کنید. این مقدار از طریق <code>setEventValue</code> قابل استفاده است:
</div>
<br/>

```js
var adtraceEvent = new AdTraceEvent("abc123");
adtraceEvent.setEventValue("Your-Value");
AdTrace.trackEvent(adtraceEvent);
```

### <div id="cp-sp" dir="rtl" align='right'>پارامترهای نشست</div>

<div dir="rtl" align='right'>
پارامترهای نشست به صورت محلی ذخیره میشوند و به همراه هر <strong>رویداد</strong> یا <strong>نشست</strong> ادتریس ارسال خواهند شد. هنگامی که هرکدام از این پارامترها  اضافه شدند، ما آنها را ذخیره خواهیم کرد پس نیازی به اضافه مجدد آنها نیست. افزودن مجدد پارامترهای مشابه تاثیری نخواهد داشت.
</div>
<br/>
<div dir="rtl" align='right'>
این پارامترها میتوانند قبل از شروع SDK ادتریس تنظیم شوند. اگر میخواهید هنگام نصب آنها را ارسال کنید، ولی پارامترهای آن بعد از نصب دراختیار شما قرار میگیرد، برای اینکار میتوانید از <a href="#cp-sp-delay-start">تاخیر</a> در شروع اولیه استفاده کنید.
</div>

### <div id="cp-sp-callback" dir="rtl" align='right'>پارامترهای callback نشست</div>

<div dir="rtl" align='right'>
شما میتوانید هرپارامتر callback ای که برای <a href="#cp-ep-callback">رویدادها</a> ارسال شده را در هر رویداد یا نشست ادتریس ذخیره کنید.
</div>
<br/>
<div dir="rtl" align='right'>
این پارامترهای callback نشست مشابه رویداد میباشد. برخلاف اضافه کردن key و value به یک رویداد، آنها را از طریق متد <code>AdTrace.addSessionCallbackParameter(String key, String value)</code> استفاده کنید:
</div>
<br/>

```js
AdTrace.addSessionCallbackParameter("foo", "bar");
```

<br/>
<div dir="rtl" align='right'>
پارامترهای callback نشست با پارامترهای callback به یک رویداد افزوده اید ادغام خواهد شد. پارامترهای رویداد بر نشست تقدم و برتری دارند، بدین معنی که اگر شما پارامتر callback یک ایونت را با یک key مشابه که به نشست افزوده شده است، این مقدار نسبت داده شده به این key از رویداد استفاده خواهد کرد.
</div>
<br/>
<div dir="rtl" align='right'>
این امکان فراهم هست که مقدار پارامترهای callback نشست از طریق key مورد نظربا متد <code>AdTrace.removeSessionCallbackParameter(String key)</code> حذف شود:
</div>
<br/>

```js
AdTrace.removeSessionCallbackParameter("foo");
```

<br/>
<div dir="rtl" align='right'>
اگر شما مایل هستید که تمام مقدایر پارامترهای callback نشست را پاک کنید، بایستی از متد <code>()AdTrace.resetSessionCallbackParameters</code> استفاده کنید:
</div>
<br/>

```js
AdTrace.resetSessionCallbackParameters();
```

### <div id="cp-sp-partner" dir="rtl" align='right'>پارامترهای partner نشست</div>

<div dir="rtl" align='right'>
به همین صورت پارامترهای partner مثل <a href="#cp-sp-callback">پارامترهای callback نشست</a> در هر رویداد یا نشست ارسال خواهند شد.
</div>
<br/>
<div dir="rtl" align='right'>
این مقادیر برای تمامی شریکان که در پنل خود فعالسازی کردید ارسال میشود.
</div>
<br/>
<div dir="rtl" align='right'>
پارامترهای partner نشست همچون رویداد میباشد. بایستی از متد <code>AdTrace.addSessionPartnerParameter(String key, String value)</code> استفاده شود:
</div>
<br/>

```js
AdTrace.addSessionPartnerParameter("foo", "bar");
```

<br/>
<div dir="rtl" align='right'>
پارامترهای partner نشست با پارامترهای partner به یک رویداد افزوده اید ادغام خواهد شد. پارامترهای رویداد بر نشست تقدم و برتری دارند، بدین معنی که اگر شما پارامتر partner یک ایونت را با یک key مشابه که به نشست افزوده شده است، این مقدار نسبت داده شده به این key از رویداد استفاده خواهد کرد.
</div>
<br/>
<div dir="rtl" align='right'>
این امکان فراهم هست که مقدار پارامترهای partner نشست از طریق key مورد نظربا متد <code>AdTrace.removeSessionPartnerParameter(String key)</code> حذف شود:
</div>
<br/>

```js
AdTrace.removeSessionPartnerParameter("foo");
```

<br/>
<div dir="rtl" align='right'>
اگر شما مایل هستید که تمام مقدایر پارامترهای partner نشست را پاک کنید، بایستی از متد <code>()AdTrace.resetSessionPartnerParameters</code> استفاده کنید:
</div>
<br/>

```js
AdTrace.resetSessionPartnerParameters();
```

### <div id="cp-sp-delay-start" dir="rtl" align='right'>شروع با تاخیر</div>

<div dir="rtl" align='right'>
شروع با تاخیر SDK ادتریس این امکان را به برنامه شما میدهد تا پارامترهای نشست شما در زمان نصب ارسال شوند.
</div>
<br/>
<div dir="rtl" align='right'>
  با استفاده از متد <code>setDelayStart</code> که ورودی آن عددی به ثانیه است، باعث تاخیر در شروع اولیه خواهد شد:
</div>
<br/>

```js
adtraceConfig.setDelayStart(5.5);
```

<br/>
<div dir="rtl" align='right'>
در این مثال SDK ادتریس مانع از ارسال نشست نصب اولیه و هر رویدادی با تاخیر 5.5 ثانیه خواهد شد. بعد از اتمام این زمان (یا فراخوانی متد <code>()AdTrace.sendFirstPackages</code> در طی این زمان) هر پارامتر نشستی با تاخیر آن زمان افزوده خواهد شد و بعد آن ادتریس به حالت عادی به کار خود ادامه میدهد.
</div>
<br/>
<div dir="rtl" align='right'>
<strong>بیشترین زمان ممکن برای تاخیر در شروع SDK ادتریس 10 ثانیه خواهد بود.</strong>
</div>

## <div dir="rtl" align='right'>ویژگی های بیشتر</div>

<div dir="rtl" align='right'>
هنگامی که شما SDK ادتریس را پیاده سازی کردید، میتوانید از ویژگی های زیر بهره ببرید:
</div>

### <div id="af-push-token" dir="rtl" align='right'>توکن push (ردیابی تعداد حذف برنامه)</div>

<div dir="rtl" align='right'>
توکن پوش برای برقراری ارتباط با کاربران استفاده میشود، همچنین برای ردیابی تعداد حذف یا نصب مجدد برنامه از این توکن استفاده میشود.
</div>
<br/>
<div dir="rtl" align='right'>
برای ارسال توکن پوش نوتیفیکشین خط زیر را در قسمتی که کد را دریافت کرده اید (یا هنگامی که مقدار آن تغییر میکند) اضافه نمایید:
</div>
<br/>

```js
AdTrace.setPushToken("YourPushNotificationToken");
```

### <div id="af-attribution-callback" dir="rtl" align='right'>callback اتریبیوشن</div>

<div dir="rtl" align='right'>
شما میتوانید یک listener هنگامی که اتریبیشون ترکر تغییر کند، داشته باشید. ما امکان فراهم سازی این اطلاعات را به صورت همزمان به دلیل تنوع منبع اتریبیوشن را نداریم.
</div>
<br/>
<div dir="rtl" align='right'>
برای callback اتریبیشون  قبل از شروع SDK موارد زیر را اضافه کنید:
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setAttributionCallbackListener(function(attribution) {
    //
});

AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
این تابع بعد از دریافت آخرین اطلاعات اتریبیوشن صدا زده خواهد شد. با این تابع، به پارامتر <code>attribution</code> دسترسی پیدا خواهید کرد. موارد زیر یک خلاصه ای از امکانات گفته شده است:
</div>
<div dir="rtl" align='right'>
<ul>
<li><code>trackerToken</code> توکن ترکر از اتریبیوشن درحال حاضر است و جنس آن رشته میباشد.</li>
<li><code>trackerName</code> اسم ترکر از اتریبیوشن درحال حاضر است و جنس آن رشته میباشد.</li>
<li><code>network</code> لایه نتورک از اتریبیوشن درحال حاضر است و جنس آن رشته میباشد.</li>
<li><code>campain</code> لایه کمپین از اتریبیوشن درحال حاضر است و جنس آن رشته میباشد.</li>
<li><code>adgroup</code> لایه ادگروپ از اتریبیوشن درحال حاضر است و جنس آن رشته میباشد.</li>
<li><code>creative</code> لایه کریتیو از اتریبیوشن درحال حاضر است و جنس آن رشته میباشد.</li>
<li><code>adid</code> شناسه ادتریس است و جنس آن رشته میباشد.</li>
<ul>
</div>

### <div id="af-session-event-callbacks" dir="rtl" align='right'>callback های رویداد و نشست</div>

<div dir="rtl" align='right'>
این امکان فراهم است که یک listener هنگامی که رویداد یا نشستی ردیابی میشود، به اطلاع شما برساند. چهار نوع listener داریم: یکی برای ردیابی موفق بودن رویدادها، یکی برای ردیابی ناموفق بودن رویدادها، دیگری برای موفق بودن نشست و آخری نیز برای ناموفق بودن ردیابی نشست. برای درست کردن همچین listener هایی به صورت زیر عمل میکنیم:
</div>
<br/>

<div dir="rtl" align='right'>
ردیابی موفق رویدادها
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setEventTrackingSucceededCallbackListener(function(eventSuccess) {
    //
});

AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
ردیابی ناموفق رویدادها
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setEventTrackingFailedCallbackListener(function(eventFailure) {
    //
});

AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
ردیابی موفق نشست
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setSessionTrackingSucceededCallbackListener(function(sessionSuccess) {
    //
});

AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
ردیابی ناموفق نشست
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);

adtraceConfig.setSessionTrackingFailedCallbackListener(function(sessionFailure) {
    //
});

AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
listener ها هنگامی فراخوانده میشوند که SDK تلاش به ارسال داده سمت سرور کند. با این listener شما دسترسی به  داده های دریافتی دارید. موارد زیر یک خلاصه ای از داده های دریافتی هنگام نشست موفق میباشد:
</div>
<br/>
<div dir="rtl" align='right'>
<ul>
<li><code>var message</code> پیام از طرف سرور(یا ارور از طرف SDK)</li>
<li><code>var timestamp</code> زمان دریافتی از سرور</li>
<li><code>var adid</code> یک شناسه یکتا که از طریق ادتریس ساخته شده است</li>
<li><code>var jsonResponse</code> شی JSON دریافتی از سمت سرور</li>
</ul>
</div>
<br/>
<div dir="rtl" align='right'>
هر دو داده دریافتی رویداد شامل موارد زیر میباشد:
</div>
<br/>
<div dir="rtl" align='right'>
<ul>
<li><code>var eventToken</code> توکن مربوط به رویداد مورد نظر</li>
<li><code>var callbackId</code> <a href="#cp-ep-id">شناسه callback</a> که برای یک رویداد تنظیم میشود</li>
</ul>
</div>
<br/>
<div dir="rtl" align='right'>
و هر دو رویداد و نشست ناموفق شامل موارد زیر میشوند:
</div>
<br/>
<div dir="rtl" align='right'>
<ul>
<li><code>var willRetry</code> یک boolean ای  تلاش مجدد برای ارسال داده را نشان میدهد.</li>
</ul>
</div>

### <div id="af-user-attribution" dir="rtl" align='right'>اتریبیوشن کاربر</div>

<div dir="rtl" align='right'>
همانطور که در بخش <a href="#af-attribution-callback">callback اتریبیوشن</a> توضیح دادیم، این  callback هنگامی که اطلاعات اتریبیوشن عوض بشود، فعالسازی میشود. برای دسترسی به اطلاعات اتریبیوشن فعلی کاربر درهر زمانی که نیاز بود از طریق متد زیر قابل دسترس است:
</div>
<br/>

```js
AdTrace.getAttribution((attribution) => {
    //
});
```

<br/>
<div dir="rtl" align='right'>
<strong>نکته</strong>: اطلاعات اتریبیوشن فعلی تنها درصورتی دردسترس است که از سمت سرور نصب برنامه ردیابی شود و از طریق callback اتریبیوشن فعالسازی شود. <strong>امکان این نیست که</strong> قبل از اجرا اولیه SDK  و فعالسازی callback اتریبیوشن بتوان به داده های کاربر دسترسی پیدا کرد.
</div>

### <div id="af-send-installed-apps" dir="rtl" align='right'>ارسال برنامه های نصب شده دستگاه</div>

<div dir="rtl" align='right'>
برای افزایش دقت و امنیت در تشخیص تقلب برنامه ای، میتوانید برنامه های ئرون دستگاه کاربر را برای ارسال سمت سرور به صورت زیر فعالسازی کنید:
</div>
<br/>

```js
adtraceConfig.setEnableSendInstalledApps(true);
```

<br/>
<div dir="rtl" align='right'>
<strong>نکته</strong>: این ویژگی در حالت پیشفرض <strong>غیرفعال</strong> میباشد.
</div>

### <div id="af-di" dir="rtl" align='right'>شناسه های دستگاه</div>

<div dir="rtl" align='right'>
SDK ادتریس انواع شناسه ها رو به شما پیشنهاد میکند.
</div>

### <div id="af-di-idfa" dir="rtl" align='right'>شناسه تبلیغات iOS</div>

<div dir="rtl" align='right'>
برای دستیابی به شناسه iOS یا همان IDFA میتوانید به صورت زیر عمل کنید:
</div>
<br/>

```js
AdTrace.getIdfa(function(idfa) {
    // Use idfa value.
});
```

### <div id="af-di-gps-adid" dir="rtl" align='right'>شناسه تبلیغات سرویس های گوگل پلی</div>

<div dir="rtl" align='right'>
سرویس های مشخص (همچون Google Analytics) برای هماهنگی بین شناسه تبلیغات و شناسه کاربر به جهت ممانعت از گزارش تکراری به شما نیاز دارد.
</div>
<br/>

<div dir="rtl" align='right'>
برای دستیابی به شناسه تبلیغاتی گوگل لازم است تا یک تابع callback به متد <code>AdTrace.getGoogleAdId</code> که این شناسه را دریافت میکند به صورت زیر استفاده کنید:
</div>
<br/>

```js
AdTrace.getGoogleAdId(function(googleAdId) {
    // Use googleAdId value.
});
```


### <div id="af-di-amz-adid" dir="rtl" align='right'>شناسه تبلیغات آمازون</div>

<div dir="rtl" align='right'>
برای دستیابی به شناسه تبلیغاتی آمازون لازم است تا یک تابع callback به متد <code>AdTrace.getAmazonAdId</code> که این شناسه را دریافت میکند به صورت زیر استفاده کنید:
</div>
<br/>

```js
AdTrace.getAmazonAdId(function(amazonAdId) {
    // Use amazonAdId value.
});
```

### <div id="af-di-adid" dir="rtl" align='right'>شناسه دستگاه ادتریس</div>

<div dir="rtl" align='right'>
برای هر دستگاهی که نصب میشود، سرور ادتریس یک <strong>شناسه یکتا</strong> (که به صورت <strong>adid</strong> نامیده ومشود) تولید میکند. برای دستیابی به این شناسه میتوانید به صورت زیر استفاده کنید:
</div>
<br/>

```js
AdTrace.getAdid(function(adid) {
    // Use adid value.
});
```

<br/>
<div dir="rtl" align='right'>
<strong>نکته</strong>: اطلاعات مربوط به شناسه <strong>شناسه ادتریس</strong> تنها بعد از ردیابی نصب توسط سرور ادتریس قابل درسترس است. دسترسی به شناسه ادتریس قبل این ردیابی و یا قبل راه اندازی ادتریس <strong>امکان پذیر نیست</strong>.
</div>

### <div id="af-pre-installed-trackers" dir="rtl" align='right'>ردیابی قبل از نصب</div>

<div dir="rtl" align='right'>
اگر مایل به این هستید که SDK ادتریس تشخیص این را بدهد که کدام کاربرانی از طریق نصب از پیشن تعیین شده وارد برنامه شده اند مراحل زیر را انجام دهید:
</div>
<br/>
<div dir="rtl" align='right'>
<ul>
<li>یک ترکر جدید در پنل خود ایجاد نمایید.</li>
<li>در تنظیمات SDK ادتریس مثل زیر ترکر پیشفرض را اعمال کنید:</li>
</ul>
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);
adtraceConfig.setDefaultTracker("{TrackerToken}");
AdTrace.create(adtraceConfig);
```

<br/>
<div dir="rtl" align='right'>
<ul>
<li>مقدار <code>{TrackerToken}</code> را با مقدار توکن ترکری که در مرحله اول دریافت کرده اید جاگزین کنید.</li>
<li>برنامه خود را بسازید. در قسمت خروجی لاگ خود همچین خطی را مشاهده خواهید کرد.</li>
</ul>
</div>
<br/>

  ```
  Default tracker: 'abc123'
  ```

### <div id="af-offline-mode" dir="rtl" align='right'>حالت آفلاین</div>

<div dir="rtl" align='right'>
برای مسدودسازی ارتباط SDK با سرورهای ادتریس میتوانید از حالت آفلاین SDK استفاده کنید(درحالیکه مجموعه داده ها بعدا برای رصد کردن ارسال میشود). در حالت آفلاین تمامی اطلاعات درون یک فایل ذخیره خواهد شد. توجه کنید که در این حالت رویدادهای زیادی را ایجاد نکنید.
</div>
<br/>
<div dir="rtl" align='right'>
برای فعالسازی حالت آفلاین متد <code>setOfflineMode</code> را با پارامتر <code>true</code> فعالسازی کنید.
</div>
<br/>

```js
AdTrace.setOfflineMode(true);
```

<br/>
<div dir="rtl" align='right'>
بر عکس حالت بالا با فراخوانی متد <code>setOfflineMode</code> به همراه متغیر <code>false</code> میتوانید این حالت آفلاین را غیرفعال کنید. هنگامی که SDK ادتریس به حالت آنلاین برگردد، تمامی اطلاعات ذخیر شده با زمان صحیح مربوط به خودش سمت سرور ارسال میشود.
</div>
<br/>
<div dir="rtl" align='right'>
برخلاف غیرفعال کردن ردیابی، این تنظیم بین نشست ها <strong>توصیه نمیشود</strong>. این بدین معنی است که SDK هرزمان که شروع شود در حالت آنلاین است، حتی اگر برنامه درحالت آفلاین خاتمه پیدا کند.
</div>

### <div id="af-disable-tracking" dir="rtl" align='right'>غیرفعال کردن ردیابی</div>

<div dir="rtl" align='right'>
شما میتوانید SDK ادتریس را برای رصدکردن هرگونی فعالیت برای این دستگاه غیر فعال کنید که این کار از طریق متد <code>setEnabled</code> با پارامتر <code>false</code> امکان پذیر است. <strong>این تنظیم بین نشست ها به خاطر سپرده میشود</strong>.
</div>
<br/>

```js
AdTrace.setEnabled(false);
```

<br/>
<div dir="rtl" align='right'>
شما برای اطلاع از فعال بودن ادتریس میتوانید از تابع <code>isEnabled</code> استفاده کنید. این امکان فراهم است که  SDK ادتریس را با متد <code>setEnabled</code> و پارامتر <code>true</code> فعالسازی کنید.
</div>

### <div id="af-event-buffering" dir="rtl" align='right'>بافرکردن رویدادها</div>

<div dir="rtl" align='right'>
اگر برنامه شما استفاده زیادی از رویدادها میکند، ممکن است بخواهید با یک حالت تاخیر و در یک مجموعه هر دقیقه ارسال کنید. میتوانید از طریق زیر بافرکردن رویدادها را فعالسازی کنید:
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);
adtraceConfig.setEventBufferingEnabled(true);
AdTrace.create(adtraceConfig);
```

### <div id="af-background-tracking" dir="rtl" align='right'>ردیابی در پس زمینه</div>

<div dir="rtl" align='right'>
رفتار پیشفرض SDK ادتریس هنگامی که برنامه در حالت پس زمینه قرار دارد، به صورت متوقف شده از ارسال داده ها میباشد. برای تغییر این مورد میتوانید به صورت زیر عمل کنید:
</div>
<br/>

```js
var adtraceConfig = new AdTraceConfig(appToken, environment);
adtraceConfig.setSendInBackground(true);
AdTrace.create(adtraceConfig);
```

### <div id="af-gdpr-forget-me" dir="rtl" align='right'>GPDR</div>

<div dir="rtl" align='right'>
بر طبق قانون GPDR شما این اعلان را به ادتریس میتوانید بکنید هنگامی که کاربر حق این را دارد که اطلاعاتش محفوظ بماند. از طریق متد زیر میتوانید این کار را انجام دهید:
</div>
<br/>

```js
AdTrace.gdprForgetMe();
```

<br/>
<div dir="rtl" align='right'>
طی دریافت این داده، ادتریس تمامی داده های کاربر را پاک خواهد کرد و ردیابی کاربر را متوقف خواهد کرد. هیچ درخواستی از این دستگاه به ادتریس در آینده ارسال نخواهد شد.
</div>
<br/>
<div dir="rtl" align='right'>
درنظر داشته باشید که حتی در زمان تست، این تصمیم بدون تغییر خواهد بود و قابل برگشت <strong>نیست</strong>.
</div>
