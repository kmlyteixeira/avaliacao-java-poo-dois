import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Cliente {
    int id;
    String nome;
    String cpf;
    String telefone;
    String endereco;

    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Cliente (int id, String nome, String cpf, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;

        clientes.add(this);

    }

    public static void ListarClientes() {

        for (Cliente cliente : clientes) {
            System.out.println(
                "ID: " + cliente.id + "\n"
                + " Nome: " + cliente.nome + "\n"
                + " CPF: " + cliente.cpf + "\n"
                + " Telefone: " + cliente.telefone + "\n"
                + " Endereço: " + cliente.endereco
            );
        }

        try {
            PrintWriter criaArq = new PrintWriter(new File("ArquivosCSV/Clientes.csv"));
            
            for (Cliente cliente : clientes) {
                criaArq.println(cliente.id+ ";" +cliente.nome+";"+cliente.cpf+";"+cliente.telefone+";"+cliente.endereco);
            }

            criaArq.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar Arquivo CSV:" + e.getMessage());
        }
    }

    public static Cliente verificaIdCliente(int id) throws Exception {
        for (Cliente cliente : clientes) {
            if (cliente.id == id) {
                return cliente;
            }
        }
  
        throw new Exception("Cliente não encontrado");
    }     
}
