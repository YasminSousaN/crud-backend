//É uma interface que fala diretamente com o banco de dados.
//Ele herda o JpaRepository, que já fornece automaticamente todos os métodos básicos de CRUD, como salvar, buscar, listar e deletar produtos.
package com.crud.repository;

import com.crud.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNome(String nome);
    // buca o produto onde o campo nome seja igual o vaalor que o usuario passar
}
