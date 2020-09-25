/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.playerRegister;

import java.util.HashMap;
import java.util.Set;

public class PlayerRegister {
    private HashMap<String, PlayerInformation> playerRegister;
    
    public PlayerRegister(){
        this.playerRegister = new HashMap<>();
    }
    
    public PlayerInformation getPlayer(String userID){
        return this.playerRegister.get(userID);
    }
    
    public Set<String> getAllUserIDs(){
        return this.playerRegister.keySet();
    }
    
    public void addPlayer(String userID, PlayerInformation newPlayer){
        if(!this.playerRegister.containsKey(userID)){
            this.playerRegister.put(userID, newPlayer);
            
            newPlayer.setGameID(this.playerRegister.size());
        }
    }
    
    public void removePlayer(String userID){
        this.playerRegister.remove(userID);
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
}
