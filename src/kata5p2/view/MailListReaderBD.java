package kata5p2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderBD {
    
    private static Connection connect(){
        String url = "jdbc:sqlite:C:\\Users\\Experimentos\\Documents\\NetBeansProjects\\Kata5p1\\Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public static List<Mail> read() throws SQLException{
        String sql = "SELECT * FROM email";
        List<Mail> lista = new ArrayList();
        try(Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                lista.add(new Mail(rs.getString("direccion")));                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }      
    return lista;
    }   
}