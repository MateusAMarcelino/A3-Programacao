package modelo;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;



/**
 * Classe do empréstimo, com IdEmprestimo, IdAmigo, IdFerramentas, dataEmp.
 */
public class Emprestimo {

    private int IdEmprestimo;
    private int IdAmigo;
    private int IdFerramentas;
    private String dataEmp;
    private String dataDev;
    private EmprestimoDAO dao;

    /**
     * Construtor para a classe Emprestimo, inicializa o empréstimo com IdAmigo do
     * amigo, id da ferramenta e data do emprestimo.
     */
  public Emprestimo() {
    
        this( 0, 0, 0, "", "");
    }

  /**
   * 
   * @param IdEmprestimo; Id do empréstimo feito.
   * @param IdAmigo; Nome do amigo fazendo o empréstimo.
   * @param IdFerramentas; Id da ferramenta emprestada.
   * @param dataEmp; Data do empréstimo
   */
    public Emprestimo(int IdEmprestimo, int IdAmigo, int IdFerramentas, String dataEmp, String dataDev) {
        this.IdEmprestimo = IdEmprestimo;
        this.IdAmigo = IdAmigo;
        this.IdFerramentas = IdFerramentas;
        this.dataEmp = dataEmp;
        this.dataDev = dataDev;
        this.dao = new EmprestimoDAO();
    }
    
    /**
     * Obtém o IdAmigo do amigo fazendo o empréstimo.
     * @return O IdAmigo do amigo.
     */
    public int getIdAmigo() {
        return IdAmigo;
    }

    /**
     * Define do IdAmigo do amigo fazendo o empréstimo.
     * @param IdAmigo; Nome do amigo a ser definido.
     */
    public void setIdAmigo(int IdAmigo) {
        this.IdAmigo = IdAmigo;
    }
    
    /**
     * Obtém o id do empréstimo realizado.
     * @return O id do empréstimo.
     */
    public int getIdEmprestimo() {
        return IdEmprestimo;
    }

    /**
     * Define o id do empréstimo realizado.
     * @param IdEmprestimo; O id do empréstimo a ser definido.
     */
    public void setIdEmprestimo(int IdEmprestimo) {
        this.IdEmprestimo = IdEmprestimo;
    }
    
    /**
     * Obtém a data em que o empréstimo foi feito.
     * @return A data do empréstimo.
     */
    public String getDataEmp() {
        return dataEmp;
    }

    /**
     * Define a data em que o empréstimo foi feito.
     * @param dataEmp; A data do empréstimo a ser definido.
     */
    public void setDataEmp(String dataEmp) {
        this.dataEmp = dataEmp;
    }
    
    public String getDataDev() {
     return dataDev;
    }
    
    public void setDataDev(String dataDev) {
        this.dataDev = dataDev;
    }
    
    /**
     * Define o id da ferramenta a ser emprestada.
     * @param IdFerramentas; O id da ferramenta a ser definido.
     */
    public void setIdFerramentas(int IdFerramentas){
        this.IdFerramentas = IdFerramentas;
    }
    
    /**
     * Obtém o id da ferramenta a ser emprestada.
     * @return O id da ferramenta.
     */
    public int getIdFerramentas(){
        return IdFerramentas;
    }
    
    /**
     * Obtém o ArrayList ListaEmprestimo, que contém os empréstimos realizados.
     * @return O ArrayList ListaEmprestimo.
     */
public ArrayList<Emprestimo> ListaEmprestimo() {
        return dao.getListaEmprestimo();
    }
    
 /**
  * Cadastra um novo empréstimo no banco de dados.
  * @param IdAmigo; Nome do amigo que está fazendo o empréstimo.
  * @param IdFerramentas; Id da ferramenta emprestada.
  * @param dataEmp; Data em que o empréstimo foi realizado.
  * @return True caso o empréstimo tiver sido cadastrado com sucesso, false caso tenha falhado.
  */
    public boolean insertEmprestimoBD(int IdAmigo, int IdFerramentas, String dataEmp) {
        int IdEmprestimo = this.maiorID() + 1;
        Emprestimo emprestimo = new Emprestimo(IdEmprestimo, IdAmigo, IdFerramentas, dataEmp, null);
        dao.insertEmprestimoBD(emprestimo);
        return true;
    }
    
