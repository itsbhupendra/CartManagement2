package com.example.assignment2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productItems")
public class ProductItems {

    @Id
    private Long productId;
    private String productName;
    private String productType;
    private Integer productPrice;
    private Integer productQuantity;
    @ManyToOne
    @JoinColumn(name="cart_id")
    @JsonIgnore
    private Cart cart;

    public ProductItems(Long productId, String productName, String productType, Integer productPrice, Integer productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }
}
