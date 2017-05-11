/*
 * Esse arquivo pertence a XY Inc e nao pode ser utilizado fora
 * dessa empresa sem previa autorizacao.
 */
package br.com.xyinc.poi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xyinc.poi.entity.PontoInteresse;
import br.com.xyinc.poi.service.PontoInteresseService;

/**
 * Controlador de requisições para {@link PontoInteresse}
 */
@RestController
@RequestMapping("/pontoInteresse")
public class PontoInteresseController {

    @Autowired
    private PontoInteresseService pontoInteresseService;

    /**
     * Método que retorna todos os pontos de interesse cadastrados
     * 
     * @return lista com os pontos de interesse
     */
    @GetMapping
    public ResponseEntity<List<PontoInteresse>> findAll() {
        List<PontoInteresse> poiList = pontoInteresseService.findAll();
        return new ResponseEntity<List<PontoInteresse>>(poiList, HttpStatus.OK);
    }

    /**
     * Método que cria um ponto de interesse
     * 
     * @param poi Entidade com os dados do ponto de interesse
     * @return entidade com os dados persistidos
     * @throws IllegalArgumentException
     */
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PontoInteresse poi) {
        try {
            pontoInteresseService.save(poi);
            return new ResponseEntity<PontoInteresse>(poi, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<Object>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    /**
     * Método que busca pontos de interesse de acordo com distancia, x e y
     * 
     * @param x coordenada x do ponto de interesse
     * @param y coordenada y do ponto de interesse
     * @param distance distancia verificada do ponto de interesse
     * @return lista contendo os pontos de interesse
     */
    @GetMapping(path = "/{x}/{y}/{distance}")
    public ResponseEntity<List<PontoInteresse>> findNearbyPoi(@PathVariable("x") int x, @PathVariable("y") int y,
            @PathVariable("distance") int distance) {
        List<PontoInteresse> poiList = pontoInteresseService.findNearbyPoi(x, y, distance);

        return new ResponseEntity<List<PontoInteresse>>(poiList, HttpStatus.OK);
    }
}
