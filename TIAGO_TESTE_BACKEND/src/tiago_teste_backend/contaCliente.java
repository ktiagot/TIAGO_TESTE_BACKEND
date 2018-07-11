package tiago_teste_backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class contaCliente {
   private int id;
   private String cpfCnpj;
   private String nome;
   private String status;
   private double valor; 


    public static void adicionarCliente(int id, String cpf_cnpj, String nome, String status, double valor)throws Exception
    {
        String query = "INSERT INTO tb_customer_account VALUES("+"?,?,?,?,?)";
        PreparedStatement stmt;
        stmt = conexaoBanco.getConexao().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, cpf_cnpj);
        stmt.setString(3, nome);
        stmt.setString(4, status);
        stmt.setDouble(5, valor);
        stmt.execute();
        stmt.close();
    }
    public static double getValorCliente() throws SQLException, InstantiationException, IllegalAccessException {
      String query = "SELECT AVG(VL_TOTAL) FROM tb_customer_account WHERE VL_TOTAL > 560 AND ID_CUSTOMER BETWEEN 1500 AND 2700;";
      PreparedStatement stmt=null;
      try
      {
        stmt = conexaoBanco.getConexao().prepareStatement(query);
      }
      catch (Exception ex)
      {
          System.out.println(conexaoBanco.getConexao());
      }
      ResultSet res = stmt.executeQuery();
      double vltotal = 0;
      if (res.next()) {
         vltotal = res.getDouble(1);
      }
      res.close();
      stmt.close();
      return vltotal;
   }
    
   public static void getCustomerAccount() throws SQLException, InstantiationException, IllegalAccessException 
   {
       String query = "SELECT * FROM tb_customer_account "+
       "WHERE VL_TOTAL > 560 AND ID_CUSTOMER BETWEEN 1500 AND 2700 ORDER BY VL_TOTAL DESC";
       PreparedStatement stmt = null;
       try
       {
           stmt = conexaoBanco.getConexao().prepareStatement(query);
       }
       catch (Exception ex)
       {
           System.out.println(conexaoBanco.getConexao());
       }
       ResultSet res = stmt.executeQuery();
       
       System.out.println("Clientes utilizados para o cálculo da média:");
       String is_active;
       while (res.next())
       {
           if(res.getString("IS_ACTIVE").toUpperCase().equals("S"))
           {
               is_active="SIM";
           }
           else
           {
               is_active="NÃO";
           }
          System.out.println(res.getInt("ID_CUSTOMER") + " - "
          + res.getString("CPF_CNPJ") + " - "
          + res.getString("NM_CUSTOMER") + " - "
          + is_active + " - "
          + res.getDouble("VL_TOTAL"));
      }
      res.close();
      stmt.close();
   }
}
