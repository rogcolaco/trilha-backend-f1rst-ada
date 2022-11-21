package Modelo.Estoque;

import Enum.CategoriasProdutosEmEstoque;
import Modelo.Produto.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Getter
@Setter
public class EstoqueGeral {
    private static EstoqueGeral instance;

    public Map<CategoriasProdutosEmEstoque, Map<Integer, ? extends Produto>> estoqueGeral = new HashMap<>();

    public void atualizaEstoqueGeral
            (CategoriasProdutosEmEstoque tipoEstoqueEspecifico, Map<Integer, ? extends Produto> estoqueEspecifico){
        estoqueGeral.put(tipoEstoqueEspecifico, estoqueEspecifico);
        System.out.println("Estoque Geral Atualizado");
    }

//    public void atualizarEstoqueAposCompra(CategoriasProdutosEmEstoque categoria, int keyProdutoComprado, T produtocomprado){
//
//    }

    private void buscarProdutoPorChaveId(Integer keyProduct, Map<Integer, ? extends Produto> estoqueEspecifico){

    }

    public Map<CategoriasProdutosEmEstoque, Map<Integer, ? extends Produto>> consultarEstoqueGeral(){
        return estoqueGeral;
    }

    public Set<CategoriasProdutosEmEstoque> consultaCategorias(){
        return estoqueGeral.keySet();
    }

    public Map<Integer, ? extends Produto> consultaProdutosPorCategoria(CategoriasProdutosEmEstoque categoria){
        if(!estoqueGeral.keySet().contains(categoria)){
            System.out.println("Os produtos dessa categoria estão indisponíveis!");
            System.out.println("Por favor utilize 'consultaCategorias' para consultar as categorias disponíveis");
            return null;
        } else {
            return estoqueGeral.get(categoria);
        }
    }

    private EstoqueGeral() {
    }


    public static EstoqueGeral getInstance() {
        if(instance == null){
            instance = new EstoqueGeral();
        }
        return instance;
    }
}
