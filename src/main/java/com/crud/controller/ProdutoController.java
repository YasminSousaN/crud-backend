package com.crud.controller;
//porta de entrada
import com.crud.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
//@RestController → indica que a classe vai responder requisições web
public class ProdutoController {
    //@GetMapping("/produtos") → cria a rota GET em http://localhost:8080/produtos
    @GetMapping("/produtos")
    public List<Produto> getProdutos() {
        Produto p1 = new Produto(1, "Notebook", 3500.0);
        Produto p2 = new Produto(2, "Mouse", 50.0);
        Produto p3 = new Produto(3, "Teclado", 150.0);

        return Arrays.asList(p1, p2, p3);
        //Arrays.asList() → cria uma lista de produtos simulando um “banco de dados”
    }


}
