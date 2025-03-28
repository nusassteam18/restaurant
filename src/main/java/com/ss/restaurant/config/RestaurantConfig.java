package com.ss.restaurant.config;

import com.ss.restaurant.entity.Product;
import com.ss.restaurant.entity.Rating;
import com.ss.restaurant.entity.Restaurant;
import com.ss.restaurant.repository.RatingRepository;
import com.ss.restaurant.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Configuration
public class RestaurantConfig {

    Logger log =  LoggerFactory.getLogger(RestaurantConfig.class);

    @Bean
    CommandLineRunner commandLineRunner(RestaurantRepository restaurantRepository, RatingRepository ratingRepository) {
        return args -> {
//            prepopulateData(restaurantRepository, ratingRepository);

            findRestaurants(restaurantRepository);
        };
    }

    private void findRestaurants(RestaurantRepository restaurantRepository) {
//        Restaurant restaurant3 = restaurantRepository.findById(3L).orElse(null);
        List<Restaurant> restaurants = restaurantRepository.findAll();

        log.info("Restaurant 1: {}", restaurants.get(0));
//        log.info("Restaurant 1 Products: {}", restaurants.get(0).getProducts());
//        log.info("Restaurant 1 Ratings: {}", restaurants.get(0).getRatings());

        log.info("Restaurant 2: {}", restaurants.get(1));
//        log.info("Restaurant 2 Products: {}", restaurants.get(1).getProducts());
//        log.info("Restaurant 2 Ratings: {}", restaurants.get(1).getRatings());

        log.info("Restaurant 3: {}", restaurants.get(2));
//        log.info("Restaurant 3 Products: {}", restaurants.get(2).getProducts());
//        log.info("Restaurant 3 Ratings: {}", restaurants.get(2).getRatings());
    }

