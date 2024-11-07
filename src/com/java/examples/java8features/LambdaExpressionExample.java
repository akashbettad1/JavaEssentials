package com.java.examples.java8features;

interface Speak {
     String say(String message);
}

public class LambdaExpressionExample {

    public static void main(String[] args) {
        Speak s = (message) -> {
            String msg = "Announce " + message;
            return msg;
        };
        System.out.println(s.say("nominations"));
    }
}
