package org.DAO.DAOLayer;

public class DoctorDAOImpl  {
   /* @Override
    public Doctor get(int tId) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Doctor doctor = null;

        String sql = "SELECT doctor_id, first_name, last_name, salary, department_id, " +
                "specialization_id FROM doctors WHERE doctor_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        //indexes start from 1 here!
        ps.setInt(1, tId);

        ResultSet rs = ps.executeQuery();
        //if there's at least one result
        if(rs.next()) {
            int returnedId = rs.getInt("doctor_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("specialization_id");

            doctor = new Doctor(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return doctor;
    }

    @Override
    public List<Doctor> getAll() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Doctor doctor = null;

        String sql = "SELECT * FROM doctors";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        ArrayList<Doctor> doctors = new ArrayList<>();

        while(rs.next()) {
            int returnedId = rs.getInt("doctor_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("specialization_id");

            doctor = new Doctor(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
            doctors.add(doctor);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return doctors;
    }

    @Override
    public int save(Doctor doctor) throws SQLException {
        return 0;
    }

    //CRUD - Create
    @Override
    public int insert(Doctor doctor) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO doctors (first_name, last_name, salary, " +
                "department_id, specialization_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, doctor.getFirstName());
        ps.setString(2, doctor.getLastName());
        ps.setInt(3, doctor.getSalary());
        ps.setInt(4, doctor.getDepartmentId());
        ps.setInt(5, doctor.getSpecializationId());


        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    //CRUD - Update
    @Override
    public int update(Doctor doctor) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE doctors SET first_name = ?, last_name = ?, salary = ?, department_id = ?, specialization_id = ? WHERE doctor_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, doctor.getFirstName());
        ps.setString(2, doctor.getLastName());
        ps.setInt(3, doctor.getSalary());
        ps.setInt(4, doctor.getDepartmentId());
        ps.setInt(5, doctor.getSpecializationId());
        ps.setInt(6, doctor.getDoctorId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    @Override
    public int delete(Doctor doctor) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM doctors WHERE doctor_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, doctor.getDoctorId());

        int result = ps.executeUpdate();

        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeConnection(con);

        return result;
    }

    @Override
    public List<Doctor> getAllWithLastName(String lastName) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Doctor doctor = null;

        String sql = "SELECT * FROM doctors WHERE last_name = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, lastName);

        ResultSet rs = ps.executeQuery();
        ArrayList<Doctor> doctors = new ArrayList<>();

        while(rs.next()) {
            int returnedId = rs.getInt("doctor_id");
            String returnedFirstName = rs.getString("first_name");
            String returnedLastName = rs.getString("last_name");
            int returnedSalary = rs.getInt("salary");
            int returnedDeptId = rs.getInt("department_id");
            int returnedSpecId = rs.getInt("specialization_id");

            doctor = new Doctor(returnedId, returnedFirstName, returnedLastName,
                    returnedSalary, returnedDeptId, returnedSpecId);
            doctors.add(doctor);
        }
        //Cleaning up
        ConnectionFactory.closePreparedStatement(ps);
        ConnectionFactory.closeResultSet(rs);
        ConnectionFactory.closeConnection(con);

        return doctors;
    }*/
}
