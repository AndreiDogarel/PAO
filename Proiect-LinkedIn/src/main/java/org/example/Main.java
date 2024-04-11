package org.example;

import view.ConsoleApp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ConsoleApp consoleApp;

    public static void main(String[] args) {
        consoleApp = ConsoleApp.getInstance();
        consoleApp.start();
    }
}