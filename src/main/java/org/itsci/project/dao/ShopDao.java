package org.itsci.project.dao;

import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;
import java.util.List;

public interface ShopDao {

    List<Shop> getShops();
    void saveShop(Shop shop);
    Shop getShop(int id);
    void deleteShop(int id);

    List<Shop> getShopDoesNotHaveProduct(int id);

}
