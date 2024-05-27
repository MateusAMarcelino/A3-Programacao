package modelo;

import dao.EmprestimoDAO;
import java.util.ArrayList;

public class Emprestimo {

    private int idEmprestimo;
    private String nome;
    private int idFerramenta;
    private int date;
    private EmprestimoDAO dao;
  
  public Emprestimo() {
    
        this( 0, "", 0, 0);
    }

    public Emprestimo(int idEmprestimo, String nome, int idFerramenta, int date) {
        this.idEmprestimo = idEmprestimo;
        this.nome = nome;
        this.idFerramenta = idFerramenta;
        this.date = date;
        this.dao = new EmprestimoDAO();
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    
public String getDate() {
        return nome;
    }

    public void setDate(String nome) {
        this.nome = nome;
    }
    
    public void setIdFerramenta(int idFerramenta){
        this.idFerramenta = idFerramenta;
    }
    
    public int getIdFerramenta(){
        return idFerramenta;
    }
    
public ArrayList<Emprestimo> getListaEmprestimo() {
        return dao.getListaEmprestimo();
    }
    
 //Cadastrar novo Emprestimo
    public boolean insertEmprestimoBD(String nome, int idFerramenta, int date) {
        int idEmprestimo = this.maiorID() + 1;
        Emprestimo objeto = new Emprestimo(idEmprestimo, nome, idFerramenta, date);
        dao.ListaEmprestimo.add(objeto);
        return true;
    }
    
 //Retorna o maior ID da base de dados
    
    public int maiorID() {
        return dao.maiorID();

    }
    
    //deletar emprestimo
    
    public boolean deleteEmprestimoBD(int idEmprestimo) {
        int indice = this.procuraIndice(idEmprestimo);
        dao.ListaEmprestimo.remove(indice);
        return true;
    }
    
    // Editar emprestimo
     
    public boolean updateFerramentaBD(int idEmprestimo, String nome, int IdFerramenta, int date) {
        Emprestimo objeto = new Emprestimo(idEmprestimo, nome, IdFerramenta, date);
        int indice = this.procuraIndice(idEmprestimo);
        dao.ListaEmprestimo.set(indice, objeto);
        return true;
    }
    
    // Carrega dados de um emprestimo específico pelo seu ID
     
    public Emprestimo carregaEmprestimo(int idEmprestimo) {
        int indice = this.procuraIndice(idEmprestimo);
        return dao.ListaEmprestimo.get(indice);
    }
    
    // Procura o INDICE de objeto da ListaFerramenta que contem o ID enviado.
     
    private int procuraIndice(int idEmprestimo) {
        int indice = -1;
        for (int i = 0; i < dao.ListaEmprestimo.size(); i++) {
            if (dao.ListaEmprestimo.get(i).getIdEmprestimo() == idEmprestimo) {
                indice = i;
            }
        }
        return indice;
    }
}

