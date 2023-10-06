package com.tpe.controller;

import com.tpe.dto.CarDTO;
import com.tpe.dto.CarRequest;
import com.tpe.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    // Not: save() *****************************
    @PostMapping  // http://localhost:8085/car  --> localhost:8082/car
    public ResponseEntity<Map<String, String>> saveCar(@RequestBody CarRequest carRequest){

        carService.saveCar(carRequest);

        Map<String, String> map = new HashMap<>();
        map.put("message", "Car Successfully Saved");
        map.put("success", "true");
        return new ResponseEntity<>(map, HttpStatus.CREATED);

    }

    // Not: getAllCars() ******************************
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars(){
        List<CarDTO> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }


}
