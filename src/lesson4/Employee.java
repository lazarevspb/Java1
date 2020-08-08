package lesson4;

/* √ 1. Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст;*/
import java.util.Formatter;

/**
 * Класс "Person" - содержит информацию о сотруднниках.
 */
public class Employee {
    private static final int CURRENT_YEAR = 2020;
    private static int employeeID;
    private String name;
    private float salary;
    private int birthYear;
    private int uid;
    Formatter f = new Formatter();

    /* √ 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;*/
    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    public int getUid() {
        return uid;
    }

    Formatter getFullInfo(){
        f.format("ID: %d, Сотрудник: %s, Зарплата: %,.2f руб., Возраст: %d лет,",
                this.getUid(), this.getName(), this.getSalary(), this.getAge());
        return  f;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    private void setUid(int uid) {
        this.uid = uid;
    }

    /* √ 2. Конструктор класса должен заполнять эти поля при создании объекта;*/
    public Employee(String name, float salary, int birthYear) {
         /* √ 8. *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
         присваивался личный уникальный идентификационный порядковый номер*/
        employeeID++;
        this.name = name;
        this.salary = salary;
        this.birthYear = birthYear;
        setUid(employeeID);
    }
}
