package com.example.fiestasardilla;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Eleccion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Eleccion extends Fragment implements View.OnClickListener{

    //Elementos de la vista
    ImageView img_jugador;
    Button btn_empezar;
    Button btn_reset;
    TextView txt_nombre;
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

    // TODO: Rename and change types of parameters

    public Eleccion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment eleccion.
     */
    // TODO: Rename and change types and number of parameters
    public static Eleccion newInstance(ArrayList<Jugador> jugadores) {
        Eleccion fragment = new Eleccion();

        fragment.setJugadores(jugadores);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eleccion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Inicializamos todos los elementos del layout
        img_jugador = (ImageView) getView().findViewById(R.id.img_jugador);
        btn_empezar = (Button) getView().findViewById(R.id.btn_comenzar);
        btn_reset = (Button) getView().findViewById(R.id.btn_reset);
        txt_nombre = (TextView) getView().findViewById(R.id.nombre_jugador);

        btn_empezar.setOnClickListener(this::onClick);
        btn_reset.setOnClickListener(this::onClick);

        aparecer = AnimationUtils.loadAnimation(getContext(), R.anim.aparecer);
    }

    @Override
    public void onClick(View v) {
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

    private void btnEmpezarAccion()
    {
        btn_reset.setEnabled(true);
        btn_empezar.setEnabled(false);

        if (reproductor!=null)
        {
            reproductor.stop();
        }

        if(jugadores.size()>0)
        {
            Jugador jugador_elegido = jugadores.get((int)(Math.random()*jugadores.size()));

            img_jugador.setImageResource(jugador_elegido.getImagen());
            img_jugador.startAnimation(aparecer);
            //img_jugador.startAnimation(escalar);

            txt_nombre.setText(jugador_elegido.getNombre());

            if(jugador_elegido.getCancion()!=0)
            {
                reproductor = MediaPlayer.create(getContext(), jugador_elegido.getCancion());

                reproductor.seekTo(jugador_elegido.getInicio_reproduccion());

                reproductor.start();
            }
        }
        else
        {
            Toast.makeText(getContext(), "No has elegido ningún jugador", Toast.LENGTH_SHORT).show();
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

        txt_nombre.setText("¿Quién será?");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (reproductor!=null)
        {
            reproductor.release();
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}