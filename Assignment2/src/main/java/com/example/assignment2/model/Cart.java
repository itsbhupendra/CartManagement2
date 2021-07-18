package com.example.assignment2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.util.Pair;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="cart")
public class Cart {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cartId;


   @OneToMany
           (mappedBy = "cart",
            cascade = CascadeType.ALL
           )
   private List<ProductItems> productList;
//   @OneToOne
//   @JoinColumn(name="user_id",nullable = false)
//   @JsonIgnore
//   @NonNull
//   private Customers users;

   //private Pair<Long,Integer> productQuantity;
   public Cart(Long cartId, List<ProductItems> productList) {
      this.cartId = cartId;
      this.productList = productList;
//      this.users = new Customers();
   }

//   public  Cart(Long userId, ArrayList<Product> productList) {
//      this.cartId=userId;
//      this.productList=productList;
//   }

   public Long getCartId() {
      return cartId;
   }

      public List<ProductItems> getProductList() {
      return productList;
   }
}
