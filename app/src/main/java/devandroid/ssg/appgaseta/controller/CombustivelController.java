package devandroid.ssg.appgaseta.controller;

import android.content.SharedPreferences;

import devandroid.ssg.appgaseta.database.GasEtaDB;
import devandroid.ssg.appgaseta.model.Combustivel;
import devandroid.ssg.appgaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;

    // psfs resulmo do codigo para aramazenar o nome do arquivo.
    public static final String NOME_PREFERENCES = "Pref_gaseta";

    public  CombustivelController(GasEtaActivity activity){
        super(activity);

        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);
        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel combustivel){

        dadosPreferences.putString("combustivel",combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao",combustivel.getRecomendacao());
        dadosPreferences.apply();


    }

    public void limpar(){

        dadosPreferences.clear();
        dadosPreferences.apply();

    }


}
