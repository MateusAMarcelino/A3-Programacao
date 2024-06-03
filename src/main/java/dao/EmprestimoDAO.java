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
    
    public ArrayList<Emprestimo> ListaEmprestimo = new ArrayList<>();

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
