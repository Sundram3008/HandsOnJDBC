import Dao.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        // get connection
        Connection con= new EstablishConnectionDAO().makeConnection();

        // load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        InputStreamReader i= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(i);

        // Taking input continuously
        while(true){

            // call to print operations on console
            StubOutput.ConsoleStuff();

            // get the input present on the line
            String x= br.readLine();  // will get in string
            Integer input = Integer.parseInt(x); // convert string to integer

            // handling operations -

            if(input==1){
                System.out.print("Enter id ");
                String idString= br.readLine();
                Integer id= Integer.parseInt(idString);

                System.out.print("Enter Name ");
                String name= br.readLine();

                Integer rows = InsertDataDAO.insertData(id, name, con);

                System.out.println("Student added Successfully!!");
            }
            else if(input==2){
                System.out.println("Enter id");
                String idString= br.readLine();
                Integer id= Integer.parseInt(idString);

                Integer rows = DeleteDataDAO.deleteData(id, con);

                System.out.println("Student deleted Successfully!!");
            }
            else if(input==3){
                System.out.println("Enter id");
                String idString = br.readLine();
                Integer id= Integer.parseInt(idString);

                System.out.println("Enter new Name");
                String name = br.readLine();

                Integer rows = UpdateDataDAO.updateData(id, name, con);

                System.out.println("Student name Changed!!");
            }
            else if(input==4){
                PrintTableDataDAO.print(con);
            }
            else{
                System.out.println("Thank You !!");
                break;
            }
        }
        con.close();
        i.close();
        br.close();
    }
}
