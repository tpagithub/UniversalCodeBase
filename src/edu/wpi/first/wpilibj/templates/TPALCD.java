/*
 /*
 *  TPA LCD
 *  Version: 0.1
 *  Desc: Allows you to print message on driver station, line 1 thru 6 inclusive
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;

public class TPALCD {

    private DriverStationLCD lcd;
    private static TPALCD instance = null;
    private String line[];

    private TPALCD() {
        lcd = DriverStationLCD.getInstance();
        line = new String[]{null, null, null, null, null, null};
    }
    public static TPALCD getInstance(){
        if (instance == null) {
            instance = new TPALCD();
        }
        return instance;
    }
    /**
     * This method allows the user to reset the lcd instance. 
     * Resetting the instance clears all the lines and starts the user with
     * blank lines again. Warning: This method calls the garbage collector. It 
     * is not recommended to call it from a method other than an Init method.
     */
    public static void deleteInstance() {
        if (instance != null)
        {
            // Remove the pointer to the instance and garbage collect the now
            // un-accessible data.
            instance = null;
            System.gc();
        }
    }
    public void println(int lineNumber, String text) {
        line[lineNumber - 1] = text;
        clear();
        for (int i = 0; i < line.length; i++) {
            if (line[i] != null) {
                switch (i) {
                    case 0:
                        lcd.println(DriverStationLCD.Line.kUser1, 1, line[i]);
                        break;
                    case 1:
                        lcd.println(DriverStationLCD.Line.kUser2, 1, line[i]);
                        break;
                    case 2:
                        lcd.println(DriverStationLCD.Line.kUser3, 1, line[i]);
                        break;
                    case 3:
                        lcd.println(DriverStationLCD.Line.kUser4, 1, line[i]);
                        break;
                    case 4:
                        lcd.println(DriverStationLCD.Line.kUser5, 1, line[i]);
                        break;
                    case 5:
                        lcd.println(DriverStationLCD.Line.kUser6, 1, line[i]);
                        break;

                }
            }
        }
        update();
    }

    private void update() {
        lcd.updateLCD();
    }

    private void clear() {
        lcd.clear();
    }
}
