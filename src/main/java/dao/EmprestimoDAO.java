package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Emprestimo;

public class EmprestimoDAO {
    
    public ArrayList<Emprestimo> ListaEmprestimo = new ArrayList<>();

    public ArrayList<Emprestimo> getListaEmprestimo() {
        
       ListaEmprestimo.clear(); //Limpa nosso ArrayList
       
       try{
           Statement stmt = this.getConexaoEmprestimo().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");
            while (res.next()) {

                int id = res.getInt("IdEmprestimo");
                String nome = res.getString("NomeAmigo");
                int idFerramentas = res.getInt("IdFerramentas");
                int data = res.getInt("Data");

                Emprestimo objeto = new Emprestimo(id, nome, idFerramentas, data);

                ListaEmprestimo.add(objeto);
       }
            stmt.close();
    } catch (SQLException ex){
        System.out.println("Erro: " + ex);
    }
       return ListaEmprestimo;
    }
    
    public void setListaEmprestimo(ArrayList<Emprestimo> ListaEmprestimo) {
        this.ListaEmprestimo = ListaEmprestimo;
        
    }
     public int maiorID() {
        int maiorIdEmprestimo = 0;
        try {
            Statement stmt = this.getConexaoEmprestimo().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(IdEmprestimo) IdEmprestimo FROM tb_emprestimos");
            res.next();
            maiorIdEmprestimo = res.getInt("IdEmprestimo");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorIdEmprestimo;
    }
     
     public Connection getConexaoEmprestimo() {

        Connection connection = null;  //instância da conexão
        try {
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conexão
            String server = "localhost"; //caminho do MySQL
            String database = "db_a3";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);
            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }
     
     public boolean insertEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimos(IdEmprestimo,NomeAmigo,IdFerramentas,Data) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexaoEmprestimo().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdEmprestimo());
            stmt.setString(2, objeto.getNome());
            stmt.setInt(3, objeto.getIdFerramentas());
            stmt.setInt(4, objeto.getData());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
    
     public boolean deleteEmprestimoBD(int idEmprestimo) {
        try {
            Statement stmt = this.getConexaoEmprestimo().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE IdEmprestimo = " + idEmprestimo);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }
     
     public boolean updateEmprestimoBD(Emprestimo objeto) {

        String sql = "UPDATE tb_emprestimos set NomeAmigo = ? ,IdFerramentas = ? ,Data = ? , WHERE IdEmprestimo = ?";

        try {
            PreparedStatement stmt = this.getConexaoEmprestimo().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getIdFerramentas());
            stmt.setInt(3, objeto.getData());
            stmt.setInt(4, objeto.getIdEmprestimo());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
     
     public Emprestimo carregaEmprestimo(int idEmprestimo) {
        Emprestimo objeto = new Emprestimo();
        objeto.setIdEmprestimo(idEmprestimo);
        try {
            Statement stmt = this.getConexaoEmprestimo().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE IdEmprestimo = " + idEmprestimo);
            res.next();

            objeto.setNome(res.getString("NomeAmigo"));
            objeto.setIdFerramentas(res.getInt("IdFerramentas"));
            objeto.setData(res.getInt("Data"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}
