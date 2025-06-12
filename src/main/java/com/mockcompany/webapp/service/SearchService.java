package com.mockcompany.webapp.service;

import com.mockcompany.webapp.data.ProductItemRepository;
import com.mockcompany.webapp.model.ProductItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final ProductItemRepository productItemRepository;

    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    public List<ProductItem> search(String query) {
        Iterable<ProductItem> allItems = productItemRepository.findAll();
        List<ProductItem> itemList = new ArrayList<>();

        boolean isExactMatch = query.startsWith("\"") && query.endsWith("\"");
        String trimmedQuery = isExactMatch
                ? query.substring(1, query.length() - 1)  // remove quotes
                : query.toLowerCase();

        for (ProductItem item : allItems) {
            String name = item.getName() != null ? item.getName() : "";
            String desc = item.getDescription() != null ? item.getDescription() : "";

            if (isExactMatch) {
                if (name.equals(trimmedQuery) || desc.equals(trimmedQuery)) {
                    itemList.add(item);
                }
            } else {
                if (name.toLowerCase().contains(trimmedQuery) || desc.toLowerCase().contains(trimmedQuery)) {
                    itemList.add(item);
                }
            }
        }

        return itemList;
    }
}
