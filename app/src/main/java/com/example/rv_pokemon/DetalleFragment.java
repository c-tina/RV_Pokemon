package com.example.rv_pokemon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.rv_pokemon.databinding.FragmentDetalleBinding;
import com.example.rv_pokemon.model.Pokemon;

public class DetalleFragment extends Fragment {

    private FragmentDetalleBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentDetalleBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PokemonsViewModel pokemonsViewModel = new ViewModelProvider(requireActivity()).get(PokemonsViewModel.class);

        pokemonsViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                binding.nombre.setText(pokemon.nombre);
                binding.tipo.setText(pokemon.tipo);
                binding.generacion.setText(pokemon.generacion);
                binding.imagen.setImageResource(pokemon.imagen);
                binding.descripcion.setText(pokemon.descripcion);
            }
        });
    }

}