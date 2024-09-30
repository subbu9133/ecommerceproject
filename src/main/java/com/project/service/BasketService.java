package com.project.service;

import com.project.entity.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BasketService {

    private Map<Product, Integer> basket = new HashMap<>();

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public void addProduct(Product product) {
        basket.put(product, basket.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product) {
        if (basket.containsKey(product)) {
            if (basket.get(product) > 1) {
                basket.put(product, basket.get(product) - 1);
            } else {
                basket.remove(product);
            }
        }
    }

    public void clearBasket() {
        basket.clear();
    }

    public int getBasketSize() {
        return basket.values().stream().mapToInt(Integer::intValue).sum();
    }
}
