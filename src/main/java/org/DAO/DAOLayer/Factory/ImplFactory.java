package org.DAO.DAOLayer.Factory;

import org.DAO.DAOLayer.AdminPMyBatisImpl;
import org.DAO.DAOLayer.DoctorMyBatisImpl;
import org.DAO.DAOLayer.NurseMyBatisImpl;
import org.DAO.DAOLayer.interfaces.MainMyBatisMapper;
import org.apache.ibatis.session.SqlSession;

public class ImplFactory {
    public MainMyBatisMapper createMyBatisImpl(String implName, SqlSession session) {
        switch (implName) {
            case "Doctor":
                return new DoctorMyBatisImpl(session);
            case "Nurse":
                return new NurseMyBatisImpl(session);
            case "AdminP":
                return new AdminPMyBatisImpl(session);
            default:
                return null;
        }
    }
}
