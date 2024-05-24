package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

public class Ferramenta {
    
    private int IdFerramentas;
    private String NomeFerramenta;
    private String Marca;
    private int Custo;
    private FerramentaDAO dao;
    
    // Construtores
    
    public Ferramenta(){
        this (0, "", "", 0);
    }
    
    public Ferramenta (int IdFerramentas, String NomeFerramenta, String Marca, int Custo){
        this.IdFerramentas = IdFerramentas;
        this.NomeFerramenta = NomeFerramenta;
        this.Marca = Marca;
        this.Custo = Custo;
        this.dao = new FerramentaDAO();
    }
    
    // Getters and Setters
    
    public int getIdFerramentas() {
        return IdFerramentas;
    }

    public void setIdFerramentas(int IdFerramentas) {
        this.IdFerramentas = IdFerramentas;
    }

    public String getNomeFerramenta() {
        return NomeFerramenta;
    }

    public void setNomeFerramenta(String NomeFerramenta) {
        this.NomeFerramenta = NomeFerramenta;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getCusto() {
        return Custo;
    }

    public void setCusto(int Custo) {
        this.Custo = Custo;
    }   
    
    // Chama a lista de ferramentas
     
    public ArrayList<Ferramenta> getListaFerramenta() {
        return dao.getListaFerramenta();
    }
    
    // Cadastrar nova ferramenta
    
    public boolean insertFerramentaBD(String NomeFerramenta, String Marca, int Valor) {
        int IdFerramentas = this.maiorIdFerramenta() + 1;
        Ferramenta objeto = new Ferramenta(IdFerramentas, NomeFerramenta, Marca, Valor);
        dao.insertFerramentaBD(objeto);
        return true;
    }

    // Deleta uma ferramenta
    
    public boolean deleteFerramentaBD(int IdFerramentas) {
        int indice = this.procuraIndice(IdFerramentas);
        dao.deleteFerramentaBD(indice);
        return true;
    }

    // Editar ferramenta
     
    public boolean updateFerramentaBD(int IdFerramenta, String NomeFerramenta, String Marca, int Valor) {
        Ferramenta objeto = new Ferramenta(IdFerramenta, NomeFerramenta, Marca, Valor);
        int indice = this.procuraIndice(IdFerramenta);
        dao.ListaFerramenta.set(indice, objeto);
        return true;
    }

    // Procura o INDICE de objeto da ListaFerramenta que contem o ID enviado.
     
    private int procuraIndice(int IdFerramenta) {
        int indice = -1;
        for (int i = 0; i < dao.ListaFerramenta.size(); i++) {
            if (dao.ListaFerramenta.get(i).getIdFerramentas() == IdFerramenta) {
                indice = i;
            }
        }
        return indice;
    }
    
    // Carrega dados de uma ferramenta específica pelo seu ID
     
    public Ferramenta carregaFerramenta(int IdFerramenta) {
        int indice = this.procuraIndice(IdFerramenta);
        return dao.ListaFerramenta.get(indice);
    }
    
    // Retorna o maior ID da base de dados
     
    public int maiorIdFerramenta(){
        return dao.maiorIdFerramentas();
    }    
}
