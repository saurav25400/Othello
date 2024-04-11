package Othello;

public class Player {
    private String name;
    private int color;

    Player(String name,int color){
        this.name=name;
        this.color=color;
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
