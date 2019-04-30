package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int count = 0;
        int y1 = 370;
        while (true) {
            try {
                while (y1 > 230) {
                    super.setY(y1);
                    y1 -= 20;
                    super.setImage(sprite.get(0));
                    Thread.sleep(300);
                }
                while (y1 < 370) {
                    y1 += 20;
                    super.setY(y1);
                    super.setImage(sprite.get(1));
                    Thread.sleep(200);
                }

                super.setY(370);
                super.setImage(sprite.get(2));
                Thread.sleep(800);

            } catch (InterruptedException ex) {
            }
        }
    }
}
