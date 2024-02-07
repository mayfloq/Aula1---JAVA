
package br.edu.infnet.infra.respostas;

import br.edu.infnet.domain.respostas.Resposta;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RespostaRepository extends CrudRepository<Resposta, Integer>{
    
    List<Resposta> findByIdUsuario(int idUsuario);
    
}
