package app;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {0, 1, 1, 1, 0}, {1, 1, 0, 0, 0}};
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Введите координаты");
            String num = scanner.nextLine();
            String[] exampleArr = num.split(" ");
            String rowS = exampleArr[0];
            String columnS = exampleArr[1];
            int row = Integer.parseInt(rowS);
            int column = Integer.parseInt(columnS);
            int element = arr[row][column];
            if (element == 1) {
                System.out.println("Попадание");
                attempts++;
            } else System.out.println("Не попал");
        }
    }
}
