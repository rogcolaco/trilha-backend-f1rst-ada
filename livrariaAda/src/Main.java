import Modelo.Produto.Livro;
import Enum.GeneroLivro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Livro l = new Livro();
        List<GeneroLivro> lista = new ArrayList<>();
        lista.add(GeneroLivro.DIDATICO);
        lista.forEach(c -> System.out.println(c));
    }
}
