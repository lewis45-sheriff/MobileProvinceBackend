package com.MP.MobileProvince.ProductType;

import com.MP.MobileProvince.ProductCategories.ProductCategories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String productTypeName;
    @Column
    private String productTypeDescription;
    @Column
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategories category;
}
