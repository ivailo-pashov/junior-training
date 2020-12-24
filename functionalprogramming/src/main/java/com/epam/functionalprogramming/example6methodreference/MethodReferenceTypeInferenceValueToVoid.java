package com.epam.functionalprogramming.example6methodreference;

public class MethodReferenceTypeInferenceValueToVoid {

    public static void main(String[] args) {
        //declare a method reference to identity as Consumer<Integer>
    }

    private static Integer identity(Integer x) {
        return x;
    }
}
