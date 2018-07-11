package tiago_teste_backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException
    {   
        //Declaração de variáveis
        Scanner leitor = new Scanner(System.in);
        String erro = null;
        boolean verificar;
        double avg;
        System.out.println("Deseja inserir um registro? (S/N)");
        String insert = leitor.next();
        //Verificar se o usuário quer cadastrar um cliente
        if("S".equals(insert.toUpperCase()))
        {
            verificar = true;
        }
        else
        {
            verificar = false;
        }
        //Enquanto ele quiser cadastrar, os comandos de inserção serão pedidos
        while(verificar == true)
        {
            System.out.println("ID do cliente: ");
            int id = leitor.nextInt();
            System.out.println("CPF ou CNPJ do cliente: ");
            String cpf_cnpj = leitor.next();
            System.out.println("Nome do cliente: ");
            String nome = leitor.next();
            System.out.println("Cliente está ativo? (S/N)");
            String status = leitor.next();
            System.out.println("Saldo total do cliente: ");
            double valor = leitor.nextDouble();
            
            try
            {
                contaCliente.adicionarCliente(id, cpf_cnpj, nome, status, valor);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            
            System.out.println("Deseja inserir um registro? (S/N)");
            insert = leitor.next();     
            //Verificando novamente, ao final da inserção, se o usuário quer cadastrar um cliente
            if("S".equals(insert.toUpperCase()))
            {
                verificar = true;
            }
            else
            {
                verificar = false;
            }
        }
        avg = contaCliente.getValorCliente();
        //Apresentando média dos valores totais
        System.out.println("Média dos valores: R$"+avg);
        //Apresentando lista dos clientes usados no cálculo da média
        contaCliente.getCustomerAccount();
    }
}
