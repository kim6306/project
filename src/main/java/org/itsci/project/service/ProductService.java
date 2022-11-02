package org.itsci.project.service;

import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    public void saveProduct(Product product);
    Product getProduct(int productId);
    void deleteProduct(int productId);
    void updateProduct(Product productEntity, Product product);

    void addShopToProduct(int productId, int shopId);

    void removeShopFromProduct(int productId, int shopId);

    List<Product> getProductDoesNotHaveShop(int id);
}
