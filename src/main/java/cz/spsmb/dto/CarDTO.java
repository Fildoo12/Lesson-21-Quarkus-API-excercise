package cz.spsmb.dto;

public class CarDTO {
    long id;
    String brand;
    int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }


    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public String setBrand() {
        return this.brand = brand;
    }

    public int setPrice() {
        return this.price = price;
    }
}
