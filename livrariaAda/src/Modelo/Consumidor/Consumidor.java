package Modelo.Consumidor;

import Modelo.Estoque.EstoqueGeral;
import Enum.CategoriasProdutosEmEstoque;
import Modelo.Produto.Produto;
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

    public void inserirProdutoNoCarrinhoDeCompras(){
//        CarrinhoDeCompra carrinhoDeCompra = CarrinhoDeCompra.getInstance();
    }

    public void consultarCarrinhoDeCompras(){
        System.out.println(carrinhoDeCompra);
    }

}
