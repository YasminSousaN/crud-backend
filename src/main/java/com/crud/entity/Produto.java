//a entidade e a  copia da tabela do banco de dados
//O arquivo Produto é a classe que representa um produto, mostrando quais informações um produto tem
package com.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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
    private Double preco;                  // as informaçoes dos produtos
    private String brand;     // ← marca
    private String supplier;  // ← fornecedor

    public Integer getId() { // para ler o valor
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    // set= para alterar os produtos- ele muda ou atualiza

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
