package org.DAO.DAOLayer;

import org.DAO.DAOLayer.interfaces.DoctorMyBatisMapper;
import org.DAO.ModelObjs.Doctor;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class DoctorMyBatisImpl implements DoctorMyBatisMapper {
    private final SqlSession session;

    public DoctorMyBatisImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public Doctor get(int doctorID) throws SQLException {
        return session.selectOne("org.DAO.DAOLayer.interfaces.DoctorMyBatisMapper.get", doctorID);
    }

    @Override
    public List<Doctor> getAll() throws SQLException {
        return session.selectList("org.DAO.DAOLayer.interfaces.DoctorMyBatisMapper.getAll");
    }

    @Override
    public void insert(Doctor doctor) throws SQLException {
        session.insert("org.DAO.DAOLayer.interfaces.DoctorMyBatisMapper.insert", doctor);
        session.commit();
    }

    @Override
    public void update(Doctor doctor) throws SQLException {
        session.update("org.DAO.DAOLayer.interfaces.DoctorMyBatisMapper.update", doctor);
        session.commit();
    }

    @Override
    public void delete(Doctor doctor) throws SQLException {
        session.delete("org.DAO.DAOLayer.interfaces.DoctorMyBatisMapper.delete", doctor);
        session.commit();
    }
}
