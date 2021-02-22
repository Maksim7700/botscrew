package botscrew.domain;

import java.util.Objects;

public class Degree {
    private Integer id;

    private String name;

    public Degree(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Degree() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Degree degree = (Degree) o;
        return Objects.equals(id, degree.id) && Objects.equals(name, degree.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Degree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
