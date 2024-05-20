package dao;

import java.util.ArrayList;
import modelo.Ferramenta;

public class FerramentaDAO {

    //Cria ArrayList de Ferramentas
    public static ArrayList<Ferramenta> ListaFerramenta = new ArrayList<>();

    //Métodos Getter e Setter da ArrayList Ferramentas
    public static ArrayList<Ferramenta> getListaFerramenta() {
        return ListaFerramenta;
    }

    public static void setListaFerramenta(ArrayList<Ferramenta> ListaFerramenta) {
        FerramentaDAO.ListaFerramenta = ListaFerramenta;
    }

    //Método para buscar maior ID
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
