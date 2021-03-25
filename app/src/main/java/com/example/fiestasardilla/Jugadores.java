package com.example.fiestasardilla;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jugadores#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jugadores extends Fragment {

    CheckBox check_valido;
    CheckBox check_ana;
    CheckBox check_melero;
    CheckBox check_max;
    CheckBox check_trikko;
    CheckBox check_jd;
    //Lista de jugadores
    ArrayList<Jugador> jugadores = new ArrayList<>();
    //Jugadores
    Jugador valido;
    Jugador ana;
    Jugador melero;
    Jugador max;
    Jugador trikko;
    Jugador jd;

    public Jugadores() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Jugadores.
     */
    // TODO: Rename and change types and number of parameters
    public static Jugadores newInstance() {
        Jugadores fragment = new Jugadores();

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
        return inflater.inflate(R.layout.fragment_jugadores, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        check_valido = (CheckBox) getView().findViewById(R.id.checkbox_valido);
        check_ana = (CheckBox) getView().findViewById(R.id.checkbox_ana);
        check_melero = (CheckBox) getView().findViewById(R.id.checkbox_melero);
        check_max = (CheckBox) getView().findViewById(R.id.checkbox_max);
        check_trikko = (CheckBox) getView().findViewById(R.id.checkbox_trikko);
        check_jd = (CheckBox) getView().findViewById(R.id.checkbox_jd);

        valido = new Jugador("Valido", R.drawable.valido, R.raw.cancion_valido, 147000);
        ana = new Jugador("Ana", R.drawable.ana, R.raw.cancion_ana, 11000);
        melero = new Jugador("Melero", R.drawable.melero, R.raw.cancion_melero, 0);
        max = new Jugador("Max", R.drawable.max, R.raw.cancion_max, 0);
        trikko = new Jugador("Trikko", R.drawable.trikko, R.raw.cancion_trikko, 44000);
        jd = new Jugador("JD", R.drawable.jd);

        check_valido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    jugadores.add(valido);
                }
                else
                    {
                        jugadores.remove(valido);
                    }
            }
        });

        check_ana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    jugadores.add(ana);
                }
                else
                {
                    jugadores.remove(ana);
                }
            }
        });

        check_melero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    jugadores.add(melero);
                }
                else
                {
                    jugadores.remove(melero);
                }
            }
        });

        check_max.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    jugadores.add(max);
                }
                else
                {
                    jugadores.remove(max);
                }
            }
        });

        check_trikko.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    jugadores.add(trikko);
                }
                else
                {
                    jugadores.remove(trikko);
                }
            }
        });

        check_jd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    jugadores.add(jd);
                }
                else
                {
                    jugadores.remove(jd);
                }
            }
        });
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}