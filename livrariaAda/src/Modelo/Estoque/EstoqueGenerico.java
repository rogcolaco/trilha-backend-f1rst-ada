package Modelo.Estoque;

import Enum.CategoriasProdutosEmEstoque;

import Modelo.Produto.*;

import java.util.HashMap;
import java.util.Map;


public class EstoqueGenerico<T extends Produto> {

    Map<Integer, T> estoque = new HashMap<>();
    EstoqueGeral estoqueGeral = EstoqueGeral.getInstance();

    public Map<Integer, T> getEstoque(){
        return this.estoque;
    }

    public void adicionarProduto (T t){
        Integer key = t.getId();
        if(!estoque.containsKey(key)){
            estoque.put(t.getId(), t);
            atualizarEstoqueGeral(t);
            System.out.println("Produto cadastrado com sucesso");
        } else {
            System.out.println("Produto já existente, caso queira alterar os dados solicite 'ALTERAR PRODUTO'");
        }
    }

    public void removerProduto(T t){
        Integer key = t.getId();
        if(estoque.containsKey(key)){
            estoque.remove(key);
            atualizarEstoqueGeral(t);
            System.out.println("Produto removido com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public void alterarProduto(T t){
        Integer key = t.getId();
        if(estoque.containsKey(key)){
            estoque.put(key, t);
            atualizarEstoqueGeral(t);
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

    private void atualizarEstoqueGeral(T t){
        if(t instanceof Brinquedo){
            estoqueGeral.atualizaEstoqueGeral(CategoriasProdutosEmEstoque.BRINQUEDO, estoque);
            return;
        }
        if (t instanceof Jogo){
            estoqueGeral.atualizaEstoqueGeral(CategoriasProdutosEmEstoque.JOGO, estoque);
            return;
        }
        if (t instanceof Filme){
            estoqueGeral.atualizaEstoqueGeral(CategoriasProdutosEmEstoque.FILME, estoque);
            return;
        }
        if (t instanceof Livro){
            estoqueGeral.atualizaEstoqueGeral(CategoriasProdutosEmEstoque.LIVRO, estoque);
            return;
        }
        if (t instanceof AlbumMusica){
            estoqueGeral.atualizaEstoqueGeral(CategoriasProdutosEmEstoque.MUSICA, estoque);
            return;
        }

    }
}
