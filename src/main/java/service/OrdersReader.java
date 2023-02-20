package service;

import entity.Orders;
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

public class OrdersReader {
    private static final Logger LOGGER = LogManager.getLogger(OrdersReader.class);

    public void readOrderById(int order_id) throws  IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student  by  id
        Orders orders = (Orders) session.selectOne("Orders.getById", order_id);

        //Print the student details
        LOGGER.info(orders.getOrder_id());
        LOGGER.info(orders.getUser_id());
        LOGGER.info(orders.getUser_email());
        LOGGER.info(orders.getUser_name());

        session.commit();
        session.close();
    }

    public void readAllOrders() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Orders> orders = session.selectList("Orders.getAll");

        for(Orders o : orders ){
            LOGGER.info(o.getOrder_id());
            LOGGER.info(o.getUser_id());
            LOGGER.info(o.getUser_email());
            LOGGER.info(o.getUser_name());

        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }

    public void readOrderByUserId(int user_id) throws  IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Orders> orders = session.selectList("Orders.getOrdersByUserId", user_id);

        for(Orders o : orders ){
            LOGGER.info("Order id: " + o.getOrder_id());
            LOGGER.info("User id: " + o.getUser_id());
            LOGGER.info("User email: " + o.getUser_email());
            LOGGER.info("User name: " + o.getUser_name());

        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
