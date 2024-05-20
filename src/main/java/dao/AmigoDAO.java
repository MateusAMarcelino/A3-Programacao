package dao;

import java.util.ArrayList;
import modelo.Amigo;

public class AmigoDAO {

    //Cria ArrayList de Amigos:
    public static ArrayList<Amigo> ListaAmigo = new ArrayList<>();

    //Métodos Getter e Setter da ArrayList Amigos
    public static ArrayList<Amigo> getListaAmigo() {
        return ListaAmigo;
    }

    public static void setListaAmigo(ArrayList<Amigo> ListaAmigo) {
        AmigoDAO.ListaAmigo = ListaAmigo;
    }

    //Método para buscar maior ID
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
