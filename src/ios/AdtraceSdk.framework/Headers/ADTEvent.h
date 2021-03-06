//
//  ADTEvent.h
//  adtrace
//
//  Created by Aref Hosseini on 25th December 2019.
//  Copyright (c) 2012-2019 AdTrace GmbH. All rights reserved.
//

#import <Foundation/Foundation.h>

/**
 * @brief AdTrace event class.
 */
@interface ADTEvent : NSObject<NSCopying>

/**
 * @brief Revenue attached to the event.
 */
@property (nonatomic, copy, readonly, nonnull) NSNumber *revenue;

/**
 * @brief Event token.
 */
@property (nonatomic, copy, readonly, nonnull) NSString *eventToken;

/**
 * @brief Custom user defined event ID.
 */
@property (nonatomic, copy, readonly, nonnull) NSString *callbackId;

/**
 * @brief Currency value.
 */
@property (nonatomic, copy, readonly, nonnull) NSString *currency;

/**
 * @brief IAP receipt.
 */
@property (nonatomic, copy, readonly, nonnull) NSData *receipt;

/**
 * @brief List of partner parameters.
 */
@property (nonatomic, readonly, nonnull) NSDictionary *partnerParameters;

/**
 * @brief List of callback parameters.
 */
@property (nonatomic, readonly, nonnull) NSDictionary *callbackParameters;

/**
 * @brief Is the given receipt empty.
 */
@property (nonatomic, assign, readonly) BOOL emptyReceipt;

/**
 * @brief Create Event object with event token.
 *
 * @param eventToken Event token that is created in the dashboard
 *                   at http://adtrace.io and should be six characters long.
 */
+ (nullable ADTEvent *)eventWithEventToken:(nonnull NSString *)eventToken;

- (nullable id)initWithEventToken:(nonnull NSString *)eventToken;

/**
 * @brief Add a key-pair to a callback URL.
 *
 * @param key String key in the callback URL.
 * @param value String value of the key in the Callback URL.
 *
 * @note In your dashboard at http://adtrace.io you can assign a callback URL to each
 *       event type. That URL will get called every time the event is triggered. On
 *       top of that you can add callback parameters to the following method that
 *       will be forwarded to these callbacks.
 */
- (void)addCallbackParameter:(nonnull NSString *)key value:(nonnull NSString *)value;

/**
 * @brief Add a key-pair to be fowarded to a partner.
 *
 * @param key String key to be fowarded to the partner.
 * @param value String value of the key to be fowarded to the partner.
 */
- (void)addPartnerParameter:(nonnull NSString *)key value:(nonnull NSString *)value;

/**
 * @brief Set the revenue and associated currency of the event.
 *
 * @param amount The amount in units (example: for 1.50 EUR is 1.5).
 * @param currency String of the currency with ISO 4217 format.
 *                 It should be 3 characters long (example: for 1.50 EUR is @"EUR").
 *
 * @note The event can contain some revenue. The amount revenue is measured in units.
 *       It must include a currency in the ISO 4217 format.
 */
- (void)setRevenue:(double)amount currency:(nonnull NSString *)currency;

/**
 * @brief Set the custom user defined ID for the event which will be reported in
 *        success/failure callbacks.
 *
 * @param callbackId Custom user defined identifier for the event
 */
- (void)setCallbackId:(nonnull NSString *)callbackId;

/**
 * @brief Check if created adtrace event object is valid.
 *
 * @return Boolean indicating whether the adtrace event object is valid or not.
 */
- (BOOL)isValid;

@end