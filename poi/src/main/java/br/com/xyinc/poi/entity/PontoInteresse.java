/*
 * Esse arquivo pertence a XY Inc e nao pode ser utilizado fora
 * dessa empresa sem previa autorizacao.
 */
/**
 * Entidade
 */
package br.com.xyinc.poi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade
 */
@Getter
@Setter
@Entity
@Table(name = "ponto_interesse")
public class PontoInteresse {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private int x;

    private int y;    
}
