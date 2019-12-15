import java.util.ArrayList;

public abstract class Soup {

    private int ml;
    private ArrayList<String> foods;

    public Soup(){
        this.ml = 0;
        this.foods = new ArrayList<String>();
    }

    public abstract boolean fill(int volume, String food);
    public void emptyBowl(){
        ml = 0;
        foods = null;
    };

    public void addFood(String food){
        foods.add(food);
    }

    public boolean removeFood(int index){
        if(foods.size() != 0 && index < foods.size()) {
            foods.remove(index);
            return true;
        }
        return false;
    }

    public boolean hasIngredient(String foodItem){
        return foodItem.contains(foodItem);
    }

    public boolean isFoodInSoupGone(){
        return foods.size() == 0;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public abstract boolean isFilled();

}
