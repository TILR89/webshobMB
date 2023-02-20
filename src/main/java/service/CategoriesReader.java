package service;

import entity.Categories;
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

public class CategoriesReader {
    private static final Logger LOGGER = LogManager.getLogger(CategoriesReader.class);
    public void readCategoryById(int category_id) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Categories categories = (Categories) session.selectOne("Categories.getById", category_id);

        LOGGER.info(categories.getCategory_id());
        LOGGER.info(categories.getCategory_name());

        session.commit();
        session.close();
    }

    public void readAllCategories() throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Categories> categoriesList = session.selectList("Categories.getAll");

        for(Categories c : categoriesList ){
            LOGGER.info(c.getCategory_id());
            LOGGER.info(c.getCategory_name());

        }

        LOGGER.info("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
