package org.usfirst.frc.team1799.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1799.robot.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
/**
 *
 */
public class CompressorSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Compressor compressor = new Compressor(RobotMap.CAN.pcmId);
	// TODO: try below
	//Compressor compressor = new Compressor();


	public void start() {
		if (!compressor.getClosedLoopControl()) {
			compressor.start();
		}
	}

	public void stop() {
		if (compressor.getClosedLoopControl()) {
			compressor.stop();
		}
	}

	public void toggleRun() {
		if (compressor.getClosedLoopControl()) {
			compressor.stop();
		} else {
			compressor.start();
		}
	}

	public void sendInfo() {
		SmartDashboard.putData(this);
	}
	
	@Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

