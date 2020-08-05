package lesson4;


/* √ 1. Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст;*/
/**
 * Класс "Person" - содержит информацию о сотруднниках.
 */
public class Person {

    private static int personID;
    private String name;
    private float salary;
    private int age;
    private int id;

    /* √ 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;*/
    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /* √ 2. Конструктор класса должен заполнять эти поля при создании объекта;*/
    public Person(String name, float salary, int age) {
         /* √ 8. *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
         присваивался личный уникальный идентификационный порядковый номер*/
        personID++;
        this.name = name;
        this.salary = salary;
        this.age = age;
        setId(personID);
    }
}
