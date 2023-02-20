package service;

import entity.Products;
import entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ProductsReader {
    private static final Logger LOGGER = LogManager.getLogger(ProductsReader.class);
    public void readProductById(int product_id) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Products product = (Products) session.selectOne("Products.getById", product_id);

        LOGGER.info(product.getProduct_id());
        LOGGER.info(product.getProduct_name());
        LOGGER.info(product.getProduct_price());
        LOGGER.info(product.getProduct_description());
        LOGGER.info(product.getSupplier_id());

        session.commit();
        session.close();
    }

    public void readAllProducts() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Products> productsList = session.selectList("Products.getAll");

        for(Products p : productsList ){
            LOGGER.info(p.getProduct_id());
            LOGGER.info(p.getProduct_name());
            LOGGER.info(p.getProduct_price());
            LOGGER.info(p.getProduct_description());
            LOGGER.info(p.getSupplier_id());

        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
