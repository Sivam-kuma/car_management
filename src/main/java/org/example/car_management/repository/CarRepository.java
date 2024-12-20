package org.example.car_management.repository;


import org.example.car_management.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findByCarNameContainingOrModelContainingOrYearContainingOrColorContainingOrFuelTypeContaining(
            String carName, String model, String year, String color, String fuelType, Pageable pageable);

}

