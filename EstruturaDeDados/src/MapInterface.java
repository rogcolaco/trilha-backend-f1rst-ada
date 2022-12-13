import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class MapInterface {

    Map<String,String> informacoes = new HashMap<>();
    Scanner s = new Scanner(System.in);

    public String Menu(){
        System.out.println("Gostaria de acrescentar mais informações ?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        String opcao = s.nextLine();
//        s.nextLine();
        return opcao;
    }

    public void InformarDados(){
        System.out.println("Informe o título do dado: ");
        String key = s.nextLine();
        System.out.println("Informe o valor do dado: ");
        String value = s.nextLine();
        this.informacoes.put(key, value);
    }

    public void ImprimirDados(){
        this.informacoes.forEach((key,value) -> {
        System.out.println("Título: " + key + "\t\tDado: " + value);
        });

        for(Entry<String, String> entry: this.informacoes.entrySet()) {
            System.out.print("Titulo: " + entry.getKey() + "\t\tValor: " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        MapInterface m = new MapInterface();

//        m.InformarDados();
//        String opcao = m.Menu();
//        while(opcao.equals("1") ){
//            m.InformarDados();
//            opcao = m.Menu();
//        }

        String opcao = "";
        do {
            m.InformarDados();
            opcao = m.Menu();
        } while (opcao.equals("1"));
        m.ImprimirDados();
    }
}
