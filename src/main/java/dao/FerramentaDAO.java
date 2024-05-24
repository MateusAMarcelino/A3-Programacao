package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

public class FerramentaDAO {

    //Cria ArrayList de Amigos:
    public ArrayList<Ferramenta> ListaFerramenta = new ArrayList<>();

     public ArrayList<Ferramenta> getListaFerramenta() {

        ListaFerramenta.clear(); // Limpa nosso ArrayList
        
       //adicionando objeto amigo ao banco de dados
        try {
            Statement stmt = this.getConexaoFerramenta().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {

                int IdFerramentas = res.getInt("IdFerramentas");
                String NomeFerramenta = res.getString("NomeFerramenta");
                String Marca = res.getString("Marca");
                int Custo = res.getInt("Custo");

                Ferramenta objeto = new Ferramenta(IdFerramentas, NomeFerramenta, Marca, Custo);

                ListaFerramenta.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaFerramenta;
    }

    public void setListaFerramenta(ArrayList<Ferramenta> ListaFerramenta) {
        this.ListaFerramenta = ListaFerramenta;
    }

    //Método para buscar maior ID
    public int maiorIdFerramentas() {
        int maiorIdFerramentas = 0;
        try {
            Statement stmt = this.getConexaoFerramenta().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(IdFerramentas) IdFerramentas FROM tb_ferramentas");
            res.next();
            maiorIdFerramentas = res.getInt("IdFerramentas");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorIdFerramentas;
    }
    
    //conexão com o banco de dados 
    public Connection getConexaoFerramenta() {

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
    
    public boolean insertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(IdFerramentas,NomeFerramenta,Marca,Custo) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexaoFerramenta().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdFerramentas());
            stmt.setString(2, objeto.getNomeFerramenta());
            stmt.setString(3, objeto.getMarca());
            stmt.setInt(4, objeto.getCusto());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
    
    public boolean deleteFerramentaBD(int IdFerramentas) {
        try {
            Statement stmt = this.getConexaoFerramenta().createStatement();
            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE IdFerramenta = " + IdFerramentas);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }
    
    public boolean updateFerramentaBD(Ferramenta objeto) {

        String sql = "UPDATE tb_ferramentas set NomeFerramenta = ? ,Marca = ? ,Custo = ? , WHERE IdFerramentas = ?";

        try {
            PreparedStatement stmt = this.getConexaoFerramenta().prepareStatement(sql);

            stmt.setString(1, objeto.getNomeFerramenta());
            stmt.setString(2, objeto.getMarca());
            stmt.setInt(3, objeto.getCusto());
            stmt.setInt(4, objeto.getIdFerramentas());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    public Ferramenta carregaFerramenta(int IdFerramentas) {
        Ferramenta objeto = new Ferramenta();
        objeto.setIdFerramentas(IdFerramentas);
        try {
            Statement stmt = this.getConexaoFerramenta().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE IdFerramenta = " + IdFerramentas);
            res.next();

            objeto.setNomeFerramenta(res.getString("NomeFerramenta"));
            objeto.setMarca(res.getString("Marca"));
            objeto.setCusto(res.getInt("Custo"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}