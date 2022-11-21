package Modelo.Consumidor;

import Modelo.Estoque.EstoqueGeral;
import Enum.CategoriasProdutosEmEstoque;
import Modelo.Produto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consumidor {
    private String nome;
    private String email;

    EstoqueGeral estoqueGeral = EstoqueGeral.getInstance();
    CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();

    public void mostrarCategorias(){
        estoqueGeral.consultaCategorias().forEach(c -> {
            System.out.println(c);
        });
    }

    public void mostrarProdutosPorCategorias(CategoriasProdutosEmEstoque categoria){
        if(estoqueGeral.consultaProdutosPorCategoria(categoria) != null){
            estoqueGeral.consultaProdutosPorCategoria(categoria).forEach((key, value)->
                    System.out.println(value));
        }
    }

    public void inserirProdutoNoCarrinhoDeCompras(CategoriasProdutosEmEstoque categoria, Integer id, Integer quantidade){
        Map<Integer, ? extends Produto> estoquePorCategoria = new HashMap<>();
        estoquePorCategoria =  estoqueGeral.consultaProdutosPorCategoria(categoria);
        if(estoquePorCategoria.get(id).getQuantidade()<quantidade){
            System.out.println("Quantidade Insuficiente para atender pedido");
        } else {
            switch (categoria) {
                case BRINQUEDO -> {
                    Brinquedo brinquedo = (Brinquedo) estoquePorCategoria.get(id);
                    brinquedo.setQuantidade(quantidade);
                    carrinhoDeCompra.adicinarBrinquedo(brinquedo);
                    break;
                }
                case JOGO -> {
                    Jogo jogo = (Jogo) estoquePorCategoria.get(id);
                    jogo.setQuantidade(quantidade);
                    carrinhoDeCompra.adicinarJogo(jogo);
                    break;
                }
                case LIVRO -> {
                    Livro livro = (Livro) estoquePorCategoria.get(id);
                    livro.setQuantidade(quantidade);
                    carrinhoDeCompra.adicinarLivro(livro);
                    break;
                }
                case FILME -> {
                    Filme filme = (Filme) estoquePorCategoria.get(id);
                    filme.setQuantidade(quantidade);
                    carrinhoDeCompra.adicinarFilme(filme);
                    break;
                }
                case MUSICA -> {
                    AlbumMusica musica = (AlbumMusica) estoquePorCategoria.get(id);
                    musica.setQuantidade(quantidade);
                    carrinhoDeCompra.adicinaralbumMusica(musica);
                    break;
                }
            }
        }
    }

    public void finalizarCompra(CarrinhoDeCompra carrinhoDeCompra){
        carrinhoDeCompra.checkout();
    }
}
