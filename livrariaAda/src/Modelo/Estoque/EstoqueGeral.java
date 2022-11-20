package Modelo.Estoque;

import Enum.CategoriasProdutosEmEstoque;
import Modelo.Produto.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

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

    public Map<CategoriasProdutosEmEstoque, Map<Integer, ? extends Produto>> consultarEstoqueGeral(){
        return estoqueGeral;
    }

    public EstoqueGeral() {
        this.estoqueGeral = estoqueGeral;
    }


    public static EstoqueGeral getInstance() {
        if(instance == null){
            instance = new EstoqueGeral();
        }
        return instance;
    }
}
