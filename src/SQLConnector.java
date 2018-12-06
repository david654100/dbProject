import java.sql.*;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class SQLConnector {
    usercreds user1=new usercreds();
    private  String user = user1.getUsername();
    private  String pass = user1.getPassword();
    Connection c = null;
    SQLConnector(){



        try{
            //connecting to postgresql using jbdc
            Class.forName("org.postgresql.Driver");
            c=DriverManager.getConnection("jdbc:postgresql://localhost:5433/DBproject",
                    user, pass);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }











    }

    /**
     * using the connection imputs a quarry with given code
     * @param sql string with the sql code
     * @param c the Connection to the postgresql server
     * @return the result set of the sql quarry
     */
    public ResultSet stmtMaker(String sql, Connection c){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = c.createStatement();

          rs= stmt.executeQuery(sql);



        }catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }
}
