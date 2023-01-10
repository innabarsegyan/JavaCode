package app;

// 0 1 1 2 3 5 8 13
public class Test {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int c) {

        if (c == 0) {
            return 0;
        } else if (c == 1) {
            return 1;
        } else {
            int result = fib(c - 1) + fib(c - 2);
            return result;
        }
    }
}