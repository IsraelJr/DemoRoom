package com.example.logonrm.myapplication.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.logonrm.myapplication.persistence.dao.TrofeuDAO;
import com.example.logonrm.myapplication.persistence.dao.UsuarioDAO;
import com.example.logonrm.myapplication.persistence.entidades.Trofeu;
import com.example.logonrm.myapplication.persistence.entidades.Usuario;

@Database(entities = {Usuario.class, Trofeu.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase INSTANCE;

    public abstract UsuarioDAO usuarioDAO();
    public abstract TrofeuDAO trofeuDAO();

    public static AppDatabase getDatabase(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "gamedatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstacen(){
        INSTANCE = null;
    }

}
