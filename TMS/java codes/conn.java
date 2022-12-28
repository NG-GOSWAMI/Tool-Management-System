package tool.management.system;

import java.sql.*;

public class conn {

    static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connected");
            c=DriverManager.getConnection("jdbc:mysql:///project","root","");
            s=c.createStatement();
        }catch(Exception e){
                System.out.println(e);
        }
    }
    
}
