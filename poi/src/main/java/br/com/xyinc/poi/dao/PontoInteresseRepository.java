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
 * Repositorio para {@link PontoInteresse}
 */
@Repository
public interface PontoInteresseRepository extends JpaRepository<PontoInteresse, Long>{

//    @Query("{$geoWithin : { $centerSphere: [ [ x, y ], distance ] }}")
    @Query("SELECT p FROM PontoInteresse p WHERE (ABS(p.x - :pX) + ABS(p.y - :pY)) <= :distance")
    public List<PontoInteresse> findNearbyPoi(@Param("pX") int x, @Param("pY") int y, @Param("distance") int distance);

    @Query("SELECT p FROM PontoInteresse p WHERE p.x = :pX AND p.y = :pY")
    public PontoInteresse verificarExistenciaPoi(@Param("pX") int x,@Param("pY") int y);
}
