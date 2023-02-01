package io.deckgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeckGame {

    private Deck deck=new Deck();
    private HashMap<String,Player> playerList=new HashMap<>();
    public void startPlaying(){

        System.out.println("Let's start the Game,\n");
        System.out.println("But let me take you through some rules \n " +
                "i) Each Player will get one card each from the shuffled deck (requires atleast 2 player two play the game\n" +
                "ii) Player with higher value card will win and for same value priority will be Spades > Hearts > Clubs > diamonds\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n=scanner.nextInt();



        for(int x=0;x<n;x++)
        {
            System.out.print("Enter name of player: ");
            String name;
            name = scanner.next();
            name += scanner.nextLine();
            createPlayer(name);
        }

        System.out.print("Do you want to delete any player..... (only Yes or No)");
        String check=scanner.nextLine();

        while(check.equalsIgnoreCase("Yes"))
        {


            System.out.print("Please enter name of player to be deleted: ");
            String delete=scanner.nextLine();
            deletePlayer(delete);

            System.out.print("Still do you want to delete any player..... (only Yes or No)");
            check=scanner.nextLine();
        }

        System.out.print("Do you want to shuffle the deck... (Only Yes or No)");
        String shuffle=scanner.nextLine();

        if(shuffle.equalsIgnoreCase("Yes"))
        {
            deck.shuffleDeck();
        }


        System.out.print("Do you want to print the deck... (Only Yes or No)");

        if(shuffle.equalsIgnoreCase("Yes"))
        {
            deck.printDeck();
        }

        System.out.println("Now the real game Begins (:\n");

        decideTheWinner();

        deck.restoreDeck();

    }

    private void createPlayer(String name){

        Player player=new Player();
        player.setPlayerName(name);
        playerList.put(name,player);

        String card=deck.getCard();
        player.setCard(card);

        player.setTyp(deck.getTyp());
        player.setVal(deck.getVal());
        System.out.println("Player registered Successfully (: "+player.getName()+"\n");
    }
    private void deletePlayer(String deletePlayer){
        Player player=playerList.get(deletePlayer);
        deck.returnCardToDeck(player.getCardHolding());
        playerList.remove(deletePlayer);
    }

    private void decideTheWinner(){
        int mx=0;
        int level=5;
        String winner="None";
        for(Map.Entry<String,Player> itr : playerList.entrySet())
        {
            System.out.println("Player Name: "+itr.getValue().getName()+"\n"+
                            "Player Card: "+itr.getValue().getCardHolding()+"\n"
//                                "Player value: "+itr.getValue().val+"\n"+
//                                "Player type: "+itr.getValue().typ+"\n"
            );

            if(mx<itr.getValue().getVal())
            {
                mx=itr.getValue().getVal();
                winner=itr.getValue().getName();
                level=itr.getValue().getTyp();
            }
            if(mx==itr.getValue().getVal()&&level>itr.getValue().getTyp())
            {
                level=itr.getValue().getTyp();
                winner=itr.getValue().getName();
            }


        }

        System.out.println("And the winner is "+winner);

    }
}
