package fiap.br.challenge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.br.challenge.FilialDTO;
import fiap.br.challenge.repository.FilialRepository;

@RestController
@RequestMapping("/filial")
public class FilialController {
	
	Logger logger = LoggerFactory.getLogger(FilialController.class);
	
	@Autowired
	FilialRepository repo;

	@RequestMapping(value="/relatorios/compras",method = RequestMethod.GET)
	 public ResponseEntity<?> relatorioListarQuantidadeComprasPorFilial(){
		 
		 try {
		 		logger.info(repo.listarQuantidadeComprasPorFilial().toString());
			 List<FilialDTO> filiaisDTO = repo.listarQuantidadeComprasPorFilial();
			 if(filiaisDTO.isEmpty()) {
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum resultado encontrado");
                 
 	        }else {
                 return ResponseEntity.ok(filiaisDTO);

             }

 	}catch(Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar compras por filial: " + e.getMessage());
 	}
		 
	 }

}