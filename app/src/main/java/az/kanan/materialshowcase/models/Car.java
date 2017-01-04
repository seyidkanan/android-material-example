package az.kanan.materialshowcase.models;


/**
 * Created by Kanan on 12/31/2016.
 */

public class Car {

    private String brand;
    private String model;
    private String imageUrl;

    public Car() {
    }

    public Car(String brand, String model, String imageUrl) {
        this.brand = brand;
        this.model = model;
        this.imageUrl = imageUrl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
