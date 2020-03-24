import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Square extends JButton {

    private static String PATH = "pieces/";
    public static String GREEN_FORG = PATH + "GreenFrog.png";
    public static String GREEN_FORG_SELECT = PATH + "GreenFrog2.png";
    public static String RED_FORG = PATH + "RedFrog.png";
    public static String RED_FORG_SELECT = PATH + "RedFrog2.png";
    public static String WATER = PATH + "Water.png";
    public static String LILY_PAD = PATH + "LilyPad.png";

    // the position of current square
    private final int r, c;

    public Square(int r, int c, String type) {
        this.r = r;
        this.c = c;
        setType(type);
    }

    public String toString() {
        return String.format("%d %d %s", r, c, getType());
    }

    // the type of current square
    private String type;

    public void setType(String image) {
        this.type = image;
        ImageIcon icon = new ImageIcon(image);
        this.setIcon(icon);
    }

    public String getType() {
        return type;
    }

    /**
     * move to the target square
     * @param squareTable
     * @param target
     * @return 
     */
    public boolean moveTo(Square[][] squareTable, Square target) {

        int r1 = target.r;
        int c1 = target.c;

        if (!(r == r1 && Math.abs(c - c1) == 4
                || c == c1 && Math.abs(r - r1) == 4
                || Math.abs(c - c1) == 2 && Math.abs(r - r1) == 2)) {
            // the current position and target position is NOT horizontally, vertically or diagonally
            return false;
        }
        int midr = (r1 + r) / 2;
        int midc = (c1 + c) / 2;

        if (!squareTable[midr][midc].type.equals(GREEN_FORG)
                && !squareTable[midr][midc].type.equals(GREEN_FORG_SELECT)) {
            // if there is NO green forg to jump over
            return false;
        }

        if (!squareTable[r1][c1].type.equals(LILY_PAD)) {
            // destination square MUST be LilyPad.
            return false;
        }
        // make a jump
        String thisType = getType();
        this.setType(LILY_PAD);
        squareTable[midr][midc].setType(LILY_PAD);
        squareTable[r1][c1].setType(thisType);

        // System.out.println("Jump Success");
        return true;
    }

    /**
     * select select image
     * @param b 
     */
    public void setSelected(boolean b) {

        if (b == true) {
            if (this.getType().equals(GREEN_FORG)) {
                setType(GREEN_FORG_SELECT);
            } else if (this.getType().equals(RED_FORG)) {
                setType(RED_FORG_SELECT);
            }
        } else if (this.getType().equals(GREEN_FORG_SELECT)) {
            setType(GREEN_FORG);
        } else if (this.getType().equals(RED_FORG_SELECT)) {
            setType(RED_FORG);
        }

    }

}
