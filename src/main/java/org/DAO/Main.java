package org.DAO;

import com.sun.istack.Pool;
import org.DAO.DAOLayer.AdminPMyBatisImpl;
import org.DAO.DAOLayer.DoctorMyBatisImpl;
import org.DAO.DAOLayer.Factory.ImplFactory;
import org.DAO.DAOLayer.NurseMyBatisImpl;
import org.DAO.ModelObjs.AdminP;
import org.DAO.ModelObjs.Builder.DoctorBuilder;
import org.DAO.ModelObjs.Doctor;
import org.DAO.ModelObjs.MVC.DoctorController;
import org.DAO.ModelObjs.MVC.DoctorModel;
import org.DAO.ModelObjs.MVC.DoctorView;
import org.DAO.ModelObjs.Nurse;
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
        //adminUsage();
       // doctorUsage();
        doctorMVCUsage();
        //nurseUsage();

    }

    public static void adminUsage() {
        try {
            //load MyBatis
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //Open session
            SqlSession sqlSession = sqlSessionFactory.openSession();

            AdminPMyBatisImpl adminPMyBatis = new AdminPMyBatisImpl(sqlSession);

            //Get
            AdminP returnedByBatis = adminPMyBatis.get(1);
            logger.info("Get one AdminP: " + returnedByBatis);

            //Insert
            AdminP insertAdminP = new AdminP("BatisFirstName4", "BatisLastName4", 100, 6, 1);
            adminPMyBatis.insert(insertAdminP);
            logger.info("Insert one AdminP: " + insertAdminP);

            //GetAll
            List<AdminP> result = adminPMyBatis.getAll();
            logger.info("List of all AdminPs");
            for (AdminP adminP : result) {
                logger.info("AdminP: " + adminP);
            }

             //Update
            AdminP updateAdminP = new AdminP(14, "asdasd", "asasdas", 100000, 6, 1);
            adminPMyBatis.update(updateAdminP);
            logger.info("Update one AdminP: " + updateAdminP);

            //Delete
            AdminP deleteadminP = new AdminP(9, "Batis3", "Batis32", 100000, 6, 1);
            adminPMyBatis.delete(deleteadminP);
            logger.info("Delete one AdminP: " + deleteadminP);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doctorUsage() {
        try {
            //load MyBatis
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //Open session
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //Factory
            ImplFactory factory = new ImplFactory();
            DoctorMyBatisImpl doctorMyBatis = (DoctorMyBatisImpl) factory.createMyBatisImpl("Doctor", sqlSession);

            //Get
            Doctor returnedByBatis = doctorMyBatis.get(1);
            logger.info("Get one Doctor: " + returnedByBatis);

            //Insert
            //Doctor Builder
            DoctorBuilder builder = new DoctorBuilder();
            Doctor insertDoctor = builder.buildFirstName("BuilderDoctor")
                    .buildLastName("BuilderDoctorLast")
                    .buildSalary(1000)
                    .buildSpecId(1)
                    .buildDepartmentId(2)
                    .getDoctor();


            doctorMyBatis.insert(insertDoctor);
            logger.info("Insert one Doctor: " + insertDoctor);

            //GetAll
            List<Doctor> result = doctorMyBatis.getAll();
            logger.info("List of all Doctors");
            for (Doctor doctor : result) {
                logger.info("Doctor: " + doctor);
            }

            //Update
            Doctor updateDoctor = builder.buildDoctorId(14)
                    .buildFirstName("UPDBuilderDoctor")
                    .buildLastName("UPDBuilderDoctorLast")
                    .buildSalary(1000)
                    .buildSpecId(1)
                    .buildDepartmentId(2)
                    .getDoctor();
            doctorMyBatis.update(updateDoctor);
            logger.info("Update one Doctor: " + updateDoctor);

          /*  //Delete
            Doctor deleteadminP = new Doctor(5, "Batis3", "Batis32", 100000, 1, 1);
            doctorMyBatis.delete(deleteadminP);
            logger.info("Delete one Doctor: " + deleteadminP);*/


        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doctorMVCUsage() {
        DoctorModel doctorModel = new DoctorModel();
        DoctorView doctorView = new DoctorView();
        DoctorController doctorController = new DoctorController(doctorView, doctorModel);

        doctorController.updateView();
        doctorController.setDoctorFirstLastName("MVCFirst", "MVCLast");
        doctorController.setDoctorSalarySpecAndDept(1000, 1, 1);
        doctorController.updateView();
    }

    public static void nurseUsage() {
        try {
            //load MyBatis
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //Open session
            SqlSession sqlSession = sqlSessionFactory.openSession();

            NurseMyBatisImpl nurseMyBatis = new NurseMyBatisImpl(sqlSession);

            //Get
            Nurse returnedByBatis = nurseMyBatis.get(1);
            logger.info("Get one Nurse: " + returnedByBatis);

            //Insert
            Nurse insertNurse = new Nurse("NurseBatis", "NurseBatis", 100, 2, 4);
            nurseMyBatis.insert(insertNurse);
            logger.info("Insert one Nurse: " + insertNurse);

            //GetAll
            List<Nurse> result = nurseMyBatis.getAll();
            logger.info("List of all Nurses");
            for (Nurse nurse : result) {
                logger.info("Nurse: " + nurse);
            }

            //Update
            Nurse updateNurse = new Nurse(2, "Nurse", "Espnosza", 100000, 1, 1);
            nurseMyBatis.update(updateNurse);
            logger.info("Update one Nurse: " + updateNurse);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

