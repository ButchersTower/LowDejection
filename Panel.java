package overWack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener, KeyListener {
	// Clicking mouse draws the screen.

	int width = 360;
	int height = 420;

	Image[] imageAr;

	Thread thread;
	Image image;
	Graphics g;

	// Vars for gLoop Above

	float[][] squareOne = { { 2, 2 }, { 3, 1 }, { 4, 2 }, { 3, 3 } };
	float[][] squareTwo = { { 3, 5 }, { 4, 3 }, { 6, 4 }, { 5, 6 } };

	float scalar = 40;

	public Panel() {
		super();

		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();

		addKeyListener(this);
		addMouseListener(this);

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		this.setSize(new Dimension(width, height));

		pStart();
	}

	/**
	 * Methods go below here.
	 */

	// draw the squares.
	// draw vectors to each point. record previous and post collision.
	// What information do I need about the collisions?
	// which line causes the collision.
	// some way of knowing the location of the collision, probably scalar from
	// low point to high, or end to start.
	// whether it was before or after the intended point.

	public void pStart() {
		imageInit();
	}

	void drawSquares() {
		float[][] tempSq = squareOne.clone();
		tempSq = scale2dVectAr(scalar, tempSq);

		// draw squareOne and squareTwo.
		g.setColor(Color.BLUE);
		for (int o = 0; o < tempSq.length; o++) {
			if (o + 1 == tempSq.length) {
				g.drawLine((int) tempSq[o][0], (int) tempSq[o][1],
						(int) tempSq[0][0], (int) tempSq[0][1]);
			} else {
				g.drawLine((int) tempSq[o][0], (int) tempSq[o][1],
						(int) tempSq[o + 1][0], (int) tempSq[o + 1][1]);
			}
		}
		tempSq = squareTwo.clone();
		tempSq = scale2dVectAr(scalar, tempSq);
		g.setColor(Color.RED);
		for (int o = 0; o < tempSq.length; o++) {
			if (o + 1 == tempSq.length) {
				g.drawLine((int) tempSq[o][0], (int) tempSq[o][1],
						(int) tempSq[0][0], (int) tempSq[0][1]);
			} else {
				g.drawLine((int) tempSq[o][0], (int) tempSq[o][1],
						(int) tempSq[o + 1][0], (int) tempSq[o + 1][1]);
			}
		}

		// record collisions for both squares interacting with them selves and
		// the other.

		tempSq = scale2dVectAr(scalar, squareOne.clone());
		// run through each point and draw a vect.
		for (int o = 0; o < tempSq.length; o++) {
			g.setColor(new Color((255 / squareOne.length) * o, 255
					- (255 / squareOne.length) * o, 0));
			g.drawLine(0, 0, (int) tempSq[o][0], (int) tempSq[o][1]);
		}

		tempSq = scale2dVectAr(scalar, squareTwo.clone());
		// run through each point and draw a vect.
		for (int o = 0; o < tempSq.length; o++) {
			g.setColor(new Color((255 / squareOne.length) * o, 255
					- (255 / squareOne.length) * o, 0));
			g.drawLine(0, 0, (int) tempSq[o][0], (int) tempSq[o][1]);
		}
	}

	float[][] scale2dVectAr(float scalar, float[][] vectAr) {
		for (int v = 0; v < vectAr.length; v++) {
			vectAr[v] = Vect2d.vectMultScalar(scalar, vectAr[v]);
		}
		return vectAr;
	}

	/**
	 * Methods go above here.
	 * 
	 */

	public void drwGm() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

	public void imageInit() {
		/**
		 * imageAr = new Image[1]; ImageIcon ie = new
		 * ImageIcon(this.getClass().getResource( "res/image.png")); imageAr[0]
		 * = ie.getImage();
		 */
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		drawSquares();
		drwGm();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub.
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
