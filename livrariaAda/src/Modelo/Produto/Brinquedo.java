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
}
