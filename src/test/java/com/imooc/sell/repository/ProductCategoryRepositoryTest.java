package com.imooc.sell.repository;

import com.imooc.sell.dataObject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findoneTest() {
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("最受欢迎的");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void updateTest() {
//        Optional<ProductCategory> productCategorys = repository.getOne(2);
//        ProductCategory productCategory = new ProductCategory();
//        if (productCategorys.isPresent()){
//             productCategory = productCategorys.get();
//        }
//        productCategory.setCategoryName("最受人们欢迎的");
//        productCategory.setCategoryType("3");
//        repository.save(productCategory);

        ProductCategory productCategory = repository.getOne(2);
        productCategory.setCategoryName("最受人们欢迎的");
        productCategory.setCategoryType(3);
        repository.save(productCategory);

    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        System.out.println(result.toString());

    }


}