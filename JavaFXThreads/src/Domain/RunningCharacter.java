package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 16; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int x = 30;
        int count = 0;
        while (true) {
            try {
                while (x < 750) {
                    if (count > 7) {
                        count = 0;
                    } else {
                        x += 20;
                        super.setX(x);
                        super.setImage(sprite.get(count++));
                        Thread.sleep(300);
                    }

                }
                count = 8;
                while (x > 30) {
                   
                    if (count > 15) {
                        count = 8;
                    } else {
                        x -= 20;
                        super.setX(x);
                        super.setImage(sprite.get(count++));
                        Thread.sleep(200);
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
