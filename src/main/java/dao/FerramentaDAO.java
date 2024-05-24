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

    // Cria ArrayList de Ferramentas
    public static ArrayList<Ferramenta> ListaFerramenta = new ArrayList<>();

    // Métodos Getter e Setter da ArrayList Ferramentas
    public ArrayList<Ferramenta> getListaFerramenta() {
        ListaFerramenta.clear(); // Limpa nosso ArrayList

        try (Connection connection = getConexao();
             Statement stmt = connection.createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas")) {

            while (res.next()) {
                int ID = res.getInt("ID");
                String Nome = res.getString("Nome");
                String Marca = res.getString("Marca");
                int Valor = res.getInt("Valor");

                Ferramenta objeto = new Ferramenta(ID, Nome, Marca, Valor);
                ListaFerramenta.add(objeto);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return ListaFerramenta;
    }

    public static void setListaFerramenta(ArrayList<Ferramenta> listaFerramenta) {
        ListaFerramenta = listaFerramenta;
    }

    // Método para buscar maior ID
    public int maiorID() {
        int maiorID = 0;
        try (Connection connection = getConexao();
             Statement stmt = connection.createStatement();
             ResultSet res = stmt.executeQuery("SELECT MAX(ID) AS ID FROM tb_ferramentas")) {

            if (res.next()) {
                maiorID = res.getInt("ID");
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    public Connection getConexao() {
        Connection connection = null; // instância da conexão
        try {
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conexão
            String server = "localhost"; // caminho do MySQL
            String database = "db_a3";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Status: Conectado!");

        } catch (ClassNotFoundException e) {
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
        }
        return connection;
    }

    public boolean insertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(ID, Nome, Marca, Valor) VALUES(?, ?, ?, ?)";
        try (Connection connection = getConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, objeto.getID());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setInt(4, objeto.getValor());

            stmt.execute();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    public boolean deleteFerramentaBD(int ID) {
        try (Connection connection = getConexao();
             Statement stmt = connection.createStatement()) {

            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE ID = " + ID);
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    public boolean updateFerramentaBD(Ferramenta objeto) {
        String sql = "UPDATE tb_ferramentas SET Nome = ?, Marca = ?, Valor = ? WHERE ID = ?";
        try (Connection connection = getConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setInt(3, objeto.getValor());
            stmt.setInt(4, objeto.getID());

            stmt.execute();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    public Ferramenta carregaFerramenta(int ID) {
        Ferramenta objeto = new Ferramenta();
        objeto.setID(ID);
        try (Connection connection = getConexao();
             Statement stmt = connection.createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE Id = " + ID)) {

            if (res.next()) {
                objeto.setNome(res.getString("Nome"));
                objeto.setMarca(res.getString("Marca"));
                objeto.setValor(res.getInt("Valor"));
            }

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return objeto;
    }
}