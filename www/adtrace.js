function callCordova(action) {
    var args = Array.prototype.slice.call(arguments, 1);

    cordova.exec(
        function callback(data) { },
        function errorHandler(err) { },
        'AdTrace',
        action,
        args
    );
}

function callCordovaStringify(action) {
    var args = Array.prototype.slice.call(arguments, 1);

    cordova.exec(
        function callback(data) { },
        function errorHandler(err) { },
        'AdTrace',
        action,
        [JSON.stringify(args)]
    );
}

function callCordovaCallback(action, callback) {
    var args = Array.prototype.slice.call(arguments, 2);

    cordova.exec(callback,
        function errorHandler(err) { },
        'AdTrace',
        action,
        args
    );
}

var AdTrace = {
    create: function(adtraceConfig) {
        if (adtraceConfig) {
            adtraceConfig.sdkPrefix = this.getSdkPrefix();
        }

        if (adtraceConfig.hasAttributionListener()) {
            callCordovaCallback('setAttributionCallback', adtraceConfig.getAttributionCallback());
        }

        if (adtraceConfig.hasEventTrackingSucceededListener()) {
            callCordovaCallback('setEventTrackingSucceededCallback', adtraceConfig.getEventTrackingSucceededCallback());
        }

        if (adtraceConfig.hasEventTrackingFailedListener()) {
            callCordovaCallback('setEventTrackingFailedCallback', adtraceConfig.getEventTrackingFailedCallback());
        }

        if (adtraceConfig.hasSessionTrackingSucceededListener()) {
            callCordovaCallback('setSessionTrackingSucceededCallback', adtraceConfig.getSessionTrackingSucceededCallback());
        }

        if (adtraceConfig.hasSessionTrackingFailedListener()) {
            callCordovaCallback('setSessionTrackingFailedCallback', adtraceConfig.getSessionTrackingFailedCallback());
        }

        if (adtraceConfig.hasDeferredDeeplinkCallbackListener()) {
            callCordovaCallback('setDeferredDeeplinkCallback', adtraceConfig.getDeferredDeeplinkCallback());
        }

        callCordovaStringify('create', adtraceConfig);
    },

    trackEvent: function(adtraceEvent) {
        callCordovaStringify('trackEvent', adtraceEvent);
    },

    setOfflineMode: function(enabled) {
        callCordova('setOfflineMode', enabled);
    },

    appWillOpenUrl: function(url) {
        callCordova('appWillOpenUrl', url);
    },

    setEnabled: function(enabled) {
        callCordova('setEnabled', enabled);
    },

    setPushToken: function(pushToken) {
        callCordova('setPushToken', pushToken);
    },

    setReferrer: function(referrer) {
        callCordova('setReferrer', referrer);
    },

    isEnabled: function(callback) {
        callCordovaCallback('isEnabled', callback);
    },

    gdprForgetMe: function() {
        callCordova('gdprForgetMe');
    },

    getGoogleAdId: function(callback) {
        callCordovaCallback('getGoogleAdId', callback);
    },

    getAmazonAdId: function(callback) {
        callCordovaCallback('getAmazonAdId', callback);
    },

    getIdfa: function(callback) {
        callCordovaCallback('getIdfa', callback);
    },

    getAdid: function(callback) {
        callCordovaCallback('getAdid', callback);
    },

    getAttribution: function(callback) {
        callCordovaCallback('getAttribution', callback);
    },

    getSdkVersion: function(callback) {
        var sdkPrefix = this.getSdkPrefix();
        callCordovaCallback('getSdkVersion', function(sdkVersion) {
            callback(sdkPrefix + "@" + sdkVersion);
        });
    },

    getSdkPrefix: function () {
        return 'cordova0.0.4';
    },

    addSessionCallbackParameter: function(key, value) {
        callCordova('addSessionCallbackParameter', key, value);
    },

    removeSessionCallbackParameter: function(key) {
        callCordova('removeSessionCallbackParameter', key);
    },

    resetSessionCallbackParameters: function() {
        callCordova('resetSessionCallbackParameters');
    },

    addSessionPartnerParameter: function(key, value) {
        callCordova('addSessionPartnerParameter', key, value);
    },

    removeSessionPartnerParameter: function(key) {
        callCordova('removeSessionPartnerParameter', key);
    },

    resetSessionPartnerParameters: function() {
        callCordova('resetSessionPartnerParameters');
    },

    sendFirstPackages: function() {
        callCordova('sendFirstPackages');
    },

    setTestOptions: function(testOptions) {
        callCordova('setTestOptions', testOptions);
    },

    teardown: function(testParam) {
        if(testParam === null || testParam === undefined || testParam !== 'test') {
           return;
        }
        callCordova('teardown');
    },

    onResume: function(testParam) {
        if(testParam === null || testParam === undefined || testParam !== 'test') {
           return;
        }
        callCordova('onResume');
    },

    onPause: function(testParam) {
        if(testParam === null || testParam === undefined || testParam !== 'test') {
           return;
        }
        callCordova('onPause');
    }
};

function onPause() {
    callCordova('onPause');
}

function onResume() {
    callCordova('onResume');
}

document.addEventListener('resume', onResume, false);
document.addEventListener('pause', onPause, false);

module.exports = AdTrace;