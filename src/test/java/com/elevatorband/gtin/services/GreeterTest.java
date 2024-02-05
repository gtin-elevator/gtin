package com.elevatorband.gtin.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreeterTest {
    private final Greeter greeter = new Greeter();

    @Test
    void testComposeHiWorld() {
        String expected = "Hello, Mad World :)";

        String actual = greeter.composeHi();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testComposeHiName() {
        String input = "John";
        String expected = "Hello, " + input + " :)";

        String actual = greeter.composeHi(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testComposeByeWorld() {
        String expected = "Goodbye, Wonderful World :D";

        String actual = greeter.composeBye();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testComposeByeName() {
        String input = "John";
        String expected = "Goodbye, " + input + " :D";

        String actual = greeter.composeBye(input);

        Assertions.assertEquals(expected, actual);
    }
}