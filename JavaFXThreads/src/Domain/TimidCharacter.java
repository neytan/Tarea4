package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class TimidCharacter extends Character {

    private Image image2;
    private PixelReader pixel;

    public TimidCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        ArrayList<Image> jump = super.getJump();
        for (int i = 0; i < 16; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));

        }
        super.setSprite(sprite);
        for (int j = 0; j < 3; j++) {
            jump.add(new Image(new FileInputStream("src/Assets/Jumping" + j + ".png")));

        }
        super.setJump(jump);
        this.image2 = new Image(new FileInputStream("src/Assets/Running10.png"));
        this.pixel = this.image2.getPixelReader();
    }

    public void run() {
        boolean run = true;
        ArrayList<Image> sprite = super.getSprite();
        ArrayList<Image> jump = super.getJump();
        int count2 = 0;
        int count3 = 1;
        int x = 30;
        int y = 470;
        int count = 0;
        while (run) {
            try {
                while (x < 350) {
                    if (count > 7) {
                        count = 0;
                    } else {
                        x += 20;
                        super.setX(x);
                        super.setImage(sprite.get(count++));
                        Thread.sleep(100);
                    }
                }
                while (y > 350 && x < 500) {
                    super.setY(y);
                    super.setImage(jump.get(count2));
                    y -= 20;
                    Thread.sleep(400);
                }

                while (x < 440) {
                    if (count > 7) {
                        count = 0;
                    } else {
                        x += 20;
                        super.setX(x);
                        super.setImage(sprite.get(count++));
                        Thread.sleep(300);
                    }
                }
                while (y > 40) {
                    super.setY(y);
                    super.setImage(jump.get(count2));
                    y -= 20;
                    Thread.sleep(300);
                }
                while (x < 660) {
                    if (count > 7) {
                        count = 0;
                    } else {
                        x += 20;
                        super.setX(x);
                        super.setImage(sprite.get(count++));
                        Thread.sleep(300);
                    }
                }
                while (y < 260 && x <= 670) {
                    super.setY(y);
                    super.setImage(jump.get(count3));
                    y += 10;
                    Thread.sleep(200);
                }
                super.setY(250);
                Thread.sleep(200);

                while (x <= 670 && y == 260) {
                    count = 8;
                    while (x <= 670 && x > 590) {
                        if (count > 15) {
                            count = 8;
                        } else {
                            x -= 10;
                            super.setX(x);
                            super.setImage(sprite.get(count++));
                            Thread.sleep(300);
                        }
                    }
                    //Recortar imagen
                    int w = 2;
                    int h = 0;
                    int h1 = 40;
                    int w1 = 40;

                    for (int i = 0; i < 6; i++) {

                        WritableImage subImage = new WritableImage(this.pixel, w, h, w1, h1); //Lee los pixeles (imagen, xInicio, yInicio, xFin, yFin)
                        w += 19;
                        w1 -= 11;
                        x -= 3;
                        super.setX(x);
                        super.setImage(subImage);
                        Thread.sleep(300);
                    }
                    WritableImage subImage = new WritableImage(this.pixel, 0, 0, 0, 0); //Lee los pixeles (imagen, xInicio, yInicio, xFin, yFin)
                    super.setImage(subImage);
                    run = false;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
