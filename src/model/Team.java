package model;

public class Team extends Entity{
    String name;
    String city;


    public Team(int id, String name, String city) {
        super(id);
        this.name = name;
        this.city = city;
    }

    public Team(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
