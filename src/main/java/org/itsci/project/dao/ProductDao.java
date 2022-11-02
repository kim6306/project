package org.itsci.project.dao;

import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    void saveProduct(Product product);
    Product getProduct(int id);
    void deleteProduct(int id);

    List<Product> getProductDoesNotHaveShop(int id);
}
