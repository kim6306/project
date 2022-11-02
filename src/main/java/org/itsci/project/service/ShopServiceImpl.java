package org.itsci.project.service;

import org.itsci.project.dao.ProductDao;
import org.itsci.project.dao.ShopDao;
import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public List<Shop> getShops() {
        return shopDao.getShops();
    }

    @Override
    @Transactional
    public void saveShop(Shop shop) {
        shopDao.saveShop(shop);
    }

    @Override
    @Transactional
    public Shop getShop(int shopId) {
        return shopDao.getShop(shopId);
    }

    @Override
    @Transactional
    public void deleteShop(int shopId) {
        shopDao.deleteShop(shopId);
    }

    @Override
    @Transactional
    public void updateShop(Shop shopEntity, Shop shop) {
        shopEntity.fill(shop);
        shopDao.saveShop(shopEntity);
    }

    @Override
    @Transactional
    public List<Shop> getShopDoesNotHaveProduct(int id) {
        return shopDao.getShopDoesNotHaveProduct(id);
    }

    @Override
    @Transactional
    public void addProductToShop (int shopId, int productId) {
        Product product = productDao.getProduct(productId);
        Shop shop = shopDao.getShop(shopId);
        shop.getProducts().add(product);
        shopDao.saveShop(shop);
    }

    @Override
    @Transactional
    public void removeProductFromShop(int shopId, int productId) {
        Product product = productDao.getProduct(productId);
        Shop shop = shopDao.getShop(shopId);
        shop.getProducts().remove(product);
        shopDao.saveShop(shop);
    }
}
