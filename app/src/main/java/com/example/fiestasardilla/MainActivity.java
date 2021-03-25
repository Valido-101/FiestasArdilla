package com.example.fiestasardilla;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Elementos de la vista
    ImageView img_jugador;
    Button btn_empezar;
    Button btn_reset;
    TextView txt_nombre;
    CheckBox check_valido;
    CheckBox check_ana;
    CheckBox check_melero;
    CheckBox check_max;
    CheckBox check_trikko;
    CheckBox check_jd;
    //Jugadores
    Jugador valido;
    Jugador ana;
    Jugador melero;
    Jugador max;
    Jugador trikko;
    Jugador jd;
    //Listado de jugadores
    ArrayList<Jugador> jugadores;
    //Reproductor de música
    MediaPlayer reproductor;
    //Animaciones
    Animation aparecer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos todos los elementos del layout
        img_jugador = findViewById(R.id.img_jugador);
        btn_empezar = findViewById(R.id.btn_comenzar);
        btn_reset = findViewById(R.id.btn_reset);
        txt_nombre = findViewById(R.id.nombre_jugador);
        check_valido = findViewById(R.id.checkbox_valido);
        check_ana = findViewById(R.id.checkbox_ana);
        check_melero = findViewById(R.id.checkbox_melero);
        check_max = findViewById(R.id.checkbox_max);
        check_trikko = findViewById(R.id.checkbox_trikko);
        check_jd = findViewById(R.id.checkbox_jd);

        jugadores = new ArrayList<>();


        valido = new Jugador("Valido", R.drawable.valido, R.raw.cancion_valido);
        ana = new Jugador("Ana", R.drawable.ana, R.raw.cancion_ana);
        melero = new Jugador("Melero", R.drawable.melero, R.raw.cancion_melero);
        max = new Jugador("Max", R.drawable.max, R.raw.cancion_max);
        trikko = new Jugador("Trikko", R.drawable.trikko);
        jd = new Jugador("JD", R.drawable.jd);

        btn_empezar.setOnClickListener(this::onClick);
        btn_reset.setOnClickListener(this::onClick);

        aparecer = AnimationUtils.loadAnimation(this, R.anim.aparecer);
    }


    @Override
    public void onClick(View v)
    {
        Button btn_pulsado = (Button) v;

        if (btn_pulsado==btn_empezar)
        {
            btnEmpezarAccion();
        }
        else
        {
            btnResetAccion();
        }
    }

    private void rellenarJugadores()
    {
        jugadores.clear();

        if (check_valido.isChecked())
        {
            jugadores.add(valido);
        }

        if (check_ana.isChecked())
        {
            jugadores.add(ana);
        }

        if (check_melero.isChecked())
        {
            jugadores.add(melero);
        }

        if (check_max.isChecked())
        {
            jugadores.add(max);
        }

        if (check_trikko.isChecked())
        {
            jugadores.add(trikko);
        }

        if (check_jd.isChecked())
        {
            jugadores.add(jd);
        }
    }

    private void btnEmpezarAccion()
    {
        btn_reset.setEnabled(true);
        btn_empezar.setEnabled(false);

        if (reproductor!=null)
        {
            reproductor.stop();
        }

        rellenarJugadores();

        if(jugadores.size()>0)
        {
            Jugador jugador_elegido = jugadores.get((int)(Math.random()*jugadores.size()));

            img_jugador.setImageResource(jugador_elegido.getImagen());
            img_jugador.startAnimation(aparecer);
            //img_jugador.startAnimation(escalar);

            txt_nombre.setText(jugador_elegido.getNombre());

            if(jugador_elegido.getCancion()!=0)
            {
                reproductor = MediaPlayer.create(this, jugador_elegido.getCancion());

                reproductor.start();
            }
        }
        else
        {
            Toast.makeText(this, "No has elegido ningún jugador", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnResetAccion()
    {
        btn_reset.setEnabled(false);
        btn_empezar.setEnabled(true);

        if (reproductor!=null)
        {
            reproductor.stop();
        }

        img_jugador.setImageResource(0);

        txt_nombre.setText("");
    }
}