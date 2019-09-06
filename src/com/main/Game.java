package com.main;

import sun.awt.geom.AreaOp;

import java.util.*;

public class Game {

    /**
     * 一，创建一副扑克牌，包括四种花色（黑桃，红桃，梅花，方块） 十三种点数（2-10，J,K,Q,A） √
     *二，创建两名玩家，ID,姓名，手牌，手牌为扑克牌集合 √
     * 三，洗牌，打乱扑克牌顺序 √
     * 四，发牌，将扑克牌每人一张的顺序发两张 √
     * 五，游戏，比较两个人手中的各自最大的牌进行比较，点数大的赢，若相等则按照花色匹配
     */

    public List<Cards> washCrads = new ArrayList<Cards>();

    /**
     * 洗牌
     * 先创建一副牌，接着遍历内部数据，使用random随机得到一个数， (不用)
     * 新方法：创建一个list，将set中的数据放入list，使用collections的shuffle方法打乱顺序
     */
    public void washCrads(NewCards nc){
        for (int i = 0;i<nc.newCards.size();i++){
            washCrads.add(nc.newCards.get(i));
        }
        Collections.shuffle(washCrads);
//        System.out.println(washCrads.toString());
    }

    /**
     * 发牌，将扑克牌每人一张的顺序发两张
     */
    public Boolean sendCrads(Player payer1,Player payer2){
        for (int i=0; i<4; i++){
            if (i%2==0){
                payer2.playCards.add(washCrads.get(i));
            }
            else{
                payer1.playCards.add(washCrads.get(i));
            }
        }
        return true;
    }

    /**
     * 比较大小，首先按照牌的点数crad比较，如果相同，则按照花色比较
     */
    public Cards isMax(Cards cards1, Cards cards2){
        Cards end = cards1;
        try {
            int cardNum1 = cards1.getCard();
            int cardNum2 = cards2.getCard();
            if(cardNum1 > cardNum2){
                end = cards1;
            }
            else if (cardNum1 == cardNum2){
                if (cards1.getVariety() > cards2.getVariety()) {
                    end = cards1;
                }
                else {
                    end = cards2;
                }
            }
            else{
                end = cards2;
            }
        } catch (NumberFormatException e) {
            System.out.println("-----------比较出错，请重新启动游戏-----------");
        }
        return end;
    }


    public static void main(String[] arg0){
        System.out.println("----------------游戏开始----------------");

//      创建牌
        NewCards nc = new NewCards();
//      输出牌
        nc.forEachCards();

//      创建玩家，获得玩家姓名
        Scanner console = new Scanner(System.in);
        System.out.println("----------请输入玩家1的姓名----------");
        String name1 = console.next();
        Player player1 = new Player(name1);
        System.out.println("----------请输入玩家2的姓名----------");
        String name2 = console.next();
        Player player2 = new Player(name2);

        System.out.println("----------两位玩家用户分别为："+player1.getPlayerName()+" 和 "+player2.getPlayerName());

//      创建对象，调用洗牌方法
        System.out.println("----------正在洗牌，请稍等----------");
        Game game = new Game();
        game.washCrads(nc);

//      发牌
        game.sendCrads(player1,player2);
        System.out.println("----------------发牌完成----------------");
        System.out.println("玩家："+player1.getPlayerName()+" 的牌为："+player1.playCards.toString());
        System.out.println("玩家："+player2.getPlayerName()+" 的牌为："+player2.playCards.toString());

//        比较大小,首先先比较自己的牌，接着再两个玩家之间对比
        Iterator<Cards> it = player1.playCards.iterator();
        Cards maxPlayer1 = game.isMax(it.next(),it.next());
        it = player2.playCards.iterator();
        Cards maxPlayer2 = game.isMax(it.next(),it.next());

        Cards max = game.isMax(maxPlayer1,maxPlayer2);
        if (max.toString().equals(maxPlayer1.toString())){
            System.out.println("胜利者："+player1.getPlayerName());
        }else{
            System.out.println("胜利者："+player2.getPlayerName());
        }

//        nc.isMax(player1.playCards,player2.playCards);
    }



}
