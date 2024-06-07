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

                int IdEmprestimo = res.getInt("IdEmprestimo");
                int IdAmigo = res.getInt("IdAmigo");
                int IdFerramentas = res.getInt("IdFerramentas");
                String dataEmp = res.getString("DataEmprestimo");
                String dataDev = res.getString("DataDevolucao");

                Emprestimo objeto = new Emprestimo(IdEmprestimo, IdAmigo, IdFerramentas, dataEmp, dataDev);

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
     public int maiorIDEmprestimo() {
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
        String sql = "INSERT INTO tb_emprestimos(IdEmprestimo,IdAmigo,IdFerramentas,DataEmprestimo,DataDevolucao) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = ut.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdEmprestimo());
            stmt.setInt(2, objeto.getIdAmigo());
            stmt.setInt(3, objeto.getIdFerramentas());
            stmt.setString(4, objeto.getDataEmp());
            stmt.setString(5, objeto.getDataDev());

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

        String sql = "UPDATE tb_emprestimos set IdAmigo = ? ,IdFerramentas = ? ,DataEmprestimo = ? , WHERE IdEmprestimo = ?";

        try {
            PreparedStatement stmt = ut.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdAmigo());
            stmt.setInt(2, objeto.getIdFerramentas());
            stmt.setString(3, objeto.getDataEmp());
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

            objeto.setIdAmigo(res.getInt("IdAmigo"));
            objeto.setIdFerramentas(res.getInt("IdFerramentas"));
            objeto.setDataEmp(res.getString("DataEmprestimo"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
     
    public boolean isFerramentaDisponivel(int IdFerramentas) throws SQLException {
    String sql = "SELECT DisponibilidadeFerramentas FROM ferramentas WHERE IdFerramentas = ?";
    try (PreparedStatement pstmt = ut.getConexao().prepareStatement(sql)) {
        pstmt.setInt(1, IdFerramentas);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getBoolean("DisponibilidadeFerramentas");
            } else {
                throw new SQLException("Ferramenta com ID " + IdFerramentas + " não encontrada.");
            }
        }
    } catch (SQLException e) {
        throw new SQLException("Erro ao verificar disponibilidade da ferramenta", e);
    }
}
}

