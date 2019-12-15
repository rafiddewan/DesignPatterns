public class VegetableSoup extends  Soup {

    private static final int SOUP_MAX = 700;

    public VegetableSoup(int ml){
        setMl(ml);
    }

    public boolean ifThereIsMeat(){
        return hasIngredient("Chicken");
    }

    @Override
    public boolean fill(int volume, String food) {
        if(isFilled()) return false;
        else{
            setMl(volume);
            addFood(food);

            if(ifThereIsMeat()) {
                emptyBowl();
                System.out.println("I want to vomit");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isFilled() {
        return getMl() >= SOUP_MAX && !isFoodInSoupGone();
    }

    public static void main(String[] args){
        Soup bowl = new VegetableSoup(100);
        bowl.addFood("Carrot");
        bowl.addFood("Brocolli");
        bowl.addFood("cheddar");
        bowl.fill(300, "Chicken");
    }
}
