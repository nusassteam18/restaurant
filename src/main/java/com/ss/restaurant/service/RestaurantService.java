package com.ss.restaurant.service;

import com.ss.restaurant.dto.RestaurantDTO;
import com.ss.restaurant.entity.Restaurant;
import com.ss.restaurant.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    Logger log = LoggerFactory.getLogger(RestaurantService.class);

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Autowired
    public RestTemplate restTemplate;

    @Value("${users.url:http://www.google.com}")
    private String USERS_URL;

    public List<RestaurantDTO> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        ArrayList<RestaurantDTO> result = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            result.add(new RestaurantDTO(restaurant.getRestaurantId(), restaurant.getName(), restaurant.getDescription(), restaurant.getAddress(), restaurant.getContact(), restaurant.getImageId()));
        }
        return result;
    }

    public RestaurantDTO getRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            return new RestaurantDTO(restaurant.getRestaurantId(), restaurant.getName(), restaurant.getDescription(), restaurant.getAddress(), restaurant.getContact(), restaurant.getImageId());
        }
        return null;
    }


}
