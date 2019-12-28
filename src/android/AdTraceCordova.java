package io.adtrace.sdk;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import android.net.Uri;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult.Status;
import static io.adtrace.sdk.AdTraceCordovaUtils.*;

public class AdTraceCordova extends CordovaPlugin implements OnAttributionChangedListener, 
    OnEventTrackingSucceededListener,
    OnEventTrackingFailedListener,
    OnSessionTrackingSucceededListener,
    OnSessionTrackingFailedListener,
    OnDeeplinkResponseListener, 
    OnDeviceIdsRead {
    private boolean shouldLaunchDeeplink = true;
    private CallbackContext attributionCallbackContext;
    private CallbackContext eventTrackingSucceededCallbackContext;
    private CallbackContext eventTrackingFailedCallbackContext;
    private CallbackContext sessionTrackingSucceededCallbackContext;
    private CallbackContext sessionTrackingFailedCallbackContext;
    private CallbackContext deferredDeeplinkCallbackContext;
    private CallbackContext getAdidCallbackContext;
    private CallbackContext getIdfaCallbackContext;
    private CallbackContext getGoogleAdIdCallbackContext;
    private CallbackContext getAmazonAdidCallbackContext;
    private CallbackContext getAttributionCallbackContext;

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(COMMAND_CREATE)) {
            executeCreate(args);
        } else if (action.equals(COMMAND_SET_ATTRIBUTION_CALLBACK)) {
            attributionCallbackContext = callbackContext;
        } else if (action.equals(COMMAND_SET_EVENT_TRACKING_SUCCEEDED_CALLBACK)) {
            eventTrackingSucceededCallbackContext = callbackContext;
        } else if (action.equals(COMMAND_SET_EVENT_TRACKING_FAILED_CALLBACK)) {
            eventTrackingFailedCallbackContext = callbackContext;
        } else if (action.equals(COMMAND_SET_SESSION_TRACKING_SUCCEEDED_CALLBACK)) {
            sessionTrackingSucceededCallbackContext = callbackContext;
        } else if (action.equals(COMMAND_SET_SESSION_TRACKING_FAILED_CALLBACK)) {
            sessionTrackingFailedCallbackContext = callbackContext;
        } else if (action.equals(COMMAND_SET_DEFERRED_DEEPLINK_CALLBACK)) {
            deferredDeeplinkCallbackContext = callbackContext;
        } else if (action.equals(COMMAND_GET_GOOGLE_AD_ID)) {
            getGoogleAdIdCallbackContext = callbackContext;
            if (getGoogleAdIdCallbackContext != null) {
                AdTrace.getGoogleAdId(this.cordova.getActivity().getApplicationContext(), this);
            }
        } else if (action.equals(COMMAND_GET_AMAZON_AD_ID)) {
            getAmazonAdidCallbackContext = callbackContext;
            if (getAmazonAdidCallbackContext != null) {
                String amazonAdId = AdTrace.getAmazonAdId(this.cordova.getActivity().getApplicationContext());
                if (amazonAdId == null) {
                    amazonAdId = "";
                }
                PluginResult pluginResult = new PluginResult(Status.OK, amazonAdId);
                pluginResult.setKeepCallback(true);
                getAmazonAdidCallbackContext.sendPluginResult(pluginResult);
            }
        } else if (action.equals(COMMAND_GET_ADID)) {
            getAdidCallbackContext = callbackContext;
            if (getAdidCallbackContext != null) {
                final String adid = AdTrace.getAdid();
                PluginResult pluginResult = new PluginResult(Status.OK, adid);
                pluginResult.setKeepCallback(true);
                getAdidCallbackContext.sendPluginResult(pluginResult);
            }
        } else if (action.equals(COMMAND_GET_ATTRIBUTION)) {
            getAttributionCallbackContext = callbackContext;
            if (getAttributionCallbackContext != null) {
                final AdTraceAttribution attribution = AdTrace.getAttribution();
                JSONObject attributionJsonData = new JSONObject(getAttributionMap(attribution));
                PluginResult pluginResult = new PluginResult(Status.OK, attributionJsonData);
                pluginResult.setKeepCallback(true);
                getAttributionCallbackContext.sendPluginResult(pluginResult);
            }
        } else if (action.equals(COMMAND_GET_IDFA)) {
            getIdfaCallbackContext = callbackContext;
            final String idfa = "";
            PluginResult pluginResult = new PluginResult(Status.OK, idfa);
            pluginResult.setKeepCallback(true);
            getIdfaCallbackContext.sendPluginResult(pluginResult);
        } else if (action.equals(COMMAND_GET_SDK_VERSION)) {
            String sdkVersion = AdTrace.getSdkVersion();
            if (sdkVersion == null) {
                sdkVersion = "";
            }
            PluginResult pluginResult = new PluginResult(Status.OK, sdkVersion);
            callbackContext.sendPluginResult(pluginResult);
        } else if (action.equals(COMMAND_TRACK_EVENT)) {
            executeTrackEvent(args);
        } else if (action.equals(COMMAND_SET_OFFLINE_MODE)) {
            final Boolean enabled = args.getBoolean(0);
            AdTrace.setOfflineMode(enabled);
        } else if (action.equals(COMMAND_SET_PUSH_TOKEN)) {
            final String token = args.getString(0);
            AdTrace.setPushToken(token, this.cordova.getActivity().getApplicationContext());
        } else if (action.equals(COMMAND_ON_PAUSE)) {
            AdTrace.onPause();
        } else if (action.equals(COMMAND_ON_RESUME)) {
            AdTrace.onResume();
        } else if (action.equals(COMMAND_SET_ENABLED)) {
            final Boolean enabled = args.getBoolean(0);
            AdTrace.setEnabled(enabled);
        } else if (action.equals(COMMAND_IS_ENABLED)) {
            final Boolean isEnabled = AdTrace.isEnabled();
            PluginResult pluginResult = new PluginResult(Status.OK, isEnabled);
            callbackContext.sendPluginResult(pluginResult);
        } else if (action.equals(COMMAND_APP_WILL_OPEN_URL)) {
            String url = args.getString(0);
            final Uri uri = Uri.parse(url);
            AdTrace.appWillOpenUrl(uri, this.cordova.getActivity().getApplicationContext());
        } else if (action.equals(COMMAND_ADD_SESSION_CALLBACK_PARAMETER)) {
            final String key = args.getString(0);
            final String value = args.getString(1);
            AdTrace.addSessionCallbackParameter(key, value);
        } else if (action.equals(COMMAND_REMOVE_SESSION_CALLBACK_PARAMETER)) {
            final String key = args.getString(0);
            AdTrace.removeSessionCallbackParameter(key);
        } else if (action.equals(COMMAND_RESET_SESSION_CALLBACK_PARAMETERS)) {
            AdTrace.resetSessionCallbackParameters();
        } else if (action.equals(COMMAND_ADD_SESSION_PARTNER_PARAMETER)) {
            final String key = args.getString(0);
            final String value = args.getString(1);
            AdTrace.addSessionPartnerParameter(key, value);
        } else if (action.equals(COMMAND_REMOVE_SESSION_PARTNER_PARAMETER)) {
            final String key = args.getString(0);
            AdTrace.removeSessionPartnerParameter(key);
        } else if (action.equals(COMMAND_RESET_SESSION_PARTNER_PARAMETERS)) {
            AdTrace.resetSessionPartnerParameters();
        } else if (action.equals(COMMAND_SEND_FIRST_PACKAGES)) {
            AdTrace.sendFirstPackages();
        } else if (action.equals(COMMAND_GDPR_FORGET_ME)) {
            AdTrace.gdprForgetMe(this.cordova.getActivity().getApplicationContext());
        } else if (action.equals(COMMAND_SET_REFERRER)) {
            final String referrer = args.getString(0);
            AdTrace.setReferrer(referrer, this.cordova.getActivity().getApplicationContext());
        } else if (action.equals(COMMAND_SET_TEST_OPTIONS)) {
            executeSetTestOptions(args);
        } else if (action.equals(COMMAND_TEARDOWN)) {
            attributionCallbackContext = null;
            eventTrackingSucceededCallbackContext = null;
            eventTrackingFailedCallbackContext = null;
            sessionTrackingSucceededCallbackContext = null;
            sessionTrackingFailedCallbackContext = null;
            deferredDeeplinkCallbackContext = null;
            getAdidCallbackContext = null;
            getIdfaCallbackContext = null;
            getGoogleAdIdCallbackContext = null;
            getAmazonAdidCallbackContext = null;
            getAttributionCallbackContext = null;
            shouldLaunchDeeplink = true;
        } else {
            Logger logger = (Logger)AdTraceFactory.getLogger();
            logger.error(String.format("[AdTraceCordova]: Invalid call (%s).", action));
            return false;    
        }

        return true;
    }

    private void executeCreate(final JSONArray args) throws JSONException {
        String params = args.getString(0);
        JSONArray jsonArrayParams = new JSONArray(params);
        JSONObject jsonParameters = jsonArrayParams.optJSONObject(0);
        Map<String, Object> parameters = jsonObjectToMap(jsonParameters);

        String appToken = null;
        String environment = null;
        String defaultTracker = null;
        String processName = null;
        String delayStart = null;
        String logLevel = null;
        String userAgent = null;
        String sdkPrefix = null;
        String secretId = null;
        String info1 = null;
        String info2 = null;
        String info3 = null;
        String info4 = null;
        boolean isLogLevelSuppress = false;
        boolean eventBufferingEnabled = false;
        boolean isDeviceKnown = false;
        boolean sendInBackground = false;
        boolean shouldLaunchDeeplink = false;
        boolean enableInstalledApps = false;

        if (parameters.containsKey(KEY_APP_TOKEN)) {
            appToken = parameters.get(KEY_APP_TOKEN).toString();
        }
        if (parameters.containsKey(KEY_ENVIRONMENT)) {
            environment = parameters.get(KEY_ENVIRONMENT).toString();
        }
        if (parameters.containsKey(KEY_DEFAULT_TRACKER)) {
            defaultTracker = parameters.get(KEY_DEFAULT_TRACKER).toString();
        }
        if (parameters.containsKey(KEY_PROCESS_NAME)) {
            processName = parameters.get(KEY_PROCESS_NAME).toString();
        }
        if (parameters.containsKey(KEY_DELAY_START)) {
            delayStart = parameters.get(KEY_DELAY_START).toString();
        }
        if (parameters.containsKey(KEY_LOG_LEVEL)) {
            logLevel = parameters.get(KEY_LOG_LEVEL).toString().toUpperCase();
        }
        if (parameters.containsKey(KEY_USER_AGENT)) {
            userAgent = parameters.get(KEY_USER_AGENT).toString();
        }
        if (parameters.containsKey(KEY_SECRET_ID)) {
            secretId = parameters.get(KEY_SECRET_ID).toString();
        }
        if (parameters.containsKey(KEY_SDK_PREFIX)) {
            sdkPrefix = parameters.get(KEY_SDK_PREFIX).toString();
        }
        if (parameters.containsKey(KEY_INFO_1)) {
            info1 = parameters.get(KEY_INFO_1).toString();
        }
        if (parameters.containsKey(KEY_INFO_2)) {
            info2 = parameters.get(KEY_INFO_2).toString();
        }
        if (parameters.containsKey(KEY_INFO_3)) {
            info3 = parameters.get(KEY_INFO_3).toString();
        }
        if (parameters.containsKey(KEY_INFO_4)) {
            info4 = parameters.get(KEY_INFO_4).toString();
        }
        if (parameters.containsKey(KEY_EVENT_BUFFERING_ENABLED)) {
            eventBufferingEnabled = parameters.get(KEY_EVENT_BUFFERING_ENABLED).toString() == "true" ? true : false;
        }
        if (parameters.containsKey(KEY_DEVICE_KNOWN)) {
            isDeviceKnown = parameters.get(KEY_DEVICE_KNOWN).toString() == "true" ? true : false;
        }
        if (parameters.containsKey(KEY_SEND_IN_BACKGROUND)) {
            sendInBackground = parameters.get(KEY_SEND_IN_BACKGROUND).toString() == "true" ? true : false;
        }
        if (parameters.containsKey(KEY_SHOULD_LAUNCH_DEEPLINK)) {
            shouldLaunchDeeplink = parameters.get(KEY_SHOULD_LAUNCH_DEEPLINK).toString() == "true" ? true : false;
        }
        if (parameters.containsKey(KEY_ENABLE_INSTALLED_APPS)) {
            enableInstalledApps = parameters.get(KEY_ENABLE_INSTALLED_APPS).toString() == "true" ? true : false;
        }

        if (isFieldValid(logLevel) && logLevel.equals("SUPPRESS")) {
            isLogLevelSuppress = true;
        }

        final AdTraceConfig adtraceConfig = new AdTraceConfig(this.cordova.getActivity().getApplicationContext(), appToken, environment, isLogLevelSuppress);
        if (!adtraceConfig.isValid()) {
            return;
        }

        // Log level.
        if (isFieldValid(logLevel)) {
            if (logLevel.equals("VERBOSE")) {
                adtraceConfig.setLogLevel(LogLevel.VERBOSE);
            } else if (logLevel.equals("DEBUG")) {
                adtraceConfig.setLogLevel(LogLevel.DEBUG);
            } else if (logLevel.equals("INFO")) {
                adtraceConfig.setLogLevel(LogLevel.INFO);
            } else if (logLevel.equals("WARN")) {
                adtraceConfig.setLogLevel(LogLevel.WARN);
            } else if (logLevel.equals("ERROR")) {
                adtraceConfig.setLogLevel(LogLevel.ERROR);
            } else if (logLevel.equals("ASSERT")) {
                adtraceConfig.setLogLevel(LogLevel.ASSERT);
            } else if (logLevel.equals("SUPPRESS")) {
                adtraceConfig.setLogLevel(LogLevel.SUPRESS);
            } else {
                adtraceConfig.setLogLevel(LogLevel.INFO);
            }
        }

        // SDK prefix.
        if (isFieldValid(sdkPrefix)) {
            adtraceConfig.setSdkPrefix(sdkPrefix);
        }

        // Main process name.
        if (isFieldValid(processName)) {
            adtraceConfig.setProcessName(processName);
        }

        // Default tracker.
        if (isFieldValid(defaultTracker)) {
            adtraceConfig.setDefaultTracker(defaultTracker);
        }

        // User agent.
        if (isFieldValid(userAgent)) {
            adtraceConfig.setUserAgent(userAgent);
        }

        // App secret.
        if (isFieldValid(secretId) && isFieldValid(info1) && isFieldValid(info2) && isFieldValid(info3) && isFieldValid(info4)) {
            try {
                long lSecretId = Long.parseLong(secretId, 10);
                long lInfo1 = Long.parseLong(info1, 10);
                long lInfo2 = Long.parseLong(info2, 10);
                long lInfo3 = Long.parseLong(info3, 10);
                long lInfo4 = Long.parseLong(info4, 10);
                adtraceConfig.setAppSecret(lSecretId, lInfo1, lInfo2, lInfo3, lInfo4);
            } catch(NumberFormatException ignored) {}
        }

        // Event buffering.
        adtraceConfig.setEventBufferingEnabled(eventBufferingEnabled);

        // Is device known.
        adtraceConfig.setDeviceKnown(isDeviceKnown);

        // Background tracking.
        adtraceConfig.setSendInBackground(sendInBackground);

        // Send installed apps.
        adtraceConfig.enableSendInstalledApps(enableInstalledApps);

        // Launching deferred deep link.
        this.shouldLaunchDeeplink = shouldLaunchDeeplink;

        // Delayed start.
        if (isFieldValid(delayStart)) {
            try {
                double dDelayStart = Double.parseDouble(delayStart);
                adtraceConfig.setDelayStart(dDelayStart);
            } catch(NumberFormatException ignored) {}
        }

        // Attribution callback.
        if (attributionCallbackContext != null) {
            adtraceConfig.setOnAttributionChangedListener(this);
        }

        // Event tracking succeeded callback.
        if (eventTrackingSucceededCallbackContext != null) {
            adtraceConfig.setOnEventTrackingSucceededListener(this);
        }

        // Event tracking failed callback.
        if (eventTrackingFailedCallbackContext != null) {
            adtraceConfig.setOnEventTrackingFailedListener(this);
        }

        // Session tracking succeeded callback.
        if (sessionTrackingSucceededCallbackContext != null) {
            adtraceConfig.setOnSessionTrackingSucceededListener(this);
        }

        // Session tracking failed callback.
        if (sessionTrackingFailedCallbackContext != null) {
            adtraceConfig.setOnSessionTrackingFailedListener(this);
        }

        // Deferred deeplink callback listener.
        if (deferredDeeplinkCallbackContext != null) {
            adtraceConfig.setOnDeeplinkResponseListener(this);
        }

        // Start SDK.
        AdTrace.onCreate(adtraceConfig);
        // Needed because Cordova doesn't launch 'resume' event on app start.
        // It initializes it only when app comes back from the background.
        AdTrace.onResume();
    }

    private void executeTrackEvent(final JSONArray args) throws JSONException {
        String params = args.getString(0);
        JSONArray jsonArrayParams = new JSONArray(params);
        JSONObject jsonParameters = jsonArrayParams.optJSONObject(0);
        Map<String, Object> parameters = jsonObjectToMap(jsonParameters);

        String eventToken = null;
        String revenue = null;
        String currency = null;
        String callbackId = null;

        if (parameters.containsKey(KEY_EVENT_TOKEN)) {
            eventToken = parameters.get(KEY_EVENT_TOKEN).toString();
        }
        if (parameters.containsKey(KEY_REVENUE)) {
            revenue = parameters.get(KEY_REVENUE).toString();
        }
        if (parameters.containsKey(KEY_CURRENCY)) {
            currency = parameters.get(KEY_CURRENCY).toString();
        }
        if (parameters.containsKey(KEY_CALLBACK_ID)) {
            callbackId = parameters.get(KEY_CALLBACK_ID).toString();
        }

        JSONArray partnerParametersJson = (JSONArray)parameters.get(KEY_PARTNER_PARAMETERS);
        JSONArray callbackParametersJson = (JSONArray)parameters.get(KEY_CALLBACK_PARAMETERS);
        String[] partnerParameters = jsonArrayToArray(partnerParametersJson);
        String[] callbackParameters = jsonArrayToArray(callbackParametersJson);

        final AdTraceEvent adtraceEvent = new AdTraceEvent(eventToken);
        if (!adtraceEvent.isValid()) {
            return;
        }

        // Revenue and currency.
        if (isFieldValid(revenue) && isFieldValid(currency)) {
            try {
                double revenueValue = Double.parseDouble(revenue);
                adtraceEvent.setRevenue(revenueValue, currency);
            } catch (Exception e) {
                ILogger logger = AdTraceFactory.getLogger();
                logger.error("[AdTraceCordova]: Unable to parse revenue.");
            }
        }

        // Callback parameters.
        for (int i = 0; i < callbackParameters.length; i +=2) {
            String key = callbackParameters[i];
            String value = callbackParameters[i+1];
            adtraceEvent.addCallbackParameter(key, value);
        }

        // Partner parameters.
        for (int i = 0; i < partnerParameters.length; i += 2) {
            String key = partnerParameters[i];
            String value = partnerParameters[i+1];
            adtraceEvent.addPartnerParameter(key, value);
        }

        // Callback ID.
        if (isFieldValid(callbackId)) {
            adtraceEvent.setCallbackId(callbackId);
        }

        // Track event.
        AdTrace.trackEvent(adtraceEvent);
    }

    private void executeSetTestOptions(final JSONArray args) throws JSONException {
        JSONObject jsonParameters = args.optJSONObject(0);
        Map<String, Object> parameters = jsonObjectToMap(jsonParameters);
        final AdTraceTestOptions testOptions = new AdTraceTestOptions();

        if (!jsonParameters.isNull(KEY_HAS_CONTEXT)) {
            try {
                boolean value = jsonParameters.getBoolean(KEY_HAS_CONTEXT);
                if (value) {
                    testOptions.context = this.cordova.getActivity().getApplicationContext();
                }
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse context.");
            }
        }

        if (!jsonParameters.isNull(KEY_BASE_URL)) {
            try {
                String value = jsonParameters.getString(KEY_BASE_URL);
                testOptions.baseUrl = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse base URL.");
            }
        }

        if (!jsonParameters.isNull(KEY_GDPR_URL)) {
            try {
                String value = jsonParameters.getString(KEY_GDPR_URL);
                testOptions.gdprUrl = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse GDPR URL.");
            }
        }

        if (!jsonParameters.isNull(KEY_BASE_PATH)) {
            try {
                String value = jsonParameters.getString(KEY_BASE_PATH);
                testOptions.basePath = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse base path.");
            }
        }

        if (!jsonParameters.isNull(KEY_GDPR_PATH)) {
            try {
                String value = jsonParameters.getString(KEY_GDPR_PATH);
                testOptions.gdprPath = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse GDPR path.");
            }
        }

        if (!jsonParameters.isNull(KEY_USE_TEST_CONNECTION_OPTIONS)) {
            try {
                boolean value = jsonParameters.getBoolean(KEY_USE_TEST_CONNECTION_OPTIONS);
                testOptions.useTestConnectionOptions = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse use test connection options.");
            }
        }

        if (!jsonParameters.isNull(KEY_TIMER_INTERVAL)) {
            try {
                long value = jsonParameters.getLong(KEY_TIMER_INTERVAL);
                testOptions.timerIntervalInMilliseconds = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse timer interval.");
            }
        }

        if (!jsonParameters.isNull(KEY_TIMER_START)) {
            try {
                long value = jsonParameters.getLong(KEY_TIMER_START);
                testOptions.timerStartInMilliseconds = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse timer start.");
            }
        }

        if (!jsonParameters.isNull(KEY_SESSION_INTERVAL)) {
            try {
                long value = jsonParameters.getLong(KEY_SESSION_INTERVAL);
                testOptions.sessionIntervalInMilliseconds = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse session interval.");
            }
        } 

        if (!jsonParameters.isNull(KEY_SUBSESSION_INTERVAL)) {
            try {
                long value = jsonParameters.getLong(KEY_SUBSESSION_INTERVAL);
                testOptions.subsessionIntervalInMilliseconds = value;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse subsession interval.");
            }
        }

        if (!jsonParameters.isNull(KEY_TEARDOWN)) {
            try {
                boolean teardown = jsonParameters.getBoolean(KEY_TEARDOWN);
                testOptions.teardown = teardown;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse teardown.");
            }
        }

        if (!jsonParameters.isNull(KEY_NO_BACKOFF_WAIT)) {
            try {
                boolean noBackoffWait = jsonParameters.getBoolean(KEY_NO_BACKOFF_WAIT);
                testOptions.noBackoffWait = noBackoffWait;
            } catch (JSONException e) {
                AdTraceFactory.getLogger().error("[AdTraceCordova]: Unable to parse noBackoffWait.");
            }
        }

        AdTrace.setTestOptions(testOptions);
    }

    @Override
    public void onAttributionChanged(AdTraceAttribution attribution) {
        if (attributionCallbackContext == null) {
            return;
        }

        JSONObject attributionJsonData = new JSONObject(getAttributionMap(attribution));
        PluginResult pluginResult = new PluginResult(Status.OK, attributionJsonData);
        pluginResult.setKeepCallback(true);
        attributionCallbackContext.sendPluginResult(pluginResult);
    }

    @Override
    public void onFinishedEventTrackingSucceeded(AdTraceEventSuccess event) {
        if (eventTrackingSucceededCallbackContext == null) {
            return;
        }

        JSONObject jsonData = new JSONObject(getEventSuccessMap(event));
        PluginResult pluginResult = new PluginResult(Status.OK, jsonData);
        pluginResult.setKeepCallback(true);
        eventTrackingSucceededCallbackContext.sendPluginResult(pluginResult);
    }

    @Override
    public void onFinishedEventTrackingFailed(AdTraceEventFailure event) {
        if (eventTrackingFailedCallbackContext == null) {
            return;
        }

        JSONObject jsonData = new JSONObject(getEventFailureMap(event));
        PluginResult pluginResult = new PluginResult(Status.OK, jsonData);
        pluginResult.setKeepCallback(true);
        eventTrackingFailedCallbackContext.sendPluginResult(pluginResult);
    }

    @Override
    public void onFinishedSessionTrackingSucceeded(AdTraceSessionSuccess session) {
        if (sessionTrackingSucceededCallbackContext == null) {
            return;
        }

        JSONObject jsonData = new JSONObject(getSessionSuccessMap(session));
        PluginResult pluginResult = new PluginResult(Status.OK, jsonData);
        pluginResult.setKeepCallback(true);
        sessionTrackingSucceededCallbackContext.sendPluginResult(pluginResult);
    }

    @Override
    public void onFinishedSessionTrackingFailed(AdTraceSessionFailure session) {
        if (sessionTrackingFailedCallbackContext == null) {
            return;
        }

        JSONObject jsonData = new JSONObject(getSessionFailureMap(session));
        PluginResult pluginResult = new PluginResult(Status.OK, jsonData);
        pluginResult.setKeepCallback(true);
        sessionTrackingFailedCallbackContext.sendPluginResult(pluginResult);
    }

    @Override
    public boolean launchReceivedDeeplink(Uri deeplink) {
        if (deferredDeeplinkCallbackContext != null) {
            PluginResult pluginResult = new PluginResult(Status.OK, deeplink.toString());
            pluginResult.setKeepCallback(true);
            deferredDeeplinkCallbackContext.sendPluginResult(pluginResult);
        }

        return this.shouldLaunchDeeplink;
    }

    @Override
    public void onGoogleAdIdRead(String playAdId) {
        if (getGoogleAdIdCallbackContext == null) {
            return;
        }

        PluginResult pluginResult = new PluginResult(Status.OK, playAdId);
        pluginResult.setKeepCallback(true);
        getGoogleAdIdCallbackContext.sendPluginResult(pluginResult);
    }
}