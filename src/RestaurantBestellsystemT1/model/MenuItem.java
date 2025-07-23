package RestaurantBestellsystemT1.model;

public class MenuItem {
    private int id;
    private String name;
    private float preis;

    public MenuItem(int id, String name, float preis){
        this.id = id;
        this.name = name;
        this.preis = preis;
    }

    public int getId() { return id; }
    public String getName(){return name;}
    public float getPreis(){return preis;}

    @Override
    public String toString() {
        return id + " " + name + " " + preis + " €";
    }

}
