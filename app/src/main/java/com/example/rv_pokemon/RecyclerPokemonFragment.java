package com.example.rv_pokemon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rv_pokemon.databinding.FragmentRecyclerPokemonBinding;
import com.example.rv_pokemon.databinding.ItemPokemonBinding;
import com.example.rv_pokemon.model.Pokemon;

import java.util.List;

public class RecyclerPokemonFragment extends Fragment {

    private FragmentRecyclerPokemonBinding binding;
    private PokemonsViewModel pokemonsViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecyclerPokemonBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pokemonsViewModel = new ViewModelProvider(requireActivity()).get(PokemonsViewModel.class);
        navController = Navigation.findNavController(view);

        // Crear el Adaptador
        PokemonsAdapter pokemonsAdapter = new PokemonsAdapter();

        //Asociar el Adaptador con el RecyclerView
        binding.recyclerView.setAdapter(pokemonsAdapter);

        // Obtener el array de Pokemons, y pasárselo al Adaptador
        pokemonsViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(List<Pokemon> pokemons) {
                pokemonsAdapter.establecerLista(pokemons);
            }
        });
    }

    class PokemonsAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
        List<Pokemon> pokemons;

        // Crear un nuevo ViewHolder
        @NonNull
        @Override
        public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PokemonViewHolder(ItemPokemonBinding.inflate(getLayoutInflater(), parent, false));
        }

        // Rellenar un ViewHolder en una posición del Recycler con los datos del pokemon que
        // esté en esa misma posición en el Array
        @Override
        public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {

            Pokemon pokemon = pokemons.get(position);

            holder.binding.nombre.setText(pokemon.nombre);
            holder.binding.tipo.setText(pokemon.tipo);
            holder.binding.imagen.setImageResource(pokemon.imagen);

            // Permite navegar a la pantalla del detalle
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pokemonsViewModel.seleccionar(pokemon);
                    navController.navigate(R.id.action_recyclerPokemonFragment_to_detallePokemonFragment);
                }
            });
        }

        // Informar al Recycler de cuántos elementos habrá en la lista
        @Override
        public int getItemCount() {
            return pokemons != null ? pokemons.size() : 0;
        }

        // establecer la referencia a la lista, y notificar al Recycler para que se regenere
        public void establecerLista(List<Pokemon> pokemons){
            this.pokemons = pokemons;
            notifyDataSetChanged();
        }

        public Pokemon obtenerElemento(int posicion){
            return pokemons.get(posicion);
        }
    }

    // Clase para inicializar el ViewBinding en los ViewHolder
    class PokemonViewHolder extends RecyclerView.ViewHolder {
        private final ItemPokemonBinding binding;

        public PokemonViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}