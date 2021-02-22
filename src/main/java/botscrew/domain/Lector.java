package botscrew.domain;

import java.util.Objects;

public class Lector {

    private Integer id;

    private String name;

    private int age;

    private int salary;

    private int dep_id;

    private int un_id;

    private int deg_id;

    public Lector(Integer id, String name, int age, int salary, int dep_id, int un_id, int deg_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dep_id = dep_id;
        this.un_id = un_id;
        this.deg_id = deg_id;
    }

    public Lector() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public int getUn_id() {
        return un_id;
    }

    public void setUn_id(int un_id) {
        this.un_id = un_id;
    }

    public int getDeg_id() {
        return deg_id;
    }

    public void setDeg_id(int deg_id) {
        this.deg_id = deg_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return age == lector.age && salary == lector.salary && dep_id == lector.dep_id && un_id == lector.un_id && deg_id == lector.deg_id && Objects.equals(id, lector.id) && Objects.equals(name, lector.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary, dep_id, un_id, deg_id);
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dep_id=" + dep_id +
                ", un_id=" + un_id +
                ", deg_id=" + deg_id +
                '}';
    }
}
