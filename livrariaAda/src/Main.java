import Modelo.Estoque.EstoqueGenerico;
import Modelo.Produto.Brinquedo;

import Enum.TipoBrinquedo;

public class Main {
    public static void main(String[] args) {
        EstoqueGenerico<Brinquedo> estoqueBrinquedo = new EstoqueGenerico<>();
        System.out.println(estoqueBrinquedo.getEstoque());
        Brinquedo b = new Brinquedo();
        b.setId(1);
        b.setTipo(TipoBrinquedo.DIDATICO);
        b.setNome("Matemática legal");
        b.setPreco(10.50);
        b.setQuantidade(10);

        estoqueBrinquedo.adicionarProduto(b);
        System.out.println(estoqueBrinquedo.getEstoque());
    }
}
