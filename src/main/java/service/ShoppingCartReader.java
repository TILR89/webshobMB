package service;

import entity.ShoppingCart;
import entity.Suppliers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ShoppingCartReader {
    private static final Logger LOGGER = LogManager.getLogger(SuppliersReader.class);
    public void readShoppingCartById(int user_id) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        ShoppingCart shoppingCart = (ShoppingCart) session.selectOne("ShoppingCart.getById", user_id);

        LOGGER.info(shoppingCart.getUser_id());
        LOGGER.info(shoppingCart.getProduct_id());
        LOGGER.info(shoppingCart.getOrders_order_id());


        session.commit();
        session.close();
    }

    public void readAllShoppingCarts() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<ShoppingCart> shoppingCartList = session.selectList("ShoppingCart.getAll");

        for(ShoppingCart s : shoppingCartList ){
            LOGGER.info(s.getUser_id());
            LOGGER.info(s.getProduct_id());
            LOGGER.info(s.getOrders_order_id());
        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
