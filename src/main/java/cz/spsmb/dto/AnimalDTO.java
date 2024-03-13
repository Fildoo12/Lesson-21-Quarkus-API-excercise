package cz.spsmb.dto;

public class AnimalDTO {
    long id;
    String name;
    String Kind;
    String Breed;
    int BornDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public int getBornDate() {
        return BornDate;
    }


    @Override
    public String toString() {
        return "AnimalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Kind='" + Kind + '\'' +
                ", Breed='" + Breed + '\'' +
                ", BornDate=" + BornDate +
                '}';
    }

    public int setBornDate() {
        return this.BornDate;
    }

    public String setKind() {
        return this.Kind;
    }

    public String setBreed() {
        return this.Breed;
    }

    public String setName() {
        return this.name;
    }
}
