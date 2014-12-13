/*----------------------------------------------------------------------------*/
/*  TPA Joystick Class                                                        */  
/*  Version: 0.1                                                              */  
/*  Desc: Adds additional functionality to the FRC Joystick class.            */

/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Desc: The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation.If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * Version: 0.1
 */

public class RobotTemplate extends IterativeRobot {
    private TPAJoystick joystick;
    private TPARobotDrive robotDrive;
    private TPAServo servo;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        TPALCD.deleteInstance();
        joystick = new TPAJoystick(RobotMap.joystickOnePort);
        robotDrive = new TPARobotDrive(RobotMap.frontLeftPort, RobotMap.rearLeftPort, RobotMap.frontRightPort, RobotMap.rearRightPort, joystick);
        //servo = new TPAServo(RobotMap.servoPort, joystick);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        robotDrive.mecanumDrive_Polar();
        //servo.runServo();
        TPALCD.getInstance().println(2, joystick.getDirectionDegrees() + "");
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
