package tiago_teste_backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBanco 
{
    private static String url = "jdbc:mysql://localhost:1527/tiago_teste_backend";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "KTIAGOT";   
    private static String password = "@12345";
    private static Connection con;
    private static String urlstring;
    
    public static Connection getConnection() 
    {
        try 
        {
            Class.forName(driverName);
            try 
            {
                con = DriverManager.getConnection(urlstring, username, password);
            } 
            catch (SQLException ex) 
            {
                System.out.println("Falha na conexão"); 
            }
        }
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Driver não encontrado"); 
        }
        return con;
    }
}
