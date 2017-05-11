/*
 * Esse arquivo pertence a XY Inc e nao pode ser utilizado fora
 * dessa empresa sem previa autorizacao.
 */
package br.com.xyinc.poi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.xyinc.poi.dao.PontoInteresseRepository;
import br.com.xyinc.poi.entity.PontoInteresse;

/**
 * Implementação de Serviço para {@link PontoInteresse}
 */
@Service
@Transactional(readOnly = true)
public class PontoInteresseService {

    @Autowired
    private PontoInteresseRepository pontoInteresseRepository;

    /**
     * Consulta que retorna todos os pontos de interesse do banco
     * 
     * @return lista de pois
     */
    public List<PontoInteresse> findAll() {
        return pontoInteresseRepository.findAll();
    }

    /**
     * Consulta que retorna todos os pontos de interesse dentro da distância
     * especificada a partir do ponto parametrizado
     * 
     * @param x coordenada x do ponto de interesse escolhido
     * @param y coordenada y do ponto de interesse escolhido
     * @param distance distancia do ponto escolhido
     * @return lista de pois filtrada
     */
    public List<PontoInteresse> findNearbyPoi(Integer x, Integer y, Integer distance) {
        return pontoInteresseRepository.findNearbyPoi(x, y, distance);
    }

    /**
     * Cria ponto de interesse no banco
     * 
     * @return entidade persistida
     */
    @Transactional(readOnly = false)
    public PontoInteresse save(PontoInteresse entity) {
        validateEntity(entity);

        entity = pontoInteresseRepository.save(entity);

        return entity;
    }

    /**
     * Valida a entidade PontoInteresse para persistir.
     * 
     * @param entity: objeto que será validado.
     */
    private void validateEntity(PontoInteresse entity) {
        if (entity.getNome() == null) {
            throw new IllegalArgumentException("Nome inválido");
        } else if (entity.getX() < 0) {
            throw new IllegalArgumentException("Coordenada X menor ou igual a 0");
        } else if (entity.getY() < 0) {
            throw new IllegalArgumentException("Coordenada Y menor ou igual a 0");
        }
    }
}
