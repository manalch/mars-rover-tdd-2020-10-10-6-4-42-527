package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DemoTest {
    @Test
    void should_return_0_locationX_1_locationY_N_heading_when_command_given_is_M() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommand("M");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(1, marsRover.getLocationY());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_W_heading_when_command_given_is_L() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommand("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_E_heading_when_command_given_is_R() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommand("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_negative1_locationY_N_heading_when_command_given_is_M() {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommand("M");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(-1, marsRover.getLocationY());
        assertEquals("S", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_E_heading_when_command_given_is_L() {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommand("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_W_heading_when_command_given_is_R() {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommand("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getDirection());
    }

    @Test
    void should_return_1_locationX_0_locationY_E_heading_when_command_given_is_M() {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommand("M");

        assertEquals(1, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_N_heading_when_command_given_is_L() {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommand("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_S_heading_when_command_given_is_R() {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommand("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("S", marsRover.getDirection());
    }

    @Test
    void should_return_negative1_locationX_0_locationY_W_heading_when_command_given_is_M() {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommand("M");

        assertEquals(-1, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_S_heading_when_command_given_is_L() {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommand("L");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("S", marsRover.getDirection());
    }

    @Test
    void should_return_0_locationX_0_locationY_N_heading_when_command_given_is_R() {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommand("R");

        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    void should_throw_command_not_defined_exception_when_command_given_is_invalid() {
        MarsRover marsRover = new MarsRover(0, 0, "N");
        assertThrows(CommandNotDefinedException.class, () -> {
            marsRover.checkValidCommand("F");
        });
    }

    @Test
    void should_return_negative1_locationX_1_locationY_N_heading_when_command_given_is_MLMR() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommand("MLMR");

        assertEquals(-1, marsRover.getLocationX());
        assertEquals(1, marsRover.getLocationY());
        assertEquals("N", marsRover.getDirection());
    }
}