 /**
  * Retorna o maior id dos empréstimos do banco de dados.
  * @return O id do empréstimo com maior id.
  */
    
    public int maiorID() {
        return dao.maiorIDEmprestimo();

    }
    
    /**
     * Deleta um empréstimo do banco de dados pelo seu id.
     * @param IdEmprestimo; Id do empréstimo a ser deletado.
     * @return True caso o empréstimo tiver sido deletado com sucesso, false caso tenha falhado.
     */
    
    public boolean deleteEmprestimoBD(int IdEmprestimo) {
        int indice = this.procuraIndice(IdEmprestimo);
        dao.ListaEmprestimo.remove(indice);
        return true;
    }
    
    /**
     * Atualiza as informações de um empréstimo dentro do banco de dados.
     * @param IdEmprestimo; Id do empréstimo sendo atualizado;
     * @param IdAmigo; Nome do amigo que fez o empréstimo.
     * @param IdFerramentas; Id da ferramenta emprestada;
     * @param dataEmp; Data em que o empréstimo foi realizado.
     * @return True caso o empréstimo tiver sido atualizado com sucesso, false caso tenha falhado.
     */
     
    public boolean updateEmprestimoBD(int IdEmprestimo, int IdAmigo, int IdFerramentas, String dataEmp, String dataDev) {
        Emprestimo objeto = new Emprestimo(IdEmprestimo, IdAmigo, IdFerramentas, dataEmp, dataDev);
        int indice = this.procuraIndice(IdEmprestimo);
        dao.updateEmprestimoBD(objeto);
        return true;
    }
    
    /**
     * Carrega as informações de um empréstimo específico pelo seu id.
     * @param IdEmprestimo; Id do empréstimo a ser carregado.
     * @return As informações do empréstimo procurado.
     */
     
    public Emprestimo carregaEmprestimo(int IdEmprestimo) {
        int indice = this.procuraIndice(IdEmprestimo);
        return dao.ListaEmprestimo.get(indice);
    }
    
    /**
     * Procura o INDICE de objeto da ListaEmprestimo que contém o id enviado.
     * @param IdEmprestimo; Id do empréstimo procurado.
     * @return O objeto do empréstimo com seus dados carregados, ou nada caso não tenha sido encontrado.
     */
     
    public int procuraIndice(int IdEmprestimo) {
        int indice = -1;
        for (int i = 0; i < dao.ListaEmprestimo.size(); i++) {
            if (dao.ListaEmprestimo.get(i).getIdEmprestimo() == IdEmprestimo) {
                indice = i;
            }
        }
        return indice;
    }
    
    public ArrayList<Emprestimo> getListaEmprestimoAtivo(){
        ArrayList<Emprestimo> listaEmprestimoAtivo = new ArrayList<>();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList<Emprestimo> ListaEmprestimo = this.ListaEmprestimo();
            
            for (int i = 0; i < ListaEmprestimo.size(); i++) {
                
            if (ListaEmprestimo.get(i).getDataDev() == null) {
                listaEmprestimoAtivo.add(ListaEmprestimo.get(i));
            }
            
            if (ListaEmprestimo.get(i).getDataDev() != null) {
                Date dataDevo = (Date) sdf.parse(ListaEmprestimo.get(i).getDataDev());
                java.util.Date dataAtual = sdf.parse(LocalDate.now() + "");
                
                if ( dataAtual.compareTo(dataDevo)  < 0) {
                    listaEmprestimoAtivo.add(ListaEmprestimo.get(i));
                }
            }
}
            } catch (ParseException ex) {
               
        }
        return listaEmprestimoAtivo;
    }
    
    public String emprestimoAtivo(int IdEmprestimo){
        String ativo = "Não";
        Emprestimo emp = new Emprestimo();
        ArrayList<Emprestimo> listaEmprestimoAtivo = emp.getListaEmprestimoAtivo();
        for (int i = 0; i < listaEmprestimoAtivo.size(); i++) {
            if (listaEmprestimoAtivo.get(i).getIdEmprestimo() == IdEmprestimo){
                ativo = "Sim";
            }
        }
    return ativo;
    }
    
}

