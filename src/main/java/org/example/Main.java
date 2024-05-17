package org.example;

import org.example.util.Ihm.Ihm;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Ihm ihm = new Ihm(scanner);
        ihm.start();
    }
}