package modelo;

import dao.EmprestimoDAO;
import java.util.ArrayList;

public class Emprestimo {

    private String nome;
    private int id;
    private int date;
  
  public Emprestimo() {
    
        this("", 0, "", 0);
    }

    public Emprestimo(String nome, int id, String email, int telefone) {
        this.nome = nome;
        this.id = id;
        this.date = date;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
public String getDate() {
        return nome;
    }

    public void setDate(String nome) {
        this.nome = nome;
    }
public ArrayList<Emprestimo> getListaEmprestimo() {
        return EmprestimoDAO.getListaEmprestimo();
    }
    
 //Cadastrar novo Emprestimo
    public boolean insertEmprestimoBD(String Nome, int Id, String email, int date) {
        int id = this.maiorID() + 1;
        Emprestimo objeto = new Emprestimo(Nome, Id, email, date);
        EmprestimoDAO.ListaEmprestimo.add(objeto);
        return true;
    }
 //Retorna o maior ID da base de dados
    public int maiorID() {
        return EmprestimoDAO.maiorID();

    }
}

