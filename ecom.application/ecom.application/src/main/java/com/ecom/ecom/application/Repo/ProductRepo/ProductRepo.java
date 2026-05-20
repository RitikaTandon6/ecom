package com.ecom.ecom.application.Repo.ProductRepo;

import com.ecom.ecom.application.Model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
