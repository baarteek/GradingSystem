package com.gradingsystem.server;

public class Main {
    public static void main(String[] args) {
        Database.connect();
        Database.disconnect();
    }
}
