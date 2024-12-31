package com.samaham.warcardgame;

import java.util.concurrent.TimeUnit;
/**
 *
 * @author Matthew Samaha
 * The Utils class enhances printing a message, which simulates a typing effect, 
 * enhancing the user experience by making the output feel more dynamic and engaging.
 */
public class Utils {
    public static void systemPrint(String message, String color){
        // clear line before starting to print
        System.out.print("\r");
        
        for (char c : message.toCharArray()){
            System.out.print(color + c);
            System.out.flush(); // ensure character is printed immediately
            try {
                TimeUnit.MILLISECONDS.sleep(50); // adjust speed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.print(ANSI.RESET); // reset color after message
        System.out.println(); 
    }
}
