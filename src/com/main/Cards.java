package com.main;

public class Cards {
    private String variety;
    private String crad;

    public int getVariety() {
        if (variety.equals("黑桃"))
            return 4;
        if (variety.equals("红桃"))
            return 3;
        if (variety.equals("梅花"))
            return 2;
        if (variety.equals("方块"))
            return 1;
        else
            return 0;
    }

    public int getCard(){
        if (crad.equals("J"))
            return 11;
        if (crad.equals("Q"))
            return 12;
        if (crad.equals("K"))
            return 13;
        if (crad.equals("A"))
            return 14;
        else
            return Integer.parseInt(crad);
    }

    public Cards(String variety, String crad){
        this.variety = variety;
        this.crad = crad;
    }

    @Override
    public String toString(){
        return this.variety+this.crad;
    }
}
