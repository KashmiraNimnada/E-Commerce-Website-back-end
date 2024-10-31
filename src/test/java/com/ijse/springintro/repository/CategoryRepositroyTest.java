package com.ijse.springintro.repository;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ijse.springintro.entity.Category;

@ExtendWith(MockitoExtension.class)
public class CategoryRepositroyTest {
    
    @Mock
    CategoryRepository categoryRepository;

    @Test
    void saveShouldSave() {

        Category category = Category.builder().id(1L).name("Clothes").build();

        when(categoryRepository.save(category)).thenReturn(category);

        Category createdCategory = categoryRepository.save(category);
        Assertions.assertEquals(category, createdCategory);
        Assertions.assertTrue(createdCategory.getName()=="Clothes");
    }
    
    @Test
    void findByIdShouldfindById() {

        Category category = Category.builder().id(1L).name("Clothes").build();
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Category gotCategory = categoryRepository.findById(1L).orElse(null);
        Assertions.assertEquals(category, gotCategory);
        Assertions.assertTrue(gotCategory.getName()=="Clothes");
    }   

    @Test
    void findAllShouldFindAll() {

        Category category1 = Category.builder().id(1L).name("Clothes").build();
        Category category2 = Category.builder().id(2L).name("Books").build();

        List<Category> categories = Arrays.asList(category1,category2);
        when(categoryRepository.findAll()).thenReturn(categories);

        List<Category> categoryList = categoryRepository.findAll();
        Assertions.assertEquals(categories, categoryList);
        Assertions.assertTrue(categoryList.get(0).getName()=="Clothes");
    }

}
