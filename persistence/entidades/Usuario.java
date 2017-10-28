package com.example.logonrm.myapplication.persistence.entidades;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by logonrm on 28/10/2017.
 */

@Entity
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private int level;
    private long pontos;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }
}
