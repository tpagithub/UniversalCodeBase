/*
 *  TPA Joystick Class
 *  Version: 0.1
 *  Desc: Adds additional functionality to the FRC Joystick class.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;


public class TPAJoystick extends Joystick {
    private boolean[] buttonState = new boolean[11];
    
    public TPAJoystick(final int aPort) {
        super(aPort);
        for(int i=0; i<buttonState.length; i++) {
            buttonState[i] = true;
        }
    }
    
    public boolean getPushButton(int button) {
        boolean returnValue;
        boolean newState = getRawButton(button);
        if(newState == true && newState != buttonState[button-1]) {
                returnValue = true;
        }
        else {returnValue = false;}
        buttonState[button-1] = newState;
        return(returnValue);
    }
}
