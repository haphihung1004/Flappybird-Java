package flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private ConChim conchimT = new ConChim();
	private Ong ongnuoc1 = new Ong(1000);
	private Ong ongnuoc2 = new Ong(1000 + 280);
	private Ong ongnuoc3 = new Ong(1000 + 280 + 280);
	private Ong ongnuoc4 = new Ong(1000 + 280 + 280 + 280);
	// private KiemTra kiemtraT = new KiemTra();

	private static int diem = 0;

	private static boolean bl1 = false;
	private static boolean bl2 = false;
	private static boolean bl3 = false;
	private static boolean bl4 = false;

	private static boolean ketThuc = false;

	private Thread threadT;

	public GamePanel() {
		threadT = new Thread(this);
		threadT.start(); // khi goi lenh nay se duoc chuyen den phuong thuc
							// run() phia duoi
	}
	

	// ve cac nhan vat trong game
	public void paint(Graphics g) {

		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());

		// them ong nuoc vao nen game
		ongnuoc1.paint(g);
		ongnuoc2.paint(g);
		ongnuoc3.paint(g);
		ongnuoc4.paint(g);

		g.setColor(Color.ORANGE);
		g.fillRect(0, 400, getWidth(), getHeight());

		// them con chim vao game
		conchimT.paint(g);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 20));
		g.drawString("diem: " + diem, 10, 20);
	}

	// implements Runnable thư viện để chạy game

	public void run() {

		// 1 vong lap khong bao gio dung
		while (true) {

			repaint(); // goi lai paint

			ongnuoc1.giamX(); // goi den phuong thuc giamX cua class OngNuoc
			ongnuoc2.giamX();
			ongnuoc3.giamX();
			ongnuoc4.giamX();

			try {
				threadT.sleep(20); // chuong trinh dung lai 20 ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ongnuoc1.laplaiX(); // goi den phuong thuc .... cua class OngNuoc
			ongnuoc2.laplaiX();
			ongnuoc3.laplaiX();
			ongnuoc4.laplaiX();

			conchimT.tangY(); // con chim tu roi xuong dat chet

			// kiem tra dieu kien neu chet thi dung game
			if (chet() == true) {

				//ketThuc = true;

				//threadT.stop();
			}

			quaOngTangDiem(conchimT, ongnuoc1);
			quaOngTangDiem(conchimT, ongnuoc2);
			quaOngTangDiem(conchimT, ongnuoc3);
			quaOngTangDiem(conchimT, ongnuoc4);

		}
	
	}

	public boolean chet() {

		// khi con chim cham dat
		if (conchimT.getY() + ConChim.kichThuoc >= 400) {
			return true;
		}

		// khi con chim cham ong nuoc
		// con chim cham ong nuoc thu 1234
		if (coVaCham(conchimT, ongnuoc1) || coVaCham(conchimT, ongnuoc2)
				|| coVaCham(conchimT, ongnuoc3) || coVaCham(conchimT, ongnuoc4)) {
			return true;
		}

		return false;
	}

	private boolean coVaCham(ConChim chim, Ong ong) {
		if ((chim.getY() <= ong.getH() && (((chim.getX() + ConChim.kichThuoc) >= ong.getX())) && chim
				.getX() <= (ong.getX() + Ong.PI))
				|| (chim.getY() + ConChim.kichThuoc >= ong.getH() + Ong.TRONG
						&& (((chim.getX() + ConChim.kichThuoc) >= ong.getX())) && chim.getX() <= (ong
						.getX() + Ong.PI))) {
			return true;
		}
		return false;
	}

	private void quaOngTangDiem(ConChim chim, Ong ong) {
		if (chim.getX() + ConChim.kichThuoc > ong.getX() && chim.getX() < ong.getX() + 65) {
			ong.setChuaQua(true);
		}
		if (ong.isChuaQua() == true && chim.getX() > ong.getX() + 65) {
			diem+=1000;
			ong.setChuaQua(false);
		}
	}
}
