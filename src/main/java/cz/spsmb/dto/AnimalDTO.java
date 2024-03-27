package cz.spsmb.dto;

import java.util.List;

public class AnimalDTO {
    String name;
    Integer age;
    List<String> category;
    String majitel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getMajitel() {
        return majitel;
    }

    public void setMajitel(String majitel) {
        this.majitel = majitel;
    }

    @Override
    public String toString() {
        return "AnimalDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", category=" + category +
                ", majitel='" + majitel + '\'' +
                '}';
    }
}