package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataDAO {

    public static Integer insertData(Integer id, String name, Connection con) throws SQLException {

        // SQL query
        String query = "insert into students values (?,?)";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1, id);
        pst.setString(2, name);
        Integer rows = pst.executeUpdate();

        pst.close();
        return rows;
    }
}
