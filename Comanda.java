import java.util.ArrayList;

public class Comanda {
    int id;
    int numero;
    String data;
    Cliente cliente;
    ArrayList<Pizza> pizzas;

    public static ArrayList<Comanda> comandas = new ArrayList<Comanda>();

    public Comanda (int id, int numero, String data, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.pizzas = new ArrayList<Pizza>();

        comandas.add(this);
    }

    public static void ListarComandas() {
        for (Comanda comanda : comandas) {
            System.out.println(
                "ID: " + comanda.id + "\n"
                + " Número: " + comanda.numero + "\n"
                + " Data: " + comanda.data + "\n"
                + " Cliente: " + comanda.cliente.nome + "\n"
                + " Quantidade de Pizzas: " + comanda.pizzas.size() + "\n"
                + " Pizzas: " + comanda.pizzas.toString()
            );
        }
    }

}
