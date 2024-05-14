package dao;

import java.util.ArrayList;
import model.Amigo;

public class AmigoDAO {

    public static ArrayList<Amigo> ListaAmigo = new ArrayList<>();

    public static ArrayList<Amigo> getListaAmigo() {
        return ListaAmigo;
    }

    public static void setListaAmigo(ArrayList<Amigo> ListaAmigo) {
        AmigoDAO.ListaAmigo = ListaAmigo;
    }

    public static int maiorID() {
        int maiorID = 0;
        for (int i = 0; i < ListaAmigo.size(); i++) {
            if (ListaAmigo.get(i).getId() > maiorID) {
                maiorID = ListaAmigo.get(i).getId();
            }
        }
        return maiorID;
    }
}
