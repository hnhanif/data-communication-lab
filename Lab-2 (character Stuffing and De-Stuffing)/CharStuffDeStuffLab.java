package com.datacommunication;

import java.util.Scanner;

public class CharStuffDeStuffLab {
    static final String START = "DLESTX ";
    static final String END = " DLEETX";

    public static String stuffData(String input) {
        StringBuilder stuffed = new StringBuilder(START);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'D' && input.charAt(i + 1) == 'L' && input.charAt(i + 2) == 'E') {
                stuffed.append("DLEDLE");
                i += 2;
            } else if (input.charAt(i) == 'F') {
                stuffed.append("DLEF");
            } else if (input.charAt(i) == 'E') {
                stuffed.append("DLEE");
            } else {
                stuffed.append(input.charAt(i));
            }
        }
        stuffed.append(END);

        return stuffed.toString();
    }

    public static String deStuffData(String input) {
        StringBuilder destuffed = new StringBuilder(START);
        for (int i = 6; i < input.indexOf(END) + 1; i++) {
            if (input.charAt(i) == 'D' && input.charAt(i + 1) == 'L' && input.charAt(i + 2) == 'E' && input.charAt(i + 3) == 'D' && input.charAt(i + 4) == 'L' && input.charAt(i + 5) == 'E') {
                destuffed.append("DLE");
                i += 5;
            } else if (input.charAt(i) == 'D' && input.charAt(i + 1) == 'L' && input.charAt(i + 2) == 'E' && input.charAt(i + 3) == 'F') {
                destuffed.append("F");
                i += 3;
            } else if (input.charAt(i) == 'D' && input.charAt(i + 1) == 'L' && input.charAt(i + 2) == 'E' && input.charAt(i + 3) == 'E') {
                destuffed.append("E");
                i += 3;
            } else {
                destuffed.append(input.charAt(i));
            }
        }
        destuffed.append(END);

        return destuffed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of characters: ");
        String input = scanner.nextLine().toUpperCase();

        System.out.print("Do you want to change the transmitted bit stream before de-stuffing? (y/n): ");
        String choice = scanner.nextLine().toLowerCase();


        if (choice.equals("y")) {
            System.out.print("Enter the modified sequence of characters: ");
            input = scanner.nextLine().toUpperCase();
        } else
            System.out.println("Well, Stuffing with original data.");


        String stuffedData = stuffData(input);
        String deStuffedData = deStuffData(stuffedData);

        System.out.println("Stuffing data: " + stuffedData);
        System.out.println("DeStuffing data: " + deStuffedData);
    }
}
