import java.util.ArrayList;

public class Pizza {
    int id;
    char tamanho;
    Sabor sabor;
    Comanda comanda;

    public static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    public Pizza (int id, char tamanho, Sabor sabor, Comanda comanda) {
        this.id = id;
        this.tamanho = tamanho;
        this.sabor = sabor;

        pizzas.add(this);

        comanda.pizzas.add(this);
    }

    public static void ListarPizzas() {
        for (Pizza pizza : pizzas) {
            System.out.println(
                "ID: " + pizza.id + "\n"
                + " Tamanho: " + pizza.tamanho + "\n"
                + " Sabor: " + pizza.sabor.descricao + "\n"
                + " Comanda: " + pizza.comanda.numero
            );
        }
    }
}
