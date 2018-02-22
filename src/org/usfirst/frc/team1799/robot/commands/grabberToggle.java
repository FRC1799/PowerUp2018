package org.usfirst.frc.team1799.robot.commands;

import org.usfirst.frc.team1799.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class grabberToggle extends Command {

    public grabberToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.kGrabberSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		System.out.println(this.getClass().getName() + " initalize");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (DoubleSolenoid.Value.kOff == Robot.kGrabberSystem.Rget())
    	{
    		Robot.kGrabberSystem.Rclose();
    	}else
    	{
    		Robot.kGrabberSystem.Roff();
    	}
    	
    	if (DoubleSolenoid.Value.kOff == Robot.kGrabberSystem.Lget())
    	{
    		Robot.kGrabberSystem.Lclose();
    	}else
    	{
    		Robot.kGrabberSystem.Loff();
    	}

		System.out.println(this.getClass().getName() + " execute");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
		System.out.println(this.getClass().getName() + " end");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		System.out.println(this.getClass().getName() + " interrupted");
    }
}
