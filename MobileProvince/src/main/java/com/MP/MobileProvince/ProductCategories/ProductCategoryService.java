package com.MP.MobileProvince.ProductCategories;

import com.MP.MobileProvince.ProductCategories.Request.ProductCategoriesRequestDTO;
import com.MP.MobileProvince.Utils.CustomeResponse;

public interface ProductCategoryService {
    CustomeResponse<?>createCategories(ProductCategoriesRequestDTO productCategoriesRequestDTO);

}
