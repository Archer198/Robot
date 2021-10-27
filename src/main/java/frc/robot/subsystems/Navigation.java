// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Toolkit.CT_Gyro;
import frc.robot.RobotContainer;

public class Navigation extends SubsystemBase {

    CT_Gyro gyro = new CT_Gyro(Port.kOnboardCS0);

  /** Creates a new Navigation. */
  public Navigation() {

     
    

  }

  @Override
  public void periodic() {
    
    double yaw = gyro.getYaw();
    if ((yaw > 3.0) || (yaw < -3.0)){

      System.out.println("Yes sir its pimp chimping");
      //RobotContainer.getDrivebaseSubsystem().moveLeft();

    }

    System.out.println("Yaw = " + gyro.getYaw());



  }
}
