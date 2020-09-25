/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.playerRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Ismael
 */
public class PlayerRegister {
    private HashMap<String, PlayerInformation> playerRegister;

    public PlayerRegister(){
        this.playerRegister = new HashMap<>();
    }

    public PlayerInformation getPlayer(String userID){
        return this.playerRegister.get(userID);
    }

    public ArrayList<String> getAllUserIDs(){
        ArrayList<String> list = new ArrayList<>();
        for(String index : this.playerRegister.keySet()){
            list.add(index);
        }
        return list;
    }

    public void addPlayer(String userID, PlayerInformation newPlayer){
        if(!this.playerRegister.containsKey(userID)){
            this.playerRegister.put(userID, newPlayer);

            newPlayer.setGameID(this.playerRegister.size());
        }
    }

    public void addPlayerFromFile(String userID, PlayerInformation newPlayer){
        if(!this.playerRegister.containsKey(userID)){
            this.playerRegister.put(userID, newPlayer);
        }
    }

    public void replacePlayer(String userID, PlayerInformation newPlayer){
        this.playerRegister.put(userID, newPlayer);
    }

    public void removePlayer(String userID){
        this.playerRegister.remove(userID);
    }

    public ArrayList<String> getNameAndLastNamePlayer(){
        ArrayList<String> list = new ArrayList<>();
        for(PlayerInformation index : this.playerRegister.values()){
            StringBuilder player = new StringBuilder();
            player.append(index.getName()).append(" ").append(index.getLastName());
            list.add(String.valueOf(player));
        }
        return list;
    }

    @Override
    public String toString(){
        StringBuilder toPrint = new StringBuilder();
        for(PlayerInformation index : this.playerRegister.values()){
            toPrint.append(index.toString()).append("\n");
        }
        return String.valueOf(toPrint);
    }

    public int getSize(){
        return this.playerRegister.size();
    }

    public boolean containsPlayer(String id){
        return this.playerRegister.containsKey(id);
    }

    public int getVictoriesOf(PlayerInformation player){
        return player.getVictories();
    }

    public void setVictoriesOf(PlayerInformation player, int victories){
        player.setVictories(victories);
    }
}
