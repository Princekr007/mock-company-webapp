package com.mockcompany.webapp.data;

import com.mockcompany.webapp.model.ProductItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepository extends CrudRepository<ProductItem, Long> {
    List<ProductItem> findByNameContainingIgnoreCase(String query);
}
