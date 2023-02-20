package service;

import entity.Suppliers;
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

public class SuppliersReader {
    private static final Logger LOGGER = LogManager.getLogger(SuppliersReader.class);
    public void readSupplierById(int supplier_id) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Suppliers supplier = (Suppliers) session.selectOne("Suppliers.getById", supplier_id);

        LOGGER.info(supplier.getSupplier_id());
        LOGGER.info(supplier.getSupplier_name());


        session.commit();
        session.close();
    }

    public void readAllSuppliers() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Suppliers> suppliers = session.selectList("Suppliers.getAll");

        for(Suppliers s : suppliers ){
            LOGGER.info(s.getSupplier_id());
            LOGGER.info(s.getSupplier_name());
            }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }

}
