package com.main;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Player {

    /**
     * 二，创建两名玩家，ID,姓名，手牌，手牌为扑克牌集合
     */
    private String playerName;
    private String playerID;
    public Set<Cards> playCards;

    public String getPlayerName() {
        return playerName;
    }

    public Player(String playerName){
        this.playerID = UUID.randomUUID().toString();
        this.playerName = playerName;
        this.playCards = new HashSet<Cards>();
    }

}
