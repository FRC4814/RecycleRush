package org.usfirst.frc.team4814.robot;
//USES HALLEFFEX SENSORS
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    //public static final int[] LEFT_MOTORS = {3,2}; // Front Left, Back Left//TODO FIIXX THISS
	public static final int[] LEFT_MOTORS = {1,4};
    public static final int[] RIGHT_MOTORS = {1,0}; // Front Right, Back Right
    public static final int[] ELEVATOR_MOTOR = {4,5}; // Motor set to elevator winch
    public static final int ARM_MOTOR = 7; // Motor set to arm winch
    public static final int[] ENCODER_LEFT = {1, 2};//left side movement encoder
   // public static final int[] ENCODER_RIGHT = {2, 3};//right side movement encoder
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
