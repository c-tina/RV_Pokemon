package com.example.rv_pokemon.model;

import com.example.rv_pokemon.R;

import java.util.ArrayList;
import java.util.List;

public class PokemonProvider {

    List<Pokemon> pokemonList = new ArrayList<>();

    interface Callback {
        void cuandoFinalice (List<Pokemon> pokemonList);
    }

    public PokemonProvider(){
        pokemonList.add(new Pokemon("Bulbasur","Planta y Veneno",R.drawable.bulbasaur,"Primera",
                "Es uno de los tres Pokémon iniciales que pueden elegir los entrenadores " +
                        "que empiezan su aventura en la región de Kanto, junto a Charmander y Squirtle. " +
                        "Se destaca por ser el primer Pokémon de la Pokédex Nacional."));
        pokemonList.add(new Pokemon("Charmander", "Fuego",R.drawable.charmander,"Primera",
                "Es uno de los tres Pokémon iniciales que pueden elegir los entrenadores " +
                        "que empiezan su aventura en la región de Kanto, junto a Bulbasaur y Squirtle"));
        pokemonList.add(new Pokemon("Latias", "Dragón y Psíquico",R.drawable.latias , "Tercera",
                "Es un Pokémon con un cuerpo similar al de un ave mezclada con un avión. " +
                        "Su cuello es largo extendiéndose hasta el torso de su pecho, es de color rojo " +
                        "con blanco con un triángulo azul en el pecho. Tiene unas alas de un avión y " +
                        "una aleta en la parte inferior."));
        pokemonList.add(new Pokemon("Arceus", "Normal", R.drawable.arceus, "Cuarta",
                "De acuerdo con la mitología, es el primer Pokémon existente y creador del mundo Pokémon. " +
                        "Es la mascota de Leyendas Pokémon: Arceus. En el pasado, sus adoradores en Hisui lo conocieron " +
                        "bajo el nombre del Gran Sinnoh."));
        pokemonList.add(new Pokemon("Ferrotesta", "Acero y Psíquico",R.drawable.ferrotesta, "Novena",
                "Es un Pokémon cuadrúpedo. Su cuerpo es principalmente azul turquesa, " +
                        "aunque presenta zonas gris metálico en su cara, pecho y abdomen. " +
                        "En su cabeza posee un par de cuernos dorados con una zona azulada en la " +
                        "parte superior de la que emite haces de luz azul claro a modo de cuchillas."));
        pokemonList.add(new Pokemon("Popplio","Agua",R.drawable.popplio,"Séptima",
                "Es uno de los tres Pokémon iniciales que pueden elegir los entrenadores " +
                        "que empiezan su aventura en la región de Alola. Está basado en un león marino " +
                        "de la familia de los pinnípedos y en un payaso de circo."));
        pokemonList.add(new Pokemon("Pansage", "Planta",R.drawable.pansage,"Quinta",
                "Está basado en un mono del código moral japonés: Los tres monos sabios. " +
                        "Los cuales representan el no ver el mal, no escuchar el mal y no decir el mal. " +
                        "Pansage es el mono que representa el no decir el mal."));
        pokemonList.add(new Pokemon("Umbreon", "Siniestro",R.drawable.umbreon,"Segunda",
                "Es un Pokémon nocturno, se vuelve más activo a la medianoche. " +
                        "Fue creado cuando la luz lunar alteró la estructura genética de Eevee provocando " +
                        "su evolución. Aprovecha la oscuridad para cazar a sus presas."));
    }

    public List<Pokemon> obtener(){
        return pokemonList;
    }
}
