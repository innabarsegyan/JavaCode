package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TestBowl {
    public static void main(String[] args) {
        bowlsList();
        //       bowlStack();
    }

    public static void bowlsList() {

        List<Bowl> bowls = new ArrayList<>();

        bowls.add(new Bowl("Ikea", Bowl.Size.S));
        bowls.add(new Bowl("Leroy Merlen", Bowl.Size.M));
        bowls.add(new Bowl("Hoff", Bowl.Size.L));
        bowls.add(new Bowl("Ikea", Bowl.Size.L));
        bowls.add(new Bowl("Hoff", Bowl.Size.S));
        bowls.add(new Bowl("Hoff", Bowl.Size.L));
        bowls.add(new Bowl("Leroy Merlen", Bowl.Size.S));
        bowls.add(new Bowl("Hoff", Bowl.Size.L));

        List<Bowl> smallBowls = bowls
                .stream()
                .filter(bowl -> bowl.getSize() == Bowl.Size.S)
                .collect(Collectors.toList());
        System.out.println(smallBowls);

        List<Bowl> bigBowls = bowls
                .stream()
                .filter(bowl -> bowl.getSize() == Bowl.Size.M || bowl.getSize() == Bowl.Size.L)
                .collect(Collectors.toList());
        System.out.println(bigBowls);

        List<String> makers = bowls
                .stream()
                .map(Bowl::getMaker)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(makers);

        //добавить элементы, выбрать все элеменеты размером м и л, отдельный вывод для маленьких
    }

    public static void bowlStack() {
        Stack<Bowl> bowls = new Stack<>();
        bowls.push(new Bowl("Ikea", Bowl.Size.S));
        bowls.push(new Bowl("Leroy Merlen", Bowl.Size.M));
        bowls.push(new Bowl("Hoff", Bowl.Size.L));

        Bowl bowl = bowls.get(2);
        Bowl bowl1 = bowls.get(1);

        System.out.println(bowl);
        System.out.println(bowl1);

        bowls.pop();
        System.out.println(bowls);
    }
}
