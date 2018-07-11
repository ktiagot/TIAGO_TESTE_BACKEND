package tiago_teste_backend;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        Scanner leitor = new Scanner(System.in);
        String erro = null;
        boolean verificar = true;
        String controle;
        double avg;
        boolean status;
        
        JOptionPane.showInputDialog("Deseja inserir novo registro no sistema? (S/N)");
        controle = leitor.next();
        switch(controle.toUpperCase())
        {
            case "S":
                verificar = true;
                break;
            case "N":
                verificar = false;
                break;
        }
        while(verificar == true)
        {
            JOptionPane.showInputDialog("ID do cliente: ");
            int id = leitor.nextInt();
            JOptionPane.showInputDialog("CPF ou CNPJ do cliente: ");
            String cpf_cnpj = leitor.next();
            JOptionPane.showInputDialog("Nome do cliente: ");
            String nome = leitor.next();
            int atividade = JOptionPane.showOptionDialog(null, "O Cliente está ativo?", 
                    null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(atividade==JOptionPane.YES_OPTION)
            {
                status = true;
            }
            else
            {
                status = false;
            }
            
            JOptionPane.showInputDialog("Saldo total do cliente: ");
            double valor = leitor.nextDouble();
            
            try
            {
                contaCliente.adicionarCliente(id, cpf_cnpj, nome, status, valor);
            }
            catch (Exception ex)
            {
                
            }
            
            atividade = JOptionPane.showOptionDialog(null, "Deseja inserir mais um registro?", 
                    null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(atividade==JOptionPane.YES_OPTION)
            {
                verificar = true;
            }
            else
            {
                verificar = false;
            }
        }
        
        avg = contaCliente.getValorCliente();
        JOptionPane.showMessageDialog(null, "Média dos valores: R$"+avg);
        
    }
}
