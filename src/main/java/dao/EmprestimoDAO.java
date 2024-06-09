package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import modelo.Emprestimo;

public class EmprestimoDAO {
    
    /**
     * Inicializa o Utilitario para podermos realizar a conecxão com o banco de dados.
     */
    private Utilitario ut = new Utilitario();
    
    /**
     * Cria um ArrayList para os emprestimos.
     */
    public static ArrayList<Emprestimo> ListaEmprestimo = new ArrayList<>();

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
        EmprestimoDAO.ListaEmprestimo = ListaEmprestimo;
        
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
     
     public Emprestimo RecuperaEmprestimoDB(int IdEmprestimo){
         Emprestimo emprestimo = new Emprestimo();
         emprestimo.setIdEmprestimo(IdEmprestimo);
         try {
             Statement smt = ut.getConexao().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_emprestimo where IdEmprestimo = " + IdEmprestimo);
            res.next();
            emprestimo.setIdEmprestimo(res.getInt("IdEmprestimo"));
            emprestimo.setDataEmp(res.getString("DataEmprestimo"));
            emprestimo.setDataDev(res.getString("DataDevolucao"));
            emprestimo.setIdAmigo(res.getInt("IdAmigo"));
            emprestimo.setIdFerramentas(res.getInt("IdFerramentas"));
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return emprestimo;
     }
     
     /*
     Atualiza um emprestimo no banco de dados.
     */
     public boolean updateEmprestimoBD(Emprestimo objeto) {
    String sql = "UPDATE tb_emprestimos SET IdAmigo=?, IdFerramentas=?, DataEmprestimo=?, DataDevolucao=? WHERE IdEmprestimo=?";

    try {
        PreparedStatement stmt = ut.getConexao().prepareStatement(sql);
        stmt.setInt(1, objeto.getIdAmigo());
        stmt.setInt(2, objeto.getIdFerramentas());
        stmt.setString(3, objeto.getDataEmp());
        
        // Verifica se a data de devolução de um emprestimo é nula ou não.
        if (objeto.getDataDev() == null || objeto.getDataDev().isEmpty()) {
            stmt.setNull(4, Types.DATE); // Caso seja vazia, define a mesma como nula.
        } else {
            stmt.setString(4, objeto.getDataDev()); // Caso não, define a data de devolução.
        }

        stmt.setInt(5, objeto.getIdEmprestimo());

        stmt.executeUpdate();
        stmt.close();

        return true;
    } catch (SQLException erro) {
        System.out.println("Erro:" + erro);
        throw new RuntimeException(erro);
    }
}
     

}
