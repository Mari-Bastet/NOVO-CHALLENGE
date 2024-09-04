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
import org.springframework.web.bind.annotation.RestController;

import fiap.br.challenge.domain.Cliente;
import fiap.br.challenge.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clirepo;
	
    @RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listarClientes(){
		return clirepo.findAll();
}
	
    @RequestMapping(value="/adicionar",method = RequestMethod.POST)
	public ResponseEntity<String> adicionarCliente(@RequestBody Cliente cliente){
    	
    	try {
		clirepo.save(cliente);
        return ResponseEntity.ok("Cliente criado com sucesso");
		
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar cliente" + e.getMessage());
    		
    	}
    }
   
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
    	
    	try {
        clirepo.deleteById(id);
        return ResponseEntity.ok("Cliente eliminado com sucesso");

    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover cliente" + e.getMessage());

    	}
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> consultarclientePorId(@PathVariable Long id) {
    	try {
    		 Optional<Cliente> cli = clirepo.findById(id);
    	        if(cli.isPresent()) {
                    return ResponseEntity.ok(cli.get());

    	        	
    	        }else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
                }

    	}catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao consultar cliente por ID: " + e.getMessage());
    	}
    }
}