package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Ong {
	public static int caoMax = 400;
	public static int rongMax = 1000;
	public static int PI = 65;
	public static int TRONG = 100;// khoang trong giua 2 ong nuoc
	private int x;

	private int h;

	private boolean chuaQua = false;

	public Ong() {
		ngaunhien();
	}

	public Ong(int x) {
		ngaunhien();
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public int getH() {
		return h;
	}

	public boolean isChuaQua() {
		return chuaQua;
	}

	public void setChuaQua(boolean chuaQua) {
		this.chuaQua = chuaQua;
	}

	// chieu dai ngau nhien cua 1 ong nuoc
	public void ngaunhien() {
		Random rd = new Random();

		h = 100 + rd.nextInt(200); // h1 se bang 1 so ngau nhien trong khoang 0
									// - 199

	}

	// ve ong nuoc
	public void paint(Graphics g) {

		g.setColor(Color.GREEN);
		g.fillRect(x, 0, PI, h);

		g.fillRect(x, h + TRONG, PI, caoMax - h - TRONG);

	}

	// ong nuoc di chuyen giam theo chieu X
	public void giamX() {
		x--;

	}

	// ong nuoc lap lai theo chieu X
	public void laplaiX() {
		if (x == -PI) {
			x = rongMax;

		}
	}
}
