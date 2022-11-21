package Modelo.Consumidor;

import Modelo.Caixa.Caixa;
import Modelo.Estoque.EstoqueGeral;
import Modelo.Produto.*;
import Enum.CategoriasProdutosEmEstoque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarrinhoDeCompra{

    private static CarrinhoDeCompra instance;
    Caixa caixa = Caixa.getInstance();
    EstoqueGeral estoqueGeral = EstoqueGeral.getInstance();

    public Map<CategoriasProdutosEmEstoque, Map<Integer, ? extends Produto>> meuCarrinhoDeCompras = new HashMap<>();

    public void adicinarBrinquedo(Brinquedo brinquedo){
        Map<Integer, Brinquedo> novoItem = new HashMap<>();
        novoItem.put(brinquedo.getId(), brinquedo);
        meuCarrinhoDeCompras.put(CategoriasProdutosEmEstoque.BRINQUEDO, novoItem);
        System.out.println("Item adicionado ao Carrinho");
    }

    public void adicinarJogo(Jogo jogo) {
        Map<Integer, Jogo> novoItem = new HashMap<>();
        novoItem.put(jogo.getId(), jogo);
        meuCarrinhoDeCompras.put(CategoriasProdutosEmEstoque.JOGO, novoItem);
        System.out.println("Item adicionado ao Carrinho");
    }

    public void adicinarFilme(Filme filme) {
        Map<Integer, Filme> novoItem = new HashMap<>();
        novoItem.put(filme.getId(), filme);
        meuCarrinhoDeCompras.put(CategoriasProdutosEmEstoque.JOGO, novoItem);
        System.out.println("Item adicionado ao Carrinho");
    }

    public void adicinarLivro(Livro livro) {
        Map<Integer, Livro> novoItem = new HashMap<>();
        novoItem.put(livro.getId(), livro);
        meuCarrinhoDeCompras.put(CategoriasProdutosEmEstoque.JOGO, novoItem);
        System.out.println("Item adicionado ao Carrinho");
    }

    public void adicinaralbumMusica(AlbumMusica albummusica) {
        Map<Integer, AlbumMusica> novoItem = new HashMap<>();
        novoItem.put(albummusica.getId(), albummusica);
        meuCarrinhoDeCompras.put(CategoriasProdutosEmEstoque.JOGO, novoItem);
        System.out.println("Item adicionado ao Carrinho");
    }

    public void checkout(){
        meuCarrinhoDeCompras.forEach((keyCategoria, produtosCompradosPorCategoria) -> {
//            estoqueGeral.atualizaEstoquesAposCompra(keyCategoria, produtosCompradosPorCategoria);
            produtosCompradosPorCategoria.forEach( (keyProduto, produtoComprado)-> {
//                System.out.println("#########");
//                System.out.println(keyProduto + "---" + produtoComprado);
//                estoqueGeral.atualizarEstoqueAposCompra(keyCategoria, keyProduto, produtoComprado);
                atualizarCaixa(produtoComprado.getPreco(), produtoComprado.getQuantidade());
            });
        });
    }

    private void atualizarCaixa(Double valorItem, Integer quantidade){
        double valorTotalItem = valorItem * quantidade;
        caixa.efetivarCompra(valorTotalItem);
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompra{" +
                "meuCarrinhoDeCompras=" + meuCarrinhoDeCompras +
                '}';
    }
}

