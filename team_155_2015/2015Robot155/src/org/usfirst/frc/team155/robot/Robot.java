
package org.usfirst.frc.team155.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	robotMap155 robot;
	Lift155 robotLift;
	DRIVE155 robotDrive;
	Joystick rightStick;
	Joystick leftStick;
	
	
	
	
    public void robotInit() {
    	rightStick = new Joystick(1);
    	leftStick = new Joystick(0);
    	robot = new robotMap155();
    	robotLift = new Lift155(robot, rightStick);
    	robotDrive = new DRIVE155(leftStick, rightStick, robot);
    	
    }
    
    
    public void autonomousInit() {

    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    public void teleopInit() {
        
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    		//call drive run() method
    		robotDrive.run();
    		//call lift run() method
    		//robotLift.run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}