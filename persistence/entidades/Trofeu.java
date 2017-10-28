package com.example.logonrm.myapplication.persistence.entidades;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by logonrm on 28/10/2017.
 */

@Entity(tableName = "trofeu", foreignKeys = @ForeignKey(entity = Usuario.class,
        parentColumns = "id",
        childColumns = "userId"))
public class Trofeu {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private String descricao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
