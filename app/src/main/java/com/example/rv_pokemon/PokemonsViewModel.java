package com.example.rv_pokemon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.rv_pokemon.model.Pokemon;
import com.example.rv_pokemon.model.PokemonProvider;

import java.util.List;

public class PokemonsViewModel extends AndroidViewModel {
    PokemonProvider pokemonProvider;

    MutableLiveData<List<Pokemon>> listPokemonMutableLiveData = new MutableLiveData<>();

    MutableLiveData<Pokemon> pokemonSeleccionado = new MutableLiveData<>();

    public PokemonsViewModel(@NonNull Application application) {
        super(application);

        pokemonProvider = new PokemonProvider();

        listPokemonMutableLiveData.setValue(pokemonProvider.obtener());
    }

    MutableLiveData<List<Pokemon>> obtener(){
        return listPokemonMutableLiveData;
    }

    void seleccionar(Pokemon pokemon) {
        pokemonSeleccionado.setValue(pokemon);
    }

    MutableLiveData<Pokemon> seleccionado(){
        return pokemonSeleccionado;
    }
}
