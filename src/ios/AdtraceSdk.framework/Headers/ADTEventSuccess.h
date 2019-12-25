//
//  ADTEventSuccess.h
//  adtrace
//
//  Created by Aref Hosseini on 25th December 2019.
//  Copyright (c) 2012-2019 AdTrace GmbH. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ADTEventSuccess : NSObject

/**
 * @brief Message from the adtrace backend.
 */
@property (nonatomic, copy) NSString *message;

/**
 * @brief Timestamp from the adtrace backend.
 */
@property (nonatomic, copy) NSString *timeStamp;

/**
 * @brief AdTrace identifier of the device.
 */
@property (nonatomic, copy) NSString *adid;

/**
 * @brief Event token value.
 */
@property (nonatomic, copy) NSString *eventToken;

/**
 * @brief Event callback ID.
 */
@property (nonatomic, copy) NSString *callbackId;

/**
 * @brief Backend response in JSON format.
 */
@property (nonatomic, strong) NSDictionary *jsonResponse;

/**
 * @brief Initialisation method.
 *
 * @return ADTEventSuccess instance.
 */
+ (ADTEventSuccess *)eventSuccessResponseData;

@end