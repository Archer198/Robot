package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivebaseSubsystem extends SubsystemBase {

  private WPI_TalonSRX m_rightFront = new WPI_TalonSRX(Constants.RIGHT_FRONT_MOTOR_CAN_ID);
  private WPI_TalonSRX m_rightBack = new WPI_TalonSRX(Constants.RIGHT_REAR_MOTOR_CAN_ID);
  private WPI_TalonSRX m_leftFront = new WPI_TalonSRX(Constants.LEFT_FRONT_MOTOR_CAN_ID);
  private WPI_TalonSRX m_leftBack = new WPI_TalonSRX(Constants.LEFT_REAR_MOTOR_CAN_ID);

  private static final int kJoystickChannel = 0;

  private MecanumDrive m_robotDrive;
  private Joystick m_stick;

  public DrivebaseSubsystem() {

    DriverStation.getInstance().silenceJoystickConnectionWarning(true);

    m_leftFront.configOpenloopRamp(0.5);
    m_leftBack.configOpenloopRamp(0.5);
    m_rightFront.configOpenloopRamp(0.5);
    m_rightBack.configOpenloopRamp(0.5);

    m_leftBack.follow(m_leftFront);
    m_rightBack.follow(m_rightFront);

    m_robotDrive = new MecanumDrive(m_leftFront, m_leftBack, m_rightFront, m_rightBack);

    m_stick = new Joystick(kJoystickChannel);
  }

  private double deadband(final double value) {
		/* Upper deadband */
		if (value >= 0.2) {
			return value;
		}

		/* Lower deadband */
		if (value <= -0.2) {
			return value;
		}

		/* Inside deadband */
		return 0.0;
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    double x = (deadband(m_stick.getX())/3);
    double y = (deadband(m_stick.getY())/3);
    double z = (deadband(m_stick.getZ())/3);

     //System.out.println("X: " + x + " Y: " + y + " Z: " + z);

     m_robotDrive.driveCartesian (x, y, -z);

    //m_robotDrive.driveCartesian(0, 0, 0);
  }

  

  public Joystick getJoystick() {
    return m_stick;
  }

  public void moveLeft() {
    m_robotDrive.driveCartesian(0.5, 0, 0);
  }
    
}


