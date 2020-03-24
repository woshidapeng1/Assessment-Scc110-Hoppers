import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JFrame implements ActionListener {

    private Square[][] squareTable;// contains all the square
    private Square prevSqu;// previous selected square

    // initialize the game board
    public Board() {

        GridLayout gl = new GridLayout(5, 5);
        this.setLayout(gl);
        this.setTitle("Hoppers");
        this.setLocation(300, 200);
        this.setPreferredSize(new Dimension(800, 800));
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        init();
    }

    // init the game
    private void init() {
        int level = 0;

        // ask user for input level
        try {
            String s = JOptionPane.showInputDialog(this, "Input Level(1-40)", "level select", JOptionPane.INFORMATION_MESSAGE);
            level = Integer.parseInt(s) - 1;
        } catch (Exception ex) {
            // System.out.println(ex.toString());
            this.dispose();
        }

        // remove the old component
        this.getContentPane().removeAll();

        // create the 5x5 square
        prevSqu = null;
        squareTable = new Square[5][];
        for (int i = 0; i < 5; i++) {
            squareTable[i] = new Square[5];
        }

        // add the button into panel
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                String type;
                switch (gameData[level][r][c]) {
                    case 1:
                        type = Square.LILY_PAD;
                        break;
                    case 2:
                        type = Square.GREEN_FORG;
                        break;
                    case 3:
                        type = Square.RED_FORG;
                        break;
                    default:
                        type = Square.WATER;
                        break;
                }
                Square squ = new Square(r, c, type);
                squareTable[r][c] = squ;
                squ.addActionListener(this);
                this.add(squ);
            }
        }
       this.setVisible(true);
    }

    private boolean checkSuccess() {

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (squareTable[r][c].getType().equals(Square.GREEN_FORG) || squareTable[r][c].getType().equals(Square.GREEN_FORG_SELECT)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Square curSqu = (Square) e.getSource();

        // remove the old selected square
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                squareTable[r][c].setSelected(false);
            }
        }

        // only red frog and green frog can jump
        if (prevSqu != null && (prevSqu.getType().equals(Square.RED_FORG) || prevSqu.getType().equals(Square.GREEN_FORG))) {
            
            // call the moveTo method
            prevSqu.moveTo(squareTable, curSqu);
        }

        curSqu.setSelected(true);
        prevSqu = curSqu;

        // check success
        if (checkSuccess()) {
            JOptionPane.showMessageDialog(this, "You Win The Game!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
            init();
        }

    }

    // the 40 level data
    final int[][][] gameData = {
        {
            // 1
            {3, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},},
        {
            // 2
            {1, 0, 1, 0, 3},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 2},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},},
        {
            // 3 
            {1, 0, 1, 0, 1},
            {0, 1, 0, 2, 0},
            {1, 0, 3, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},},
        {
            // 4 
            {3, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 5 
            {1, 0, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {2, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {3, 0, 1, 0, 1},},
        {
            // 6 
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 2, 0, 3},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 7
            {1, 0, 2, 0, 3},
            {0, 1, 0, 1, 0},
            {2, 0, 1, 0, 2},
            {0, 1, 0, 1, 0},
            {1, 0, 2, 0, 1},},
        {
            // 8
            {1, 0, 3, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 9
            {1, 0, 2, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 3, 0, 2},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 10
            {1, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {2, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 3},},
        {
            // 11
            {3, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 12
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 2, 0, 2},
            {0, 1, 0, 1, 0},
            {3, 0, 1, 0, 1},},
        {
            // 13 
            {1, 0, 1, 0, 3},
            {0, 2, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {1, 0, 2, 0, 1},},
        {
            // 14 
            {1, 0, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {2, 0, 1, 0, 2},
            {0, 2, 0, 1, 0},
            {1, 0, 3, 0, 2},},
        {
            // 15
            {2, 0, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 2},
            {0, 3, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 16 
            {1, 0, 1, 0, 3},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 2},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},},
        {
            // 17 
            {1, 0, 3, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 2, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 2, 0, 1},},
        {
            // 18 
            {1, 0, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {2, 0, 2, 0, 2},
            {0, 2, 0, 2, 0},
            {1, 0, 3, 0, 1},},
        {
            // 19 
            {2, 0, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {3, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 2, 0, 1},},
        {
            // 20
            {1, 0, 2, 0, 2},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 2},
            {0, 3, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 21
            {2, 0, 1, 0, 1},
            {0, 2, 0, 3, 0},
            {1, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 2},},
        {
            // 22
            {1, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {2, 0, 3, 0, 2},},
        {
            // 23 
            {1, 0, 1, 0, 2},
            {0, 2, 0, 2, 0},
            {1, 0, 2, 0, 1},
            {0, 2, 0, 1, 0},
            {2, 0, 1, 0, 3},},
        {
            // 24 
            {1, 0, 2, 0, 1},
            {0, 2, 0, 2, 0},
            {2, 0, 2, 0, 1},
            {0, 2, 0, 1, 0},
            {1, 0, 1, 0, 3},},
        {
            // 25
            {1, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 2},
            {0, 2, 0, 1, 0},
            {2, 0, 1, 0, 3},},
        {
            // 26 
            {3, 0, 2, 0, 1},
            {0, 2, 0, 1, 0},
            {2, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 27 
            {1, 0, 1, 0, 3},
            {0, 1, 0, 1, 0},
            {2, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {2, 0, 2, 0, 1},},
        {
            // 28 
            {1, 0, 3, 0, 1},
            {0, 2, 0, 2, 0},
            {2, 0, 1, 0, 2},
            {0, 1, 0, 1, 0},
            {2, 0, 1, 0, 2},},
        {
            // 29 
            {1, 0, 3, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 2, 0, 1},
            {0, 2, 0, 2, 0},
            {2, 0, 1, 0, 2},},
        {
            // 30
            {2, 0, 2, 0, 1},
            {0, 2, 0, 2, 0},
            {2, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {1, 0, 1, 0, 3},},
        {
            // 31
            {1, 0, 2, 0, 3},
            {0, 2, 0, 1, 0},
            {1, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 1},},
        {
            // 32
            {1, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {2, 0, 2, 0, 1},
            {0, 2, 0, 2, 0},
            {3, 0, 2, 0, 1},},
        {
            // 33 
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {2, 0, 3, 0, 2},
            {0, 2, 0, 2, 0},
            {1, 0, 2, 0, 1},},
        {
            // 34 
            {1, 0, 2, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {2, 0, 2, 0, 3},},
        {
            // 35
            {2, 0, 1, 0, 2},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 3},},
        {
            // 36 
            {1, 0, 2, 0, 1},
            {0, 2, 0, 2, 0},
            {1, 0, 1, 0, 1},
            {0, 2, 0, 2, 0},
            {2, 0, 1, 0, 3},},
        {
            // 37 
            {1, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {2, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {3, 0, 2, 0, 1},},
        {
            // 38 
            {2, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {1, 0, 1, 0, 1},
            {0, 2, 0, 1, 0},
            {1, 0, 2, 0, 3},},
        {
            // 39 
            {3, 0, 1, 0, 2},
            {0, 1, 0, 2, 0},
            {2, 0, 2, 0, 1},
            {0, 2, 0, 1, 0},
            {1, 0, 2, 0, 1},},
        {
            // 40 
            {1, 0, 1, 0, 2},
            {0, 2, 0, 1, 0},
            {2, 0, 2, 0, 1},
            {0, 1, 0, 2, 0},
            {3, 0, 2, 0, 1},},};

}
