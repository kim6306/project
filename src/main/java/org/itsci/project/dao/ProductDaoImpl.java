package org.itsci.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.project.model.Product;
import org.itsci.project.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public Product getProduct(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, productId);
        return product;
    }

    @Override
    public void deleteProduct(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Product where id=:productId");
        query.setParameter("productId", productId);
        query.executeUpdate();
    }

    @Override
    public List<Product> getProductDoesNotHaveShop(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("select s.products from Shop s where s.id=:id");
        query.setParameter("id", id);
        List<Product> productList1 = query.getResultList();
        query = session.createQuery("from Product");
        List<Product> productList2 = query.getResultList();
        productList2.removeAll(productList1);
        return productList2;
    }

}
