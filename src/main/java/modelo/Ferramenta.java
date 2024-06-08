package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

/**
 * Classe de ferramenta com ; id,nome,marca,custo,disponibilidade.
 *  
 */

public class Ferramenta {
    
    private int IdFerramentas;
    private String NomeFerramentas;
    private String MarcaFerramentas;
    private double CustoFerramentas;
    FerramentaDAO dao;
    
    
/**
 * Construtor para a classe Ferramenta, incializa a ferramenta com nome e custo,
 * define a marca como uma string vazia e tambem define a disponibilidade como 
 * verdadeira 
 * 
 
 */
    
public Ferramenta() {
    this(0,"","",0.0);
}

/**
 * 
 * @param IdFerramentas : O Id da ferramenta.
 * @param NomeFerramentas : O Nome da ferramenta.
 * @param MarcaFerramentas : A Marca da ferramenta.
 * @param CustoFerramentas : O Custo da ferramenta.
 * 
 * 
 * Inicializa todos com os valores inicias acima, que são :
 * Id = 0
 * NomeFerramentas = "" ( vazio )
 * MarcaFerramentas = "" ( vazio )
 * CustoFerramentas = 0
 * DisponibilidadeFerramentas = True ( Disponivel )
 */

    public Ferramenta(int IdFerramentas, String NomeFerramentas, String MarcaFerramentas, double CustoFerramentas) {
        this.IdFerramentas = IdFerramentas;
        this.NomeFerramentas = NomeFerramentas;
        this.MarcaFerramentas = MarcaFerramentas;
        this.CustoFerramentas = CustoFerramentas;
        this.dao = new FerramentaDAO();
    }

    
    /**
     * Obtém o Id da ferramenta.
     * @return o Id da ferramenta.
     */
    public int getIdFerramentas() {
        return IdFerramentas;
    }

    /**
     * Define o Id da ferramenta
     * 
     * @param IdFerramentas : O Id a ser definido.
     */
    public void setIdFerramentas(int IdFerramentas) {
        this.IdFerramentas = IdFerramentas;
    }
    /**
     * Obtém o Nome da ferramenta.
     * @return o Nome da ferramenta.
     */
    public String getNomeFerramentas() {
        return NomeFerramentas;
    }

    /**
     * Define o nome da ferramenta.
     * 
     * @param NomeFerramentas : O nome da ferramenta a ser definido.
     */
    public void setNomeFerramentas(String NomeFerramentas) {
        this.NomeFerramentas = NomeFerramentas;
    }
    /**
     * Obtém a Marca da ferramenta.
     * @return a Marca da ferramenta.
     */
    public String getMarcaFerramentas() {
        return MarcaFerramentas;
    }
    
    /**
     * Define a marca da ferramenta.
     * 
     * @param MarcaFerramentas  : A marca da ferramenta a ser definida.
     */
    public void setMarcaFerramentas(String MarcaFerramentas) {
        this.MarcaFerramentas = MarcaFerramentas;
    }
    /**
     * Obtém o Custo da ferramenta.
     * @return o Custo da ferramenta.
     */
    public double getCustoFerramentas() {
        return CustoFerramentas;
    }
    
    /**
     * Define o custo da ferramenta.
     * 
     * @param CustoFerramentas : O custo da ferramenta a ser definido.
     */
    public void setCustoFerramenta(double CustoFerramentas) {
        this.CustoFerramentas = CustoFerramentas;
    }
    
    
    /**
     * Obtém a Disponibilidade da ferramenta.
     * @return a Disponibilidade da ferramenta.
     */
    public boolean getDisponibilidadeFerramenta(int Id) {
    boolean disponivel = true; // Assume que a ferramenta está disponível por padrão
    
    Emprestimo emp = new Emprestimo();
    ArrayList<Emprestimo> listaEmprestimoAtivo = emp.getListaEmprestimoAtivo();
    
    for (int i = 0; i < listaEmprestimoAtivo.size(); i++) {
        if (listaEmprestimoAtivo.get(i).getIdFerramentas() == Id) {
            disponivel = false; // Se a ferramenta estiver emprestada, define disponível como falso
            break; // Sai do loop, já que encontrou um empréstimo ativo para a ferramenta
        }
    }
    
    return disponivel;
}
    
   public boolean updateFerramentaDB(int IdFerramenta, String NomeFerramenta, String MarcaFerramenta, double CustoFerramenta) {
    Ferramenta ferramenta = new Ferramenta(IdFerramenta, NomeFerramenta, MarcaFerramenta, CustoFerramenta);
    boolean atualizado = dao.UpdateFerramentaDB(ferramenta);
    if (atualizado) {
        System.out.println("Ferramenta atualizada com sucesso");
    } else {
        System.out.println("Erro ao atualizar a ferramenta");
    }
    return atualizado;
}

   
  
    
    public ArrayList<Ferramenta> ListaFerramenta(){
        return dao.getListaFerramentas();
    }
    
    /**
     * Insere uma ferramenta no Banco de dados, puxando os parametros com os Getters e Setters acima.
     * 
     * 
     * @param NomeFerramenta é o Nome da ferramenta.
     * @param MarcaFerramenta é a Marca da ferramenta.
     * @param CustoFerramenta é o Custo da ferramenta.
     * @return True, caso seja possivel inserir uma ferramenta.
     */
    public boolean InsertFerramentaDB(String NomeFerramenta, String MarcaFerramenta,double CustoFerramenta){
        int maiorID = dao.MaiorIdFerramentas() +1;
        
        Ferramenta ferramenta = new Ferramenta (maiorID, NomeFerramenta, MarcaFerramenta, CustoFerramenta);
        dao.InsertFerramentaDB(ferramenta);
        return true;
    }
    
    /**
     * Deleta uma ferramenta, pelo Id dela.
     * 
     * @param IdFerramentas é o Id da ferramenta.
     * @return True, caso seja possivel deletar uam ferramenta.
     */
    public boolean DeleteFerramentaDB(int IdFerramentas) {
        dao.DeleteFerramentaDB(IdFerramentas);
        return true;
    }
    
    /**
     * Procura o INDICE de objeto da ListaFerramenta que contem o ID enviado.
     * 
     * @param IdFerramentas : O id da ferramenta.
     * @return  O objeto da ferramenta com os dados carregados, ou nada se não encontrado.
     */
    private int procuraIndice(int IdFerramentas){
        int indice = -1;
        for (int i = 0; i < FerramentaDAO.ListaFerramentas.size(); i++ ) {
            if (FerramentaDAO.ListaFerramentas.get(i).getIdFerramentas() == IdFerramentas) {
                indice = i;
            } 
        }
        return indice;
    }

    
    /**
     * Atualiza as informações de uma ferramenta já existente.
     * 
     * @param IdFerramenta é o Id da ferramenta a ser atualizada.
     * @param NomeFerramenta é o Nome da ferramenta a ser atualizada.
     * @param MarcaFerramenta é a Marca da ferramenta a ser atualizada.
     * @param CustoFerramenta é o Custo da ferramenta a ser atualizada.
     * @param DisponibilidadeFerramenta é a Disponibilidade da ferramenta a ser atualizada.
     * @return True, caso seja possivel atualizar a ferramenta desejada.
     */
    
    
    public Ferramenta RecuperaFerramentaDB(int id) {
        return dao.RecuperaFerramentaDB(id);
    }
    
    /**
     * É um metodo para procurar o Maior id, entre todas as ferramentas existentes.
     * @return o Maior id, entre todas as ferramentas existentes.
     */
    public int MaiorId() {
        return dao.MaiorIdFerramentas();
    }
    
    
}