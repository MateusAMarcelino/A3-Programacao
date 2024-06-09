package modelo;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Ferramenta ferramenta;

    /**
     * Construtor para a classe Emprestimo, inicializa o empréstimo com IdAmigo do amigo, id da ferramenta e data do emprestimo.
     */
    public Emprestimo() {
        this(0, 0, 0, "", "");
    }

    /**
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
        this.ferramenta = new Ferramenta();
    }

    // Getter e Setter para IdAmigo
    public int getIdAmigo() {
        return IdAmigo;
    }

    public void setIdAmigo(int IdAmigo) {
        this.IdAmigo = IdAmigo;
    }

    // Getter e Setter para IdEmprestimo
    public int getIdEmprestimo() {
        return IdEmprestimo;
    }

    public void setIdEmprestimo(int IdEmprestimo) {
        this.IdEmprestimo = IdEmprestimo;
    }

    // Getter e Setter para dataEmp
    public String getDataEmp() {
        return dataEmp;
    }

    public void setDataEmp(String dataEmp) {
        this.dataEmp = dataEmp;
    }

    // Métodos adicionais
    

    public String getDataDev() {
        return dataDev;
    }

    public void setDataDev(String dataDev) {
        this.dataDev = dataDev;
    }

    

    public void setIdFerramentas(int IdFerramentas) {
        this.IdFerramentas = IdFerramentas;
    }

    public int getIdFerramentas() {
        return IdFerramentas;
    }

    public ArrayList<Emprestimo> ListaEmprestimo() {
        return dao.getListaEmprestimo();
    }

    public boolean insertEmprestimoBD(int IdAmigo, int IdFerramentas, String dataEmp) {
        int maiorID = dao.maiorIDEmprestimo() + 1;
        Emprestimo emprestimo = new Emprestimo(maiorID, IdAmigo, IdFerramentas, dataEmp, null);
        dao.insertEmprestimoBD(emprestimo);
        return true;
    }

    public int maiorID() {
        return dao.maiorIDEmprestimo();
    }

    public boolean deleteEmprestimoBD(int IdEmprestimo) {
        dao.deleteEmprestimoBD(IdEmprestimo);
        return true;
    }

  public boolean updateEmprestimoDB(int idEmprestimo, int idAmigo, int idFerramenta, String dataEmprestimo, String dataDevolucao) {
        Emprestimo emprestimo = new Emprestimo(idEmprestimo, idAmigo, idFerramenta, dataEmprestimo, dataDevolucao);
        int indice = this.procuraIndice(idEmprestimo);
        dao.updateEmprestimoBD(emprestimo);
        return true;
    }

    public Emprestimo RecuperaEmprestimoDB(int IdEmprestimo) {
        return dao.RecuperaEmprestimoDB(IdEmprestimo);
    }

    public int procuraIndice(int IdEmprestimo) {
        int indice = -1;
        for (int i = 0; i < dao.ListaEmprestimo.size(); i++) {
            if (dao.ListaEmprestimo.get(i).getIdEmprestimo() == IdEmprestimo) {
                indice = i;
            }
        }
        return indice;
    }

    public ArrayList<Emprestimo> getListaEmprestimoAtivo() {
        ArrayList<Emprestimo> listaEmprestimoAtivo = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList<Emprestimo> listaEmprestimo = this.ListaEmprestimo();

            for (Emprestimo emprestimo : listaEmprestimo) {
                if (emprestimo.getDataDev() == null) {
                    listaEmprestimoAtivo.add(emprestimo);
                } else {
                    java.util.Date dataDevolucaoUtil = sdf.parse(emprestimo.getDataDev());
                    java.sql.Date dataDevolucao = new java.sql.Date(dataDevolucaoUtil.getTime());

                    java.util.Date dataAtualUtil = new java.util.Date();
                    java.sql.Date dataAtual = new java.sql.Date(dataAtualUtil.getTime());

                    if (dataAtual.compareTo(dataDevolucao) < 0) {
                        listaEmprestimoAtivo.add(emprestimo);
                    }
                }
            }
        } catch (ParseException erro) {
            erro.printStackTrace(); // Log da exceção para depuração
        }
        return listaEmprestimoAtivo;
    }

    public String emprestimoAtivo(int idEmprestimo) {
        String ativo = "Não";
        Emprestimo emp = new Emprestimo();
        ArrayList<Emprestimo> listaEmprestimoAtivo = emp.getListaEmprestimoAtivo();
        for (Emprestimo emprestimo : listaEmprestimoAtivo) {
            if (emprestimo.getIdEmprestimo() == idEmprestimo) {
                ativo = "Sim";
            }
        }
        return ativo;
    }
}