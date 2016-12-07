package org.usfirst.frc5933.Rosieppbs;

public class FieldElements {
    
    // In Inches
    public static final double kGarbageCanRadius = 11;

    // In Inches
    public static final double kLidarOffsetFromCenter = 12; // FIXME: I think this is correct, but double check

    // Center of circle to center of garbage can in inches
    public static final double kNearCanCenterDistance = (10 * 12);
    public static final double kMidCanCenterDistance = (15 * 12);
    public static final double kFarCanCenterDistance = (20 * 12);

    // From the Lidar to the front of the can
    public static final double kNearCanLidarFrontDistance = kNearCanCenterDistance - kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kMidCanLidarFrontDistance = kMidCanCenterDistance - kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kFarCanLidarFrontDistance = kFarCanCenterDistance - kGarbageCanRadius - kLidarOffsetFromCenter;    

    // From the Lidar to the front of the can
    public static final double kNearCanLidarBackDistance = kNearCanCenterDistance + kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kMidCanLidarBackDistance = kMidCanCenterDistance + kGarbageCanRadius - kLidarOffsetFromCenter;    
    public static final double kFarCanLidarBackDistance = kFarCanCenterDistance + kGarbageCanRadius - kLidarOffsetFromCenter;    
}
