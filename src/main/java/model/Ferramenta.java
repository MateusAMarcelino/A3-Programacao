package model;

import dao.FerramentaDAO;
import java.util.ArrayList;

public class Ferramenta {
    
    private int Id;
    private String Nome;
    private String Marca;
    private int Valor;
    
    //Construtores
    
    public Ferramenta(){
        this (0, "", "", 0);
    }
    
    public Ferramenta (int Id, String Nome, String Marca, int Valor){
        this.Id = Id;
        this.Nome = Nome;
        this.Marca = Marca;
        this.Valor = Valor;
    }
    
    //Getters and Setters
    
     public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
    
     //Chama a lista de ferramentas
     
    public ArrayList<Ferramenta> getListaFerramenta() {
        return FerramentaDAO.getListaFerramenta();
    }
    
     //Cadastrar nova ferramenta
    
    public boolean insertFerramentaBD(String Nome, String Marca, int Valor) {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(Id, Nome, Marca, Valor);
        FerramentaDAO.ListaFerramenta.add(objeto);
        return true;
    }

     //Deleta uma ferramenta
    
    public boolean deleteFerramentaBD(int id) {
        int indice = this.procuraIndice(id);
        FerramentaDAO.ListaFerramenta.remove(indice);
        return true;
    }

    //Editar ferramenta
     
    public boolean updateFerramentaBD(int Id, String Nome, String Marca, int Valor) {
        Ferramenta objeto = new Ferramenta(Id, Nome, Marca,Valor);
        int indice = this.procuraIndice(Id);
        FerramentaDAO.ListaFerramenta.set(indice, objeto);
        return true;
    }

    
     //Procura o INDICE de objeto da ListaFerramenta que contem o ID enviado.
     
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < FerramentaDAO.ListaFerramenta.size(); i++) {
            if (FerramentaDAO.ListaFerramenta.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
    
    
     //Carrega dados de uma ferramenta especÍfica pelo seu ID
     
    public Ferramenta carregaFerramenta(int id) {
        int indice = this.procuraIndice(id);
        return FerramentaDAO.ListaFerramenta.get(indice);
    }
    
 
     //Retorna o maior ID da base de dados
     
    public int maiorID(){
        return FerramentaDAO.maiorID();
        
    }    
}
