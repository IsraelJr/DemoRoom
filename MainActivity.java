package com.example.logonrm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.logonrm.myapplication.persistence.AppDatabase;
import com.example.logonrm.myapplication.persistence.entidades.Usuario;
import com.facebook.stetho.Stetho;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        resultado = (TextView) findViewById(R.id.tvResultado);
        db = AppDatabase.getDatabase(this);

        List<Usuario> usuarios = db.usuarioDAO().buscarTodos();
        if(usuarios == null || usuarios.size() == 0){
            Usuario usuario = new Usuario();
            usuario.setLevel(1);
            usuario.setNome("Junior");
            usuario.setPontos(1000);

            db.usuarioDAO().adicionarUsuario(usuario);

            StringBuilder sb = new StringBuilder();
            sb.append(usuario.getNome());
            sb.append(" Pontos: ");
            sb.append(usuario.getPontos());
            resultado.setText(sb.toString());
        }else{
            StringBuilder sb = new StringBuilder();
            for(Usuario usuario : usuarios) {
                sb.append(usuario.getNome());
                sb.append(" Pontos: ");
                sb.append(usuario.getPontos());
                sb.append(System.getProperty("line.separator"));
            }
            resultado.setText(sb.toString());
        }
    }
}
