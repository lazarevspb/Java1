package lesson4;

/**
 * Homework for lesson #4
 *
 * @author Valeriy Lazarev
 * @since 2020-08-08
 */

public class Main {

    /* √ 5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;*/
    public static Employee[] arrEmployees = {
            new Employee("Пал Палыч", 25000.00f, 1957),
            new Employee("Володарыч", 20000.00f, 1970),
            new Employee("Сан Саныч", 20000.00f, 1960),
            new Employee("Алисей Алисеич", 30000.00f, 1956),
            new Employee("Петр", 55000.00f, 2002),
    };

    public static void main(String[] args) {
        /* √ 6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.*/
        float rise = 5000.00f;
        salaryUp(rise, 45);

        /* √ 4. Вывести при помощи методов из пункта 3 ФИО и возраст.*/
        printPerson();

        /* √ 7. * Подсчитать средние арифметические зарплаты и возраста*/
        System.out.printf("Средняя зарплата по больнице: %,.2f руб.\n", averageSalary(arrEmployees));
        System.out.println("Средний возраст по больнице: " + averageAge(arrEmployees) + ". ");
    }

    /**
     * * Метод считает среднюю арифмитическую зарплату;
     *
     * @param arrEmployees - Массив, для которого считается среднее арифметическое значение;
     * @return -  Возвращает целочисленную переменную равную средней зарплате всех сотрудников содержашихся в массиве
     */
    private static int averageAge(Employee[] arrEmployees) {
        int result = 0;
        for (Employee employee : arrEmployees) {
            result += employee.getAge();
        }
        return result / arrEmployees.length;
    }

    /**
     * * Метод считает среднюю арифмитический возраст;
     *
     * @param arrEmployees - Массив, для которого считается среднее арифметическое значение;
     * @return -  Возвращает целочисленную переменную равную среднему возрасту всех сотрудников содержашихся в массиве
     */
    private static float averageSalary(Employee[] arrEmployees) {
        float result = 0;
        for (Employee employee : arrEmployees) {
            result += employee.getSalary();
        }
        return result / arrEmployees.length;
    }

    /**
     *   * Метод, который повышает зарплату всем сотрудникам старше 45 лет на переданное значение
     *
     *  @param rise - переменная с плавающей точкой на значение которой метод увеличивает заработную плату работника.
     * @param age - целочисленная переменаая - возраст сотрудника.
     */
    private static void salaryUp(float rise, int age) {
        for (Employee employee : arrEmployees) {
            if (employee.getAge() >= age) {
                employee.setSalary(employee.getSalary() + rise);
            }
        }
    }

    /**
     * Метод выводит в консоль данные о сотрудниках.
     */
    private static void printPerson() {
        for (Employee employee : arrEmployees) {
            System.out.println(employee.getFullInfo());
        }
    }


}
/*

Вывод:
        ID: 1, Сотрудник: Пал Палыч, Зарплата: 30 000,00 руб., Возраст: 63 лет,
        ID: 2, Сотрудник: Володарыч, Зарплата: 25 000,00 руб., Возраст: 50 лет,
        ID: 3, Сотрудник: Сан Саныч, Зарплата: 25 000,00 руб., Возраст: 60 лет,
        ID: 4, Сотрудник: Алисей Алисеич, Зарплата: 35 000,00 руб., Возраст: 64 лет,
        ID: 5, Сотрудник: Петр, Зарплата: 55 000,00 руб., Возраст: 18 лет,
        Средняя зарплата по больнице: 34 000,00 руб.
        Средний возраст по больнице: 51.
* */