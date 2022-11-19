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
}
