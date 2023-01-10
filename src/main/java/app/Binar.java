package app;

import java.util.Scanner;

public class Binar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int random = 1 + (int) (Math.random() * (100 - 0));
        int numb;
        int attempts = 0;
        do {
            System.out.println("Введите число:");
            String number = scanner.nextLine();
            numb = Integer.parseInt(number);

            if (numb < random) {
                System.out.println("Ваше число меньше загаданного, попробуйте еще!");
                attempts++;
            } else if (numb > random) {
                System.out.println("Ваше число больше загаданного, попробуйте еще!");
                attempts++;
            } else {
                System.out.println("Вы угадали с " + ++attempts + " попытки!");
            }
        } while (numb != random);
    }
}