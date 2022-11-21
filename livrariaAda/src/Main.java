import Modelo.Consumidor.Consumidor;
import Modelo.Estoque.EstoqueGenerico;
import Modelo.Estoque.EstoqueGeral;
import Modelo.Produto.Brinquedo;

import Enum.TipoBrinquedo;
import Enum.GeneroJogo;
import Enum.CategoriasProdutosEmEstoque;
import Modelo.Produto.Jogo;

public class Main {
    public static void main(String[] args) {
        EstoqueGenerico<Brinquedo> estoqueBrinquedo = new EstoqueGenerico<>();
        EstoqueGenerico<Jogo> estoqueJogo = new EstoqueGenerico<>();
        EstoqueGeral estoqueGeral = EstoqueGeral.getInstance();
        System.out.println(estoqueBrinquedo.getEstoque());
        Brinquedo b = new Brinquedo();
        b.setId(1);
        b.setTipo(TipoBrinquedo.DIDATICO);
        b.setNome("Matemática legal");
        b.setPreco(10.50);
        b.setQuantidade(10);

        Brinquedo b1 = new Brinquedo();
        b1.setId(2);
        b1.setTipo(TipoBrinquedo.CARTAS);
        b1.setNome("UNO");
        b1.setPreco(12);
        b1.setQuantidade(5);

        estoqueBrinquedo.adicionarProduto(b);
        estoqueBrinquedo.adicionarProduto(b1);
        System.out.println(estoqueBrinquedo.getEstoque());
        b.setQuantidade(30);
        estoqueBrinquedo.alterarProduto(b);
//        System.out.println(estoqueBrinquedo.getEstoque());
//        System.out.println(estoqueBrinquedo.buscarProduto(2));
//        estoqueBrinquedo.removerProduto(b);
//        System.out.println(estoqueBrinquedo.getEstoque());

        Jogo jogo = new Jogo();
        jogo.setId(1);
        jogo.setGeneroJogo(GeneroJogo.RPG);
        jogo.setEstudioJogo("Nintendo");
        jogo.setNome("Pokemon");
        jogo.setDistribuidora("Magalu");
        jogo.setPreco(200.0);
        jogo.setQuantidade(2);
        estoqueJogo.adicionarProduto(jogo);

        System.out.println("\n\n\n Teste Estoque Geral \n\n\n");
        System.out.println(estoqueGeral.getEstoqueGeral());

        System.out.println("\n\n\n Teste consumidor\n\n\n");
        Consumidor c = new Consumidor();
        Consumidor c2 = new Consumidor();
        c.mostrarCategorias();
        c.mostrarProdutosPorCategorias(CategoriasProdutosEmEstoque.BRINQUEDO);
        System.out.println("\n");
        c.mostrarProdutosPorCategorias(CategoriasProdutosEmEstoque.JOGO);
        System.out.println("\n");
        c.mostrarProdutosPorCategorias(CategoriasProdutosEmEstoque.LIVRO);
//        System.out.println("-----");
        c.inserirProdutoNoCarrinhoDeCompras(CategoriasProdutosEmEstoque.BRINQUEDO, 2, 5);
        c.inserirProdutoNoCarrinhoDeCompras(CategoriasProdutosEmEstoque.JOGO, 1, 3);
        System.out.println(c.getCarrinhoDeCompra());
    }
}
