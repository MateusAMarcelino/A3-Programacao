package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

public class Ferramenta {
    
    private int ID;
    private String Nome;
    private String Marca;
    private int Valor;
    private FerramentaDAO dao;
    
    // Construtores
    
    public Ferramenta(){
        this (0, "", "", 0);
    }
    
    public Ferramenta (int ID, String Nome, String Marca, int Valor){
        this.ID = ID;
        this.Nome = Nome;
        this.Marca = Marca;
        this.Valor = Valor;
        this.dao = new FerramentaDAO();
    }
    
    // Getters and Setters
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }   
    
    // Chama a lista de ferramentas
     
    public ArrayList<Ferramenta> getListaFerramenta() {
        return dao.getListaFerramenta();
    }
    
    // Cadastrar nova ferramenta
    
    public boolean insertFerramentaBD(String Nome, String Marca, int Valor) {
        int IdFerramenta = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(ID, Nome, Marca, Valor);
        dao.ListaFerramenta.add(objeto);
        return true;
    }

    // Deleta uma ferramenta
    
    public boolean deleteFerramentaBD(int id) {
        int indice = this.procuraIndice(id);
        dao.ListaFerramenta.remove(indice);
        return true;
    }

    // Editar ferramenta
     
    public boolean updateFerramentaBD(int ID, String Nome, String Marca, int Valor) {
        Ferramenta objeto = new Ferramenta(ID, Nome, Marca, Valor);
        int indice = this.procuraIndice(ID);
        dao.ListaFerramenta.set(indice, objeto);
        return true;
    }

    // Procura o INDICE de objeto da ListaFerramenta que contem o ID enviado.
     
    private int procuraIndice(int IdFerramenta) {
        int indice = -1;
        for (int i = 0; i < dao.ListaFerramenta.size(); i++) {
            if (dao.ListaFerramenta.get(i).getID() == IdFerramenta) {
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
     
    public int maiorID(){
        return dao.maiorID();
    }    
}
