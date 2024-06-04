package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;

public class AmigoDAO {

    private Utilitario ut = new Utilitario();
    
    /**
     * Cria a ArrayList para os amigos.
     */
    public ArrayList<Amigo> ListaAmigo = new ArrayList<>();
    
    
    /**
     * Coleta as informações dos amigos do banco de dados e cria um objeto com essas informações no ArrayList da ListaAmigos. 
     * @return A lista de ferramentas após pegar os dados.
     */
     public ArrayList<Amigo> getListaAmigo() {

        ListaAmigo.clear(); // Limpa nosso ArrayList
                 
       
        try {
            Statement stmt = ut.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                int telefone = res.getInt("telefone");
                String email = res.getString("email");

                Amigo objeto = new Amigo(id, nome, telefone, email);

                ListaAmigo.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaAmigo;
    }

    public void setListaAmigo(ArrayList<Amigo> ListaAmigo) {
        this.ListaAmigo = ListaAmigo;
    }

   /**
    * Procura o maior ID entre os amigos, buscando por todos os amigos no banco de dados.
    * @return O maior ID encontrado.
    */
    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = ut.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_amigos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }
    
    /**
     * Insere as informações como um amigo no banco de dados.
     * @param objeto é o objeto de amigos, que carrega as informações, como id,nome, etc..
     * @return True, caso seja possivel inserir o amigo, ou retorna um erro caso não seja possivel.
     */
    public boolean insertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigos(id,nome,telefone,email) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = ut.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setInt(3, objeto.getTelefone());
            stmt.setString(4, objeto.getEmail());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
    
    /**
     * Deleta um amigo do banco de dados.
     * @param id é o id do amigo que será deletado.
     * @return True, caso seja possivel deletar, ou retorna um erro caso não seja possivel.
     */
    public boolean deleteAmigoBD(int id) {
        try {
            Statement stmt = ut.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }
    
    /**
     * Atualiza as informações de um amigo, já existente no banco de dados.
     * @param objeto é o objeto do amigo, o qual será atualizado.
     * @return True, caso seja possivel atualizar, ou retorna um erro caso não seja possivel.
     */
    public boolean updateAmigoBD(Amigo objeto) {

        String sql = "UPDATE tb_amigos set nome = ? ,telefone = ? ,email = ?  WHERE id = ?";

        try {
            PreparedStatement stmt = ut.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getTelefone());
            stmt.setString(3, objeto.getEmail());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
/**
 * Carrega o objeto amigo, com as informações, coletando as informações do banco de dados
 * e preenchendo os valores, definindo no objeto.
 * @param id é o Id que será carregado.
 * @return 
 */
    public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo();
        objeto.setId(id);
        try {
            Statement stmt = ut.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getInt("telefone"));
            objeto.setEmail(res.getString("email"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}
