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
            if (direction.equals("S")) {
                locationY--;
            }
            if (direction.equals("E")) {
                locationX++;
            }
        }
    }

    private void turn(String command) {
        if (command.equals("L")) {
            if (direction.equals("N")) {
                direction = "W";
            }
            if (direction.equals("S")) {
                direction = "E";
            }
        }
        if (command.equals("R")) {
            if (direction.equals("N")) {
                direction = "E";
            }
            if (direction.equals("S")) {
                direction = "W";
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
