/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1799.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static final int kJoystickChannel = 0;
	public static final int kGyroChannel = 0;
	public static final double kShooterPunchTime = 0.1; //seconds

	//Arm system
	public static final double kArmspeed = 0.9; // 0 to 1:max
	public static final double kArmSpeedUp = kArmspeed; 
	public static final double kArmSpeedDown = kArmspeed; 
	public static final boolean rightmotorInverted = false;
	public static final boolean leftmotorInverted = false;
	
	public static class CAN {
		public static final int pcmId = 0;
	}
	
	public static class Solenoid {
		public static final int  channel0 = 0;
		public static final int  channel1 = 1;
		public static final int  channel2 = 2;
		public static final int  channel3 = 3;
		public static final int  channel4 = 4;
		public static final int  channel5 = 5;
		public static final int  channel6 = 6;
		public static final int  channel7 = 7;
		

		public static final int  shooter = channel0;
		public static final int  leftGrabberOpen = channel2;
		public static final int  leftGrabberClose = channel3;
		public static final int  RightGrabberOpen = channel4;
		public static final int  RightGrabberClose = channel6;
	}
	
	public static class PWM {
		public static final int pwm0 = 0;
		public static final int pwm1 = 1;
		public static final int pwm2 = 2;
		public static final int pwm3 = 3;
		public static final int pwm4 = 4;
		public static final int pwm5 = 5;
		public static final int pwm6 = 6;
		public static final int pwm7 = 7;
		public static final int pwm8 = 8;
		public static final int pwm9 = 9;
	}
	
	
}
