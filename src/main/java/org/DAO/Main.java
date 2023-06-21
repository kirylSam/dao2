package org.DAO;

import org.DAO.DAOLayer.AdminPMyBatisImpl;
import org.DAO.ModelObjs.AdminP;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;


public class Main {
    static Logger logger;
    static {
        logger = LogManager.getLogger("org.DAO.Main");
    }
    public static void main(String[] args) {
        try {
            //load MyBatis
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            //Open session
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AdminPMyBatisImpl adminPMyBatis = new AdminPMyBatisImpl(sqlSession);

            AdminP returnedByBatis = adminPMyBatis.get(1);
            System.out.println(returnedByBatis);
           /* AdminP insertAdminP = new AdminP("BatisFirstName", "BatisLastName", 1000, 6, 1);
            System.out.println(insertAdminP);
            adminPMyBatis.insert(insertAdminP);*/

            AdminP updateAdminP = new AdminP(12, "Batis3", "Batis32", 100000, 6, 1);
            adminPMyBatis.update(updateAdminP);

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

