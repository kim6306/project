package org.itsci.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.itsci.project.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Shop> getShops() {
        Session session = sessionFactory.getCurrentSession();
        Query<Shop> query = session.createQuery("FROM Shop", Shop.class);
        List<Shop> shops = query.getResultList();
        return shops;
    }

    @Override
    public void saveShop(Shop shop) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(shop);
    }

    @Override
    public Shop getShop(int shopId) {
        Session session = sessionFactory.getCurrentSession();
        Shop shop = session.get(Shop.class, shopId);
        return shop;
    }

    @Override
    public void deleteShop(int shopId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Shop where id=:shopId");
        query.setParameter("shopId", shopId);
        query.executeUpdate();
    }

    @Override
    public List<Shop> getShopDoesNotHaveProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Shop> query = session.createQuery("select p.shops from Product p where p.id=:id");
        query.setParameter("id", id);
        List<Shop> shopList1 = query.getResultList();
        query = session.createQuery("from Shop");
        List<Shop> shopList2 = query.getResultList();
        shopList2.removeAll(shopList1);
        return shopList2;
    }

}
