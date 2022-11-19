package Modelo.Estoque;

import Modelo.Produto.Produto;
import jdk.swing.interop.SwingInterOpUtils;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

public class EstoqueGenerico<T extends Produto> {

    Map<Integer, T> estoque = new HashMap<>();

    public Map<Integer, T> getEstoque(){
        return this.estoque;
    }

    public void adicionarProduto (T t){
        Integer key = t.getId();
        if(!estoque.containsKey(key)){
            estoque.put(t.getId(), t);
            System.out.println("Produto cadastrado com sucesso");
        } else {
            System.out.println("Produto já existente, caso queira alterar os dados solicite 'ALTERAR PRODUTO'");
        }
    }

    public void removerProduto(T t){
        Integer key = t.getId();
        if(estoque.containsKey(key)){
            estoque.remove(key);
            System.out.println("Produto removido com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public void alterarProduto(T t){
        Integer key = t.getId();
        if(estoque.containsKey(key)){
            estoque.put(key, t);
            System.out.println("Produto Alterado com Sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public T buscarProduto(Integer id){
        if(!estoque.containsKey(id)){
            System.out.println("Produto não encontrado");
            return null;
        }
        return estoque.get(id);
    }
}
