package cs110.Lab.Lab8;

class Fruit {
    private String name;
    private String colour;

     Fruit(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + " is " + colour;
    }
}


public class Lab8Stage1Fruit {
    public static void main(String[] args) {

        Fruit orange = new Fruit("Orange", "Orange");
        Fruit apple = new Fruit("Apple", "Red");

        System.out.println(orange);
        System.out.println(apple);
    }
}
