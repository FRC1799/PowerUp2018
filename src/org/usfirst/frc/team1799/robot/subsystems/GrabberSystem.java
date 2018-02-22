package org.usfirst.frc.team1799.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1799.robot.commands.GrabberOff;
import org.usfirst.frc.team1799.robot.RobotMap;

/**
 *
 */
public class GrabberSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid RgrabberSolenoid = new DoubleSolenoid(RobotMap.CAN.pcmId, RobotMap.Solenoid.RightGrabberOpen, RobotMap.Solenoid.RightGrabberClose);
	DoubleSolenoid LgrabberSolenoid = new DoubleSolenoid(RobotMap.CAN.pcmId, RobotMap.Solenoid.leftGrabberOpen, RobotMap.Solenoid.leftGrabberClose);
	
	public GrabberSystem() {
		addChild("Right DSolenoid", (DoubleSolenoid) RgrabberSolenoid);
		addChild("Left DSolenoid", (DoubleSolenoid) LgrabberSolenoid);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new GrabberOff());
    }
    
	public void Ropen() {
		RgrabberSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void Rclose() {
		RgrabberSolenoid.set(DoubleSolenoid.Value.kReverse);;
	}

	public void Roff() {
		RgrabberSolenoid.set(DoubleSolenoid.Value.kOff);;
	}
	
	public void Lopen() {
		LgrabberSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void Lclose() {
		LgrabberSolenoid.set(DoubleSolenoid.Value.kReverse);;
	}

	public void Loff() {
		LgrabberSolenoid.set(DoubleSolenoid.Value.kOff);;
	}
	
	public Value Lget() {
		return LgrabberSolenoid.get();
	}
	
	public Value Rget() {
		return RgrabberSolenoid.get();
	}
	
	public void sendInfo() {
		SmartDashboard.putData(this);
	}
}

