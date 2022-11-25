package Modelo.Consumidor;

import Modelo.Estoque.EstoqueGeral;
import Enum.CategoriasProdutosEmEstoque;
import Modelo.Produto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consumidor {
    private String nome;
    private String email;
    private Date dataNascimento;

    EstoqueGeral estoqueGeral = EstoqueGeral.getInstance();
    CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();


    public int getIdade(){
        return Calendar.getInstance().get(1) - this.dataNascimento.getYear();
    }

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

    public boolean verificaAutorizacaoCompra(Map<Integer, ? extends Produto> estoquePorCategoria, Integer id){
        if (this.getIdade() > 18 && estoquePorCategoria.get(id).getProdutoParaAdulto() ){
            return true;
        } else if (!estoquePorCategoria.get(id).getProdutoParaAdulto()) {
            return true;
        }
        return false;
    }

    public void inserirProdutoNoCarrinhoDeCompras(CategoriasProdutosEmEstoque categoria, Integer id, Integer quantidade){
        Map<Integer, ? extends Produto> estoquePorCategoria = estoqueGeral.consultaProdutosPorCategoria(categoria);
        if(estoquePorCategoria.get(id).getQuantidade()<quantidade && verificaAutorizacaoCompra(estoquePorCategoria, id)){
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
