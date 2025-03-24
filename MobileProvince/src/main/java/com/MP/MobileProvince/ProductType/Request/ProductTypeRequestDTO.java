package com.MP.MobileProvince.ProductType.Request;

import lombok.Data;

@Data
public class ProductTypeRequestDTO {
    private String productTypeName;
    private String productTypeDescription;
    private String studentImage;
    private Long categories;

}
