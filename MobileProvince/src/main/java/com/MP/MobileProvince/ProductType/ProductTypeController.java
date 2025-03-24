package com.MP.MobileProvince.ProductType;

import com.MP.MobileProvince.ProductType.Request.ProductTypeRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/v1/product-type")
@RequiredArgsConstructor
public class ProductTypeController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<?> createProductType(@Valid @RequestBody ProductTypeRequestDTO productTypeRequestDTO) {
        var response = productService.createProductType(productTypeRequestDTO);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
