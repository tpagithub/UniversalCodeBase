package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Gennaro
 */
public class DriveTrainTester
{
    private TPAJoystick joystick;
    private TPARobotDrive robotDrive;
    
    // An array to track the state of each wheel.
    private boolean motorStates[];
    private final int FRONT_LEFT = 0,
            REAR_LEFT = 1,
            FRONT_RIGHT = 2,
            REAR_RIGHT = 3;
    
    // Define the speeds for the ON and OFF states.
    private final double ON = 0.75,
            OFF = 0;
    
    public DriveTrainTester(TPAJoystick joystick, TPARobotDrive robotDrive)
    {
        this.joystick = joystick;
        this.robotDrive = robotDrive;
        
        motorStates = new boolean[4];
    }
    
    public void reset()
    {
        for (int i = 0; i < motorStates.length; i++)
        {
            motorStates[i] = false;
        }
    }
    
    public void run()
    {
        /**
         * Looking at the top of the Logitech 3D Pro:
         * Top left button: 5
         * Top right button: 6
         * Bottom left button: 3
         * Bottom right button: 4
         */
        if (joystick.getButtonPush(5))
        {
            motorStates[FRONT_LEFT] = ! motorStates[FRONT_LEFT];
        }
        if (joystick.getButtonPush(6))
        {
            motorStates[FRONT_RIGHT] = ! motorStates[FRONT_RIGHT];
        }
        if (joystick.getButtonPush(3))
        {
            motorStates[REAR_LEFT] = ! motorStates[REAR_LEFT];
        }
        if (joystick.getButtonPush(4))
        {
            motorStates[REAR_RIGHT] = ! motorStates[REAR_RIGHT];
        }
        
        // Set all the motors to on or off depending on the corresponding boolean value in motorStates.
        // FRONT LEFT
        robotDrive.getFrontLeftMotor().set(
                motorStates[FRONT_LEFT] ? ON : OFF);
        TPALCD.getInstance().println(3, "FL: " + 
                (motorStates[FRONT_LEFT] ? "ON" : "OFF"));
        // FRONT RIGHT
        robotDrive.getFrontRightMotor().set(
                motorStates[FRONT_RIGHT] ? ON : OFF);
        TPALCD.getInstance().println(4, "FR: " + 
                (motorStates[FRONT_RIGHT] ? "ON" : "OFF"));
        // REAR LEFT
        robotDrive.getRearLeftMotor().set(
                motorStates[REAR_LEFT] ? ON : OFF);
        TPALCD.getInstance().println(5, "RL: " + 
                (motorStates[REAR_LEFT] ? "ON" : "OFF"));
        // REAR RIGHT
        robotDrive.getRearRightMotor().set(
                motorStates[REAR_RIGHT] ? ON : OFF);
        TPALCD.getInstance().println(6, "RR: " + 
                (motorStates[REAR_RIGHT] ? "ON" : "OFF"));
        
        
    }
}
