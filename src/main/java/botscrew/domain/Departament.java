package botscrew.domain;

import java.util.Objects;

public class Departament {
    private Integer id;

    private String name;

    private String head;

    private int un_id;


    public Departament(Integer id, String name, String head, int un_id) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.un_id = un_id;
    }

    public Departament() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHead() {
        return head;
    }

    public int getUn_id() {
        return un_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departament that = (Departament) o;
        return un_id == that.un_id && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, head, un_id);
    }

    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", head='" + head + '\'' +
                ", un_id=" + un_id +
                '}';
    }
}
