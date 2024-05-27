package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

public class Ferramenta {
    
    private int IdFerramentas;
    private String NomeFerramentas;
    private String MarcaFerramentas;
    private double CustoFerramentas;
    private boolean DisponibilidadeFerramentas;
    FerramentaDAO dao;
    
public Ferramenta() {
    this(0,"","",0.0,true);
}

    public Ferramenta(int IdFerramentas, String NomeFerramentas, String MarcaFerramentas, double CustoFerramentas, boolean DisponibilidadeFerramentas) {
        this.IdFerramentas = IdFerramentas;
        this.NomeFerramentas = NomeFerramentas;
        this.MarcaFerramentas = MarcaFerramentas;
        this.CustoFerramentas = CustoFerramentas;
        this.DisponibilidadeFerramentas = DisponibilidadeFerramentas;
        this.dao = new FerramentaDAO();
    }

    public int getIdFerramentas() {
        return IdFerramentas;
    }

    public void setIdFerramentas(int IdFerramentas) {
        this.IdFerramentas = IdFerramentas;
    }

    public String getNomeFerramentas() {
        return NomeFerramentas;
    }

    public void setNomeFerramentas(String NomeFerramentas) {
        this.NomeFerramentas = NomeFerramentas;
    }

    public String getMarcaFerramentas() {
        return MarcaFerramentas;
    }

    public void setMarcaFerramentas(String MarcaFerramentas) {
        this.MarcaFerramentas = MarcaFerramentas;
    }

    public double getCustoFerramentas() {
        return CustoFerramentas;
    }

    public void setCustoFerramenta(double CustoFerramentas) {
        this.CustoFerramentas = CustoFerramentas;
    }

    public boolean isDisponibilidadeFerramenta() {
        return DisponibilidadeFerramentas;
    }

    public void setDisponibilidadeFerramenta(boolean DisponibilidadeFerramentas) {
        this.DisponibilidadeFerramentas = DisponibilidadeFerramentas;
    }
    
    public ArrayList<Ferramenta> ListaFerramenta(){
        return dao.getListaFerramentas();
    }
    public boolean InsertFerramentaDB(String NomeFerramenta, String MarcaFerramenta,double CustoFerramenta){
        int maiorID = dao.MaiorIdFerramentas() +1;
        boolean DisponibilidadeFerramenta = true;
        Ferramenta ferramenta = new Ferramenta (maiorID, NomeFerramenta, MarcaFerramenta, CustoFerramenta,DisponibilidadeFerramenta);
        dao.InsertFerramentaDB(ferramenta);
        return true;
    }
    
    public boolean DeleteFerramentaDB(int IdFerramentas) {
        dao.DeleteFerramentaDB(IdFerramentas);
        return true;
    }
    private int procuraIndice(int IdFerramentas){
        int indice = -1;
        for (int i = 0; i < FerramentaDAO.ListaFerramentas.size(); i++ ) {
            if (FerramentaDAO.ListaFerramentas.get(i).getIdFerramentas() == IdFerramentas) {
                indice = i;
            } 
        }
        return indice;
    }
    public boolean updateFerramentaDB(int IdFerramenta,String NomeFerramenta, String MarcaFerramenta, double CustoFerramenta, boolean DisponibilidadeFerramenta){
        Ferramenta ferramenta = new Ferramenta (IdFerramenta, NomeFerramenta,MarcaFerramenta,CustoFerramenta,DisponibilidadeFerramenta);
        dao.UpdateFerramentaDB(ferramenta);
        return true;
    }
    public int MaiorId() {
        return dao.MaiorIdFerramentas();
    }
}
