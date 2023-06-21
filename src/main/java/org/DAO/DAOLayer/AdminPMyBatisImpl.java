package org.DAO.DAOLayer;

import org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper;
import org.DAO.ModelObjs.AdminP;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class AdminPMyBatisImpl implements AdminPMyBatisMapper {

    private final SqlSession session;

    public AdminPMyBatisImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public AdminP get(int adminPID) throws SQLException {
        return session.selectOne("org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper.get", adminPID);
    }

    @Override
    public List<AdminP> getAll() throws SQLException {
        return session.selectList("org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper.getAll");
    }

    @Override
    public void insert(AdminP adminP) throws SQLException {
        session.insert("org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper.insert", adminP);
        session.commit();
    }

    @Override
    public void update(AdminP adminP) throws SQLException {
        session.update("org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper.update", adminP);
        session.commit();
    }

    @Override
    public void delete(AdminP adminP) throws SQLException {
        session.delete("org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper.delete", adminP);
        session.commit();
    }
}
