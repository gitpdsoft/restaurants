package com.demo.restaurants.controller;

import com.demo.restaurants.dto.RestaurantDto;
import com.demo.restaurants.mapper.RestaurantMapper;
import com.demo.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService service;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> find() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> add(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto restaurant = service.save(restaurantDto);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<RestaurantDto> findById(@PathVariable Integer id) {
        Optional<RestaurantDto> restaurantDto = service.findById(id);
        return restaurantDto.map(
                dto -> new ResponseEntity<>(dto, HttpStatus.OK)
                ).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
