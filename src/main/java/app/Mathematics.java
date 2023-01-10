package app;

import java.util.Random;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Mathematics {
    enum Ops {
        ADD("+", Integer::sum),
        SUB("-", (a, b) -> a - b),
        MUL("*", (a, b) -> a * b),
//        DIV("/", (a, b) -> a / b), TODO остаток от деления
        ;

        private final String op;
        private final IntBinaryOperator operator;

        Ops(String op, IntBinaryOperator operator) {
            this.op = op;
            this.operator = operator;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        Ops[] ops = Ops.values();

        int rightAnswers = 0;
        int attempts = 20;

        for (int i = 1; i <= attempts; i++) {
            Ops action = ops[random.nextInt(ops.length)];

            int first = random.nextInt(100);
            int second = random.nextInt(100);

            if (action == Ops.SUB && first < second) {
                int temp = first;
                first = second;
                second = temp;
            }

            int result = action.operator.applyAsInt(first, second);

            System.out.printf("%d. %d%s%d= ", i, first, action.op, second);
            int answer = Integer.parseInt(sc.nextLine());

            if (result == answer) {
                System.out.println("Верно!");
                rightAnswers++;
            } else {
                System.out.println("Неверно! Правильный ответ: " + result);
            }
        }
        System.out.printf("Правильных ответов %d из %d", rightAnswers, attempts);
    }
}
