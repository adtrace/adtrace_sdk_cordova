//
//  AdTraceCordovaDelegate.m
//  AdTrace SDK
//
//  Created by Aref Hosseini on 25th December 2019.
//  Copyright (c) 2012-2019 AdTrace GmbH. All rights reserved.
//

#import <objc/runtime.h>
#import <Cordova/CDVPluginResult.h>
#import "AdTraceCordovaDelegate.h"

static dispatch_once_t onceToken;
static AdTraceCordovaDelegate *defaultInstance = nil;

@implementation AdTraceCordovaDelegate

#pragma mark - Object lifecycle methods

- (id)init {
    self = [super init];
    if (nil == self) {
        return nil;
    }
    return self;
}

#pragma mark - Public methods

+ (id)getInstanceWithSwizzleOfAttributionCallback:(BOOL)swizzleAttributionCallback
                           eventSucceededCallback:(BOOL)swizzleEventSucceededCallback
                              eventFailedCallback:(BOOL)swizzleEventFailedCallback
                         sessionSucceededCallback:(BOOL)swizzleSessionSucceededCallback
                            sessionFailedCallback:(BOOL)swizzleSessionFailedCallback
                         deferredDeeplinkCallback:(BOOL)swizzleDeferredDeeplinkCallback
                         andAttributionCallbackId:(NSString *)attributionCallbackId
                         eventSucceededCallbackId:(NSString *)eventSucceededCallbackId
                            eventFailedCallbackId:(NSString *)eventFailedCallbackId
                       sessionSucceededCallbackId:(NSString *)sessionSucceededCallbackId
                          sessionFailedCallbackId:(NSString *)sessionFailedCallbackId
                       deferredDeeplinkCallbackId:(NSString *)deferredDeeplinkCallbackId
                     shouldLaunchDeferredDeeplink:(BOOL)shouldLaunchDeferredDeeplink
                              withCommandDelegate:(id<CDVCommandDelegate>)adtraceCordovaCommandDelegate {
    dispatch_once(&onceToken, ^{
        defaultInstance = [[AdTraceCordovaDelegate alloc] init];

        // Do the swizzling where and if needed.
        if (swizzleAttributionCallback) {
            [defaultInstance swizzleCallbackMethod:@selector(adtraceAttributionChanged:)
                                  swizzledSelector:@selector(adtraceAttributionChangedWannabe:)];
        }
        if (swizzleEventSucceededCallback) {
            [defaultInstance swizzleCallbackMethod:@selector(adtraceEventTrackingSucceeded:)
                                  swizzledSelector:@selector(adtraceEventTrackingSucceededWannabe:)];
        }
        if (swizzleEventFailedCallback) {
            [defaultInstance swizzleCallbackMethod:@selector(adtraceEventTrackingFailed:)
                                  swizzledSelector:@selector(adtraceEventTrackingFailedWannabe:)];
        }
        if (swizzleSessionSucceededCallback) {
            [defaultInstance swizzleCallbackMethod:@selector(adtraceSessionTrackingSucceeded:)
                                  swizzledSelector:@selector(adtraceSessionTrackingSucceededWannabe:)];
        }
        if (swizzleSessionFailedCallback) {
            [defaultInstance swizzleCallbackMethod:@selector(adtraceSessionTrackingFailed:)
                                  swizzledSelector:@selector(adtraceSessionTrackingFailedWananbe:)];
        }
        if (swizzleDeferredDeeplinkCallback) {
            [defaultInstance swizzleCallbackMethod:@selector(adtraceDeeplinkResponse:)
                                  swizzledSelector:@selector(adtraceDeeplinkResponseWannabe:)];
        }

        [defaultInstance setAttributionCallbackId:attributionCallbackId];
        [defaultInstance setEventSucceededCallbackId:eventSucceededCallbackId];
        [defaultInstance setEventFailedCallbackId:eventFailedCallbackId];
        [defaultInstance setSessionSucceededCallbackId:sessionSucceededCallbackId];
        [defaultInstance setSessionFailedCallbackId:sessionFailedCallbackId];
        [defaultInstance setDeferredDeeplinkCallbackId:deferredDeeplinkCallbackId];
        [defaultInstance setShouldLaunchDeferredDeeplink:shouldLaunchDeferredDeeplink];
        [defaultInstance setAdTraceCordovaCommandDelegate:adtraceCordovaCommandDelegate];
    });
    
    return defaultInstance;
}

