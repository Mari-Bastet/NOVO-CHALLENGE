package fiap.br.challenge.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fiap.br.challenge.FilialDTO;
import fiap.br.challenge.domain.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long>{
	
	  @Query("SELECT new fiap.br.challenge.FilialDTO(count(1), " 
	  		+ "f.codFilial) FROM Compra c inner join c.filial f "
	  		+ "group by codFilial")
	    List<FilialDTO> listarQuantidadeComprasPorFilial();
	
}