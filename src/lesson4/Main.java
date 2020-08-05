package lesson4;

/**
 * Homework for lesson #4
 *
 * @author Valeriy Lazarev
 * @since 2020-08-01
 */


public class Main {


    /* √ 5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;*/
    public static Person[] arrPerson = {new Person("Пал Палыч", 25000.00f, 63),
            new Person("Володарыч", 20000.00f, 50),
            new Person("Сан Саныч", 20000.00f, 60),
            new Person("Алисей Алисеич", 30000.00f, 64),
            new Person("Петр", 55000.00f, 18),
    };

    public static void main(String[] args) {

        /* √ 6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.*/
        float rise = 5000.00f;
        salaryUp(rise);

        /* √ 4. Вывести при помощи методов из пункта 3 ФИО и возраст.*/
        printPerson();

        /* √ 7. * Подсчитать средние арифметические зарплаты и возраста*/
        System.out.printf("Средняя зарплата по больнице: %,.2f руб.\n", averageSalary(arrPerson));
        System.out.println("Средний возраст по больнице: " + averageAge(arrPerson));


    }

    /**
     *  * Метод считает среднюю арифмитическую зарплату;
     *
     * @param arrPerson - Массив, для которого считается среднее арифметическое значение;
     * @return -  Возвращает целочисленную переменную равную средней зарплате всех сотрудников содержашихся в массиве
     */
    private static int averageAge(Person[] arrPerson) {
        int result = 0;
        for (Person person : arrPerson) {
            result += person.getAge();
        }
        return  result/arrPerson.length;
    }

    /**
     *  * Метод считает среднюю арифмитический возраст;
     *
     * @param arrPerson - Массив, для которого считается среднее арифметическое значение;
     * @return -  Возвращает целочисленную переменную равную среднему возрасту всех сотрудников содержашихся в массиве
     */
    private static float averageSalary(Person[] arrPerson) {
        float result = 0;
        for (Person person : arrPerson) {
            result += person.getSalary();
        }
        return  result/arrPerson.length;

    }

    /**
     * Метод, который повышает зарплату всем сотрудникам старше 45 лет на переданное значение
     * @param rise - переменная с плавающей точкой на значение которой метод увеличивает заработную плату работника.
     */
    private static void salaryUp(float rise) {
        for (Person person : arrPerson) {
            if (person.getAge() >= 45) {
                person.setSalary(person.getSalary() + rise);
            }
        }
    }

    /**
     * Метод выводит в консоль данные о сотрудниках.
     */
    private static void printPerson() {
        for (Person person : arrPerson) {
            System.out.printf("ID: %d, Сотрудник: %s, Зарплата: %,.2f руб., Возраст: %d лет, \n",
                    person.getId(), person.getName(), person.getSalary(), person.getAge());
        }
    }


}
