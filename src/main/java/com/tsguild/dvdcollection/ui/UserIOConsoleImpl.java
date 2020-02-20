/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollection.ui;

import java.util.Scanner;

/**
 *
 * @author Craig
 */
public class UserIOConsoleImpl implements UserIO {
    
    Scanner input = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    @Override
    public double readDouble(String prompt) {
        double inputDouble;
        System.out.print(prompt + " ");
        inputDouble = input.nextDouble();
        return inputDouble;
    }

    /**
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */
    @Override
    public double readDouble(String prompt, double min, double max) {
        double inputDouble;
        boolean notBetweenMinMax = true;
        do {
            System.out.print(prompt + " ");
            inputDouble = input.nextDouble();
        
            if (inputDouble < max+1 && inputDouble > min-1) {
                notBetweenMinMax = false; // STOP PROMPTING
            } else {
                System.out.println("INVALID VALUE");
            }
        } while (notBetweenMinMax);
        return inputDouble;
    }

    @Override
    public float readFloat(String prompt) {
        float real;
        System.out.print(prompt + " ");
        real = input.nextFloat();
        return real;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float real;
        boolean notBetweenMinMax = true;
        do {
            System.out.print(prompt + " ");
            real = input.nextFloat();
        
            if (real < max+1 && real > min-1) {
                notBetweenMinMax = false; // STOP PROMPTING
            } else {
                System.out.println("INVALID VALUE");
            }
        } while (notBetweenMinMax);
        return real;
    }

    @Override
    public int readInt(String prompt) {
        int integer;
        System.out.print(prompt + " ");
        integer = input.nextInt();
     // reading the complete line for the integer 
     // and converting it to an integer 
     //   integer = Integer.parseInt(input.nextLine()); 
     // Read the leftover new line
     //   input.nextLine();
        return integer;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int integer;
        boolean notBetweenMinMax = true;
        do {
            System.out.print(prompt + " ");
            integer = input.nextInt();
        
            if (integer < max+1  && integer > min-1) {
                notBetweenMinMax = false; // STOP PROMPTING
            } else {
                System.out.println("INVALID VALUE");
            }
        } while (notBetweenMinMax);
        return integer;
    }

    @Override
    public long readLong(String prompt) {
        long inputLong;
        System.out.print(prompt + " ");
        inputLong = input.nextLong();
        return inputLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long inputLong;
        boolean notBetweenMinMax = true;
        do {
            System.out.print(prompt + " ");
            inputLong = input.nextLong();
        
            if (inputLong < max+1 && inputLong > min-1) {
                notBetweenMinMax = false; // STOP PROMPTING
            } else {
                System.out.println("INVALID VALUE");
            }
        } while (notBetweenMinMax);
        return inputLong;
    }
    
    @Override
    public String readString(String prompt) {
        System.out.print(prompt + " ");
        String response = input.nextLine();    
        if (response.trim().isEmpty()) {
            response = input.nextLine();
        }
        return response;
    }
}
