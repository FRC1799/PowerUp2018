package org.usfirst.frc.team1799.robot.drive;

import org.usfirst.frc.team1799.robot.OI;
import org.usfirst.frc.team1799.robot.Robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;

public class PlayMecanum extends MecanumDrive {

	public PlayMecanum(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void driveCartesian(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {
//	    Vector2d input = new Vector2d(ySpeed, xSpeed);
//
//	    double[] wheelSpeeds = new double[4];
//	    wheelSpeeds[MotorType.kFrontLeft.value] = (input.x + input.y + zRotation)*(0.98);
//	    wheelSpeeds[MotorType.kFrontRight.value] = (input.x - input.y + zRotation)*(0.99);
//	    wheelSpeeds[MotorType.kRearLeft.value] = -(input.x + input.y + zRotation)*(0.99);
//	    wheelSpeeds[MotorType.kRearRight.value] = -input.x - input.y + zRotation;
//	    
//	    System.out.println("x="+input.x+", y="+input.y+", zRotation="+zRotation+", gyroAngle="+gyroAngle);
//
////	    super.driveCartesian(xSpeed, ySpeed, zRotation, gyroAngle);
//	    super.driveCartesian(xSpeed, ySpeed, zRotation, 0);
//	}

	@Override
	  protected void normalize(double[] wheelSpeeds) {
	    fineTune(wheelSpeeds);

	    double maxMagnitude = Math.abs(wheelSpeeds[0]);
	    for (int i = 1; i < wheelSpeeds.length; i++) {
	      double temp = Math.abs(wheelSpeeds[i]);
	      if (maxMagnitude < temp) {
	        maxMagnitude = temp;
	      }
	    }
	    if (maxMagnitude > 1.0) {
	      for (int i = 0; i < wheelSpeeds.length; i++) {
	        wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
	      }
	    }
	    
	  }

	protected void fineTune(double[] wheelSpeeds) {
		OI oi = Robot.m_oi;
		
		/*
		 * Motor speed fine tuning ...
		 */
	    wheelSpeeds[MotorType.kFrontLeft.value] = (wheelSpeeds[MotorType.kFrontLeft.value])*oi.getMotorSpeedTuneFactor(OI.motor_location.frontLeft);
	    wheelSpeeds[MotorType.kFrontRight.value] = (wheelSpeeds[MotorType.kFrontRight.value])*oi.getMotorSpeedTuneFactor(OI.motor_location.frontRight);
	    wheelSpeeds[MotorType.kRearLeft.value] = (wheelSpeeds[MotorType.kRearLeft.value])*oi.getMotorSpeedTuneFactor(OI.motor_location.backLeft);
	    wheelSpeeds[MotorType.kRearRight.value] = (wheelSpeeds[MotorType.kRearRight.value])*oi.getMotorSpeedTuneFactor(OI.motor_location.backLeft);
		
		/*
		 * Motor speed acceleration adjustment ...
		 */
	    double ramp = oi.getMotorAccelerationRampFactor();

	    double flSign = Math.signum(wheelSpeeds[MotorType.kFrontLeft.value]);
	    double frSign = Math.signum(wheelSpeeds[MotorType.kFrontRight.value]);
	    double rlSign = Math.signum(wheelSpeeds[MotorType.kRearLeft.value]);
	    double rrSign = Math.signum(wheelSpeeds[MotorType.kRearRight.value]);
	    
	    if (ramp % 2 == 0) {
		    wheelSpeeds[MotorType.kFrontLeft.value] = flSign * Math.pow(wheelSpeeds[MotorType.kFrontLeft.value], ramp);
		    wheelSpeeds[MotorType.kFrontRight.value] = frSign * Math.pow(wheelSpeeds[MotorType.kFrontRight.value], ramp);
		    wheelSpeeds[MotorType.kRearLeft.value] = rlSign * Math.pow(wheelSpeeds[MotorType.kRearLeft.value], ramp);
		    wheelSpeeds[MotorType.kRearRight.value] = rrSign * Math.pow(wheelSpeeds[MotorType.kRearRight.value], ramp);
	    } else {
		    wheelSpeeds[MotorType.kFrontLeft.value] = Math.pow(wheelSpeeds[MotorType.kFrontLeft.value], ramp);
		    wheelSpeeds[MotorType.kFrontRight.value] = Math.pow(wheelSpeeds[MotorType.kFrontRight.value], ramp);
		    wheelSpeeds[MotorType.kRearLeft.value] = Math.pow(wheelSpeeds[MotorType.kRearLeft.value], ramp);
		    wheelSpeeds[MotorType.kRearRight.value] = Math.pow(wheelSpeeds[MotorType.kRearRight.value], ramp);
	    }
	}

}
