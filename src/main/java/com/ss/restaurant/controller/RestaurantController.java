package com.ss.restaurant.controller;

import com.ss.restaurant.entity.Restaurant;
import com.ss.restaurant.responseDTO.RestaurantProductsTruncatedDTO;
import com.ss.restaurant.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Restaurant>> getRestaurants() {

        List<Restaurant> restaurants = restaurantService.getRestaurants();

        if (restaurants != null)
            return ResponseEntity.ok(restaurants);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long restaurantId) {

        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);

        if (restaurant != null)
            return ResponseEntity.ok(restaurant);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{restaurantId}/restaurantName")
    public ResponseEntity<String> getRestaurantName(@PathVariable Long restaurantId) {

        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);

        if (restaurant != null)
            return ResponseEntity.ok(restaurant.getName());

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{restaurantId}/productsTruncated")
    public ResponseEntity<RestaurantProductsTruncatedDTO> getRestaurantProductsTruncated(@PathVariable Long restaurantId) {

        RestaurantProductsTruncatedDTO rptDTO = restaurantService.getRestaurantProductsTruncatedDTO(restaurantId);

        return ResponseEntity.ok(rptDTO);
    }
}
