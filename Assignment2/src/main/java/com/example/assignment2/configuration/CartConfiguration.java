package com.example.assignment2.configuration;

import com.example.assignment2.model.Cart;
import com.example.assignment2.model.Product;
import com.example.assignment2.model.ProductItems;
import com.example.assignment2.repository.CartRepository;
import com.example.assignment2.repository.ProductItemsRepository;
import com.example.assignment2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CartConfiguration {

    private final ProductRepository productRepository;
    private final ProductItemsRepository productItemsRepository;

    @Autowired
    public CartConfiguration(ProductRepository productRepository, ProductItemsRepository productItemsRepository) {
        this.productRepository = productRepository;
        this.productItemsRepository = productItemsRepository;
    }

    @Bean
    CommandLineRunner commandLineRunnerThird(CartRepository cartRepository){
        return args -> {
            Cart cart=new Cart();
            cart.setCartId(1L);
            List<ProductItems> productList=new ArrayList<>();
            Product product=new Product(1L,"laptop","electronics",200);
            productRepository.save(product);
            ProductItems productItems=new ProductItems(1L,"laptop","Electronics",200,1);
            productItemsRepository.save(productItems);
            productList.add(productItems);
            cart.setProductList(productList);
//            Customers customer1=new Customers(1L,"Bhupendra Singh",null);
            cartRepository.saveAll(
                    List.of(cart)
            );
        };
    }
}
