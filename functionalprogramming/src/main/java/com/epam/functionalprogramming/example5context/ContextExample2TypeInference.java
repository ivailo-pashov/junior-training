package com.epam.functionalprogramming.example5context;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class ContextExample2TypeInference {
    private final String field;

    public static void main(String[] args) {
        //function that concatenates two strings

        BinaryOperator<String> function0 = (x, y) -> x + y;
        BinaryOperator<String> function1 = (x, y) -> x + y;
        IntBinaryOperator function2 = (x, y) -> x + y;
        BinaryOperator<Long> function3 = (x, y) -> x + y;
        BiFunction<Long, Long, Long> function4 = ContextExample2TypeInference::getaLong;

        //print lambda expression to the console

        //check if two lambda expressions are equal

        ContextExample2TypeInference example1 = new ContextExample2TypeInference("1");
        BinaryOperator<String> binaryOperator1 = example1.getBinaryOperator();
        System.out.println(binaryOperator1.apply("Greetings ", "from ") + " - " + binaryOperator1);
        ContextExample2TypeInference example2 = new ContextExample2TypeInference("2");
        BinaryOperator<String> binaryOperator2 = example2.getBinaryOperator();
        System.out.println(binaryOperator2.apply("Greetings ", "from ") + " - " + binaryOperator2);
    }

    private static Long getaLong(Long x, Long y) {
        //other statement goes here
        //other statement goes here
        //other statement goes here
        //other statement goes here
        //other statement goes here
        //other statement goes here
        //other statement goes here
        //other statement goes here
        //other statement goes here
        //other statement goes here
        return x + y;
    }

    ContextExample2TypeInference(String field) {
        this.field = field;
    }

    BinaryOperator<String> getBinaryOperator() {
        return (x, y) -> x + y + field;
    }
}
