package com.example.logonrm.myapplication.persistence.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.logonrm.myapplication.persistence.entidades.Trofeu;

import java.util.List;

@Dao
public interface TrofeuDAO {

    @Query("select * from trofeu")
    List<Trofeu> listaTodos();

    @Query("select * from trofeu where id = :idTrofeu")
    List<Trofeu> listaPorTrofeu(int idTrofeu);

    @Query("select * from trofeu where id = :idUsuario")
    List<Trofeu> listaPorUsuario(int idUsuario);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void adicionarTrofeu(Trofeu... trofeu);

    @Delete
    void deletarTrofeu(Trofeu... trofeu);


}
