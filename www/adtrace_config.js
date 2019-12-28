function AdTraceConfig(appToken, environment) {
    this.appToken = appToken;
    this.environment = environment;
    this.delayStart = 0.0;
    this.logLevel = null;
    this.referrer = null;
    this.userAgent = null;
    this.isDeviceKnown = null;
    this.defaultTracker = null;
    this.sendInBackground = null;
    this.shouldLaunchDeeplink = null;
    this.enableInstalledApps = null;
    this.eventBufferingEnabled = null;
    this.attributionCallback = null;
    this.eventTrackingSucceededCallback = null;
    this.eventTrackingFailedCallback = null;
    this.sessionTrackingSucceededCallback = null;
    this.sessionTrackingFailedCallback = null;
    this.deferredDeeplinkCallback = null;
    this.sdkPrefix = null;
    this.secretId = null;
    this.info1 = null;
    this.info2 = null;
    this.info3 = null;
    this.info4 = null;
    // Android only
    this.processName = null;
    this.readMobileEquipmentIdentity = null;
};

AdTraceConfig.EnvironmentSandbox    = "sandbox";
AdTraceConfig.EnvironmentProduction = "production";
AdTraceConfig.LogLevelVerbose       = "VERBOSE";
AdTraceConfig.LogLevelDebug         = "DEBUG";
AdTraceConfig.LogLevelInfo          = "INFO";
AdTraceConfig.LogLevelWarn          = "WARN";
AdTraceConfig.LogLevelError         = "ERROR";
AdTraceConfig.LogLevelAssert        = "ASSERT";
AdTraceConfig.LogLevelSuppress      = "SUPPRESS";

AdTraceConfig.prototype.getUserAgent = function() {
    return this.userAgent;
};

AdTraceConfig.prototype.getDelayStart = function() {
    return this.delayStart;
};

AdTraceConfig.prototype.getReferrer = function() {
    return this.referrer;
};

AdTraceConfig.prototype.getSendInBackground = function() {
    return this.sendInBackground;
};

AdTraceConfig.prototype.getShouldLaunchDeeplink = function() {
    return this.shouldLaunchDeeplink;
};

AdTraceConfig.prototype.getEnableInstalledApps = function() {
    return this.enableInstalledApps;
};

AdTraceConfig.prototype.getAttributionCallback = function() {
    return this.attributionCallbackListener;
};

AdTraceConfig.prototype.getEventTrackingSucceededCallback = function() {
    return this.eventTrackingSucceededCallbackListener;
};

AdTraceConfig.prototype.getEventTrackingFailedCallback = function() {
    return this.eventTrackingFailedCallbackListener;
};

AdTraceConfig.prototype.getSessionTrackingSucceededCallback = function() {
    return this.sessionTrackingSucceededCallbackListener;
};

AdTraceConfig.prototype.getSessionTrackingFailedCallback = function() {
    return this.sessionTrackingFailedCallbackListener;
};

AdTraceConfig.prototype.getDeferredDeeplinkCallback = function() {
    return this.deferredDeeplinkCallbackListener;
};

AdTraceConfig.prototype.setEventBufferingEnabled = function(isEnabled) {
    this.eventBufferingEnabled = isEnabled;
};

AdTraceConfig.prototype.setLogLevel = function(logLevel) {
    this.logLevel = logLevel;
};

AdTraceConfig.prototype.setProcessName = function(processName) {
    this.processName = processName;
};

AdTraceConfig.prototype.setDefaultTracker = function(defaultTracker) {
    this.defaultTracker = defaultTracker;
};

AdTraceConfig.prototype.setUserAgent = function(userAgent) {
    this.userAgent = userAgent;
}

AdTraceConfig.prototype.setDeviceKnown = function(isDeviceKnown) {
    this.isDeviceKnown = isDeviceKnown;
}

AdTraceConfig.prototype.getSdkPrefix = function() {
    return this.sdkPrefix;
};

