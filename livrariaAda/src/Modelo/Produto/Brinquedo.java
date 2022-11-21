package Modelo.Produto;

import Enum.TipoBrinquedo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Brinquedo extends Produto{
    private TipoBrinquedo tipo;

    @Override
    public String toString() {
        return "Categoria Brinquedo {" +
                "id=" + this.getId() +
                ", nome='" + this.getNome() +
                ", preco=" + this.getPreco() +
                ", quantidade=" + this.getQuantidade() +
                ", tipo=" + tipo +
                '}';
    }
}
