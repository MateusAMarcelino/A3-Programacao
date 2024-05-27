package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

public class Ferramenta {
    
    private int IdFerramentas;
    private String NomeFerramentas;
    private String MarcaFerramenta;
    private double CustoFerramenta;
    private boolean DisponibilidadeFerramenta;
    FerramentaDAO dao;
    
public Ferramenta() {
    this(0,"","",0.0,true);
}

    public Ferramenta(int IdFerramentas, String NomeFerramentas, String MarcaFerramenta, double CustoFerramenta, boolean DisponibilidadeFerramenta) {
        this.IdFerramentas = IdFerramentas;
        this.NomeFerramentas = NomeFerramentas;
        this.MarcaFerramenta = MarcaFerramenta;
        this.CustoFerramenta = CustoFerramenta;
        this.DisponibilidadeFerramenta = DisponibilidadeFerramenta;
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

    public String getMarcaFerramenta() {
        return MarcaFerramenta;
    }

    public void setMarcaFerramenta(String MarcaFerramenta) {
        this.MarcaFerramenta = MarcaFerramenta;
    }

    public double getCustoFerramenta() {
        return CustoFerramenta;
    }

    public void setCustoFerramenta(double CustoFerramenta) {
        this.CustoFerramenta = CustoFerramenta;
    }

    public boolean isDisponibilidadeFerramenta() {
        return DisponibilidadeFerramenta;
    }

    public void setDisponibilidadeFerramenta(boolean DisponibilidadeFerramenta) {
        this.DisponibilidadeFerramenta = DisponibilidadeFerramenta;
    }
    
    public ArrayList<Ferramenta> ListaFerramenta(){
        return dao.getListaFerramenta();
    }
    public boolean InsertFerramentaDB(String NomeFerramenta, String MarcaFerramenta,double CustoFerramenta){
        int maiorID = dao.maiorIdFerramentas() +1;
        boolean DisponibilidadeFerramenta = true;
        Ferramenta ferramenta = new Ferramenta (maiorID, NomeFerramenta, MarcaFerramenta, CustoFerramenta,DisponibilidadeFerramenta);
        dao.insertFerramentaBD(ferramenta);
        return true;
    }
    
    public boolean DeleteFerramentaDB(int IdFerramentas) {
        dao.deleteFerramentaBD(IdFerramentas);
        return true;
    }
    private int procuraIndice(int IdFerramentas){
        int indice = -1;
        for (int i = 0; i < FerramentaDAO.ListaFerramenta.size(); i++ ) {
            if (FerramentaDAO.ListaFerramenta.get(i).getIdFerramentas() == IdFerramentas) {
                indice = i;
            } 
        }
        return indice;
    }
    public boolean updateFerramentaDB(int IdFerramenta,String NomeFerramenta, String MarcaFerramenta, double CustoFerramenta, boolean DisponibilidadeFerramenta){
        Ferramenta ferramenta = new Ferramenta (IdFerramenta, NomeFerramenta,MarcaFerramenta,CustoFerramenta,DisponibilidadeFerramenta);
        dao.updateFerramentaBD(ferramenta);
        return true;
    }
    public int MaiorId() {
        return dao.maiorIdFerramentas();
    }
}
