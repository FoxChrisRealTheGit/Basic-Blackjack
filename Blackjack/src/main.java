
import java.util.Scanner;

public class main {
    private static boolean playerStay = false;
    private static boolean dealerStay = false;
    private static int curTurn = 1;
    static deck deckOfCards = new deck();


    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        String input;
        System.out.println("Welcome to Blackjack!");
        deckOfCards.shuffle();

        int playerTotal = 0;
        int dealerTotal = 0;

        Object card1;
        Object card2;

        //give player two cards
        card1 = deckOfCards.dealOne();
        card2 = deckOfCards.dealOne();

        System.out.println("You get a " + card1 + " and a " + card2);
        playerTotal = (int)card1 + (int)card2;
        System.out.println("Your total is " + playerTotal);
        System.out.println();

        //give dealer two cards
        card1 = deckOfCards.dealOne();
        card2 = deckOfCards.dealOne();

        System.out.println("Dealer has a " + card1 + " showing, and a hidden card.");
        dealerTotal = (int)card1 + (int)card2;
        System.out.println("Their total is hidden, too.");
        System.out.println();

       while (!playerStay || !dealerStay){
           if(curTurn == 1){
               System.out.println("Would you like to \"hit\" or \"stay\"?");
                input = scnr.next();
                if(input.equalsIgnoreCase("hit")){
                    Object draw = hit();
                    System.out.println("You drew a " + draw);
                    playerTotal += (int)draw;
                    System.out.println("your total is " + playerTotal);
                    System.out.println();
                    if(playerTotal > 21){
                        playerStay = true;
                        dealerStay = true;

                        System.out.println("BUST!");
                        break;
                    }
                }else{
                    System.out.println("Okay, dealer's turn.");
                    playerStay = true;
                    curTurn = 2;
                }
           } else {
               if (playerTotal <= 21) {
                   if (dealerTotal < playerTotal && dealerTotal != 21) {
                       Object draw = hit();
                       System.out.println("Dealer drew a " + draw);
                       dealerTotal += (int)draw;
                       System.out.println("Their total is " + dealerTotal);

                       if(dealerTotal > 21){
                           dealerStay = true;
                       }

                   } else {
                       System.out.println("Dealer stays");
                       System.out.println();
                       dealerStay = true;
                   }
               }
           }

       }

    if((playerTotal > dealerTotal && playerTotal <= 21) || (playerTotal < dealerTotal && dealerTotal> 21)){
        System.out.println("YOU WIN!");
    }else{
        System.out.println("YOU LOSE...");
    }

    }

    public static Object hit(){
       return deckOfCards.dealOne();
    }
}
