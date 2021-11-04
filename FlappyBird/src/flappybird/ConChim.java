package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ConChim {
	public static int kichThuoc = 25;
	private static int y = 0;
	private static int x = 300;
	
	//lay ra gia tri y
	public static int getY() {
        return y;
    }
	
	//lay ra gia tri x
	public static int getX() {
        return x;
    }

	//ve con chim
	public void paint(Graphics g) {
		//g.setColor(Color.RED);
		//g.fillRect(x, y, kichThuoc, kichThuoc);
		
		try {
			BufferedImage bird = ImageIO.read(new File(".//res//Bird.png"));
			g.drawImage(bird, x, y,kichThuoc, kichThuoc, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//con chim roi xuong dat
	public void tangY() {
		y++;
	}
	
	//con chim bay len troi
	public void giamY() {
		y -= 30;
	}
}
