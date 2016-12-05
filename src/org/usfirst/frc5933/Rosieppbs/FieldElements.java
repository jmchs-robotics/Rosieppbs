package org.usfirst.frc5933.Rosieppbs;

public class FieldElements {
    
    // In Inches
    public static final double kGarbageCanRadius = 11;

    // In Inches
    public static final double kLidarOffsetFromCenter = 8; // FIXME

    // Center of circle to center of garbage can in inches
    public static final double kNearCanCenterDistance = 96.5; // FIXME
    public static final double kMidCanCenterDistance = 154.5; // FIXME
    public static final double kFarCanCenterDistance = 223; // FIXME

    // From the Lidar to the front of the can
    public static final double kNearCanLidarFrontDistance = kNearCanCenterDistance - kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kMidCanLidarFrontDistance = kMidCanCenterDistance - kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kFarCanLidarFrontDistance = kFarCanCenterDistance - kGarbageCanRadius - kLidarOffsetFromCenter;    

    // From the Lidar to the front of the can
    public static final double kNearCanLidarBackDistance = kNearCanCenterDistance + kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kMidCanLidarBackDistance = kMidCanCenterDistance + kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kFarCanLidarBackDistance = kFarCanCenterDistance + kGarbageCanRadius - kLidarOffsetFromCenter;    
}
