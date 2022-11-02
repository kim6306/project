package org.itsci.project.service;

import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> getShops();
    void saveShop(Shop shop);
    Shop getShop(int shopId);
    void deleteShop(int shopId);
    void updateShop(Shop shopEntity, Shop shop);

    void addProductToShop(int shopId, int productId);

    void removeProductFromShop(int shopId, int productId);

    List<Shop> getShopDoesNotHaveProduct(int id);

}
