package com.elevatorband.gtin.services;

/*
This is example of services that we are going to create.
 */
public class Greeter {
    public static final String DEFAULT_NAME = "World";

    public String composeHi(String name) {
        String message = "Hello, ";
        if (name.equals(DEFAULT_NAME)) {
            message = message + "Mad ";
        }
        message = message + name + " :)";

        return message;
    }

    public String composeHi() {
        return this.composeHi(DEFAULT_NAME);
    }

    public String composeBye(String name) {
        String message = "Goodbye, ";
        if (name.equals(DEFAULT_NAME)) {
            message = message + "Wonderful ";
        }
        message = message + name + " :D";

        return message;
    }

    public String composeBye() {
        return this.composeBye(DEFAULT_NAME);
    }
}
