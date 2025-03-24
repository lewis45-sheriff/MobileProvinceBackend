package com.MP.MobileProvince.ProductType;

import com.MP.MobileProvince.ProductCategories.ProductCategories;
import com.MP.MobileProvince.ProductCategories.ProductCategoryRepsitory;
import com.MP.MobileProvince.ProductType.Request.ProductTypeRequestDTO;
import com.MP.MobileProvince.Utils.CustomeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class  ProductServiceImpl implements ProductService {
    private final ProductCategoryRepsitory productCategoryRepsitory;
    private final ProductTypeRepository productTypeRepository;

    @Override
    public CustomeResponse<?> createProductType(ProductTypeRequestDTO productTypeRequestDTO) {
        CustomeResponse<ProductTypeRequestDTO> response = new CustomeResponse<>();
        try {
            Optional<ProductType> productTypeOptional = productTypeRepository.findByProductTypeName(productTypeRequestDTO.getProductTypeName());
            if (productTypeOptional.isPresent()) {
                response.setMessage("Product Type with the same name already exists");
                response.setStatusCode(HttpStatus.CONFLICT.value());
                return response;
            }


            ProductCategories productCategories = productCategoryRepsitory.findById(productTypeRequestDTO.getCategories())
                   .orElseThrow(() -> new IllegalArgumentException("Parent not found with ID: " + productTypeRequestDTO.getCategories()));


            ProductType productType = new ProductType();
            productType.setProductTypeName(productTypeRequestDTO.getProductTypeName());
            productType.setProductTypeDescription(productTypeRequestDTO.getProductTypeDescription());
            productType.setCategory(productCategories);
            productType.setImage(productType.getImage());
            //Save the entity to the database
            ProductType savedProductType=productTypeRepository.save(productType);
            //Create a new DTO with the saved entity's data
            ProductTypeRequestDTO productTypeRequestDTO1 = new ProductTypeRequestDTO();
            productTypeRequestDTO1.setProductTypeName(savedProductType.getProductTypeName());
            productTypeRequestDTO1.setProductTypeDescription(savedProductType.getProductTypeDescription());
            productTypeRequestDTO1.setCategories(savedProductType.getCategory().getId());

        response.setMessage("Product Type Created successfully");
        response.setStatusCode(HttpStatus.OK.value());
        response.setEntity(productTypeRequestDTO1);

        }catch (IllegalArgumentException e) {
            log.error("Validation error occurred: {}", e.getMessage(), e);
            response.setMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setEntity(null);
        } catch (Exception e) {
            log.error("Unexpected error occurred while capturing the student: {}", e.getMessage(), e);
            response.setMessage("An unexpected error occurred while capturing the student");
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setEntity(null);
        }
        return response;
    }
}
