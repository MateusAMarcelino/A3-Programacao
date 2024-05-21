package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    private String nome;
    private int Id;
    private String email;
    private int telefone;
    //objeto manipulado pelo amigo
    private AmigoDAO dao;

    //Construtores
    public Amigo() {
        
        this(0, "", 0, "");
    }

    public Amigo(int Id, String nome, int telefone, String email) {
        this.Id = Id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dao = new AmigoDAO();
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Amigo> getListaAmigo() {
        return dao.getListaAmigo();
    }

    //Cadastrar nova ferramenta
    public boolean insertAmigoBD(String Nome, int telefone, String email) {
        int Id = this.maiorID() + 1;
        Amigo objeto = new Amigo(Id, Nome, telefone, email);
        dao.insertAmigoBD(objeto);
        return true;
    }

    //Deleta uma ferramenta
    public boolean deleteAmigoBD(int id) {
        int indice = this.procuraIndice(id);
        dao.deleteAmigoBD(indice);
        return true;
    }

    //Editar ferramenta
    public boolean updateAmigoBD(int Id, String Nome, int telefone, String email) {
        Amigo objeto = new Amigo(Id, Nome, telefone, email);
        dao.updateAmigoBD(objeto);
        return true;
    }

    //Procura o INDICE de objeto da ListaFerramenta que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < dao.ListaAmigo.size(); i++) {
            if (dao.ListaAmigo.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    //Carrega dados de uma ferramenta especÍfica pelo seu ID
    public Amigo carregaAmigo(int id) {
        return dao.carregaAmigo(id);
    }

    //Retorna o maior ID da base de dados
    public int maiorID() {
        return dao.maiorID();

    }
}