+ (void)teardown {
    defaultInstance = nil;
    onceToken = 0;
}

#pragma mark - Private & helper methods

- (void)adtraceAttributionChangedWannabe:(ADTAttribution *)attribution {
    if (attribution == nil) {
        return;
    }

    NSMutableDictionary *dictionary = [NSMutableDictionary dictionary];
    [self addValueOrEmpty:attribution.trackerToken withKey:@"trackerToken" toDictionary:dictionary];
    [self addValueOrEmpty:attribution.trackerName withKey:@"trackerName" toDictionary:dictionary];
    [self addValueOrEmpty:attribution.network withKey:@"network" toDictionary:dictionary];
    [self addValueOrEmpty:attribution.campaign withKey:@"campaign" toDictionary:dictionary];
    [self addValueOrEmpty:attribution.creative withKey:@"creative" toDictionary:dictionary];
    [self addValueOrEmpty:attribution.adgroup withKey:@"adgroup" toDictionary:dictionary];
    [self addValueOrEmpty:attribution.clickLabel withKey:@"clickLabel" toDictionary:dictionary];
    [self addValueOrEmpty:attribution.adid withKey:@"adid" toDictionary:dictionary];

    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dictionary];
    pluginResult.keepCallback = [NSNumber numberWithBool:YES];
    [_adtraceCordovaCommandDelegate sendPluginResult:pluginResult callbackId:_attributionCallbackId];
}

- (void)adtraceEventTrackingSucceededWannabe:(ADTEventSuccess *)eventSuccessResponseData {
    if (nil == eventSuccessResponseData) {
        return;
    }

    NSMutableDictionary *dictionary = [NSMutableDictionary dictionary];
    [self addValueOrEmpty:eventSuccessResponseData.message withKey:@"message" toDictionary:dictionary];
    [self addValueOrEmpty:eventSuccessResponseData.timeStamp withKey:@"timestamp" toDictionary:dictionary];
    [self addValueOrEmpty:eventSuccessResponseData.adid withKey:@"adid" toDictionary:dictionary];
    [self addValueOrEmpty:eventSuccessResponseData.eventToken withKey:@"eventToken" toDictionary:dictionary];
    [self addValueOrEmpty:eventSuccessResponseData.callbackId withKey:@"callbackId" toDictionary:dictionary];
    if (eventSuccessResponseData.jsonResponse != nil) {
        [dictionary setObject:eventSuccessResponseData.jsonResponse forKey:@"jsonResponse"];
    }

    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dictionary];
    pluginResult.keepCallback = [NSNumber numberWithBool:YES];
    [_adtraceCordovaCommandDelegate sendPluginResult:pluginResult callbackId:_eventSucceededCallbackId];
}

- (void)adtraceEventTrackingFailedWannabe:(ADTEventFailure *)eventFailureResponseData {
    if (nil == eventFailureResponseData) {
        return;
    }

    NSMutableDictionary *dictionary = [NSMutableDictionary dictionary];
    [self addValueOrEmpty:eventFailureResponseData.message withKey:@"message" toDictionary:dictionary];
    [self addValueOrEmpty:eventFailureResponseData.timeStamp withKey:@"timestamp" toDictionary:dictionary];
    [self addValueOrEmpty:eventFailureResponseData.adid withKey:@"adid" toDictionary:dictionary];
    [self addValueOrEmpty:eventFailureResponseData.eventToken withKey:@"eventToken" toDictionary:dictionary];
    [self addValueOrEmpty:eventFailureResponseData.callbackId withKey:@"callbackId" toDictionary:dictionary];
    [dictionary setObject:(eventFailureResponseData.willRetry ? @"true" : @"false") forKey:@"willRetry"];
    if (eventFailureResponseData.jsonResponse != nil) {
        [dictionary setObject:eventFailureResponseData.jsonResponse forKey:@"jsonResponse"];
    }

    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dictionary];
    pluginResult.keepCallback = [NSNumber numberWithBool:YES];
    [_adtraceCordovaCommandDelegate sendPluginResult:pluginResult callbackId:_eventFailedCallbackId];
}

