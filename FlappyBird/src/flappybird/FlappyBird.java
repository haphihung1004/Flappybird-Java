package flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class FlappyBird extends JFrame {

	private GamePanel gamePanel = new GamePanel();
	private ConChim conchimM = new ConChim();

	public FlappyBird() {
		setSize(1000, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setResizable(false);

		add(gamePanel);

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (conchimM.getY() >= 0) {
					conchimM.giamY();
				}
				
			}
		});
	}

	public static void main(String[] arg) {
		FlappyBird mh = new FlappyBird();
	}
}
