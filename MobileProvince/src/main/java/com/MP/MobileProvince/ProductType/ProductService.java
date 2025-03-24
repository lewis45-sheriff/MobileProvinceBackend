package com.MP.MobileProvince.ProductType;

import com.MP.MobileProvince.ProductType.Request.ProductTypeRequestDTO;
import com.MP.MobileProvince.Utils.CustomeResponse;

public  interface ProductService {
    CustomeResponse<?>createProductType(ProductTypeRequestDTO productTypeRequestDTO);
}
