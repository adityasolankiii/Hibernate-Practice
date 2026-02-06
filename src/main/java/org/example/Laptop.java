package org.example;

import jakarta.persistence.*;
import jakarta.persistence.Embeddable;

import java.util.List;

//@Embeddable
@Entity
public class Laptop {

    @Id
    private int lId;
    private String brand;
    private String model;
    private int ram;

//    @ManyToOne
//    private Developers developers;

    @ManyToMany
    private List<Developers> developers;

//    public Developers getDevelopers() {
//        return developers;
//    }
//
//    public void setDevelopers(Developers developers) {
//        this.developers = developers;
//    }


    public List<Developers> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developers> developers) {
        this.developers = developers;
    }

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", developers=" + developers +
                '}';
    }
}
