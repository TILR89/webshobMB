package service;

import entity.Delivery;
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

public class DeliveryReader {
    private static final Logger LOGGER = LogManager.getLogger(UsersReader.class);
    public void readDeliveryById(int delivery_id) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Delivery delivery = (Delivery) session.selectOne("Delivery.getById", delivery_id);

        LOGGER.info(delivery.getDelivery_id());
        LOGGER.info(delivery.getDelivery_status());
        LOGGER.info(delivery.getUsers_user_id());

        session.commit();
        session.close();
    }

    public void readAllDeliveries() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Delivery> deliveryList = session.selectList("Delivery.getAll");

        for(Delivery d : deliveryList ){
            LOGGER.info(d.getDelivery_id());
            LOGGER.info(d.getDelivery_status());
            LOGGER.info(d.getUsers_user_id());

        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
