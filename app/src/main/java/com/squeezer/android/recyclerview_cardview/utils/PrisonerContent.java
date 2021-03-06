package com.squeezer.android.recyclerview_cardview.utils;

import com.squeezer.android.recyclerview_cardview.R;
import com.squeezer.android.recyclerview_cardview.models.Prisoner;

import java.util.ArrayList;

/**
 * Created by adnenhamdouni on 26/03/2016.
 */
public class PrisonerContent {

    public static  String[] names = {"Pablo Escobar" , "Alphone Gabriel Capone", "Charles Bronson" , "Joaquín Guzmán Elchapo" , "Tommy"};
    public static  String[] matricules = {"911" , "912" , "913" , "914" , "915"};
    public static  String[] durations = {"50 years - 1980" , "45 years - 1970" , "35 years - 2009" , "50 years - 2015" , "45 years - 1990"};
    public static Integer[] pictures ={R.drawable.escobar, R.drawable.alcapone, R.drawable.bronson, R.drawable.elchapo, R.drawable.tommy};

    public static ArrayList<Prisoner> getPrisoners(){
        ArrayList<Prisoner> prisoners = new ArrayList<>();
        for (int i = 0; i<5; i++){
            prisoners.add(new Prisoner(names[i], matricules[i], durations[i], pictures[i]));
        }

        return prisoners;
    }
}
