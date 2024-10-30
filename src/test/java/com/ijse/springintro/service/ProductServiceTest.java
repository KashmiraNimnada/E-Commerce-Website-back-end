package com.ijse.springintro.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ijse.springintro.entity.Product;
import com.ijse.springintro.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    
    @Mock
    ProductRepository productRepository;
    
    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void createProductShouldCreateProductSuccessfully() {
        Product product = new Product();
        product.setName("Saban");
        product.setPrice(1000.0);
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Product addedProduct = productService.createProduct(product);

        Assertions.assertNotNull(addedProduct);
        Assertions.assertEquals(product.getName(), addedProduct.getName());
        Assertions.assertTrue(product.getName()=="Saban");
    }

}
