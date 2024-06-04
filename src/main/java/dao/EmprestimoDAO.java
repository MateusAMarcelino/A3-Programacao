package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Emprestimo;

public class EmprestimoDAO {
    
    //chamando o metodo getConexao
    private Utilitario ut = new Utilitario();
    
    /**
     * Cria um ArrayList para os emprestimos.
     */
    public ArrayList<Emprestimo> ListaEmprestimo = new ArrayList<>();

    /**
     * Obtem as informações dos emprestimos do banco de dados e cria um objeto com essas informações no ArrayList ListaEmprestimo.
     * @return A lista de emprestimos após a coleta dos dados.
     */
    public ArrayList<Emprestimo> getListaEmprestimo() {
        
       ListaEmprestimo.clear(); //Limpa nosso ArrayList
       
       try{
           Statement stmt = ut.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");
            while (res.next()) {

                int id = res.getInt("IdEmprestimo");
                String nome = res.getString("NomeAmigo");
                int idFerramentas = res.getInt("IdFerramentas");
                int dataEmp = res.getInt("DataEmprestimo");

                Emprestimo objeto = new Emprestimo(id, nome, idFerramentas, dataEmp);

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
    
    /**
     * Procura o maior id entre todos os emprestimos do banco de dados.
     * @return O maior id encontrado.
     */
     public int maiorID() {
        int maiorIdEmprestimo = 0;
        try {
            Statement stmt = ut.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(IdEmprestimo) IdEmprestimo FROM tb_emprestimos");
            res.next();
            maiorIdEmprestimo = res.getInt("IdEmprestimo");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorIdEmprestimo;
    }
     
     
     /**
      * Adiciona um novo emprestimo ao banco de dados.
      * @param objeto é o objeto emprestimo, carregando todas as informações como o id, nome, idFerramenta, etc.
      * @return True se o emprestimo for inserido com sucesso, false caso o processo falhe.
      */
     public boolean insertEmprestimoBD(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimos(IdEmprestimo,NomeAmigo,IdFerramentas,DataEmprestimo) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = ut.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdEmprestimo());
            stmt.setString(2, objeto.getNome());
            stmt.setInt(3, objeto.getIdFerramentas());
            stmt.setInt(4, objeto.getDataEmp());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
    
     /**
      * Deleta um emprestimo existente do banco de dados pelo seu id.
      * @param idEmprestimo; O id do emprestimo a ser deletado.
      * @return True caso o emprestimo for deletado corretamente, false caso o processo falhe.
      */
     public boolean deleteEmprestimoBD(int idEmprestimo) {
        try {
            Statement stmt = ut.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE IdEmprestimo = " + idEmprestimo);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }
     
     /**
      * Atualiza as informações de um emprestimo ativo do banco de dados.
      * @param objeto; É o objeto emprestimo a ser atualizado.
      * @return True caso o emprestimo tiver sido atualizado com sucesso, false caso tenha dado algum erro.
      */
     public boolean updateEmprestimoBD(Emprestimo objeto) {

        String sql = "UPDATE tb_emprestimos set NomeAmigo = ? ,IdFerramentas = ? ,DataEmprestimo = ? , WHERE IdEmprestimo = ?";

        try {
            PreparedStatement stmt = ut.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getIdFerramentas());
            stmt.setInt(3, objeto.getDataEmp());
            stmt.setInt(4, objeto.getIdEmprestimo());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
     
     /**
      * Carrega as informações de um emprestimo por seu id.
      * @param idEmprestimo; Id do emprestimo a ser carregado.
      * @return O emprestimo com todas as suas informações, ou nada caso o id do emprestimo nao exista.
      */
     public Emprestimo carregaEmprestimo(int idEmprestimo) {
        Emprestimo objeto = new Emprestimo();
        objeto.setIdEmprestimo(idEmprestimo);
        try {
            Statement stmt = ut.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE IdEmprestimo = " + idEmprestimo);
            res.next();

            objeto.setNome(res.getString("NomeAmigo"));
            objeto.setIdFerramentas(res.getInt("IdFerramentas"));
            objeto.setDataEmp(res.getInt("DataEmprestimo"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}
