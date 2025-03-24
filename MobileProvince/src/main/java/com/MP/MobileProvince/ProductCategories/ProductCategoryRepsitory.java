package com.MP.MobileProvince.ProductCategories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepsitory extends JpaRepository <ProductCategories, Long > {


}
