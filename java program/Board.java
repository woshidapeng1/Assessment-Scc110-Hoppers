import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board implements ActionListener{
    private static Square[] squArr = new Square[25];
    Square startSquare, endSquare;
    static int s1 = -1;
    static int s2 = -1;
    int step = 1;

    public Board(){

        JFrame frame = new JFrame("Game");

        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponets(panel);

        frame.setVisible(true);
    }
    void placeComponets(JPanel panel) {
                GridLayout gl = new GridLayout(5, 5);
                panel.setLayout(gl);
        
                for (int i = 0; i < squArr.length; i++) {
                    int row = i / 5;
                    int col = i % 5;
                    String info = "";
                    info=Square.Water;
                    if ((row + col) % 2 != 0)
				squArr[i] = new Square(i, info);
			else {
				squArr[i] = new Square(i, Square.LilyPad);
			}
                    
                    squArr[i].getBtn().addActionListener(this);
                    squArr[i].getBtn().setActionCommand(i + "");
                    panel.add(squArr[i].getBtn());
        
                }
        
            }
            @Override
            public void actionPerformed(ActionEvent e) {
        
                int num = Integer.parseInt(e.getActionCommand());
                int row = num / 5;
                int col = num % 5;
            }
    
}