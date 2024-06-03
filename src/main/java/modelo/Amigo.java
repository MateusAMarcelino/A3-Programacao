package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    private String nome;
    private int Id;
    private String email;
    private int telefone;
    private AmigoDAO dao;

/**
* Construtor para a classe Amigo, inicializa o amigo com nome, Id, email e telefone.
* 
* @param Id ; O Id do amigo.
* @param nome ; O Nome do amigo.
* @param telefone ; O número de Telefone do amigo.
* @param email ; O Email do amigo.
*/ 
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

/**
* Obtém o nome do amigo.
* 
* @return O nome do amigo.
*/
    public String getNome() {
        return nome;
    }

/**
* Define o nome do amigo.
* 
* @param nome ; O nome a ser definido.
*/
    public void setNome(String nome) {
        this.nome = nome;
    }

/**
* Obtém o Id do amigo.
* 
* @return O Id do amigo.
*/
    public int getId() {
        return Id;
    }

/**
* Define o Id do amigo.
* 
* @param Id ; O Id a ser definido.
*/
    public void setId(int Id) {
        this.Id = Id;
    }

/**
* Obtém o email do amigo.
* 
* @return O email do amigo.
*/
    public String getEmail() {
        return email;
    }

/**
* Define o email do amigo.
* 
* @param email ; O email a ser definido.
*/
    public void setEmail(String email) {
        this.email = email;
    }

/**
* Obtém o número de telefone do amigo.
* 
* @return O número de telefone do amigo.
*/
    public int getTelefone() {
        return telefone;
    }

/**
* Define o número de telefone do amigo.
* 
* @param telefone ; O número de telefone a ser definido.
*/
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

/**
* Retorna uma lista de todos os amigos.
* 
* @return Uma lista de objetos Amigo.
*/
    public ArrayList<Amigo> getListaAmigo() {
        return dao.getListaAmigo();
    }

/**
* Cadastra um novo amigo.
* 
* @param Nome ; O nome do amigo.
* @param telefone ; O número de telefone do amigo.
* @param email ; O email do amigo.
* @return true se o amigo foi inserido com sucesso, false caso contrário.
*/
    public boolean insertAmigoBD(String Nome, int telefone, String email) {
        int Id = this.maiorID() + 1;
        Amigo objeto = new Amigo(Id, Nome, telefone, email);
        dao.insertAmigoBD(objeto);
        return true;
    }

/**
* Deleta um amigo pelo ID.
* 
* @param id ; O ID do amigo a ser deletado.
* @return true se o amigo foi deletado com sucesso, false caso contrário.
*/
    public boolean deleteAmigoBD(int id) {
        int indice = this.procuraIndice(id);
        dao.deleteAmigoBD(indice);
        return true;
    }

/**
* Atualiza os dados de um amigo no banco de dados.
* 
* @param Id ; O ID do amigo.
* @param Nome ; O nome do amigo.
* @param telefone ; O número de telefone do amigo.
* @param email ; O email do amigo.
* @return true se os dados do amigo foram atualizados com sucesso, false caso contrário.
*/
    public boolean updateAmigoBD(int Id, String Nome, int telefone, String email) {
        Amigo objeto = new Amigo(Id, Nome, telefone, email);
        dao.updateAmigoBD(objeto);
        return true;
    }

/**
* Procura o INDICE de objeto da ListaFerramenta que contem o ID enviado.
* 
* @param id ; O ID do amigo.
* @return O objeto Amigo com os dados carregados, ou nada se não encontrado.
*/
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < dao.ListaAmigo.size(); i++) {
            if (dao.ListaAmigo.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

/**
* Carrega os dados de um amigo específico pelo seu ID.
* 
* @param id ; O Id do amigo.
* @return O objeto Amigo com os dados carregados, ou nada se não encontrado.
*/
    public Amigo carregaAmigo(int id) {
        return dao.carregaAmigo(id);
    }

/**
* Retorna o maior ID existente na base de dados.
* 
* @return O maior ID.
*/
    public int maiorID() {
        return dao.maiorID();

    }
}
