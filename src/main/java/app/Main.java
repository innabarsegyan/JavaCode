package app;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final HashMap<Long, Person> persons = new HashMap<>();
    private static int count = 0;

    public static void main(String[] args) {
        Person testPerson = new Person(-1, "Test", 19);
        persons.put(-1L, testPerson);

        boolean toBeContinued = true;

        while (toBeContinued) {
            System.out.println(
                    "1: Создать пользователя\n" +
                            "2: Показать всех пользователей\n" +
                            "3: Отредактировать пользователя\n" +
                            "4: Удалить пользователя\n" +
                            "Для выхода из меню нажмите \"0\"");
            String number = scanner.nextLine();
            int numb = Integer.parseInt(number);
            switch (numb) {
                case 1:
                    savePerson();
                    break;
                case 2:
                    displayPersons();
                    break;
                case 3:
                    editPerson();
                    break;
                case 4:
                    removePerson();
                    break;
                case 0:
                    toBeContinued = false;
                    break;
                default:
                    System.out.println("Введите корректную цифру");
            }
        }
    }

    private static void savePerson() {
        Person savedPerson = createPerson(null);
        persons.put(savedPerson.getId(), savedPerson);
    }

    public static void displayPersons() {
        if (persons.isEmpty()) {
            System.out.println("Пользователей не найдено");
        }
        for (Map.Entry<Long, Person> entry : persons.entrySet()) {
            Person person = entry.getValue();
            System.out.printf("id пользователя: %d. Имя пользователя: %s. Возраст пользователя: %d.%n", person.getId(), person.getName(), person.getAge());
        }
    }

    private static void editPerson() {
        System.out.println("Введите id пользователя:");
        String editing = scanner.nextLine();
        Long id = Long.parseLong(editing);
        Person person = persons.get(id);
        System.out.printf("%d %s %d%n", person.getId(), person.getName(), person.getAge());
        System.out.println("Введите измененные данные:");
        Person editPerson = createPerson(person);
        persons.put(id, editPerson);
        System.out.println("Данные успешно сохранены.");
    }

    private static void removePerson() {
        System.out.println("Введите id пользователя");
        String idString = scanner.nextLine();
        long id = Long.parseLong(idString);
        Person person = persons.remove(id);
        System.out.printf("%s %s %s %d %s%n", "Удаление персоны по имени - ", person.getName(), "и возрасту - ", person.getAge(), "прошло успешно.");
    }

    static Person createPerson(Person editPerson) {
        System.out.println("Введите, пожалуйста, Ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Добро пожаловать, " + name);
        int age = 0;
        boolean getAge = true;
        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Введите, пожалуйста, Вашу дату рождения:");
            String birthdate = scanner.nextLine();
            try {
                DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate date = LocalDate.parse(birthdate, dateformat);
                LocalDate now = LocalDate.now();
                Period diff = Period.between(date, now);
                age = diff.getYears();
                getAge = false;
            } catch (DateTimeParseException e) {
                System.out.println("Введите дату в корректном формате: 31.01.2001");
                attempts++;
            }
        }

        if (editPerson == null) {
            return new Person(count++, name, age);
        }
        editPerson.setName(name);
        editPerson.setAge(age);
        return editPerson;
    }
}




