package service;

import entity.Users;
import interfaces.ICreate;
import interfaces.IDelete;
import interfaces.IUpdate;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UsersReader implements ICreate, IDelete, IUpdate {
    private static final Logger LOGGER = LogManager.getLogger(UsersReader.class);
    public void readUserById(int user_id) throws  IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Users user = (Users) session.selectOne("Users.getById", user_id);

        LOGGER.info(user.getUser_id());
        LOGGER.info(user.getUser_name());
        LOGGER.info(user.getUser_email());
        LOGGER.info(user.getUser_password());

        session.commit();
        session.close();
    }

    public void readAllUsers() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Users> users = session.selectList("Users.getAll");

        for(Users u : users ){
            LOGGER.info(u.getUser_id());
            LOGGER.info(u.getUser_name());
            LOGGER.info(u.getUser_email());
            LOGGER.info(u.getUser_password());

        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }




    @Override
    public void insert(String user_name, String user_email, String user_password) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Users user = new Users(user_name, user_email, user_password );

        session.insert("Users.insert", user);
        LOGGER.info("record inserted successfully");
        session.commit();
        session.close();

    }

    @Override
    public void delete(int user_id) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        session.delete("Users.deleteById", user_id);
        session.commit();
        session.close();
        LOGGER.info("Record deleted successfully");

    }


    @Override
    public void updateRecord(int user_id, String updated_name, String updated_email, String updated_password) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Users user = (Users) session.selectOne("Users.getById", user_id);

        user.setUser_name(updated_name);
        user.setUser_email(updated_email);
        user.setUser_password(updated_password);

        session.update("Users.update",user);
        LOGGER.info("Record updated successfully");
        session.commit();
        session.close();
    }
}
