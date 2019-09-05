import java.lang.reflect.Array;
import java.util.ArrayList;

public class deck {
    //variables
    ArrayList cards = new ArrayList();


    // constructor
    public deck(){
        for(int i = 0; i < 4; i++){
            for(int j = 2; j<=11; j++){
                cards.add(j);
            }
        }
        for(int i = 0; i < 12; i++){
            int t = 10;
            cards.add(t);
        }

    }

    //shuffle
    public void shuffle(){
        for(int i = this.cards.size() - 1; i > 0; i--){
                double j = Math.floor((Math.random() * this.cards.size()));
            Object oneChange = this.cards.get(i);
            Object twoChange = this.cards.get((int)j);

                this.cards.set(i, twoChange);
                this.cards.set((int)j, oneChange);
        }

    }

    //check deck
    public void checkDeck(){
        System.out.println(this.cards.size());
        for(int i = this.cards.size() - 1; i > 0; i--) {
            System.out.print(this.cards.get(i) + ", ");
        }
    }

    //deal two
    public void dealTwo(){


    }

    //deal one
    public Object dealOne(){
        Object card = this.cards.get(0);
        this.cards.remove(0);
        return card;
    }

}
