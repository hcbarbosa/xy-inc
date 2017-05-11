package br.com.xyinc.poi.service;

import java.util.List;

import br.com.xyinc.poi.entity.PontoInteresse;

public interface IPontoInteresseService {

    /**
     * Consulta que retorna todos os pontos de interesse do banco
     * 
     * @return lista de pois
     */
    List<PontoInteresse> findAll();

    /**
     * Consulta que retorna todos os pontos de interesse dentro da distância
     * especificada a partir do ponto parametrizado
     * 
     * @param x coordenada x do ponto de interesse escolhido
     * @param y coordenada y do ponto de interesse escolhido
     * @param distance distancia do ponto escolhido
     * @return lista de pois filtrada
     */
    List<PontoInteresse> findNearbyPoi(Integer x, Integer y, Integer distance);

    /**
     * Cria ponto de interesse no banco
     * 
     * @return entidade persistida
     */
    PontoInteresse save(PontoInteresse entity);

}