package com.afs.tdd;

public class CommandNotDefinedException extends Exception {
    CommandNotDefinedException(String message) {
        super(message);
    }
}
