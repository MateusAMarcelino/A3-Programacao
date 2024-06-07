package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;


/**
 * Classe do Amigo com ; NomeAmigo, IdAmigo, EmailAmigo, TelefoneAmigo.
 * 
 */
public class Amigo {

    private String NomeAmigo;
    private int IdAmigo;
    private String EmailAmigo;
    private int TelefoneAmigo;
    private AmigoDAO dao;


/**
 * Construtor para a classe Amigo, incializa o amigo com NomeAmigo e EmailAmigo sendo strings vazias, IdAmigo e TelefoneAmigo são iniciados com o valor 0.
 *  */
    public Amigo() {
        
        this(0, "", 0, "");
    }

    
   /**
    * 
    * @param IdAmigo
    * @param NomeAmigo
    * @param TelefoneAmigo
    * @param EmailAmigo
    * 
    * Inicializa todos com os valores iniciais acima, que são :
    * IdAmigo = 0
    * NomeAmigo = "" ( vazio )
    * TelefoneAmigo = 0
    * EmailAmigo = "" ( vazio )
    */ 
    public Amigo(int IdAmigo, String NomeAmigo, int TelefoneAmigo, String EmailAmigo) {
        this.IdAmigo = IdAmigo;
        this.NomeAmigo = NomeAmigo;
        this.TelefoneAmigo = TelefoneAmigo;
        this.EmailAmigo = EmailAmigo;
        this.dao = new AmigoDAO();
    }

/**
* Obtém o NomeAmigo do amigo.
* 
* @return O NomeAmigo do amigo.
*/
    public String getNome() {
        return NomeAmigo;
    }

/**
* Define o NomeAmigo do amigo.
* 
* @param NomeAmigo ; O NomeAmigo a ser definido.
*/
    public void setNome(String NomeAmigo) {
        this.NomeAmigo = NomeAmigo;
    }

/**
* Obtém o IdAmigo do amigo.
* 
* @return O IdAmigo do amigo.
*/
    public int getIdAmigo() {
        return IdAmigo;
    }

/**
* Define o IdAmigo do amigo.
* 
* @param IdAmigo ; O IdAmigo a ser definido.
*/
    public void setId(int IdAmigo) {
        this.IdAmigo = IdAmigo;
    }

/**
* Obtém o EmailAmigo do amigo.
* 
* @return O EmailAmigo do amigo.
*/
    public String getEmail() {
        return EmailAmigo;
    }

/**
* Define o EmailAmigo do amigo.
* 
* @param EmailAmigo ; O EmailAmigo a ser definido.
*/
    public void setEmail(String EmailAmigo) {
        this.EmailAmigo = EmailAmigo;
    }

/**
* Obtém o número de TelefoneAmigo do amigo.
* 
* @return O número de TelefoneAmigo do amigo.
*/
    public int getTelefone() {
        return TelefoneAmigo;
    }

/**
* Define o número de TelefoneAmigo do amigo.
* 
* @param TelefoneAmigo ; O número de TelefoneAmigo a ser definido.
*/
    public void setTelefone(int TelefoneAmigo) {
        this.TelefoneAmigo = TelefoneAmigo;
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
* @param Nome ; O NomeAmigo do amigo.
* @param TelefoneAmigo ; O número de TelefoneAmigo do amigo.
* @param EmailAmigo ; O EmailAmigo do amigo.
* @return true se o amigo foi inserido com sucesso, false caso contrário.
*/
    public boolean insertAmigoBD(String Nome, int TelefoneAmigo, String EmailAmigo) {
        int IdAmigo = this.maiorID() + 1;
        Amigo objeto = new Amigo(IdAmigo, Nome, TelefoneAmigo, EmailAmigo);
        dao.insertAmigoBD(objeto);
        return true;
    }

/**
* Deleta um amigo pelo ID.
* 
* @param IdAmigo ; O ID do amigo a ser deletado.
* @return true se o amigo foi deletado com sucesso, false caso contrário.
*/
    public boolean deleteAmigoBD(int IdAmigo) {
        //int indice = this.procuraIndice(IdAmigo);
        dao.deleteAmigoBD(IdAmigo);
        return true;
    }

/**
* Atualiza os dados de um amigo no banco de dados.
* 
* @param IdAmigo ; O ID do amigo.
* @param Nome ; O NomeAmigo do amigo.
* @param TelefoneAmigo ; O número de TelefoneAmigo do amigo.
* @param EmailAmigo ; O EmailAmigo do amigo.
* @return true se os dados do amigo foram atualizados com sucesso, false caso contrário.
*/
    public boolean updateAmigoBD(int IdAmigo, String Nome, int TelefoneAmigo, String EmailAmigo) {
        Amigo objeto = new Amigo(IdAmigo, Nome, TelefoneAmigo, EmailAmigo);
        dao.updateAmigoBD(objeto);
        return true;
    }

/**
* Procura o INDICE de objeto da ListaAmigo que contem o ID enviado.
* 
* @param IdAmigo ; O ID do amigo.
* @return O objeto Amigo com os dados carregados, ou nada se não encontrado.
*/
    private int procuraIndice(int IdAmigo) {
        int indice = -1;
        for (int i = 0; i < dao.ListaAmigo.size(); i++) {
            if (dao.ListaAmigo.get(i).getIdAmigo() == IdAmigo) {
                indice = i;
            }
        }
        return indice;
    }

/**
* Carrega os dados de um amigo específico pelo seu ID.
* 
* @param IdAmigo ; O IdAmigo do amigo.
* @return O objeto Amigo com os dados carregados, ou nada se não encontrado.
*/
    public Amigo carregaAmigo(int IdAmigo) {
        return dao.carregaAmigo(IdAmigo);
    }

/**
* Retorna o maior ID existente na base de dados.
* 
* @return O maior ID.
*/
    public int maiorID() {
        return dao.maiorID();

    }
  
    public boolean possuiEmprestimoAtivo(int IdAmigo) {
        boolean emprestimoAtivo = false;
        
        Emprestimo emp = new Emprestimo();
        
        ArrayList<Emprestimo> ListaEmprestimo = emp.getListaEmprestimoAtivo();
        
        for (int i = 0; i < ListaEmprestimo.size(); i++) {
            
            if(ListaEmprestimo.get(i).getIdAmigo() == IdAmigo) {
                emprestimoAtivo = true;
            }
        }
        return emprestimoAtivo;
    } 
    
    public int quantidadeEmprestimo(int IdAmigo) {
        int som = 0;
        Emprestimo emp = new Emprestimo();
        ArrayList<Emprestimo> ListaEmprestimo = emp.ListaEmprestimo();
        for (int i = 0; i < ListaEmprestimo.size(); i++) {
            if (ListaEmprestimo.get(i).getIdAmigo() == IdAmigo) {
                som++;
            }
        }
        return som;
    }
}
