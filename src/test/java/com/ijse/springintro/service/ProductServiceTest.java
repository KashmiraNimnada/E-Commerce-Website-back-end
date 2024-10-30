package com.ijse.springintro.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import com.ijse.springintro.entity.Category;
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
        product.setId(1L);
        product.setName("Saban");
        product.setPrice(1000.0);
        product.setDescription("50g saban");
        Category category = new Category();
        category.setId(1L);
        category.setName("Washing items");
        product.setCategory(category);
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Product addedProduct = productService.createProduct(product);

        Assertions.assertNotNull(addedProduct);
        Assertions.assertEquals(product.getName(), addedProduct.getName());
        Assertions.assertTrue(addedProduct.getName()=="Saban");
        Assertions.assertTrue(addedProduct.getDescription()=="50g saban");
        Assertions.assertEquals(product.getCategory(), addedProduct.getCategory());
        Assertions.assertTrue(addedProduct.getId()==1L);
    }

    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        sampleProduct = new Product();
        sampleProduct.setId(1L);
        sampleProduct.setName("atlas book");
        sampleProduct.setDescription("80 pages book");
        Category category = new Category();
        category.setId(1L);
        category.setName("Books");
        sampleProduct.setCategory(category);
    }

    @Test
    void getProductByIdShouldGetProductByIdSuccessfully() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        Product result = productService.getProductById(1L);
        Assertions.assertEquals(sampleProduct, result);
        Assertions.assertTrue(result.getDescription()=="80 pages book");
        Assertions.assertTrue(result.getName()=="atlas book");
        Assertions.assertTrue(result.getCategory().getId()==1L);
    }

}
