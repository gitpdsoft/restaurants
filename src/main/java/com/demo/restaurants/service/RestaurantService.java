package com.demo.restaurants.service;

import com.demo.restaurants.dto.RestaurantDto;
import com.demo.restaurants.entity.Restaurant;
import com.demo.restaurants.mapper.RestaurantMapper;
import com.demo.restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repository;

    public List<RestaurantDto> findAll() {
        return repository.findAll().stream().map(
                RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto
        ).collect(Collectors.toList());
    }

    public RestaurantDto save(RestaurantDto restaurantDto) {
        Restaurant restaurant = repository.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);
    }

    public Optional<RestaurantDto> findById(Integer id) {
        Optional<Restaurant> restaurant = repository.findById(id);
        return Optional.ofNullable(restaurant.map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).orElse(null));
    }
}
