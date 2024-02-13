package com.someware.bitacoraviajes.utils;

public class dataValidator {
    public static boolean validatePlate(String plate){
        return plate.matches("^[A-Z0-9]{3}-[0-9]{3}$");
    }
}
