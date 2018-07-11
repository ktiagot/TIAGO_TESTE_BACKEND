package tiago_teste_backend;
import java.sql.Connection;
import java.sql.DriverManager;


public class conexaoBanco 
{    
    private static Connection conexao;    
    public static Connection getConexao(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes?useTimezone=true&serverTimezone=UTC", "root", "");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return conexao;
    }
   
}
