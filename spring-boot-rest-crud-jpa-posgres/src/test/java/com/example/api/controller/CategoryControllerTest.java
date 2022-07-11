package com.example.api.controller;

import com.example.api.domain.dto.CategoryResponseDTO;
import com.example.api.domain.services.CategoryServices;
import com.example.api.web.controller.CategoryController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    CategoryServices categoryServices;

    private CategoryResponseDTO categoryResponseDTO;

    @Test
    void getAllCategory_ok(){
        List<CategoryResponseDTO> categories = Arrays.asList(categoryResponseDTO);
        Mockito.when(categoryServices.getAll()).thenReturn(categories);

        ResponseEntity<?> response = categoryController.getAll();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertNotNull(response.getBody());
    }
}
