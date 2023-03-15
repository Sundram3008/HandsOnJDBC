package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintTableDataDAO {

    // It will print all the tuples of student table
    public static void print(Connection con) throws SQLException {
        // SQL query
        String query= "select * from students;";

        // get statement object
        Statement st = con.createStatement();

        // execute query and get the table as result
        ResultSet res = st.executeQuery(query);

        // iterating and printing result
        System.out.println("X--------------------------------------------------X");
        while (res.next()){
            System.out.println("Id : " + res.getInt(1) + ", Student Name : " + res.getString(2));
        }
        System.out.println("X--------------------------------------------------X");
        st.close();
        res.close();
    }
}
