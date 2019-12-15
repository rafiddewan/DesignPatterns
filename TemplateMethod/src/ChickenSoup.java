import java.util.ArrayList;

public class ChickenSoup extends Soup {

    private static final int SOUP_MAX = 500;

    public ChickenSoup(int ml){
        setMl(ml);
    }

    @Override
    public boolean fill(int volume, String food) {
        if(isFilled()) return false;
        else{
            setMl(volume);
            addFood(food);
        }
        return true;
    }

    @Override
    public boolean isFilled() {
        return getMl() >= SOUP_MAX && !isFoodInSoupGone();
    }

    public static void main(String[] args){
        Soup bowl = new ChickenSoup(100);
        bowl.addFood("Chicken");
        bowl.addFood("Brocolli");
        bowl.addFood("Pepper");
        bowl.fill(300, "Chicken");
    }
}
