package com.main;

import java.util.ArrayList;
import java.util.List;
/**
 * 一，创建一副扑克牌，包括四种花色（黑桃，红桃，梅花，方块） 十三种点数（2-10，J,K,Q,A） √
 */

public class NewCards {
    public List<Cards> newCards;

    public NewCards(){
        newCards = new ArrayList<Cards>();
        String[] variety = {"黑桃","红桃","梅花","方块"};
        String[] crad = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for(String i : variety){
            for(String j : crad){
                newCards.add(new Cards(i,j));
            }
        }
    }

    /**
     * forEach遍历牌
     */
    public void forEachCards(){
            System.out.println("牌："+newCards.toString());
    }

}
