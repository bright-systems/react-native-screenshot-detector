//
//  RNScreenshotDetector.m
//
//  Created by Graham Carling on 1/11/17.
//

#import "RNScreenshotDetector.h"
#import <React/RCTBridge.h>

@implementation RNScreenshotDetector
{
    id observer;
}

RCT_EXPORT_MODULE();


- (NSArray<NSString *> *)supportedEvents {
    return @[@"ScreenshotTaken"];
}

- (void)startObserving {
   // Now set up handler to detect if user takes a screenshot
    NSOperationQueue *mainQueue = [NSOperationQueue mainQueue];
    observer = [[NSNotificationCenter defaultCenter] addObserverForName:UIApplicationUserDidTakeScreenshotNotification
                                                      object:nil
                                                       queue:mainQueue
                                                  usingBlock:^(NSNotification *notification) {
                                                      [self screenshotDetected:notification];
                                                  }];
}

- (void)stopObserving {
    if (observer != nil) {
        [[NSNotificationCenter defaultCenter] removeObserver:observer];
    }
}

- (void)screenshotDetected:(NSNotification *)notification {
    if (observer != nil) {
        [self sendEventWithName:@"ScreenshotTaken" body:@{}];
    }
}

@end
