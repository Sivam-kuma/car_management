//package org.example.car_management.controller;
//
//import org.example.car_management.entity.Car;
//import org.example.car_management.services.CarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/cars")
//public class CarController {
//
//    @Autowired
//    private CarService carService;
//
//    @GetMapping("/search")
//    public ResponseEntity<Page<Car>> searchCars(
//            @RequestParam(value = "query", required = false) String query,
//            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
//        Page<Car> cars = carService.getAllCars(query, pageable);
//        return ResponseEntity.ok(cars);
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
//        Optional<Car> car = carService.getCarById(id);
//        return car.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Car createCar(@Validated @RequestBody Car car) {
//        return carService.saveCar(car);
//    }
//
//    @PutMapping("/{id}")
//    public Car updateCar(@PathVariable Long id, @Validated @RequestBody Car car) {
//        return carService.updateCar(id, car);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
//        carService.deleteCar(id);
//        return ResponseEntity.noContent().build();
//    }
//}
///
package org.example.car_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.car_management.entity.Car;
import org.example.car_management.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@Tag(name = "Car Management", description = "API for managing car information")
public class CarController {

    @Autowired
    private CarService carService;

   @Operation(summary = "Search cars",
           description = "Retrieve a paginated list of cars based on a search query. Supports filtering by car name, model, year, color, and fuel type.")
    @GetMapping("/search")
    public ResponseEntity<Page<Car>> searchCars(
            @RequestParam(value = "query", required = false) String query,
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        Page<Car> cars = carService.getAllCars(query, pageable);
        return ResponseEntity.ok(cars);
    }

   @Operation(summary = "Get car by ID",
            description = "Retrieve a specific car's details using its unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

   @Operation(summary = "Create a new car",
            description = "Add a new car with all required details like name, model, year, color, and fuel type.")
    @PostMapping
    public Car createCar(@Validated @RequestBody Car car) {
        return carService.saveCar(car);
    }

   @Operation(summary = "Update car details",
           description = "Update the details of an existing car by providing its ID and new data.")
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @Validated @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

  @Operation(summary = "Delete a car",
           description = "Delete a specific car using its unique ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
