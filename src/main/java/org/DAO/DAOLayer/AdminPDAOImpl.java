package org.DAO.DAOLayer;

import org.DAO.Connection.ConnectionFactory;
import org.DAO.DAOLayer.interfaces.AdminPDAO;
import org.DAO.ModelObjs.AdminP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminPDAOImpl implements AdminPDAO {
    //DAO Layer

    //this class will be instantiated when we want to persist info in our db

    //CRUD - Retrieve
    @Override
    public AdminP get(int tId) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        AdminP adminP = null;

        String sql = "SELECT admin_personel_id, first_name, last_name, salary, department_id, " +
                "role_id FROM admin_personel WHERE admin_personel_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //indexes start from 1 here!
        ps.setInt(1, tId);

        ResultSet rs = ps.executeQuery();
        //if there's at least one result
        if(rs.next()) {
            int returnedId = rs.getInt("admin_personel_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("role_id");

            adminP = new AdminP(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return adminP;
    }

    @Override
    public List<AdminP> getAll() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
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

        return adminPs;
    }

    @Override
    public int save(AdminP adminP) throws SQLException {
        return 0;
    }

    //CRUD - Create
    @Override
    public int insert(AdminP adminP) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO admin_personel (first_name, last_name, salary, " +
                "department_id, role_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, adminP.getFirstName());
        ps.setString(2, adminP.getLastName());
        ps.setInt(3, adminP.getSalary());
        ps.setInt(4, adminP.getDepartmentId());
        ps.setInt(5, adminP.getRoleId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    //CRUD - Update
    @Override
    public int update(AdminP adminP) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE admin_personel SET first_name = ?, last_name = ?, salary = ?, department_id = ?, role_id = ? WHERE admin_personel_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, adminP.getFirstName());
        ps.setString(2, adminP.getLastName());
        ps.setInt(3, adminP.getSalary());
        ps.setInt(4, adminP.getDepartmentId());
        ps.setInt(5, adminP.getRoleId());
        ps.setInt(6, adminP.getAdminPersonelId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    @Override
    public int delete(AdminP adminP) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM admin_personel WHERE admin_personel_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, adminP.getAdminPersonelId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }
}
