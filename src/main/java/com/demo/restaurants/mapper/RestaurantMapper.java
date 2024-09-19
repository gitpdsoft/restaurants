package com.demo.restaurants.mapper;

import com.demo.restaurants.dto.RestaurantDto;
import com.demo.restaurants.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
