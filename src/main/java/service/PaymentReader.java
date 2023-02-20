package service;

import entity.Payment;
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

public class PaymentReader {
    private static final Logger LOGGER = LogManager.getLogger(PaymentReader.class);
    public void readPaymentById(int order_id) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Payment payment = (Payment) session.selectOne("Payment.getById", order_id);

        LOGGER.info(payment.getPayment_id());
        LOGGER.info(payment.getPayment_date());
        LOGGER.info(payment.getOrders_order_id());

        session.commit();
        session.close();
    }

    public void readAllUsers() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Payment> paymentList = session.selectList("Payment.getAll");

        for(Payment p : paymentList ){
            LOGGER.info(p.getPayment_id());
            LOGGER.info(p.getPayment_date());
            LOGGER.info(p.getOrders_order_id());
        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
