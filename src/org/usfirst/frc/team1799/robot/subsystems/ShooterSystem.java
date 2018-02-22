package org.usfirst.frc.team1799.robot.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1799.robot.RobotMap;
import org.usfirst.frc.team1799.robot.commands.ShooterPullIn;

/**
 *
 */
public class ShooterSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Solenoid ShooterSolenoid = new Solenoid(RobotMap.CAN.pcmId, RobotMap.Solenoid.shooter);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterPullIn());
    }
    
	public void on() {
		ShooterSolenoid.set(true);
		System.out.println(this.getClass().getName() + " on");
	}

	public void off() {
		ShooterSolenoid.set(false);
		System.out.println(this.getClass().getName() + " off");
	}
	
	  /**
	   * Set the pulse duration in the PCM. This is used in conjunction with
	   * the startPulse method to allow the PCM to control the timing of a pulse.
	   * The timing can be controlled in 0.01 second increments.
	   *
	   * @param durationSeconds The duration of the pulse, from 0.01 to 2.55 seconds.
	   *
	   * @see #startPulse()
	   */
	public void setPulseDuration(double pulseDuration) {
	    if( pulseDuration >= 0.01 && pulseDuration <= 2.55 ){ 
		  ShooterSolenoid.setPulseDuration(pulseDuration);	
	    }
	}
	
	 /**
	   * Trigger the PCM to generate a pulse of the duration set in
	   * setPulseDuration.
	   *
	   * @see #setPulseDuration(double)
	   */
	  public void startPulse() {
		  ShooterSolenoid.startPulse();
	  }

	  /**
	   * Read the current value of the solenoid.
	   *
	   * @return True if the solenoid output is on or false if the solenoid output is off.
	   */
	  public boolean get() {
	    return ShooterSolenoid.get();
	  }
	  
	  
	public void sendInfo() {
		SmartDashboard.putData(this);
	}

}

