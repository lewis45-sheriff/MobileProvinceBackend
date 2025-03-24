package com.MP.MobileProvince.ProductCategories;

import com.MP.MobileProvince.ProductCategories.Request.ProductCategoriesRequestDTO;
import com.MP.MobileProvince.ProductType.Request.ProductTypeRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/v1/product-categories")
@RequiredArgsConstructor
public class ProductCategoriesController {
    private final ProductCategoryService productCategoryService;
    @PostMapping("create")
    public ResponseEntity<?> createCategoryType(@Valid @RequestBody ProductCategoriesRequestDTO productCategoriesRequestDTO) {
        var response = productCategoryService.createCategories(productCategoriesRequestDTO);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
