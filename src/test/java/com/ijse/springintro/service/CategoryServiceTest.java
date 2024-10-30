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
import com.ijse.springintro.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
 
    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryServiceImpl categoryServiceImpl;

    @Test
    void createCategoryShouldCreateCategory() {

        Category category = Category.builder().id(1L).name("Clothes").build();
        Mockito.when(categoryRepository.save(category)).thenReturn(category);

        Category createdCategory = categoryServiceImpl.createCategory(category);

        Assertions.assertEquals(category.getId(), createdCategory.getId());
        Assertions.assertTrue(createdCategory.getName()=="Clothes");
    }
    
    @Test
    void getCategoryByIdShouldGetCategoryById() {

        Category category = Category.builder().id(1L).name("Clothes").build();
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Category foundCategory = categoryServiceImpl.getCategoryById(1L);

        Assertions.assertEquals(category.getId(), foundCategory.getId());
        Assertions.assertTrue(foundCategory.getName()=="Clothes");
    }

    
}
