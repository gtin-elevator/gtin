package com.elevatorband.gtin.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.test.ShellAssertions;
import org.springframework.shell.test.ShellTestClient;
import org.springframework.shell.test.autoconfigure.ShellTest;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@ShellTest
class HelloCommandIntegrationTest {

    @Autowired
    ShellTestClient client;

    ShellTestClient.InteractiveShellSession session;

    @Test
    @BeforeEach
    void shellIsStats() {
        session = client.interactive().run();
        await()
                .atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> ShellAssertions.assertThat(session.screen()).containsText("shell"));
    }

    @Test
    void testHelpShowsHelloCommand() {
        session.write(session.writeSequence().text("help").carriageReturn().build());

        await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
            ShellAssertions.assertThat(session.screen()).containsText("hello");
            ShellAssertions.assertThat(session.screen()).containsText("hi");
        });
    }

    @Test
    void testHelpShowsGoodbyeCommand() {
        session.write(session.writeSequence().text("help").carriageReturn().build());

        await().atMost(2, TimeUnit.SECONDS).untilAsserted(() -> {
            ShellAssertions.assertThat(session.screen()).containsText("goodbye");
            ShellAssertions.assertThat(session.screen()).containsText("bye");
        });
    }

    @Test
    void testIfHelloCommandRuns() {
        session.write(session.writeSequence().text("hello --name John").carriageReturn().build());

        await()
                .atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> ShellAssertions.assertThat(session.screen()).containsText("Hello, John :)"));
    }

    @Test
    void testIfGoodbyeCommandRuns() {
        session.write(session.writeSequence().text("goodbye --name John").carriageReturn().build());

        await()
                .atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> ShellAssertions.assertThat(session.screen()).containsText("Goodbye, John :D"));
    }
}