package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataDAO {
    public static Integer deleteData(Integer id, Connection con) throws SQLException {

        // so that we are able to make changes in our table
        String unsetSafeUpdates = "SET SQL_SAFE_UPDATES = 0;";
        Statement st= con.createStatement();
        st.executeUpdate(unsetSafeUpdates);

        // to delete a student from table
        String query= "delete from students where id= ? ;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        Integer rows = pst.executeUpdate();

        st.close();
        pst.close();
        return rows;
    }
}
