package tiago_teste_backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class contaCliente {
   private int id;
   private String cpfCnpj;
   private String nome;
   private boolean status;
   private double valor; 


    public static void adicionarCliente(int id, String cpf_cnpj, String nome, boolean status, double valor)throws Exception
    {
        String query = "INSERT INTO tb_customer_account VALUES("+"?,?,?,?,?)";
        PreparedStatement stmt;
        stmt = conexaoBanco.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, cpf_cnpj);
        stmt.setString(3, nome);
        stmt.setBoolean(4, status);
        stmt.setDouble(5, valor);
        stmt.execute();
        stmt.close();
    }
    public static double getValorCliente() throws SQLException {
      String query = "SELECT AVG(vl_total) FROM tb_customer_account"
              + " WHERE vl_total > 560"
              + " AND id_customer BETWEEN 1500 AND 2700";
      PreparedStatement stmt = null;
      try{
      stmt = conexaoBanco.getConnection().prepareStatement(query);
      }catch (Exception ex){
          System.out.println(conexaoBanco.getConnection());
      }
      ResultSet res = stmt.executeQuery();
      double cA = 0;
      if (res.next()) {
         cA = res.getDouble(1);
      }
      res.close();
      stmt.close();
      return cA;
   }
    
   public static void getCustomerAccount() throws SQLException {
      String query = "SELECT * FROM tb_customer_account"
              + " WHERE vl_total > 560"
              + " AND id_customer BETWEEN 1500 AND 2700";
      PreparedStatement stmt = null;
      try{
      stmt = conexaoBanco.getConnection().prepareStatement(query);
      }catch (Exception ex){
          System.out.println(conexaoBanco.getConnection());
      }
      ResultSet res = stmt.executeQuery();
      String isActive;
      while (res.next()) {
          if(res.getBoolean("is_active")){
              isActive = "Sim";
          }else{
              isActive = "Não";
          } 
          System.out.println(res.getInt("id_customer") + " | "
          + res.getString("cpf_cnpj") + " | "
          + res.getString("nm_customer") + " | "
          + isActive + " | "
          + res.getDouble("vl_total"));
      }
      res.close();
      stmt.close();
   }
}
