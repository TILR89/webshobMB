package service;

import entity.OrderHistory;
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

public class OrderHistoryReader {
    private static final Logger LOGGER = LogManager.getLogger(OrderHistory.class);
    public void readOrderHistoryById(int order_id) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        OrderHistory oh = (OrderHistory) session.selectOne("OrderHistory.getById", order_id);

        LOGGER.info(oh.getOrder_id());
        LOGGER.info(oh.getHistory_status());
        LOGGER.info(oh.getHistory_time());
        LOGGER.info(oh.getOrders_order_id());

        session.commit();
        session.close();
    }

    public void readAllOrdersHistory() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<OrderHistory> orderHistoryList = session.selectList("OrderHistory.getAll");

        for(OrderHistory oh : orderHistoryList ){
            LOGGER.info(oh.getOrder_id());
            LOGGER.info(oh.getHistory_status());
            LOGGER.info(oh.getHistory_time());
            LOGGER.info(oh.getOrders_order_id());

        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }

}
