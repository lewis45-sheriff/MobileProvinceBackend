package com.MP.MobileProvince.ProductCategories;

import com.MP.MobileProvince.ProductCategories.Request.ProductCategoriesRequestDTO;
import com.MP.MobileProvince.Utils.CustomeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ProductCategoriesServiceImpl implements ProductCategoryService{
    ProductCategoryRepsitory productCategoryRepsitory;
        @Override
        public CustomeResponse<?> createCategories(ProductCategoriesRequestDTO productCategoriesRequestDTO) {
            CustomeResponse<ProductCategoriesRequestDTO> response = new CustomeResponse<>();
            try {
                ProductCategories productCategories = new ProductCategories();
                productCategories.setCategoryName(productCategoriesRequestDTO.getCategoryName());

                ProductCategories savedCategory = productCategoryRepsitory.save(productCategories);

                ProductCategoriesRequestDTO savedCategoryDTO = new ProductCategoriesRequestDTO();
                savedCategoryDTO.setCategoryName(savedCategory.getCategoryName());

                response.setMessage("Product Category Created Successfully");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity(savedCategoryDTO);
            } catch (IllegalArgumentException e) {
                log.error("Validation error occurred: {}", e.getMessage(), e);
                response.setMessage(e.getMessage());
                response.setStatusCode(HttpStatus.BAD_REQUEST.value());
                response.setEntity(null);
            } catch (Exception e) {
                log.error("Unexpected error occurred while saving category: {}", e.getMessage(), e);
                response.setMessage("An unexpected error occurred while saving category");
                response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setEntity(null);
            }

            return response;
        }

}
