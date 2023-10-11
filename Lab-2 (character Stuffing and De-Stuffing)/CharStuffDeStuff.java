package com.datacommunication;

import java.util.Scanner;

public class CharStuffDeStuff {
    static final String START = "DLESTX ";
    static final String END = " DLEETX";

    public static String stuffData(String input) {
        StringBuilder stuffed = new StringBuilder(START);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'D' && input.charAt(i + 1) == 'L' && input.charAt(i + 2) == 'E') {
                stuffed.append("DLEDLE");
                i += 2;
            } else
                stuffed.append(input.charAt(i));

        }

        stuffed.append(END);

        return stuffed.toString();
    }

    public static String deStuffData(String input) {
        StringBuilder destuffed = new StringBuilder(START);
        for (int i = 6; i < input.length(); i++) {
            if (input.charAt(i) == 'D' && input.charAt(i + 1) == 'L' && input.charAt(i + 2) == 'E' && input.charAt(i + 3) == 'D' && input.charAt(i + 4) == 'L' && input.charAt(i + 5) == 'E') {
                destuffed.append("DLE");
                i += 5;
            } else
                destuffed.append(input.charAt(i));
        }
        return destuffed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of characters: ");
        String input = scanner.nextLine().toUpperCase();
        String stuffed = stuffData(input);
        String destuffed = deStuffData(stuffed);
        System.out.println("Stuffing data: " + stuffed);
        System.out.println("DeStuffing data: " + destuffed);
    }
}