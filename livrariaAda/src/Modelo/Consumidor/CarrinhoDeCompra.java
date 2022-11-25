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
//            System.out.println(produtosCompradosPorCategoria.keySet());
            produtosCompradosPorCategoria.keySet().forEach(c -> {
                produtosCompradosPorCategoria.get(c).setQuantidade(estoqueGeral.getEstoqueGeral().get(keyCategoria).get(c).getQuantidade()
                        - produtosCompradosPorCategoria.get(c).getQuantidade());
            });
            produtosCompradosPorCategoria.forEach( (keyProduto, produtoComprado)-> {
                if(keyCategoria.equals(CategoriasProdutosEmEstoque.LIVRO) &&
                        ((produtoComprado.getPreco()*produtoComprado.getQuantidade()) > 200.0)){
                    atualizarCaixa(produtoComprado.getPreco()*0.85, produtoComprado.getQuantidade());
                } else {
                    atualizarCaixa(produtoComprado.getPreco(), produtoComprado.getQuantidade());
                }
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

