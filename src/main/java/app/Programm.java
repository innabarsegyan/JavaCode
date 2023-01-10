package app;

import java.util.Scanner;

public class Programm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите нижний диапазон:");
        String userStart = scanner.nextLine();
        int start = Integer.parseInt(userStart);
        System.out.println("Введите верхний диапазон:");
        String userEnd = scanner.nextLine();
        int end = Integer.parseInt(userEnd);

        int attempts = 0;

        do {
            int result = (end - start) / 2 + start;
            System.out.println(result);
            int userAnswer = Integer.parseInt(scanner.nextLine());
            if (userAnswer == 1) {
                end = result;
                attempts++;
            } else if (userAnswer == 2) {
                start = result;
                attempts++;
            } else {
                System.out.printf ("Я угадал с %d попытки.", ++attempts);
                break;
            }
        } while (true);
    }
}

