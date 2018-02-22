package org.usfirst.frc.team1799.robot.commands;

import org.usfirst.frc.team1799.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * This command allows joystick to drive the robot. It is always running
 * except when interrupted by another command.
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

		requires(Robot.kDrivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
		Robot.kDrivetrain.macDrive(Robot.m_oi.getJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.kDrivetrain.stop();
    }
	
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
