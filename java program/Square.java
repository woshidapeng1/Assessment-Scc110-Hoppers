import javax.swing.*;
import java.awt.event.*;

public class Square{

    public static String GreenFrog = "images/GreenFrog.png";
    public static String GreenFrog2 = "images/GreenFrog2.png";
    public static String LilyPad = "images/LilyPad.png";
    public static String RedFrog = "images/RedFrog.png";
    public static String RedFrog2 = "images/RedFrog2.png";
    public static String Water = "images/Water.png";

    private JButton btn;
	private int location;
	private String info;

	public Square(int location, String info) {
		this.location = location;
		btn = new JButton();
		this.info = info;
		ImageIcon icon = new ImageIcon(this.info);
		btn.setIcon(icon);

	}

	public JButton getBtn() {
		return btn;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
		ImageIcon icon = new ImageIcon(this.info);
		btn.setIcon(icon);
	}

	public void moveTo(Square squ) {
		squ.setInfo(this.info);
		this.setInfo(Water);

	}

	public boolean canMoveto(Square squ) {
		if (squ.getInfo().equals(Water)) {
			return true;
		} else
			return false;
	}
}