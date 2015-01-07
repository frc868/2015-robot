package com.techhounds;

import edu.wpi.first.wpilibj.Joystick;

/**
 * @author Atif Niyaz
 */
public class OI {
	
	private static OI instance;
	
	private static ControllerMap driver;
	private static ControllerMap operator;
	
	private boolean isInit;
	private static final double DEADZONE = 0.05;
	
	public OI() {
		
		driver = new ControllerMap(new Joystick(RobotMap.DRIVER_PORT), ControllerMap.PS3);
		operator = new ControllerMap(new Joystick(RobotMap.OPERATOR_PORT), ControllerMap.LOGITECH);
		
		isInit = false;
	}
	
	public static OI getInstance() {
		if(instance == null)
			instance = new OI();
		
		return instance;
	}

    public void init() {
    	
    	if(isInit)
    		return;
    	
    	initDriver();
    	initOperator();
    	initSD();
    	
    	isInit = true;
    }
    
    public void initDriver() {
    	// TODO: Put Driver Buttons and Commands;
    }
    
    public void initOperator() {
    	// TODO: Put Operator Buttons and Commands;
    }
    
    public void initSD() {
    	// TODO: Put SmartDashboard Values;
    }
    
    public static double getDriverRightXAxis() {
    	double val = driver.getRightStickX();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
    
    public static double getDriverRightYAxis() {
    	double val = driver.getRightStickY();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
    public static double getDriverleftXAxis() {
    	double val = driver.getLeftStickX();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
    public static double getDriverLeftYAxis() {
    	double val = driver.getLeftStickY();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
    
    public static double getOperatorRightXAxis() {
    	double val = operator.getRightStickX();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
    
    public static double getOperatorRightYAxis() {
    	double val = operator.getRightStickY();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
    public static double getOperatorLeftXAxis() {
    	double val = operator.getLeftStickX();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
    public static double getOperatorLeftYAxis() {
    	double val = operator.getLeftStickY();
    	if (Math.abs(val) < DEADZONE)
    		return 0;
    	return val;
    }
}

