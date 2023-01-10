package app;

public class Testing {
    void a() {

    }

    static double sum(double d) {
        return d + 5;
    }


    public static void main(String[] args) {
        int a = sub(10, 5);
        System.out.println(a);
    }

    static int sub(int a, int b) {
        return a - b;
    }

 //   static String programmer() {
//        System.out.println("Введите, пожалуйста, Ваше имя:");
//        String name = scanner.nextLine();
//        System.out.println("Добро пожаловать, " + name);
//        System.out.println("Введите, пожалуйста, Вашу дату рождения:");
//        String birthdate = scanner.nextLine();
//        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate date = LocalDate.parse(birthdate, dateformat);
//        LocalDate now = LocalDate.now();
//        Period diff = Period.between(date, now);
//        int years = diff.getYears();
//        if (years % 10 == 1) {
//            System.out.println(name + YOU + " " + years + name + " год");
//        } else if (years % 100 > 4 && years % 100 < 21) {
//            System.out.println(name + YOU + " " + years + " лет");
//        } else if (years % 10 > 1 && years % 10 < 5) {
//            System.out.println(name + YOU + " " + years + " года");
//        } else {
//            System.out.println(name + YOU + " " + years + " лет");
//        }
//        return name;
//    }
}

