package dao;

import java.util.ArrayList;
import model.Emprestimo;

public class EmprestimoDAO {
    
    public static ArrayList<Emprestimo> ListaEmprestimo = new ArrayList<>();

    public static ArrayList<Emprestimo> getListaEmprestimo() {
        return ListaEmprestimo;
    }
    
    
    public static void setListaEmprestimo(ArrayList<Emprestimo> ListaEmprestimo) {
        EmprestimoDAO.ListaEmprestimo = ListaEmprestimo;
        
    }
     public static int maiorID() {
        int maiorID = 0;
        for (int i = 0; i < ListaEmprestimo.size(); i++) {
            if (ListaEmprestimo.get(i).getId() > maiorID) {
                maiorID = ListaEmprestimo.get(i).getId();
            }
        }
        return maiorID;
    }
    
}
