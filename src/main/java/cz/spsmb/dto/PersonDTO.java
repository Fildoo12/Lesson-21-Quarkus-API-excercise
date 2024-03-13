package cz.spsmb.dto;

public class PersonDTO {
    long id;
    String name;
    int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }
    public String getName() {
        return name;

    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public int setAge() {
        return age;
    }
}
