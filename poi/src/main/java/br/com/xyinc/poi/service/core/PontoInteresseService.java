/*
 * Esse arquivo pertence a XY Inc e nao pode ser utilizado fora
 * dessa empresa sem previa autorizacao.
 */
package br.com.xyinc.poi.service.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.xyinc.poi.dao.PontoInteresseRepository;
import br.com.xyinc.poi.entity.PontoInteresse;
import br.com.xyinc.poi.service.IPontoInteresseService;

/**
 * Implementação de Serviço para {@link PontoInteresse}
 */
@Service
@Transactional(readOnly = true)
public class PontoInteresseService implements IPontoInteresseService {

    @Autowired
    private PontoInteresseRepository pontoInteresseRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PontoInteresse> findAll() {
        return pontoInteresseRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PontoInteresse> findNearbyPoi(Integer x, Integer y, Integer distance) {
        return pontoInteresseRepository.findNearbyPoi(x, y, distance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
