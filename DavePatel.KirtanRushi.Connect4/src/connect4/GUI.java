package connect4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUI extends JPanel {
	private JFrame frame;
	private JLabel slots[][];
	private static final int rows = 7;
	private static final int columns = 6;
	private static final int fontSize = 14;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	Board board = new Board();

	public GUI() {
		slots = new JLabel[rows][columns];

		setBackground(Color.white);
		setLayout(new GridLayout(rows, columns, 10, 10));
		setPreferredSize(new Dimension(500, 500));
		setFont(new Font("Arial", Font.BOLD, fontSize));

		button1 = new JButton("1");
		button1.setFont(new Font("Courier New", Font.BOLD, fontSize));
		button1.setBackground(Color.green);
		button1.addActionListener(new buttonListener1());

		button2 = new JButton("2");
		button2.setFont(new Font("Courier New", Font.BOLD, fontSize));
		button2.setBackground(Color.green);
		//button2.addActionListener(new buttonListener2());

		button3 = new JButton("3");
		button3.setFont(new Font("Courier New", Font.BOLD, fontSize));
		button3.setBackground(Color.green);
		//button3.addActionListener(new buttonListener3());

		button4 = new JButton("4");
		button4.setFont(new Font("Courier New", Font.BOLD, fontSize));
		button4.setBackground(Color.green);
		//button4.addActionListener(new buttonListener4());

		button5 = new JButton("5");
		button5.setFont(new Font("Courier New", Font.BOLD, fontSize));
		button5.setBackground(Color.green);
		//button5.addActionListener(new buttonListener5());

		button6 = new JButton("6");
		button6.setFont(new Font("Courier New", Font.BOLD, fontSize));
		button6.setBackground(Color.green);
		//button6.addActionListener(new buttonListener6());

		button7 = new JButton("7");
		button7.setFont(new Font("Courier New", Font.BOLD, fontSize));
		button7.setBackground(Color.green);
		//button7.addActionListener(new buttonListener7());

		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				slots[x][y] = new JLabel();
				slots[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				slots[x][y].setBorder(new LineBorder(Color.black));
				add(slots[x][y]);
			}
		}
	}

	private class buttonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			{
				if (event.getSource() == button1) {
					if (!board.isColumnFull(0)) {
						board.update(0);
						slots[rows][columns].setOpaque(true);

						slots[rows][columns].setBackground(Color.red);
					} else {
						slots[rows][columns].setBackground(Color.blue);

					}
				}
			}
		}
	}


	public void updateBoard() {
		int[][] temp = board.getGrid();
		for (int i = 0; i < rows; i++) {
			for (int x = 0; x < columns; x++) {
				if (board.gridEquals(rows, columns, 1)) {
					slots[rows][columns].setOpaque(true);
					if (temp[rows][columns] == 0) {
						slots[rows][columns].setBackground(Color.red);

					} else {
						slots[rows][columns].setBackground(Color.blue);
					}
				}
			}
		}
	}
}
