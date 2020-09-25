package sample.pokemon;

import java.util.ArrayList;

public class Teams {
    private ArrayList<String> team1;
    private ArrayList<String> team2;

    private ArrayList<Integer> value1;
    private ArrayList<Integer> value2;

    private PokemonsList list = new PokemonsList();

    public Teams(){
        this.team1 = new ArrayList<>();
        this.team2 = new ArrayList<>();
        this.value1 = new ArrayList<>();
        this.value2 = new ArrayList<>();
    }

    public void setTeam1(String player, String pokemon){
        this.team1.add(player);
        this.team1.add(pokemon);
        Type type = list.enumPokemon(list.getTypePokemon(pokemon));
        this.value1.add(type.getLife());
        this.value1.add(type.getStamina());
        this.value1.add(type.getAttack());
        this.value1.add(type.getFinalAttack());
    }

    public void setTeam2(String player, String pokemon) {
        this.team2.add(player);
        this.team2.add(pokemon);
        Type type = list.enumPokemon(list.getTypePokemon(pokemon));
        this.value2.add(type.getLife());
        this.value2.add(type.getStamina());
        this.value2.add(type.getAttack());
        this.value2.add(type.getFinalAttack());
    }

    public ArrayList<String> getTeam1(){
        return this.team1;
    }

    public ArrayList<String> getTeam2(){
        return this.team2;
    }

    public ArrayList<Integer> getValue1(){
        return this.value1;
    }

    public ArrayList<Integer> getValue2(){
        return this.value2;
    }
}
