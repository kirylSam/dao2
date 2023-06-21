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
import java.util.List;


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

            //Get
            AdminP returnedByBatis = adminPMyBatis.get(1);
            System.out.println(returnedByBatis);
           /*
           //Insert
           AdminP insertAdminP = new AdminP("BatisFirstName", "BatisLastName", 1000, 6, 1);
            System.out.println(insertAdminP);
            adminPMyBatis.insert(insertAdminP);*/

            /*
            Update
            AdminP updateAdminP = new AdminP(12, "Batis3", "Batis32", 100000, 6, 1);
            adminPMyBatis.update(updateAdminP);*/

           /*
           GetAll
           List<AdminP> result = adminPMyBatis.getAll();
            for(AdminP adminP : result) {
                System.out.println(adminP);
            }*/


            //Delete
            AdminP deleteadminP = new AdminP(12, "Batis3", "Batis32", 100000, 6, 1);
            adminPMyBatis.delete(deleteadminP);

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