AdTraceConfig.prototype.setSdkPrefix = function(sdkPrefix) {
    this.sdkPrefix = sdkPrefix;
};


AdTraceConfig.prototype.setAppSecret = function(secretId, info1, info2, info3, info4) {
    if (secretId !== null) {
        this.secretId = secretId.toString();
    }
    if (info1 !== null) {
        this.info1 = info1.toString();
    }
    if (info2 !== null) {
        this.info2 = info2.toString();
    }
    if (info3 !== null) {
        this.info3 = info3.toString();
    }
    if (info4 !== null) {
        this.info4 = info4.toString();
    }
};

AdTraceConfig.prototype.setDelayStart = function(delayStart) {
    this.delayStart = delayStart;
}

AdTraceConfig.prototype.setReferrer = function(referrer) {
    this.referrer = referrer;
};

AdTraceConfig.prototype.setSendInBackground = function(sendInBackground) {
    this.sendInBackground = sendInBackground;
};

AdTraceConfig.prototype.setShouldLaunchDeeplink = function(shouldLaunchDeeplink) {
    this.shouldLaunchDeeplink = shouldLaunchDeeplink;
};

AdTraceConfig.prototype.setEnableInstalledApps = function(enableInstalledApps) {
    this.enableInstalledApps = enableInstalledApps;
};

// @deprecated
AdTraceConfig.prototype.setCallbackListener = function(callbackListener) {
    console.warn("Calling deprecated function! Use the setAttributionCallbackListener instead. Check adtrace_config.js for more info.");
    this.attributionCallbackListener = attributionCallbackListener;
};

AdTraceConfig.prototype.setAttributionCallbackListener = function(attributionCallbackListener) {
    this.attributionCallbackListener = attributionCallbackListener;
};

AdTraceConfig.prototype.setEventTrackingSucceededCallbackListener = function(eventTrackingSucceededCallbackListener) {
    this.eventTrackingSucceededCallbackListener = eventTrackingSucceededCallbackListener;
};

AdTraceConfig.prototype.setEventTrackingFailedCallbackListener = function(eventTrackingFailedCallbackListener) {
    this.eventTrackingFailedCallbackListener = eventTrackingFailedCallbackListener;
};

AdTraceConfig.prototype.setSessionTrackingSucceededCallbackListener = function(sessionTrackingSucceededCallbackListener) {
    this.sessionTrackingSucceededCallbackListener = sessionTrackingSucceededCallbackListener;
};

AdTraceConfig.prototype.setSessionTrackingFailedCallbackListener = function(sessionTrackingFailedCallbackListener) {
    this.sessionTrackingFailedCallbackListener = sessionTrackingFailedCallbackListener;
};

AdTraceConfig.prototype.setDeferredDeeplinkCallbackListener = function(deferredDeeplinkCallbackListener) {
    this.deferredDeeplinkCallbackListener = deferredDeeplinkCallbackListener;
};

// @deprecated
AdTraceConfig.prototype.hasListener = function() {
    console.warn("Calling deprecated function! Use the hasAttributionListener instead. Check adtrace_config.js for more info");
    return this.attributionCallbackListener !== null;
};

AdTraceConfig.prototype.hasAttributionListener = function() {
    return this.attributionCallbackListener !== null;
};

AdTraceConfig.prototype.hasEventTrackingSucceededListener = function() {
    return this.eventTrackingSucceededCallbackListener !== null;
};

AdTraceConfig.prototype.hasEventTrackingFailedListener = function() {
    return this.eventTrackingFailedCallbackListener !== null;
};

AdTraceConfig.prototype.hasSessionTrackingSucceededListener = function() {
    return this.sessionTrackingSucceededCallbackListener !== null;
};

AdTraceConfig.prototype.hasSessionTrackingFailedListener = function() {
    return this.sessionTrackingFailedCallbackListener !== null;
};

AdTraceConfig.prototype.hasDeferredDeeplinkCallbackListener = function() {
    return this.deferredDeeplinkCallbackListener !== null;
};

module.exports = AdTraceConfig;