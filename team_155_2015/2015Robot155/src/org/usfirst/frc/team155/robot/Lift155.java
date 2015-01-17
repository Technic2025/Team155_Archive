package org.usfirst.frc.team155.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

public class Lift155 {
	robotMap155 robotSystem;
	Joystick rightStick;
	DoubleSolenoid sol;
	DigitalInput lowLimit;
	DigitalInput highLimit;
	Victor liftDrive;
	
	
	public Lift155(robotMap155 robot, Joystick right){
		robotSystem = robot;
		rightStick = right;
		sol = new DoubleSolenoid(robot.GRIPPER_SIDE_A, robot.GRIPPER_SIDE_B);
        lowLimit = new DigitalInput(robot.LOW_LIMIT);
        highLimit = new DigitalInput(robot.HIGH_LIMIT);
		liftDrive = new Victor(robot.LIFT_MOTOR);
	}
	
	
	
	
	//LIFT METHOD
	
	private void lift(){
		
		if  (highLimit.get() || lowLimit.get())
    		if (lowLimit.get() && (rightStick.getY()<0))
    				liftDrive.set(rightStick.getY());
    		else if  (highLimit.get() && (rightStick.getY()>0))
    				liftDrive.set(rightStick.getY());
    		else 
    			liftDrive.set(0);
    	else 
    		liftDrive.set(rightStick.getY());
    	
	}
	
	//GRABBER method
	private void grabber(){
		
		if (rightStick.getTrigger()) 
    		sol.set(DoubleSolenoid.Value.kForward);
    	else sol.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	
	public void run(){
		//call lift....
		lift();
		
		//call grabber....
		grabber();
	}

}