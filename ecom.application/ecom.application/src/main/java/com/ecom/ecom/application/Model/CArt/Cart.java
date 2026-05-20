package com.ecom.ecom.application.Model.CArt;

import com.ecom.ecom.application.Model.Product.Product;
import com.ecom.ecom.application.Model.UserModel.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private BigDecimal price;

    private Long count;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;
    @ManyToOne
    @JoinColumn(name="productid")
    private Product product;
}

