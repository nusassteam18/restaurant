package com.ss.restaurant.controller;

import com.ss.restaurant.dto.RestaurantDTO;
import com.ss.restaurant.entity.Restaurant;
import com.ss.restaurant.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/restaurants")
public class RestaurantController {

    Logger log =  LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getRestaurants() {

        List<RestaurantDTO> restaurants = restaurantService.getRestaurants();

        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable Long restaurantId) {

        RestaurantDTO restaurant = restaurantService.getRestaurant(restaurantId);

        if (restaurant != null)
            return ResponseEntity.ok(restaurant);

        return ResponseEntity.notFound().build();
    }
}
