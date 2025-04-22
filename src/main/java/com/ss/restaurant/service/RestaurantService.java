package com.ss.restaurant.service;

import com.ss.restaurant.entity.Restaurant;
import com.ss.restaurant.repository.ProductRepository;
import com.ss.restaurant.repository.RestaurantRepository;
import com.ss.restaurant.responseDTO.ProductTruncatedDTO;
import com.ss.restaurant.responseDTO.RestaurantProductsTruncatedDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    Logger log =  LoggerFactory.getLogger(RestaurantService.class);

    private final RestaurantRepository restaurantRepository;

    private final ProductRepository productRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, ProductRepository productRepository) {
        this.restaurantRepository = restaurantRepository;
        this.productRepository = productRepository;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);

        return restaurantOptional.orElse(null);
    }

    public RestaurantProductsTruncatedDTO getRestaurantProductsTruncatedDTO(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        List<ProductTruncatedDTO> productTruncatedDTOS = productRepository.findProductsTruncatedByRestaurantId(restaurantId);

        RestaurantProductsTruncatedDTO rptDTO = new RestaurantProductsTruncatedDTO();

        if (restaurant != null) {
            rptDTO.setRestaurantId(restaurant.getRestaurantId());
            rptDTO.setName(restaurant.getName());
        }

        if (productTruncatedDTOS != null) {
            rptDTO.setProductTruncatedDTOS(productTruncatedDTOS);
        }
        return rptDTO;
    }
}
