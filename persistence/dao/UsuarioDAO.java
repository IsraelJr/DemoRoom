package com.example.logonrm.myapplication.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.logonrm.myapplication.persistence.entidades.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Query("select * from Usuario")
    List<Usuario> buscarTodos();

    @Query("select * from Usuario where id = :userId")
    List<Usuario> buscarPor(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void adicionarUsuario(Usuario usuario);

    @Delete
    void deletarUsuario(Usuario... usuario);
}
