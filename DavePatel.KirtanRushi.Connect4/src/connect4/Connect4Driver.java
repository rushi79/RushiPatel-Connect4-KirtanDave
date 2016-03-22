package connect4;
import javax.swing.JFrame;;

public class Connect4Driver {

	public static void main(String[] args) {

		JFrame frame=new JFrame("Connect 4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GUI());
		frame.pack();
		frame.setVisible(true);
	}

}
