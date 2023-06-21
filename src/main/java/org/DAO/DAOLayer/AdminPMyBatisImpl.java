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
       /* Connection con = ConnectionFactory.getConnection();
        AdminP adminP = null;

        String sql = "SELECT * FROM admin_personel";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        ArrayList<AdminP> adminPs = new ArrayList<>();

        while(rs.next()) {
            int returnedId = rs.getInt("admin_personel_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("role_id");

            adminP = new AdminP(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
            adminPs.add(adminP);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return adminPs;*/
        return null;
    }

    //CRUD - Create
    @Override
    public void insert(AdminP adminP) throws SQLException {
        session.insert("org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper.insert", adminP);
        session.commit();
    }

    //CRUD - Update
    @Override
    public void update(AdminP adminP) throws SQLException {
        session.update("org.DAO.DAOLayer.interfaces.AdminPMyBatisMapper.update", adminP);
        session.commit();
    }

    @Override
    public int delete(AdminP adminP) throws SQLException {
      /*  Connection con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM admin_personel WHERE admin_personel_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, adminP.getAdminPersonelId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;*/
        return 0;
    }
}
