package com.ex.main.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ex.main.entity.Product;
import com.ex.main.repo.ProductRepo;

@Component
public class ProductSeeder implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private final ProductRepo productRepo;

    public ProductSeeder(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.loadProducts();
    }

    private void loadProducts() {
    	
        Product product1 = createProduct("MOTOG60", "Motorola Moto g 60", 17000L, 10L);
        Product product2 = createProduct("XYZ123", "Lenovo Laptop", 50000L, 5L);
        Product product3 = createProduct("SSW667", "Samsung watch", 10000L, 20L);
        Product product4 = createProduct("SSW967", "Samsung watch", 10000L, 0L);

        saveProductIfNotExists(product1);
        saveProductIfNotExists(product2);
        saveProductIfNotExists(product3);
        saveProductIfNotExists(product4);
    }

    private void saveProductIfNotExists(Product product) {
        if (!productRepo.existsByProductId(product.getProductId())) {
            productRepo.save(product);
            System.out.println("Product " + product.getName() + " added.");
        } else {
            System.out.println("Product " + product.getName() + " already exists.");
        }
    }

    private Product createProduct(String productId, String name, Long price, Long quantity) {
        Product product = new Product();
        product.setProductId(productId);
        product.setName(name);
        product.setOriginalPrice(price);
        product.setQuantity(quantity);
        
        return product;
    }
}
