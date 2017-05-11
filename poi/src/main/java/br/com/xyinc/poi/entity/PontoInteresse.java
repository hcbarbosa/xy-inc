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
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Entidade
 */
@Entity
@Table(name = "ponto_interesse")
public class PontoInteresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private int x;

    private int y;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
