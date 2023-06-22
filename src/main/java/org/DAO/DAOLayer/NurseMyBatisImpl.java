package org.DAO.DAOLayer;

import org.DAO.DAOLayer.interfaces.NurseMyBatisMapper;
import org.DAO.ModelObjs.Nurse;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class NurseMyBatisImpl implements NurseMyBatisMapper {
  /*  @Override
    public Nurse get(int tId) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Nurse nurse = null;

        String sql = "SELECT nurse_id, first_name, last_name, nurse_salary, department_id, " +
                "specialization_id FROM nurses WHERE nurse_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //indexes start from 1 here!
        ps.setInt(1, tId);

        ResultSet rs = ps.executeQuery();
        //if there's at least one result
        if(rs.next()) {
            int returnedId = rs.getInt("nurse_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("nurse_salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("specialization_id");

            nurse = new Nurse(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return nurse;
    }

    @Override
    public List<Nurse> getAll() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Nurse nurse = null;

        String sql = "SELECT * FROM nurses";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        ArrayList<Nurse> nurses = new ArrayList<>();

        while(rs.next()) {
            int returnedId = rs.getInt("nurse_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("nurse_salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("specialization_id");

            nurse = new Nurse(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
            nurses.add(nurse);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return nurses;
    }

    @Override
    public int save(Nurse nurse) throws SQLException {
        return 0;
    }

    //CRUD - Create
    @Override
    public int insert(Nurse nurse) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO nurses (first_name, last_name, nurse_salary, " +
                "department_id, specialization_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, nurse.getFirstName());
        ps.setString(2, nurse.getLastName());
        ps.setInt(3, nurse.getNurseSalary());
        ps.setInt(4, nurse.getDepartmentId());
        ps.setInt(5, nurse.getSpecializationId());


        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    //CRUD - Update
    @Override
    public int update(Nurse nurse) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE nurses SET first_name = ?, last_name = ?, nurse_salary = ?, department_id = ?, specialization_id = ? WHERE nurse_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, nurse.getFirstName());
        ps.setString(2, nurse.getLastName());
        ps.setInt(3, nurse.getNurseSalary());
        ps.setInt(4, nurse.getDepartmentId());
        ps.setInt(5, nurse.getSpecializationId());
        ps.setInt(6, nurse.getNurseId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    @Override
    public int delete(Nurse nurse) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM nurses WHERE nurse_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, nurse.getNurseId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    @Override
    public List<Nurse> getAllWithSalaryHigherThan(int salary) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Nurse nurse = null;

        String sql = "SELECT * FROM nurses WHERE nurse_salary > ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, salary);

        ResultSet rs = ps.executeQuery();
        ArrayList<Nurse> nurses = new ArrayList<>();

        while(rs.next()) {
            int returnedId = rs.getInt("nurse_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("nurse_salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("specialization_id");

            nurse = new Nurse(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
            nurses.add(nurse);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return nurses;
    }*/
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
