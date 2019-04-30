package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 4; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Standing" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int count = 0 ;
        while (true) {
            try {
                if(count > 3){
                    count =0;
                }
                else{
                super.setImage(sprite.get(count++));
                Thread.sleep(800);
                }

            } catch (InterruptedException ex) {
            }
        }
    }
}
