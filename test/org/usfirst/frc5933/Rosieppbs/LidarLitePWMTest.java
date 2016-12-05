package org.usfirst.frc5933.Rosieppbs;

import static org.junit.Assert.*;

import org.junit.Test;

public class LidarLitePWMTest {

    private static final double [][] TestTable = new double[][] {
        {0, 0},
        {25.7, 96.5},
        {30.6, 118.5},
        {40, 154.5},
        {45.6, 176},
        {57.5, 223},
        {59, 237.5},
        {63.5, 246.5}
    };
   
    @Test
    public void testGetDistanceZero() {
        LidarLitePWM.kPulseWidthTable = TestTable;
        LidarLitePWM lidar = new LidarLitePWM();
        lidar.pulseWidth_ = 0.0;
        assertEquals(0.0, lidar.getDistance(), 0);
    }

    @Test
    public void testGetDistanceFirstVal() {
        LidarLitePWM.kPulseWidthTable = TestTable;
        LidarLitePWM lidar = new LidarLitePWM();
        lidar.pulseWidth_ = 25.7;
        assertEquals(96.5, lidar.getDistance(), 0.0);
    }

    @Test
    public void testGetDistanceSanityCheck() {
        LidarLitePWM.kPulseWidthTable = TestTable;
        LidarLitePWM lidar = new LidarLitePWM();
        lidar.pulseWidth_ = 100;
        assertEquals(0.0, lidar.getDistance(), 0);
    }

    @Test
    public void testGetDistanceCalc1() {
        LidarLitePWM.kPulseWidthTable = TestTable;
        LidarLitePWM lidar = new LidarLitePWM();
        lidar.pulseWidth_ = 12.5;
        assertEquals(46.93, lidar.getDistance(), 0.01);
    }

    @Test
    public void testGetDistanceCalc2() {
        LidarLitePWM.kPulseWidthTable = TestTable;
        LidarLitePWM lidar = new LidarLitePWM();
        lidar.pulseWidth_ = 27.2;
        assertEquals(103.23, lidar.getDistance(), 0.01);
    }
    @Test

    public void testGetDistanceEnd() {
        LidarLitePWM lidar = new LidarLitePWM();
        lidar.pulseWidth_ = 61.2;
        assertEquals(241.9, lidar.getDistance(), 0.01);
    }
}
