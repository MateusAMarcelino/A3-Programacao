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
     
    public static ArrayList<Ferramenta> ListaFerramentas = new ArrayList<>();
    
    
    
     public Connection getConexaoFerramenta() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_a3";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;

        } catch (ClassNotFoundException erro) {
            System.out.println("O driver não foi encontrado. " + erro.getMessage());
            return null;
        } catch (SQLException erro) {
            System.out.println("Não foi possível conectar...");
            return null;
        }
    }
     
     public ArrayList<Ferramenta> getListaFerramentas(){
         ListaFerramentas.clear();
         try {
             Statement smt = this.getConexaoFerramenta().createStatement();
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
             Statement smt = this.getConexaoFerramenta().createStatement();
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
             PreparedStatement smt = this.getConexaoFerramenta().prepareCall(res);
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
             PreparedStatement smt = this.getConexaoFerramenta().prepareCall(res);
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
             Statement smt = this.getConexaoFerramenta().createStatement();
             int res = smt.executeUpdate(("delete from tb_ferramentas where IdFerramentas=" + IdFerramentas));
             smt.close();
         } catch (SQLException erro) {
             System.out.println("Erro : " + erro);
             throw new RuntimeException(erro);
         }
         return true;
      }
}
     
     
