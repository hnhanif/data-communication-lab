package com.datacommunication;

import java.util.Scanner;

public class BitStuffDeStuff {
    public static String bitStuffing(String bits) {
        StringBuilder stuffedBits = new StringBuilder();
        int consecutiveOnes = 0;

        for (char bit : bits.toCharArray()) {
            stuffedBits.append(bit);

            if (bit == '1')
                consecutiveOnes++;
            else
                consecutiveOnes = 0;

            if (consecutiveOnes == 5) {
                stuffedBits.append("0");
                consecutiveOnes = 0;
            }

        }

        return stuffedBits.toString();
    }

    public static String bitDeStuffing(String bits) {
        StringBuilder deStuffedBits = new StringBuilder();
        int consecutiveOnes = 0;

        for (char bit : bits.toCharArray()) {
            deStuffedBits.append(bit);

            if (bit == '1')
                consecutiveOnes++;

            else if (consecutiveOnes == 5 && bit == '0') {
                deStuffedBits.deleteCharAt(deStuffedBits.length() - 1);
                consecutiveOnes = 0;
            } else
                consecutiveOnes = 0;


        }

        return deStuffedBits.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter binary bits: ");
        String bits = scanner.next();

        System.out.print("Would you like to change the transmitted bit stream before de-stuffing (Y/N): ");
        String choice = scanner.next().toLowerCase();

        if (choice.equals("y")) {
            System.out.print("Enter modified version of bits: ");
            bits = scanner.next();
        } else
            System.out.println("well, stuffing with original bits.");

        String stuffedData = bitStuffing(bits);
        String deStuffedData = bitDeStuffing(stuffedData);


        System.out.println("Stuffed Bits: " + stuffedData);

        System.out.println("De-stuffed Bits: " + deStuffedData);
    }


}
