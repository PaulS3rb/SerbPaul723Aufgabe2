package model;

public class Player extends Entity{

    String name;
    int age;
    String position;
    int marketValue;


    public Player(int id, String name, int age, String position, int marketValue) {
        super(id);
        this.name = name;
        this.age = age;
        this.position = position;
        this.marketValue = marketValue;
    }
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", marketValue=" + marketValue +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }





    public Player(int id) {
        super(id);
    }


}
