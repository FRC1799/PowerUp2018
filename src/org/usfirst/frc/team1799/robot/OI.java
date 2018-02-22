/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1799.robot;

import org.usfirst.frc.team1799.robot.commands.AutoDriveForward;
import org.usfirst.frc.team1799.robot.commands.ArmMoveDown;
import org.usfirst.frc.team1799.robot.commands.ArmMoveUp;
import org.usfirst.frc.team1799.robot.commands.ArmStop;
import org.usfirst.frc.team1799.robot.commands.AutoDriveBack;
import org.usfirst.frc.team1799.robot.RobotMap;
import org.usfirst.frc.team1799.robot.OI.motor_location;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1799.robot.commands.CompressorToggle;
import org.usfirst.frc.team1799.robot.commands.Grabber_OpenGroup;
import org.usfirst.frc.team1799.robot.commands.Grabber_closeGroup;
import org.usfirst.frc.team1799.robot.commands.LgrabberClose;
import org.usfirst.frc.team1799.robot.commands.LgrabberOff;
import org.usfirst.frc.team1799.robot.commands.LgrabberOpen;
import org.usfirst.frc.team1799.robot.commands.PusherGrabbersGroup;
import org.usfirst.frc.team1799.robot.commands.RgrabberClose;
import org.usfirst.frc.team1799.robot.commands.RgrabberOff;
import org.usfirst.frc.team1799.robot.commands.RgrabberOpen;
import org.usfirst.frc.team1799.robot.commands.ShooterPullIn;
import org.usfirst.frc.team1799.robot.commands.ShooterPunch;
import org.usfirst.frc.team1799.robot.commands.ShooterPushOut;
import org.usfirst.frc.team1799.robot.commands.grabberToggle;
import org.usfirst.frc.team1799.robot.triggers.DoubleButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * The operator interface of the robot, it has been simplified from the real
 * robot to allow control with a single PS3 joystick. 
 *
 */
public class OI {
	public static enum motor_location {frontLeft, frontRight, backLeft, backRight} 

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.

	Joystick m_stick = new Joystick( RobotMap.kJoystickChannel );

	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
/*	
	public OI() {
		// Put Some buttons on the SmartDashboard
		SmartDashboard.putData("Drive Forward", new AutoDriveForward());
		SmartDashboard.putData("Drive Platform", new AutoDriveBack());
	
		SmartDashboard.putNumber("FrontLeft Tune", new Double(0.85));
		SmartDashboard.putNumber("FrontRight Tune", new Double(0.92));
		SmartDashboard.putNumber("BackLeft Tune", new Double(0.95));
		SmartDashboard.putNumber("BackRight Tune", new Double(0.97));

		SmartDashboard.putNumber("Motor Ramping Factor", new Double(1.0));
		
		SmartDashboard.putBoolean("Invert Left Lift Motor", false);
		SmartDashboard.putBoolean("Invert Right Lift Motor", false);
		

//		// Create some buttons
//		JoystickButton dpadUp = new JoystickButton(m_stick, 5);
//		JoystickButton dpadRight = new JoystickButton(m_stick, 6);
//		JoystickButton dpadDown = new JoystickButton(m_stick, 7);
//		JoystickButton dpadLeft = new JoystickButton(m_stick, 8);

		// shooter push out
		JoystickButton dSpush = new JoystickButton(m_stick, 5);
		dSpush.whenPressed(new ShooterPushOut());
		// shooter pull in
		JoystickButton dSpull = new JoystickButton(m_stick, 6);
		dSpull.whenPressed(new ShooterPullIn());
		// toggle compressor on/off - for testing and demo mostly
		JoystickButton dcompressor = new JoystickButton(m_stick, 7);
		dcompressor.whenPressed(new CompressorToggle());
		// shooter punch for 300ms
		JoystickButton dSpunch = new JoystickButton(m_stick, 8);
		dSpunch.whenPressed(new ShooterPunch());9
		
		// Right grabber open close and off
		JoystickButton dRgrabberOpen = new JoystickButton(m_stick, 3);
		JoystickButton dRgrabberClose = new JoystickButton(m_stick, 4);
		new DoubleButton(m_stick, 3, 4).whenActive(new RgrabberOff());
		dRgrabberOpen.whileHeld(new RgrabberOpen());
		dRgrabberClose.whileHeld(new RgrabberClose());

		// Left grabber open close and off
		JoystickButton dLgrabberOpen = new JoystickButton(m_stick, 1);
		JoystickButton dLgrabberClose = new JoystickButton(m_stick, 2);
		new DoubleButton(m_stick, 1, 2).whenActive(new LgrabberOff());
		dLgrabberOpen.whileHeld(new LgrabberOpen());
		dLgrabberClose.whileHeld(new LgrabberClose());
		// Toggle grabber
		new DoubleButton(m_stick, 1, 3).whenActive(new grabberToggle());
		new DoubleButton(m_stick, 2, 4).whenActive(new grabberToggle());
		
		//Arm motors
		JoystickButton dArmUp = new JoystickButton(m_stick, 9);
		dArmUp.whenPressed(new ArmMoveUp());
		dArmUp.whenReleased(new ArmStop());
		JoystickButton dArmDown = new JoystickButton(m_stick, 10);
		dArmDown.whenPressed(new ArmMoveDown());
		dArmDown.whenReleased(new ArmStop());
//
//		// Connect the buttons to commands
//		dpadUp.whenPressed(new AutoDriveForward());
//		dpadDown.whenPressed(new AutoDriveBack());
	}
*/	
	
