package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 * ProximitySubsystem
 */
public class ProximitySubsystem extends SubsystemBase {

    // Ultrasonic m_frontSensor = new Ultrasonic(Constants.DIO_0, Constants.DIO_1);
   // Ultrasonic m_leftSensor = new Ultrasonic(Constants.DIO_2, Constants.DIO_3);
    Ultrasonic m_rightSensor = new Ultrasonic(Constants.DIO_0, Constants.DIO_1);


    public ProximitySubsystem() {
        m_rightSensor.setAutomaticMode(true);
        // m_leftSensor.setAutomaticMode(true);
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
  
        //System.out.println("FrontSensor: " + m_frontSensor.getRangeInches());
        //System.out.println("RightSensor: " + m_rightSensor.getRangeInches());

        
       //  if (m_rightSensor.getRangeInches() < 20.0) {
       //     RobotContainer.getDrivebaseSubsystem().moveLeft();
       // }
        

        


    }
  

}