package org.usfirst.frc.team1799.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;


/**
 * Note : Sample code taken from PacGoat example of wpilib.
 * 
 * A custom button that is triggered when two buttons on a Joystick are
 * simultaneously pressed.
 * 
 * look at this example to make a new conditional joystick trigger for
 * push or lift 
 */
public class DoubleButton extends Trigger {

	private Joystick m_joy;
	private int m_button1;
	private int m_button2;

	public DoubleButton(Joystick joy, int button1, int button2) {
		this.m_joy = joy;
		this.m_button1 = button1;
		this.m_button2 = button2;
	}

	@Override
	public boolean get() {
		return m_joy.getRawButton(m_button1) && m_joy.getRawButton(m_button2);
	}
}
