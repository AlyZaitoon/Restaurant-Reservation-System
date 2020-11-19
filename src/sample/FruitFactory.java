package sample;

public class FruitFactory {
    public Fruit getFruit(String fruitName){

        if(fruitName.equalsIgnoreCase("Mango"))
            return new Mango();
        else if(fruitName.equalsIgnoreCase("Watermelon"))
            return new Watermelon();
        else if(fruitName.equalsIgnoreCase("Banana"))
            return new Banana();
        return null;
    }

}
