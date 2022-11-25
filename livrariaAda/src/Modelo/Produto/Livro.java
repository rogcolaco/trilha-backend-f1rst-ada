package Modelo.Produto;

import Enum.GeneroLivro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livro extends Produto{
    private List<GeneroLivro> listaGenerosLivro;
    private String escritor;
    private String editora;

    @Override
    public String toString() {
        return "Categoria Livro {" +
                "id=" + this.getId() +
                ", nome='" + this.getNome() +
                ", preco=" + this.getPreco() +
                ", quantidade=" + this.getQuantidade() +
                ", listaGenerosLivro=" + listaGenerosLivro +
                ", escritor='" + escritor + '\'' +
                ", editora='" + editora + '\'' +
                ", rótulo=" + this.getProdutoParaAdulto() +
                '}';
    }
}
