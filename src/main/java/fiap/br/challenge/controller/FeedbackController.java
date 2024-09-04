package fiap.br.challenge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.br.challenge.domain.Feedback;
import fiap.br.challenge.repository.FeedbackRepository;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

	@Autowired
	private FeedbackRepository repo;
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listarFeedbacksPorIdCliente(@PathVariable Long id) {

		try {
			List<Feedback> feedbacks = repo.findByClienteId(id);
			if (feedbacks.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Feedbacks do cliente " + id + " não encontrados");

			} else {
				return ResponseEntity.ok(feedbacks);

			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao listar feedbacks do cliente: " + e.getMessage());
		}

	}

}