	public OI() {
		// Put Some buttons on the SmartDashboard
		SmartDashboard.putData("Drive Forward", new AutoDriveForward());
		SmartDashboard.putData("Drive Platform", new AutoDriveBack());
		SmartDashboard.putNumber("FrontLeft Tune", new Double(0.85));
		SmartDashboard.putNumber("FrontRight Tune", new Double(0.92));
		SmartDashboard.putNumber("BackLeft Tune", new Double(0.95));
		SmartDashboard.putNumber("BackRight Tune", new Double(0.97));
		SmartDashboard.putNumber("Motor Ramping Factor", new Double(1.0));
		SmartDashboard.putBoolean("Invert Left Lift Motor", false);
		SmartDashboard.putBoolean("Invert Right Lift Motor", false);
		
		// toggle compressor on/off - for testing and demo mostly
		JoystickButton dcompressor = new JoystickButton(m_stick, 9);
		dcompressor.whenPressed(new CompressorToggle());
		
		// Right grabber open close and off
		JoystickButton dRgrabberOpen = new JoystickButton(m_stick, 2);
		JoystickButton dRgrabberClose = new JoystickButton(m_stick, 3);
		dRgrabberOpen.whileHeld(new RgrabberOpen());
		dRgrabberClose.whileHeld(new RgrabberClose());

		// Left grabber open close and off
		JoystickButton dLgrabberOpen = new JoystickButton(m_stick, 1);
		JoystickButton dLgrabberClose = new JoystickButton(m_stick, 4);
		dLgrabberOpen.whileHeld(new LgrabberOpen());
		dLgrabberClose.whileHeld(new LgrabberClose());

//		// shooter push out
//		JoystickButton dSpush = new JoystickButton(m_stick, 5);
//		dSpush.whenPressed(new ShooterPushOut());
//		// shooter pull in
//		JoystickButton dSpull = new JoystickButton(m_stick, 6);
//		dSpull.whenPressed(new ShooterPullIn());
//		// shooter punch for 300ms
//		JoystickButton dSpunch = new JoystickButton(m_stick, 8);
//		dSpunch.whenPressed(new ShooterPunch());

		// Close Grabbers
		JoystickButton dGrabbersClose = new JoystickButton(m_stick, 6);
		dGrabbersClose.whenPressed(new Grabber_closeGroup());
//		
//		// Open Grabbers
		JoystickButton dGrabbersOpen = new JoystickButton(m_stick, 8);
		dGrabbersOpen.whenPressed(new Grabber_OpenGroup());

//		PusherGrabbersGroup pgg = new PusherGrabbersGroup();
		

		// Toggle grabber
//		new DoubleButton(m_stick, 1, 2).whenActive(new LgrabberOff());
//		new DoubleButton(m_stick, 1, 3).whenActive(new grabberToggle());
//		new DoubleButton(m_stick, 2, 4).whenActive(new grabberToggle());
//		
		//Arm motors
		JoystickButton dArmUp = new JoystickButton(m_stick, 5);
		dArmUp.whenPressed(new ArmMoveUp());
		dArmUp.whenReleased(new ArmStop());
		JoystickButton dArmDown = new JoystickButton(m_stick, 7);
		dArmDown.whenPressed(new ArmMoveDown());
		dArmDown.whenReleased(new ArmStop());
		
		//PushGrabberGroup
		JoystickButton dPushGrabberGroup = new JoystickButton(m_stick, 10);
		dPushGrabberGroup.whenPressed(new PusherGrabbersGroup());
		dPushGrabberGroup.whenReleased(new ShooterPullIn());

		//
//		// Connect the buttons to commands
//		dpadUp.whenPressed(new AutoDriveForward());
//		dpadDown.whenPressed(new AutoDriveBack());
	}

	public Joystick getJoystick() {
		return m_stick;
	}

	public double getMotorSpeedTuneFactor(motor_location postion) {
		double tuneFactor = 1.0;
		
		switch(postion) {
			case frontLeft:
				tuneFactor = SmartDashboard.getNumber("FrontLeft Tune", new Double(1.0));
				break;
			case frontRight:
				tuneFactor = SmartDashboard.getNumber("FrontRight Tune", new Double(1.0));
				break;
			case backLeft:
				tuneFactor = SmartDashboard.getNumber("BackLeft Tune", new Double(1.0));
				break;
			case backRight:
 				tuneFactor = SmartDashboard.getNumber("BackRight Tune", new Double(1.0));
				break;
		}
	
		return tuneFactor;
	}
	
	public double getMotorAccelerationRampFactor() {
		return SmartDashboard.getNumber("Motor Ramping Factor", new Double(1.0));
	}

	public boolean getInvertLeftLiftMotor() {
		boolean bInvert = SmartDashboard.getBoolean("Invert Left Lift Motor", false);
		return bInvert;
	}

	public boolean getInvertRightLiftMotor() {
		boolean bInvert = SmartDashboard.getBoolean("Invert Right Lift Motor", false);
		return bInvert;
	}
}
