package com.epam.functionalprogramming.example2lambda;

public class LambdaExample3 {

    public static void main(String[] args) {
        //print OK to console
        
        
        Task printToConsole = () -> System.out.println("Nothing happened");

        printToConsole.execute();

        //do nothing


        Task doNothing = () -> {};

        //call cache()

        //return number from task

    }

    private static int cache() {
        return 0;
    }

    private interface Task {

        void execute();
    }
}
