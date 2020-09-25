package sample.playerRegister;

public class PlayerInformation {

    private int gameID;
    private String userID;
    private String name;
    private String lastName;
    private String nickName;
    private int victories;

    public PlayerInformation(int gameID, String userID, String name, String lastName, String nickName, int victories) {
        this.userID = userID;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.victories = victories;
        this.gameID = gameID;
    }
    
    public PlayerInformation(String userID, String name, String lastName, String nickName){
        this(0, userID, name, lastName, nickName, 0);
    }

    public String getUserID() {
        return this.userID;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getVictories() {
        return this.victories;
    }

    @Override
    public String toString() {
        return this.gameID + " " + this.name + " " + this.lastName
                + " " + this.userID + " " + this.nickName + " " + this.victories;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getGameID() {
        return gameID;
    }
    
    
}
