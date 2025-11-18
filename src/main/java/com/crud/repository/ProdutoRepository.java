//É uma interface Que fala com a tabela Produto no banco
package com.crud.repository;

import com.crud.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNome(String nome);

}
