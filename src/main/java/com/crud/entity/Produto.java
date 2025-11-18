package com.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import com.crud.entity.Produto;
import lombok.Getter;
import lombok.Setter;


@Entity //transforme essa classe em uma tabela no banco MySQL.
@Data  //Pode gerar tudo pra mim automaticamente!
public class Produto {

    @Id  //Esse campo vai identificar cada produto.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //MySQL gera o ID automático
    private Integer id;
    private String nome;
    private Double preco;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
