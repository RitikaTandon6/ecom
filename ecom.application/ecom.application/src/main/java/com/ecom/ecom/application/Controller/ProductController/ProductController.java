package com.ecom.ecom.application.Controller.ProductController;

import com.ecom.ecom.application.Model.Product.Product;
import com.ecom.ecom.application.Service.ProductService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


private final ProductService productService;

@GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id)
{
   Product product=productService.getProductById(id);
   return ResponseEntity.ok(product);

}

@GetMapping("/allProduct")
public ResponseEntity<List<Product>> getProductList()
{
    return ResponseEntity.ok(productService.getProducts());
}

@PostMapping("/save")
public ResponseEntity<Product> saveProdcut(@RequestBody  Product product)
{
    productService.saveProduct(product);
return ResponseEntity.status(HttpStatus.CREATED).body(product);
}

}
