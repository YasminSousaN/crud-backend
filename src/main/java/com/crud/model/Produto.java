package com.crud.model;
//

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private int id;  //esta definindo oq cada produto vai ter
    private String nome;
    private double preco;
}
