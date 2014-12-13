/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author Developer
 */
public class TPAServo extends Servo {

    private TPAJoystick joystick;

    public TPAServo(int channel, TPAJoystick joystick) {
        super(channel);
        this.joystick = joystick;

    }

    public void runServo() {
        if (joystick.getRawAxis(5) == 1) {
            set(1);
        } else if (joystick.getRawAxis(5) == -1) {
            set(0);
        }

    }
}
