package br.edu.infnet.app.respostas;

import br.edu.infnet.domain.respostas.Resposta;
import br.edu.infnet.domain.respostas.RespostasCriterio;
import br.edu.infnet.infra.respostas.RespostaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/respostas"})
public class RespostaController {

    @Autowired
    private RespostaRepository respostaRepository;

    @GetMapping({"/usuario/{idUsuario}"})
    public ResponseEntity listarPorIdUsuario(@PathVariable int idUsuario) {

        ResponseEntity retorno = ResponseEntity.notFound().build();
        try {

            List<Resposta> lista = respostaRepository.findByIdUsuario(idUsuario);
            if (!lista.isEmpty()) {
                retorno = ResponseEntity.ok().body(lista);
            }
        } catch (Exception e) {
        }
        return retorno;

    }

    @PostMapping
    public ResponseEntity responderVaga(@RequestBody Resposta resposta) {

        ResponseEntity retorno = ResponseEntity.badRequest().build();
        List<RespostasCriterio> listaRespostaCriterio = resposta.getRespostasCriterioList();
        if (listaRespostaCriterio != null && !listaRespostaCriterio.isEmpty()) {

            for (RespostasCriterio respostaCriterio : listaRespostaCriterio) {

                respostaCriterio.setIdResposta(resposta);
            }
            Resposta gravado = respostaRepository.save(resposta);
            retorno = ResponseEntity.ok().body(gravado);
        }
        return retorno;
        //return vagaRepository.save(vaga);
    }

}
