package modelo;

import dao.EmprestimoDAO;
import java.util.ArrayList;


/**
 * Classe do empréstimo, com idEmprestimo, nome, idFerramentas, dataEmp.
 */
public class Emprestimo {

    private int idEmprestimo;
    private String nome;
    private int idFerramentas;
    private int dataEmp;
    private EmprestimoDAO dao;

    /**
     * Construtor para a classe Emprestimo, inicializa o empréstimo com nome do
     * amigo, id da ferramenta e data do emprestimo.
     */
  public Emprestimo() {
    
        this( 0, "", 0, 0);
    }

  /**
   * 
   * @param idEmprestimo; Id do empréstimo feito.
   * @param nome; Nome do amigo fazendo o empréstimo.
   * @param idFerramentas; Id da ferramenta emprestada.
   * @param dataEmp; Data do empréstimo
   */
    public Emprestimo(int idEmprestimo, String nome, int idFerramentas, int dataEmp) {
        this.idEmprestimo = idEmprestimo;
        this.nome = nome;
        this.idFerramentas = idFerramentas;
        this.dataEmp = dataEmp;
        this.dao = new EmprestimoDAO();
    }
    
    /**
     * Obtém o nome do amigo fazendo o empréstimo.
     * @return O nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define do nome do amigo fazendo o empréstimo.
     * @param nome; Nome do amigo a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém o id do empréstimo realizado.
     * @return O id do empréstimo.
     */
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    /**
     * Define o id do empréstimo realizado.
     * @param idEmprestimo; O id do empréstimo a ser definido.
     */
    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    
    /**
     * Obtém a data em que o empréstimo foi feito.
     * @return A data do empréstimo.
     */
    public int getDataEmp() {
        return dataEmp;
    }

    /**
     * Define a data em que o empréstimo foi feito.
     * @param dataEmp; A data do empréstimo a ser definido.
     */
    public void setDataEmp(int dataEmp) {
        this.dataEmp = dataEmp;
    }
    
    /**
     * Define o id da ferramenta a ser emprestada.
     * @param idFerramentas; O id da ferramenta a ser definido.
     */
    public void setIdFerramentas(int idFerramentas){
        this.idFerramentas = idFerramentas;
    }
    
    /**
     * Obtém o id da ferramenta a ser emprestada.
     * @return O id da ferramenta.
     */
    public int getIdFerramentas(){
        return idFerramentas;
    }
    
    /**
     * Obtém o ArrayList ListaEmprestimo, que contém os empréstimos realizados.
     * @return O ArrayList ListaEmprestimo.
     */
public ArrayList<Emprestimo> getListaEmprestimo() {
        return dao.getListaEmprestimo();
    }
    
 /**
  * Cadastra um novo empréstimo no banco de dados.
  * @param nome; Nome do amigo que está fazendo o empréstimo.
  * @param idFerramentas; Id da ferramenta emprestada.
  * @param dataEmp; Data em que o empréstimo foi realizado.
  * @return True caso o empréstimo tiver sido cadastrado com sucesso, false caso tenha falhado.
  */
    public boolean insertEmprestimoBD(String nome, int idFerramentas, int dataEmp) {
        int idEmprestimo = this.maiorID() + 1;
        Emprestimo objeto = new Emprestimo(idEmprestimo, nome, idFerramentas, dataEmp);
        dao.ListaEmprestimo.add(objeto);
        return true;
    }
    
 /**
  * Retorna o maior id dos empréstimos do banco de dados.
  * @return O id do empréstimo com maior id.
  */
    
    public int maiorID() {
        return dao.maiorID();

    }
    
    /**
     * Deleta um empréstimo do banco de dados pelo seu id.
     * @param idEmprestimo; Id do empréstimo a ser deletado.
     * @return True caso o empréstimo tiver sido deletado com sucesso, false caso tenha falhado.
     */
    
    public boolean deleteEmprestimoBD(int idEmprestimo) {
        int indice = this.procuraIndice(idEmprestimo);
        dao.ListaEmprestimo.remove(indice);
        return true;
    }
    
    /**
     * Atualiza as informações de um empréstimo dentro do banco de dados.
     * @param idEmprestimo; Id do empréstimo sendo atualizado;
     * @param nome; Nome do amigo que fez o empréstimo.
     * @param IdFerramentas; Id da ferramenta emprestada;
     * @param dataEmp; Data em que o empréstimo foi realizado.
     * @return True caso o empréstimo tiver sido atualizado com sucesso, false caso tenha falhado.
     */
     
    public boolean updateFerramentaBD(int idEmprestimo, String nome, int IdFerramentas, int dataEmp) {
        Emprestimo objeto = new Emprestimo(idEmprestimo, nome, IdFerramentas, dataEmp);
        int indice = this.procuraIndice(idEmprestimo);
        dao.ListaEmprestimo.set(indice, objeto);
        return true;
    }
    
    /**
     * Carrega as informações de um empréstimo específico pelo seu id.
     * @param idEmprestimo; Id do empréstimo a ser carregado.
     * @return As informações do empréstimo procurado.
     */
     
    public Emprestimo carregaEmprestimo(int idEmprestimo) {
        int indice = this.procuraIndice(idEmprestimo);
        return dao.ListaEmprestimo.get(indice);
    }
    
    /**
     * Procura o INDICE de objeto da ListaEmprestimo que contém o id enviado.
     * @param idEmprestimo; Id do empréstimo procurado.
     * @return O objeto do empréstimo com seus dados carregados, ou nada caso não tenha sido encontrado.
     */
     
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

