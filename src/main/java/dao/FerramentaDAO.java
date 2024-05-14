package dao;

import java.util.ArrayList;
import model.Ferramenta;

public class FerramentaDAO {
    
     public static ArrayList<Ferramenta> ListaFerramenta = new ArrayList<>();

    public static ArrayList<Ferramenta> getListaFerramenta() {
        return ListaFerramenta;
    }

    public static void setListaFerramenta(ArrayList<Ferramenta> ListaFerramenta) {
        FerramentaDAO.ListaFerramenta = ListaFerramenta;
    }

    public static int maiorID() {        
        int maiorID = 0;
        for (int i = 0; i < ListaFerramenta.size(); i++) {
            if (ListaFerramenta.get(i).getId() > maiorID) {
                maiorID = ListaFerramenta.get(i).getId();
            }
        }
        return maiorID;        
    } 
}
