package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataDAO {
    public static Integer updateData(Integer id, String newName,  Connection con) throws SQLException {

        // so that we are able to make changes in our table
        String unsetSafeUpdates = "SET SQL_SAFE_UPDATES = 0;";
        Statement st= con.createStatement();
        st.executeUpdate(unsetSafeUpdates);

        // update student name of given id
        String query = "update students set name = ? where id = ? ;";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setString(1, newName);
        pst.setInt(2, id);
        Integer rows = pst.executeUpdate();

        st.close();
        pst.close();
        return rows;
    }
}
