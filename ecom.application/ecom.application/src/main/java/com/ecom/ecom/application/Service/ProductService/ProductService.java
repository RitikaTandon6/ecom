package com.ecom.ecom.application.Service.ProductService;

import com.ecom.ecom.application.Exception.ResourceNotFoundException;
import com.ecom.ecom.application.Model.Product.Product;
import com.ecom.ecom.application.Repo.ProductRepo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

   public Product saveProduct(Product product)
   {
       return productRepo.save(product);
   }

   public Product getProductById(Long id)  {
       return productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product nor found"+ id));
   }

   public List<Product> getProducts()
   {
       return productRepo.findAll();
   }

   public Product updateProduct(Long id, Product product)
   {
       Product product1=productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found Product"));
       product1.setName(product1.getName());
       product1.setPrice(product1.getPrice());
       product1.setStock(product1.getStock());
       return productRepo.save(product1);

   }

}

