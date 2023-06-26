package org.DAO.DAOLayer;

import org.DAO.DAOLayer.interfaces.NurseMyBatisMapper;
import org.DAO.ModelObjs.Nurse;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class NurseMyBatisImpl implements NurseMyBatisMapper {
    private final SqlSession session;

    public NurseMyBatisImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public Nurse get(int nurseID) throws SQLException {
        return session.selectOne("org.DAO.DAOLayer.interfaces.NurseMyBatisMapper.get", nurseID);
    }

    @Override
    public List<Nurse> getAll() throws SQLException {
        return session.selectList("org.DAO.DAOLayer.interfaces.NurseMyBatisMapper.getAll");
    }

    @Override
    public void insert(Nurse nurse) throws SQLException {
        session.insert("org.DAO.DAOLayer.interfaces.NurseMyBatisMapper.insert", nurse);
        session.commit();
    }

    @Override
    public void update(Nurse nurse) throws SQLException {
        session.update("org.DAO.DAOLayer.interfaces.NurseMyBatisMapper.update", nurse);
        session.commit();
    }

    @Override
    public void delete(Nurse nurse) throws SQLException {
        session.delete("org.DAO.DAOLayer.interfaces.NurseMyBatisMapper.delete", nurse);
        session.commit();
    }
}
