import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mapas {

    static Map<String, Map<String,String>> alunos = new TreeMap<>();

    public static void adicionarContato(String nomeAluno, Map.Entry<String,String>... novosContatos){
        if(!alunos.containsKey(nomeAluno)){
            alunos.put(nomeAluno, new LinkedHashMap<>());
        }

        Map<String,String> contatos = alunos.get(nomeAluno);

        for (Map.Entry<String, String> novosContato : novosContatos) {
            contatos.put(novosContato.getKey(), novosContato.getValue());
        }
    }


    public static void main(String[] args) {

        LinkedHashMap<String, String> contatoRogerio = new LinkedHashMap<>();
        adicionarContato("Rogério", Map.entry("Telefone", "16123456"),
                Map.entry("Email", "teste@teste"),
                Map.entry("End", "Rua dos Limoeiros"));

        LinkedHashMap<String, String> contatoAna = new LinkedHashMap<>();
        alunos.put("Ana", contatoAna);
        contatoAna.put("Email", "email@teste");
        contatoAna.put("End", "Rua dos Tomates");
        contatoAna.put("Telefone", "654123");

        LinkedHashMap<String, String> contatoMarcos = new LinkedHashMap<>();
        alunos.put("Marcos", contatoMarcos);
        contatoMarcos.put("End", "Rua das Rosas");
        contatoMarcos.put("Email", "email@mail");
        contatoMarcos.put("Celular", "654123");

        alunos.forEach((key, value) -> {
            System.out.println(key);
            value.forEach((contatoKey, contatoValue) -> System.out.println("\t" + contatoKey + "\t " + contatoValue));
            System.out.println("\n");
        });

    }
}
