package fiap.br.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import fiap.br.challenge.domain.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("SELECT c FROM Cliente c LEFT JOIN Compra cm ON cm.cliente.id = c.id")
    List<Cliente> buscaClientesSemCompra();

}