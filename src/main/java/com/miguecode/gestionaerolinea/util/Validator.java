package com.miguecode.gestionaerolinea.util;

public class Validator {
    // Validaciones basicas
    public static boolean isNotEmpty(String value) {
        return !value.trim().isEmpty();
    }

    public static boolean positiveNumber(int number) {
        return number > 0;
    }

    public static boolean positiveDecimalNumber(double number) {
        return number > 0;
    }
}
