package fiap.br.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.br.challenge.domain.Produto;
import fiap.br.challenge.repository.CompraRepository;

@RestController
@RequestMapping("/compras")
public class CompraController {

	
	
	@Autowired
	private CompraRepository repo;
	
	
	 @RequestMapping(value="/prodCompra/{id}",method = RequestMethod.GET)
		public ResponseEntity<?> listarProdutosDaCompra(@PathVariable Long id){
	    	
	    	try {
	    		List<Produto> prods =  repo.listaProdutosDaCompra(id);
	    		if(prods.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produtos da compra " + id + " não encontrados");

    	        	
    	        }else {
                    return ResponseEntity.ok(prods);

                }

    	}catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar produtos da compra: " + e.getMessage());
    	}
	    	
	    	
	    	
	    }



}
