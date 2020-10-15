package com.afs.tdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarsRover {
    private int locationX;
    private int locationY;
    private String direction;
    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String EAST = "E";
    private static final String WEST = "W";
    private static final String TURN_LEFT_COMMAND = "L";
    private static final String TURN_RIGHT_COMMAND = "R";
    private static final String EMPTY_STRING = "";
    private static final String MOVE_COMMAND = "M";
    private static final Map<String, String> LEFT_TURN_MAP = new HashMap<>();
    private static final HashMap<String, String> RIGHT_TURN_MAP = new HashMap<>();
    private static final List<String> COMMAND_LIST = Arrays.asList(MOVE_COMMAND, TURN_LEFT_COMMAND, TURN_RIGHT_COMMAND);

    static {
        LEFT_TURN_MAP.put(NORTH, WEST);
        LEFT_TURN_MAP.put(SOUTH, EAST);
        LEFT_TURN_MAP.put(EAST, NORTH);
        LEFT_TURN_MAP.put(WEST, SOUTH);
        RIGHT_TURN_MAP.put(NORTH, EAST);
        RIGHT_TURN_MAP.put(SOUTH, WEST);
        RIGHT_TURN_MAP.put(EAST, SOUTH);
        RIGHT_TURN_MAP.put(WEST, NORTH);
    }

    public MarsRover(int locationX, int locationY, String direction) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.direction = direction;
    }

    public void executeCommand(String commands) {
        Arrays.stream(commands.split(EMPTY_STRING))
                .forEach(command -> {
                    try {
                        checkValidCommand(command);
                        move(command);
                        turn(command);
                    } catch (CommandNotDefinedException e) {
                        e.printStackTrace();
                    }
                });
    }

    public void checkValidCommand(String command) throws CommandNotDefinedException {
        if (!COMMAND_LIST.contains(command)) {
            throw new CommandNotDefinedException("Command " + command + " Not Defined");
        }
    }

    private void move(String command) {
        if (!command.equals(MOVE_COMMAND)) {
            return;
        }
        switch (direction) {
            case NORTH:
                locationY++;
                break;
            case SOUTH:
                locationY--;
                break;
            case EAST:
                locationX++;
                break;
            case WEST:
                locationX--;
                break;
        }
    }

    private void turn(String command) {
        if (command.equals(TURN_LEFT_COMMAND)) {
            direction = LEFT_TURN_MAP.get(direction);
        }
        if (command.equals(TURN_RIGHT_COMMAND)) {
            direction = RIGHT_TURN_MAP.get(direction);
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
