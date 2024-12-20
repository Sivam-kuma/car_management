package org.example.car_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car name cannot be blank")
    private String carName;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @NotBlank(message = "Year cannot be blank")
    private String year;

    @NotNull(message = "Price cannot be null")
    private Long price;

    @NotBlank(message = "Color cannot be blank")
    private String color;

    @NotBlank(message = "Fuel type cannot be blank")
    private String fuelType;

    // Getters and Setters
    // (Omitted for brevity; use Lombok if preferred)

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public @NotBlank(message = "Car name cannot be blank") String getCarName() {
        return carName;
    }

    public @NotBlank(message = "Model cannot be blank") String getModel() {
        return model;
    }

    public @NotBlank(message = "Year cannot be blank") String getYear() {
        return year;
    }

    public @NotNull(message = "Price cannot be null") Long getPrice() {
        return price;
    }

    public @NotBlank(message = "Color cannot be blank") String getColor() {
        return color;
    }

    public @NotBlank(message = "Fuel type cannot be blank") String getFuelType() {
        return fuelType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarName(@NotBlank(message = "Car name cannot be blank") String carName) {
        this.carName = carName;
    }

    public void setModel(@NotBlank(message = "Model cannot be blank") String model) {
        this.model = model;
    }

    public void setYear(@NotBlank(message = "Year cannot be blank") String year) {
        this.year = year;
    }

    public void setPrice(@NotNull(message = "Price cannot be null") Long price) {
        this.price = price;
    }

    public void setColor(@NotBlank(message = "Color cannot be blank") String color) {
        this.color = color;
    }

    public void setFuelType(@NotBlank(message = "Fuel type cannot be blank") String fuelType) {
        this.fuelType = fuelType;
    }
}
