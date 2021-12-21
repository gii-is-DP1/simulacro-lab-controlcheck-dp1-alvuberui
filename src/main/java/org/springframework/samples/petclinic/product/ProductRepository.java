package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
    List<Product> findAll();
    
    @Query("SELECT productType FROM Product product")
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    
    Product findByName(String name);
    
    Product save(Product p);
    
    @Query("SELECT productType FROM Product product where product.productType.name LIKE :name")
    ProductType findByProductTypeName(String name);
}
