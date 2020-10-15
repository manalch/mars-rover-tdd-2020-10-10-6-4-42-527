package com.afs.tdd;

import java.util.Arrays;

public class MarsRover {
    private int locationX;
    private int locationY;
    private String direction;

    public MarsRover(int locationX, int locationY, String direction) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.direction = direction;
    }

    public void executeCommand(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(command -> {
                    move(command);
                    turn(command);
                });
    }

    private void move(String command) {
        if (command.equals("M")) {
            if (direction.equals("N")) {
                locationY++;
            }
        }
    }

    private void turn(String command) {
        if (command.equals("L")) {
            if (direction.equals("N")) {
                direction = "W";
            }
        }
        if (command.equals("R")) {
            if (direction.equals("N")) {
                direction = "E";
            }
        }
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getDirection() {
        return direction;
    }
}
