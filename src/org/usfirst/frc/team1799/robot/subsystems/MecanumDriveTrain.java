package org.usfirst.frc.team1799.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogGyro;
import org.usfirst.frc.team1799.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team1799.robot.RobotMap;
import org.usfirst.frc.team1799.robot.drive.PlayMecanum;


/**
 *
 * The DriveTrain subsystem uses use Mecanum to controls the robot's chassis and reads in
 * information about it's speed and position.
 */
public class MecanumDriveTrain extends Subsystem {
	
	private static final int kFrontLeftChannel = 0;
	private static final int kRearLeftChannel = 1;
	private static final int kFrontRightChannel = 2;
	private static final int kRearRightChannel = 3;

	private AnalogGyro m_gyro = new AnalogGyro(RobotMap.kGyroChannel);
	private MecanumDrive m_robotDrive;

	public MecanumDriveTrain() {
		Spark m_frontLeft = new Spark(kFrontLeftChannel);
		Spark m_rearLeft = new Spark(kRearLeftChannel);
		Spark m_frontRight = new Spark(kFrontRightChannel);
		Spark m_rearRight = new Spark(kRearRightChannel);

		addChild("Front Left Drive", m_frontLeft);
		addChild("Rear Left Drive", m_rearLeft);
		addChild("Front Right Drive", m_frontRight);
		addChild("Rear Right Drive", m_rearRight);
		
		// Invert the left side motors.
		// You may need to change or remove this to match your robot.
//		frontLeft.setInverted(true);
//		rearLeft.setInverted(true);

		//m_robotDrive = new MecanumDrive(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);
		m_robotDrive = new PlayMecanum(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);
		addChild("Macanum drive", m_robotDrive);
		// Configure gyro
        m_gyro.setSensitivity(0.007); // TODO: Handle more gracefully?
		addChild("Gyro", m_gyro);
}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	@Override
    public void initDefaultCommand() {
    	/**
    	 * When other commands aren't using the drivetrain, allow Mecanum drive with
    	 * the joystick.
    	 */
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    }
	
	/**
	 * Mecanum drive using a PS3 joystick.
	 *
	 * @param joy PS3 style joystick to use as the input for Mecanum drive.
	 */
	public void macDrive(Joystick joy) {
		// Use the joystick X axis for lateral movement, Y axis for forward
		// movement, and Z axis for rotation.
	    System.out.println("x="+joy.getX()+",y="+joy.getY()+",zRotation="+joy.getZ());
	    m_robotDrive.driveCartesian(-1.0*(joy.getX()), -1.0*(joy.getY()), joy.getZ(), 0.0);
	}

	/**
	 * Mecanum drive using individual joystick axes.
	 * we will use this in AutoDrive commands
	 *
	 * @param xAxis lateral movement value
	 * @param yAxis forward movement value
	 * @param zAxis rotation sides value
	 */
	public void macDrive(double xAxis, double yAxis, double zAxis) {
	    System.out.println("x="+xAxis+",y="+yAxis+",zRotation="+zAxis);
	    m_robotDrive.driveCartesian(-1.0*(xAxis), -1.0*(yAxis), zAxis, 0.0);
	}
	
	/**
	 * Mecanum drive using individual joystick axes.
	 * we will use this in AutoDrive commands
	 *
	 * @param xAxis lateral movement value
	 * @param yAxis forward movement value
	 * @param zAxis rotation sides value
	 * @param angle gyro angle value
	 */
	public void macDrive(double xAxis, double yAxis, double zAxis,double angle) {
	    System.out.println("x="+xAxis+",y="+yAxis+",zRotation="+zAxis+",Angle="+angle);
	    m_robotDrive.driveCartesian(-1.0*(xAxis), -1.0*(yAxis), zAxis, angle);
	}
	
	/**
	 * Stop the drivetrain from moving.
	 */
	public void stop() {
	    m_robotDrive.driveCartesian(0,0,0, 0.0);
	}
	
	/**
	 * The current angle of the drivetrain as measured by the Gyro.
	 */
	public double getAngle() {
		return m_gyro.getAngle();
	}


	public void sendInfo() {
		SmartDashboard.putData(this);
	}
	
}

