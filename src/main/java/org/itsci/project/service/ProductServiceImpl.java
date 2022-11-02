package org.itsci.project.service;

import org.itsci.project.dao.CategoryDao;
import org.itsci.project.dao.ProductDao;
import org.itsci.project.dao.ShopDao;
import org.itsci.project.model.Category;
import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        Category category = categoryDao.getCategoryByCode(product.getCategory().getCode());
        product.setCategory(category);
        productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public Product getProduct(int productId) {
        return productDao.getProduct(productId);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    @Transactional
    public void updateProduct(Product productEntity, Product product) {
        productEntity.fill(product);
        saveProduct(productEntity);
    }

    @Override
    @Transactional
    public void addShopToProduct(int productId, int shopId) {
        Shop shop = shopDao.getShop(shopId);
        Product product = productDao.getProduct(productId);
        product.getShops().add(shop);
        productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public void removeShopFromProduct(int productId, int shopId) {
        Shop shop = shopDao.getShop(shopId);
        Product product = productDao.getProduct(productId);
        product.getShops().remove(shop);
        productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public List<Product> getProductDoesNotHaveShop(int id) {
        return productDao.getProductDoesNotHaveShop(id);
    }

}