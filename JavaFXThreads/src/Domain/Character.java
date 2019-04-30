package Domain;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Character extends Thread{

    private int x;
    private int y;
    private int imgNum;
    private Image image;
    private ArrayList<Image> sprite;
    private ArrayList<Image> jump;

    public Character(int x, int y, int imgNum) {
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
        this.sprite = new ArrayList<Image>();
        this.jump = new ArrayList<Image>();
    }

    public Character() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImgNum() {
        return imgNum;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public ArrayList<Image> getSprite() {
        return sprite;
    }

    public void setSprite(ArrayList<Image> sprite) {
        this.sprite = sprite;
    }

    public ArrayList<Image> getJump() {
        return jump;
    }

    public void setJump(ArrayList<Image> jump) {
        this.jump = jump;
    }
    
}
