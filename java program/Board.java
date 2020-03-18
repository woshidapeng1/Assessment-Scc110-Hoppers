import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board implements ActionListener{
    private static Square[] squArr = new Square[25];
    private JFrame win = new JFrame("Hoppers");
    private JOptionPane victoryMessage; 
    

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
                
                    if ((row + col) % 2 != 0){
                        squArr[i] = new Square(i, Square.Water);
                    }else {
				        squArr[i] = new Square(i, Square.LilyPad);
            }
                    if(i==2 || i==10 ){
                        squArr[i] = new Square(i,Square.GreenFrog);
                    }
                    if(i==20){
                        squArr[i] = new Square(i,Square.RedFrog);
                    }
            

                    
                    squArr[i].getBtn().addActionListener(this);
                    squArr[i].getBtn().setActionCommand(i + "");
                    panel.add(squArr[i].getBtn());
        
                }
        
            }
           
            @Override
            public void actionPerformed(ActionEvent e) {
    
                int num = Integer.parseInt(e.getActionCommand());
            if (squArr[num].getInfo().equals(Square.GreenFrog)) {
                    squArr[num].setInfo(Square.GreenFrog2);
                } else if (squArr[num].getInfo().equals(Square.GreenFrog2)) {
                    squArr[num].setInfo(Square.GreenFrog);
                }
        
                else if (squArr[num].getInfo().equals(Square.LilyPad)) {
        
                        if (num-12>=0&&squArr[num - 12].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num - 6].getInfo().equals(Square.GreenFrog)) {
                                squArr[num - 12].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num - 6].setInfo(Square.LilyPad);
        
                            }
                        } else if (num+12<=24&&squArr[num + 12].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num + 6].getInfo().equals(Square.GreenFrog)) {
                                squArr[num + 12].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num + 6].setInfo(Square.LilyPad);
        
                            }
                        } else if (num-8>=0&&squArr[num - 8].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num - 4].getInfo().equals(Square.GreenFrog)) {
                                squArr[num - 8].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num - 4].setInfo(Square.LilyPad);
        
                            }
                        } else if (num+8<=24&&squArr[num + 8].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num + 4].getInfo().equals(Square.GreenFrog)) {
                                squArr[num + 8].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num + 4].setInfo(Square.LilyPad);
        
                            }        
                        }else if (num-20>=0&&squArr[num - 20].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num - 10].getInfo().equals(Square.GreenFrog)) {
                                squArr[num - 20].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num - 10].setInfo(Square.LilyPad);
        
                            }        
                        }else if (num+20<=24&&squArr[num + 20].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num + 10].getInfo().equals(Square.GreenFrog)) {
                                squArr[num + 20].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num + 10].setInfo(Square.LilyPad);
        
                            }        
                        }else if (num-4>=0&&squArr[num - 4].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num - 2].getInfo().equals(Square.GreenFrog)) {
                                squArr[num - 4].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num - 2].setInfo(Square.LilyPad);
        
                            }        
                        }else if (num+4<=24&&squArr[num + 4].getInfo().equals(Square.GreenFrog2)) {
                            if (squArr[num + 2].getInfo().equals(Square.GreenFrog)) {
                                squArr[num + 4].setInfo(Square.LilyPad);
                                squArr[num].setInfo(Square.GreenFrog);
                                squArr[num + 2].setInfo(Square.LilyPad);
        
                            }        
                        }
                    
                }
            if (squArr[num].getInfo().equals(Square.RedFrog)) {
                squArr[num].setInfo(Square.RedFrog2);
            } else if (squArr[num].getInfo().equals(Square.RedFrog2)) {
                squArr[num].setInfo(Square.RedFrog);
            }
    
            else if (squArr[num].getInfo().equals(Square.LilyPad)) {
    
                    if (num-12>=0&&squArr[num - 12].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num - 6].getInfo().equals(Square.GreenFrog)) {
                            squArr[num - 12].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num - 6].setInfo(Square.LilyPad);
    
                        }
                    } else if (num+12<=24&&squArr[num + 12].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num + 6].getInfo().equals(Square.GreenFrog)) {
                            squArr[num + 12].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num + 6].setInfo(Square.LilyPad);
    
                        }
                    } else if (num-8>=0&&squArr[num - 8].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num - 4].getInfo().equals(Square.GreenFrog)) {
                            squArr[num - 8].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num - 4].setInfo(Square.LilyPad);
    
                        }
                    } else if (num+8<=24&&squArr[num + 8].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num + 4].getInfo().equals(Square.GreenFrog)) {
                            squArr[num + 8].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num + 4].setInfo(Square.LilyPad);   
                        }   
                    }else if (num-20>=0&&squArr[num - 20].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num - 10].getInfo().equals(Square.GreenFrog)) {
                            squArr[num - 20].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num - 10].setInfo(Square.LilyPad);   
                        }   
                    }else if (num+20<=24&&squArr[num + 20].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num + 10].getInfo().equals(Square.GreenFrog)) {
                            squArr[num + 20].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num + 10].setInfo(Square.LilyPad);   
                        }   
                    }else if (num-4>=0&&squArr[num - 4].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num - 2].getInfo().equals(Square.GreenFrog)) {
                            squArr[num - 4].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num - 2].setInfo(Square.LilyPad);   
                        }   
                    }else if (num+4<=24&&squArr[num + 4].getInfo().equals(Square.RedFrog2)) {
                        if (squArr[num + 2].getInfo().equals(Square.GreenFrog)) {
                            squArr[num + 4].setInfo(Square.LilyPad);
                            squArr[num].setInfo(Square.RedFrog);
                            squArr[num + 2].setInfo(Square.LilyPad);   
                        }   
                    }          
                }
            }
            private void checkWin(){
                int greenFrog = 0;
                boolean redFrog = false;
                for(int i = 0; i < 24; i++){
                    if(squArr[i].hasfrog()==1){
                        greenFrog++;
                    }else if(squArr[i].hasfrog()==2){
                        redFrog = true;
                    }
                }
                if(greenFrog > 0 || !redFrog){
                    return;
                }
                JOptionPane.showMessageDialog(win, "Winner!", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
