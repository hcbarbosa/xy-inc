/*
 * Esse arquivo pertence a XY Inc e nao pode ser utilizado fora
 * dessa empresa sem previa autorizacao.
 */
package br.com.xyinc.poi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.xyinc.poi.entity.PontoInteresse;

/**
 * Repositório para {@link PontoInteresse}
 */
@Repository
public interface PontoInteresseRepository extends JpaRepository<PontoInteresse, Long> {

    /**
     * Consulta de pontos de interesse com base na proximidade
     */
    @Query("SELECT p FROM PontoInteresse p WHERE (ABS(p.x - :pX) + ABS(p.y - :pY)) <= :distance")
    public List<PontoInteresse> findNearbyPoi(@Param("pX") Integer x, @Param("pY") Integer y,
            @Param("distance") Integer distance);
}