    private void prepopulateData(RestaurantRepository restaurantRepository, RatingRepository ratingRepository) {
        Restaurant restaurant1 = new Restaurant(null, "Pizza Palace", "123 Main Street, New York, NY 10001", "91234567", "Authentic Italian pizzas made with fresh ingredients", "https://images.unsplash.com/photo-1555396273-367ea4eb4db5");
        Restaurant restaurant2 = new Restaurant(null, "Burger Junction", "456 Oak Avenue, Chicago, IL 60007","91234567", "Gourmet burgers and sides for the whole family", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd");
        Restaurant restaurant3 = new Restaurant(null, "Fresh Greens", "789 Willow Boulevard, Los Angeles, CA 90001","91234567", "Healthy salads and vegetarian options", "https://images.unsplash.com/photo-1512621776951-a57141f2eefd");

        Product product1 = new Product(null, "Margherita Pizza", "Classic pizza with tomato sauce, mozzarella, and basil", new BigDecimal("12.99"),"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Pizza_Margherita_stu_spivack.jpg/1200px-Pizza_Margherita_stu_spivack.jpg");
        Product product2 = new Product(null, "Pepperoni Pizza", "Pizza topped with pepperoni slices and cheese", new BigDecimal("14.99"),"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Pepperoni_Pizza_%2829204589095%29.jpg/1920px-Pepperoni_Pizza_%2829204589095%29.jpg");
        Product product3 = new Product(null, "Veggie Burger", "Plant-based patty with lettuce, tomato, and special sauce", new BigDecimal("10.99"),"https://www.realsimple.com/thmb/z3cQCYXTyDQS9ddsqqlTVE8fnpc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/real-simple-mushroom-black-bean-burgers-recipe-0c365277d4294e6db2daa3353d6ff605.jpg");
        Product product4 = new Product(null, "Classic Burger", "Beef patty with cheese, lettuce, tomato, and pickles", new BigDecimal("11.99"),"https://i1.wp.com/coolfooddude.com/wp-content/uploads/2020/08/SFS_Classic_Sirloin_Blend_030-2-scaled.jpg?w=2048&ssl=1");
        Product product5 = new Product(null, "Caesar Salad", "Romaine lettuce, croutons, parmesan cheese with Caesar dressing", new BigDecimal("8.99"),"https://www.grocery.coop/sites/default/files/NCG_Dennis_Becker_Classic_Caesar_Salad_715_x_477.jpg");
        Product product6 = new Product(null, "Greek Salad", "Cucumber, tomato, olives, feta cheese with olive oil dressing", new BigDecimal("9.99"),"https://images.themodernproper.com/production/posts/GreekSalad_9.jpg?w=1200&h=1200&q=60&fm=jpg&fit=crop&dm=1718650734&s=70119bf37604d243d0729db7f4cda445");
        Product product7 = new Product(null, "French Fries", "Crispy golden potato fries with salt", new BigDecimal("4.99"),"https://img.apmcdn.org/4b2716626c9ff3f6e5dfebe520eb592c33cf1e7b/uncropped/941f50-splendid-table-french-fries.jpg");
        Product product8 = new Product(null, "Onion Rings", "Battered and fried onion rings", new BigDecimal("5.99"),"https://assets.afcdn.com/recipe/20170223/27146_w1024h768c1cx2464cy1632.jpg");

        restaurant1.setProducts(Arrays.asList(product1, product2));
        restaurant2.setProducts(Arrays.asList(product3, product4, product7, product8));
        restaurant3.setProducts(Arrays.asList(product5, product6));

        Rating rating1 = new Rating(null, 1L, getRandomScore());
        Rating rating2 = new Rating(null, 2L, getRandomScore());
        Rating rating3 = new Rating(null, 1L, getRandomScore());
        Rating rating4 = new Rating(null, 2L, getRandomScore());
        Rating rating5 = new Rating(null, 1L, getRandomScore());
        Rating rating6 = new Rating(null, 2L, getRandomScore());

        restaurant1.setRatings(Arrays.asList(rating1, rating2));
        restaurant2.setRatings(Arrays.asList(rating3, rating4));
        restaurant3.setRatings(Arrays.asList(rating5, rating6));

        restaurantRepository.saveAll(Arrays.asList(restaurant1, restaurant2, restaurant3));
    }

    private double getRandomScore() {
        Random random = new Random();
        double randomValue = Math.min(5.0,random.nextDouble() * 5.0000001);  // Slightly over 5 to include 5.0
        BigDecimal bd = new BigDecimal(randomValue)
                .setScale(2, RoundingMode.FLOOR);

        return bd.doubleValue();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//      const menuItems = [
//  {
//    id: 1,
//    name: "Margherita Pizza",
//    description: "Classic pizza with tomato sauce, mozzarella, and basil",
//    price: 12.99,
//    restaurantId: 1,
//    image: "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Pizza_Margherita_stu_spivack.jpg/1200px-Pizza_Margherita_stu_spivack.jpg",
//  },
//  {
//    id: 2,
//    name: "Pepperoni Pizza",
//    description: "Pizza topped with pepperoni slices and cheese",
//    price: 14.99,
//    restaurantId: 1,
//    image: "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Pepperoni_Pizza_%2829204589095%29.jpg/1920px-Pepperoni_Pizza_%2829204589095%29.jpg",
//  },
//  {
//    id: 3,
//    name: "Veggie Burger",
//    description: "Plant-based patty with lettuce, tomato, and special sauce",
//    price: 10.99,
//    restaurantId: 2,
//    image: "https://www.realsimple.com/thmb/z3cQCYXTyDQS9ddsqqlTVE8fnpc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/real-simple-mushroom-black-bean-burgers-recipe-0c365277d4294e6db2daa3353d6ff605.jpg",
//  },
//  {
//    id: 4,
//    name: "Classic Burger",
//    description: "Beef patty with cheese, lettuce, tomato, and pickles",
//    price: 11.99,
//    restaurantId: 2,
//    image: "https://i1.wp.com/coolfooddude.com/wp-content/uploads/2020/08/SFS_Classic_Sirloin_Blend_030-2-scaled.jpg?w=2048&ssl=1",
//  },
//  {
//    id: 5,
//    name: "Caesar Salad",
//    description:
//      "Romaine lettuce, croutons, parmesan cheese with Caesar dressing",
//    price: 8.99,
//    restaurantId: 3,
//    image: "https://www.grocery.coop/sites/default/files/NCG_Dennis_Becker_Classic_Caesar_Salad_715_x_477.jpg",
//  },
//  {
//    id: 6,
//    name: "Greek Salad",
//    description:
//      "Cucumber, tomato, olives, feta cheese with olive oil dressing",
//    price: 9.99,
//    restaurantId: 3,
//    image: "https://images.themodernproper.com/production/posts/GreekSalad_9.jpg?w=1200&h=1200&q=60&fm=jpg&fit=crop&dm=1718650734&s=70119bf37604d243d0729db7f4cda445",
//  },
//  {
//    id: 7,
//    name: "French Fries",
//    description: "Crispy golden potato fries with salt",
//    price: 4.99,
//    restaurantId: 2,
//    image: "https://img.apmcdn.org/4b2716626c9ff3f6e5dfebe520eb592c33cf1e7b/uncropped/941f50-splendid-table-french-fries.jpg",
//  },
//  {
//    id: 8,
//    name: "Onion Rings",
//    description: "Battered and fried onion rings",
//    price: 5.99,
//    restaurantId: 2,
//    image: "https://assets.afcdn.com/recipe/20170223/27146_w1024h768c1cx2464cy1632.jpg",
//  },
//];

//    const restaurants = [
//  {
//    id: 1,
//    name: "Pizza Palace",
//    description: "Authentic Italian pizzas made with fresh ingredients",
//    address: "123 Main Street, New York, NY 10001",
//    image: "https://images.unsplash.com/photo-1555396273-367ea4eb4db5",
//    rating: 4.5,
//    rateCount: 120,
//  },
//  {
//    id: 2,
//    name: "Burger Junction",
//    description: "Gourmet burgers and sides for the whole family",
//    address: "456 Oak Avenue, Chicago, IL 60007",
//    image: "https://images.unsplash.com/photo-1568901346375-23c9450c58cd",
//    rating: 4.2,
//    rateCount: 105,
//  },
//  {
//    id: 3,
//    name: "Fresh Greens",
//    description: "Healthy salads and vegetarian options",
//    address: "789 Willow Boulevard, Los Angeles, CA 90001",
//    image: "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
//    rating: 5.0,
//    rateCount: 60,
//  },
//];
}
