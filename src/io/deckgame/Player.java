package io.deckgame;

class Player{
    private String name;
    private String cardHolding;
    private int val;
    private int typ;
    public void setPlayerName(String nam){
        name=nam;
    }

    public String getName(){
        return name;
    }

    public void setCard(String card){
        cardHolding=card;
    }
    public String getCardHolding(){
        return cardHolding;
    }

    public void setVal(int a){
        val=a;
    }

    public int getVal(){
        return val;
    }

    public void setTyp(int a){
        typ=a;
    }

    public int getTyp(){
        return typ;
    }


}
