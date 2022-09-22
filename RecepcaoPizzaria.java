import java.util.Scanner;

public class RecepcaoPizzaria {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int op = 0, idCliente = 0, idSabor = 0, idComanda = 0, idPizza = 0;

        do {
            System.out.println("==== / PIZZARIA DO SEU ZÉ / ====");
            System.out.println("01 - Cadastrar Cliente");
            System.out.println("02 - Listar Clientes");
            System.out.println("03 - Cadastrar Sabor");
            System.out.println("04 - Listar Sabores");
            System.out.println("05 - Cadastrar Comanda");
            System.out.println("06 - Listar Comandas");
            System.out.println("07 - Encerrar");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("==== / CADASTRO DE CLIENTE / ====");
                    idCliente++;
                    System.out.println("Insira o nome do cliente: ");
                    String nome = sc.next();
                    System.out.println("Insira o CPF do cliente: ");
                    String cpf = sc.next();
                    System.out.println("Insira o telefone do cliente: ");
                    String telefone = sc.next();
                    System.out.println("Insira o endereço do cliente: ");
                    String endereco = sc.next();

                    Cliente cliente = new Cliente(idCliente ,nome, cpf, telefone, endereco);

                    System.out.println("Cliente "+ cliente.nome +" cadastrado com sucesso!");

                    break;
                case 2:
                    System.out.println("==== / LISTA DE CLIENTES / ====");
                    Cliente.ListarClientes();
                    break;
                case 3:
                    System.out.println("==== / CADASTRO DE SABOR / ====");
                    idSabor++;
                    System.out.println("Insira a descrição do sabor: ");
                    String descricao = sc.next();
                    System.out.println("Insira o detalhamento do sabor: ");
                    String detalhamento = sc.next();

                    Sabor sabor = new Sabor(idSabor, descricao, detalhamento);

                    System.out.println("Sabor "+ sabor.descricao +"cadastrado com sucesso!");
                    break;
                case 4:
                    System.out.println("==== / LISTA DE SABORES / ====");
                    Sabor.ListarSabores();
                    break;
                case 5:
                    try {
                        System.out.println("==== / CADASTRO DE COMANDA / ====");
                        idComanda++;
                        System.out.println("Insira o número da comanda: ");
                        int numero = sc.nextInt();
                        System.out.println("Insira a data da comanda: ");
                        String data = sc.next();
                        System.out.println("Insira o ID do cliente: ");
                        int idClienteComanda = sc.nextInt();
                        Cliente clienteComanda = Cliente.verificaIdCliente(idClienteComanda);
                        Comanda comanda = new Comanda(idComanda, numero, data, clienteComanda);

                        System.out.println("Quantas pizzas deseja adicionar?");
                        int qtdPizzas = sc.nextInt();
                        for (int i = 0; i < qtdPizzas; i++) {
                            idPizza++;
                            System.out.println("Insira o tamanho da pizza: [P]equena, [M]édia, [G]rande");
                            char tamanho = sc.next().charAt(0);
                            System.out.println("Insira o ID do sabor: ");
                            int idSaborComanda = sc.nextInt();
                            Sabor saborPizza = Sabor.verificaIdSabor(idSaborComanda);
                            Pizza pizza = new Pizza(idPizza,tamanho,saborPizza, comanda);
                        }

                        System.out.println("Comanda "+ comanda.numero +" cadastrada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro de cadastro:" + e.getMessage());
                        break;
                    }
                    break;
                case 6:
                    System.out.println("==== / LISTA DE COMANDAS / ====");

                    for (Comanda comanda : Comanda.comandas) {
                        System.out.println(
                            "ID: " + comanda.id + "\n"
                            + " Número: " + comanda.numero + "\n"
                            + " Data: " + comanda.data + "\n"
                            + " Cliente: " + comanda.cliente.nome + "\n"
                            + " Quantidade de Pizzas: " + comanda.pizzas.size()
                        );
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 7);
        sc.close();
    }
}