package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

public class FerramentaDAO {
     
    //chamando o metodo getConexao
    private Utilitarios ut = new Utilitarios();
    
    public static ArrayList<Ferramenta> ListaFerramentas = new ArrayList<>();
    
    
     
     public ArrayList<Ferramenta> getListaFerramentas(){
         ListaFerramentas.clear();
         try {
             Statement smt = ut.getConexao().createStatement();
             ResultSet res = smt.executeQuery("select * from tb_ferramentas");
             while (res.next()){
                 int IdFerramentas = res.getInt("IdFerramentas");
                 String NomeFerramentas = res.getString("NomeFerramentas");
                 String MarcaFerramentas = res.getString("MarcaFerramentas");
                 double CustoFerramentas = res.getDouble("CustoFerramentas");
                 boolean DisponibilidadeFerramentas = res.getBoolean("DisponibilidadeFerramentas");
                 Ferramenta objeto = new Ferramenta(IdFerramentas,NomeFerramentas,MarcaFerramentas,CustoFerramentas,DisponibilidadeFerramentas);
                 
                 ListaFerramentas.add(objeto);
             }
             smt.close();
         } catch  (SQLException erro) {
             System.out.println("Erro : " + erro);
         }
         return ListaFerramentas;
     }
     
     public static void setListaFerramentas(ArrayList<Ferramenta> ListaFerramentas){
         FerramentaDAO.ListaFerramentas = ListaFerramentas;
     }
     
     public int MaiorIdFerramentas(){
         int MaiorIdFerramentas = 0;
         try {
             Statement smt = ut.getConexao().createStatement();
             ResultSet res = smt.executeQuery("select MAX(IdFerramentas)IdFerramentas from tb_ferramentas");
             res.next();
             MaiorIdFerramentas = res.getInt("IdFerramentas");
             smt.close();
            } catch (SQLException erro) {
                System.out.println("Erro : " + erro);
            }
         return MaiorIdFerramentas;
     }
     public boolean InsertFerramentaDB(Ferramenta ferramenta){
         String res = "insert into tb_ferramentas(IdFerramentas,NomeFerramentas,MarcaFerramentas,CustoFerramentas,DisponibilidadeFerramentas) values (?,?,?,?,?)";
         try {
             PreparedStatement smt = ut.getConexao().prepareCall(res);
             smt.setInt(1,ferramenta.getIdFerramentas());
             smt.setString(2,ferramenta.getNomeFerramentas());
             smt.setString(3,ferramenta.getMarcaFerramentas());
             smt.setDouble(4,ferramenta.getCustoFerramentas());
             smt.setBoolean(5, true);
             smt.execute();
             smt.close();
             return true;
         } catch (SQLException erro) {
             System.out.println("Erro : " + erro);
             throw new RuntimeException(erro);
         }
     }
     public boolean UpdateFerramentaDB(Ferramenta ferramenta){
         String res = "update tb_ferramentas set IdFerramentas=?,NomeFerramentas=?,MarcaFerramentas=?,CustoFerramentas=?,DisponibilidadeFerramentas=? where IdFerramentas=?";
         try {
             PreparedStatement smt = ut.getConexao().prepareCall(res);
             smt.setInt(1,ferramenta.getIdFerramentas());
             smt.setString(2,ferramenta.getNomeFerramentas());
             smt.setString(3,ferramenta.getMarcaFerramentas());
             smt.setDouble(4,ferramenta.getCustoFerramentas());
             smt.setBoolean(5, ferramenta.getDisponibilidadeFerramenta());
             smt.setInt(6,ferramenta.getIdFerramentas());
             smt.execute();
             smt.close();
             return true;
         } catch (SQLException erro) {
             System.out.println("Erro : " + erro);
             throw new RuntimeException(erro);
         }
             
         }
     public boolean DeleteFerramentaDB(int IdFerramentas){
         try {
             Statement smt = ut.getConexao().createStatement();
             int res = smt.executeUpdate(("delete from tb_ferramentas where IdFerramentas=" + IdFerramentas));
             smt.close();
         } catch (SQLException erro) {
             System.out.println("Erro : " + erro);
             throw new RuntimeException(erro);
         }
         return true;
      }
}
     
     
