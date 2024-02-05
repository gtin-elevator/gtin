package com.elevatorband.gtin.commands;

import com.elevatorband.gtin.services.Greeter;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/*
This is the example of command that we are going to implement.
 */
@ShellComponent
public class HelloCommand {

    @ShellMethod(key = {"hello", "hi"}, value = "Greet our world")
    public String hello(@ShellOption(defaultValue = Greeter.DEFAULT_NAME, value = {"--name", "-n"}) String arg) {
        Greeter greeter = new Greeter();

        return greeter.composeHi(arg);
    }

    @ShellMethod(key = {"goodbye", "bye"}, value = "Be polite, say bye")
    public String goodbye(@ShellOption(defaultValue = Greeter.DEFAULT_NAME, value = {"--name", "-n"}) String arg) {
        Greeter greeter = new Greeter();

        return greeter.composeBye(arg);
    }
}
