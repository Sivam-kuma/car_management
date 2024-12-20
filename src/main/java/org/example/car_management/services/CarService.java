package org.example.car_management.services;


import org.example.car_management.entity.Car;
import org.example.car_management.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Page<Car> getAllCars(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return carRepository.findAll(pageable);
        }
        return carRepository.findByCarNameContainingOrModelContainingOrYearContainingOrColorContainingOrFuelTypeContaining(
                search, search, search, search, search, pageable);
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car updatedCar) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found"));
        car.setCarName(updatedCar.getCarName());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());
        car.setPrice(updatedCar.getPrice());
        car.setColor(updatedCar.getColor());
        car.setFuelType(updatedCar.getFuelType());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}