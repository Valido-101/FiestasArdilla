package com.example.fiestasardilla;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class GeneralFragmentPagerAdapter extends FragmentPagerAdapter {

    //Atributos necesarios para el Adaptador
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Saca uno al azar", "Elige a los participantes" };
    //Instanciamos los fragmentos
    Fragment fragmento_azar;
    Fragment fragmento_elegir;


    public GeneralFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        Jugadores f_jugadores = Jugadores.newInstance();

        fragmento_elegir = f_jugadores;
        fragmento_azar = Eleccion.newInstance(f_jugadores.getJugadores());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            default:
                return null;
            case 0:
                return fragmento_azar;
            case 1:
                return fragmento_elegir;
        }

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
