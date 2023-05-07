
package ConexaoDAO;

import com.mycompany.ado2crud.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ComputadorDAO {
    
   public static boolean salvar(Computador computador) throws SQLException{
      boolean retorno = false;
      Connection conexao = null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/lojainformatica";
           
            conexao = DriverManager.getConnection(url, "root", "nunes97@");
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO computador "
                        + "(marca, hd, processador) VALUES(?, ?, ?)"); 
            comandoSQL.setString(1, computador.getMarca("Fernando Nunes"));
            comandoSQL.setString(2, computador.getHd());
            comandoSQL.setString(3, computador.getProcessador());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
            }
       } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver");
       }
      

      return retorno;
   }
    
    public static ArrayList<Computador> listar(){
    ArrayList<Computador> listaRetorno = new ArrayList<>();
    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/lojainformatica";
        conexao = DriverManager.getConnection(url,"root","nunes97@");
        PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM computador");
        ResultSet rs = comandoSQL.executeQuery();
        if(rs!=null){
            while(rs.next()){
                Computador computador = new Computador();
                computador.setMarca(rs.getString("marca"));
                computador.setId(rs.getInt("id"));
                computador.setHd(rs.getString("hd"));
                computador.setProcessador(rs.getString("processador"));
                listaRetorno.add(computador);
            }
        }
    } catch (ClassNotFoundException ex) {
        System.out.println("Erro ao carregar o Driver");
    } catch (SQLException ex) {
        System.out.println("Erro ao abrir a conexão");
    } finally {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão");
            }
        }
    }
    return listaRetorno;
}
public static boolean excluir(int id){
    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/lojainformatica";

        // Passo 2 - Abrir a conexao
        conexao = DriverManager.getConnection(url, "root", "nunes97@");

        // Passo 3 - Prepara o comando SQL
        PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM computador WHERE id = ? "); 

        comandoSQL.setInt(1, id);
        int linhasAfetadas = comandoSQL.executeUpdate();
        
        if (linhasAfetadas > 0) {
            return true;
        }

    } catch (ClassNotFoundException ex) {
        System.out.println("Erro ao carregar o Driver");
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão");
            }
        }
    }
    return false;
    }
    
    public static boolean alterar(Computador computador){
    boolean retorno = false;
    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/lojainformatica";
        
        conexao = DriverManager.getConnection(url, "root", "nunes97@");
        
        PreparedStatement comandoSQL = conexao.prepareStatement(
            "UPDATE computador SET marca = ?, hd = ?, processador = ? WHERE id = ?");
        comandoSQL.setString(1, computador.getMarca("Fernando Nunes"));
        comandoSQL.setString(2, computador.getHd());
        comandoSQL.setString(3, computador.getProcessador());
        comandoSQL.setInt(4, computador.getId());
        
        int linhasAfetadas = comandoSQL.executeUpdate();
        
        if(linhasAfetadas > 0){
            retorno = true;
        }
    } catch (ClassNotFoundException ex) {
        System.out.println("Erro ao carregar o Driver");
    } catch (SQLException ex) {
        System.out.println("Erro ao executar o comando SQL: " + ex.getMessage());
    } finally {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão");
            }
        }
    }
    return retorno;
}
}
