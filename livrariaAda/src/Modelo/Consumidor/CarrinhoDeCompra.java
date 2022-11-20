package Modelo.Consumidor;

import Modelo.Produto.Produto;
import Enum.CategoriasProdutosEmEstoque;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompra {

    private static CarrinhoDeCompra instance;

    public Map<CategoriasProdutosEmEstoque, Map<Integer, ? extends Produto>> carrinhoDeCompra = new HashMap<>();

//    private CarrinhoDeCompra() {
//    }


//    public static CarrinhoDeCompra getInstance() {
//        if(instance == null){
//            instance = new CarrinhoDeCompra();
//        }
//        return instance;
//    }
}