- (void)adtraceSessionTrackingSucceededWannabe:(ADTSessionSuccess *)sessionSuccessResponseData {
    if (nil == sessionSuccessResponseData) {
        return;
    }

    NSMutableDictionary *dictionary = [NSMutableDictionary dictionary];
    [self addValueOrEmpty:sessionSuccessResponseData.message withKey:@"message" toDictionary:dictionary];
    [self addValueOrEmpty:sessionSuccessResponseData.timeStamp withKey:@"timestamp" toDictionary:dictionary];
    [self addValueOrEmpty:sessionSuccessResponseData.adid withKey:@"adid" toDictionary:dictionary];
    if (sessionSuccessResponseData.jsonResponse != nil) {
        [dictionary setObject:sessionSuccessResponseData.jsonResponse forKey:@"jsonResponse"];
    }

    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dictionary];
    pluginResult.keepCallback = [NSNumber numberWithBool:YES];
    [_adtraceCordovaCommandDelegate sendPluginResult:pluginResult callbackId:_sessionSucceededCallbackId];
}

- (void)adtraceSessionTrackingFailedWananbe:(ADTSessionFailure *)sessionFailureResponseData {
    if (nil == sessionFailureResponseData) {
        return;
    }

    NSMutableDictionary *dictionary = [NSMutableDictionary dictionary];
    [self addValueOrEmpty:sessionFailureResponseData.message withKey:@"message" toDictionary:dictionary];
    [self addValueOrEmpty:sessionFailureResponseData.timeStamp withKey:@"timestamp" toDictionary:dictionary];
    [self addValueOrEmpty:sessionFailureResponseData.adid withKey:@"adid" toDictionary:dictionary];
    [dictionary setObject:(sessionFailureResponseData.willRetry ? @"true" : @"false") forKey:@"willRetry"];
    if (sessionFailureResponseData.jsonResponse != nil) {
        [dictionary setObject:sessionFailureResponseData.jsonResponse forKey:@"jsonResponse"];
    }

    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dictionary];
    pluginResult.keepCallback = [NSNumber numberWithBool:YES];
    [_adtraceCordovaCommandDelegate sendPluginResult:pluginResult callbackId:_sessionFailedCallbackId];
}

- (BOOL)adtraceDeeplinkResponseWannabe:(NSURL *)deeplink {
    NSString *path = [deeplink absoluteString];
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:path];
    pluginResult.keepCallback = [NSNumber numberWithBool:YES];
    [_adtraceCordovaCommandDelegate sendPluginResult:pluginResult callbackId:_deferredDeeplinkCallbackId];

    return _shouldLaunchDeferredDeeplink;
}

- (void)swizzleCallbackMethod:(SEL)originalSelector
             swizzledSelector:(SEL)swizzledSelector {
    Class class = [self class];
    Method originalMethod = class_getInstanceMethod(class, originalSelector);
    Method swizzledMethod = class_getInstanceMethod(class, swizzledSelector);
    BOOL didAddMethod = class_addMethod(class,
                                        originalSelector,
                                        method_getImplementation(swizzledMethod),
                                        method_getTypeEncoding(swizzledMethod));
    if (didAddMethod) {
        class_replaceMethod(class,
                            swizzledSelector,
                            method_getImplementation(originalMethod),
                            method_getTypeEncoding(originalMethod));
    } else {
        method_exchangeImplementations(originalMethod, swizzledMethod);
    }
}

- (void)addValueOrEmpty:(NSObject *)value
                withKey:(NSString *)key
           toDictionary:(NSMutableDictionary *)dictionary {
    if (nil != value) {
        [dictionary setObject:[NSString stringWithFormat:@"%@", value] forKey:key];
    } else {
        [dictionary setObject:@"" forKey:key];
    }
}

@end