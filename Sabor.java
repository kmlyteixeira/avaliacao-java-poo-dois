import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Sabor {
    int id;
    String descricao;
    String detalhamento;

    public static ArrayList<Sabor> sabores = new ArrayList<Sabor>();

    public Sabor (int id, String descricao, String detalhamento){
        this.id = id;
        this.descricao = descricao;
        this.detalhamento = detalhamento;

        sabores.add(this);
    }

    public static void ListarSabores() {
        for (Sabor sabor : sabores) {
            System.out.println(
                "ID: " + sabor.id + "\n"
                + " Descrição: " + sabor.descricao + "\n"
                + " Detalhamento: " + sabor.detalhamento
            );
        }

        try {
            PrintWriter criaArq = new PrintWriter(new File("ArquivosCSV/Sabores.csv"));
            
            for (Sabor sabor : sabores) {
                criaArq.println(sabor.id+ ";" +sabor.descricao+";"+sabor.detalhamento);
            }

            criaArq.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar Arquivo CSV:" + e.getMessage());
        }
    }

    public static Sabor verificaIdSabor(int id) throws Exception {

        FileReader fr = new FileReader("ArquivosCSV/Sabores.csv");
        try (BufferedReader reader = new BufferedReader(fr)) {
            String linha = reader.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                if (Integer.parseInt(dados[0]) == id) {
                    return new Sabor(Integer.parseInt(dados[0]), dados[1], dados[2]);
                }
                linha = reader.readLine();
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler Arquivo CSV:" + e.getMessage());
        }

        throw new Exception("Sabor não encontrado");
    } 
}
