package tictactoe;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToe implements ActionListener {
    
    Random random=new Random();//picks random value from 0 and 1 to decide the turn of the player at the beginning of the game
    JFrame frame=new JFrame();
    JPanel t_panel=new JPanel();
    JPanel button_Panel = new JPanel();
    JLabel textField=new JLabel();
    JButton[] buttons=new JButton[9];//button array contains all the buttons 0 to 9.
    boolean player1_turn;//boolean to check whether it is player1 turn or not. if not it will be player2's turn. (player1 means 'X')

    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textField.setBackground(Color.black);
        textField.setForeground(Color.green);
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TicTacToe");
        textField.setOpaque(true);
        
        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);
        
        button_Panel.setLayout(new GridLayout(3,3));
        
        for(int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            button_Panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,75));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        
        t_panel.add(textField);
        frame.add(t_panel,BorderLayout.NORTH);
        frame.add(button_Panel);
        
        firstTurn();//this will return '0' for 'X's turn or '1' for 'O's turn
    }
    
    public int drawcount=0;//these are used to check whether  the match is a draw
    public int xwins=0;
    public int owins=0;
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //for every action get the source which will be a button set the text of the button corresponding to the turn ('X' or 'O') and changes the turn to next player.
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])//get the source of action and check whether it is in buttons array.
            {
                drawcount++;
                if(player1_turn)//after getting the source check the player turn if player1_turn returns true 'X' is the player.
                {
                    if("".equals(buttons[i].getText()))
                    {
                        buttons[i].setForeground(Color.black);
                        buttons[i].setText("X");
                        player1_turn=false;//player1_turn set to 'false' to change the turn to player 'O'.
                        textField.setText("O turn");
                        check();//checking whether there is a winning combinations contans the valu 'X'
                    }
                }
                else if("".equals(buttons[i].getText()))
                    {
                        buttons[i].setForeground(Color.pink);
                        buttons[i].setText("O");
                        player1_turn=true;//player1_turn set to 'true' to change the turn to player 'X'.
                        textField.setText("X turn");
                        check();//checking whether there is a winning combinations contans the valu 'O'
                    }
            }
        }
        
    }
    
    public void firstTurn()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(random.nextInt(2)==0)
        {
            player1_turn=true;
            textField.setText("X turn");
        }
        else
        {
            player1_turn=false;
            textField.setText("O turn");
        }
    }
    
    //the winning combinations are:
    //rows
    //0 1 2
    //3 4 5
    //6 7 8
    //columns
    //0 3 6
    //1 4 7
    //2 5 8
    //diagonals
    //0 4 8
    //2 4 6
    
    public void check()
    {
        //for "X" checking all the rows and colums and diagonals
        if("X".equals(buttons[0].getText())&&"X".equals(buttons[1].getText())&&"X".equals(buttons[2].getText()))
        {
            xWins(0,1,2);
        }
        if("X".equals(buttons[3].getText())&&"X".equals(buttons[4].getText())&&"X".equals(buttons[5].getText()))
        {
            xWins(3,4,5);
        }
        if("X".equals(buttons[6].getText())&&"X".equals(buttons[7].getText())&&"X".equals(buttons[8].getText()))
        {
            xWins(6,7,8);
        }
        if("X".equals(buttons[0].getText())&&"X".equals(buttons[4].getText())&&"X".equals(buttons[8].getText()))
        {
            xWins(0,4,8);
        }
        if("X".equals(buttons[0].getText())&&"X".equals(buttons[3].getText())&&"X".equals(buttons[6].getText()))
        {
            xWins(0,3,6);
        }
        if("X".equals(buttons[1].getText())&&"X".equals(buttons[4].getText())&&"X".equals(buttons[7].getText()))
        {
            xWins(1,4,7);
        }
        if("X".equals(buttons[2].getText())&&"X".equals(buttons[5].getText())&&"X".equals(buttons[8].getText()))
        {
            xWins(2,5,8);
        }
        if("X".equals(buttons[2].getText())&&"X".equals(buttons[4].getText())&&"X".equals(buttons[6].getText()))
        {
            xWins(2,4,6);
        }
        
        //for "O" checking all the rows and colums and diagonals
        if("O".equals(buttons[0].getText())&&"O".equals(buttons[1].getText())&&"O".equals(buttons[2].getText()))
        {
            oWins(0,1,2);
        }
        if("O".equals(buttons[3].getText())&&"O".equals(buttons[4].getText())&&"O".equals(buttons[5].getText()))
        {
            oWins(3,4,5);
        }
        if("O".equals(buttons[6].getText())&&"O".equals(buttons[7].getText())&&"O".equals(buttons[8].getText()))
        {
            oWins(6,7,8);
        }
        if("O".equals(buttons[0].getText())&&"O".equals(buttons[4].getText())&&"O".equals(buttons[8].getText()))
        {
            oWins(0,4,8);
        }
        if("O".equals(buttons[0].getText())&&"O".equals(buttons[3].getText())&&"O".equals(buttons[6].getText()))
        {
            oWins(0,3,6);
        }
        if("O".equals(buttons[1].getText())&&"O".equals(buttons[4].getText())&&"O".equals(buttons[7].getText()))
        {
            oWins(1,4,7);
        }
        if("O".equals(buttons[2].getText())&&"O".equals(buttons[5].getText())&&"O".equals(buttons[8].getText()))
        {
            oWins(2,5,8);
        }
        if("O".equals(buttons[2].getText())&&"O".equals(buttons[4].getText())&&"O".equals(buttons[6].getText()))
        {
            oWins(2,4,6);
        }
        
        if(drawcount==9&&xwins==0&&owins==0)//to check its a draw.
        {
            draw();//if we reached all the boxes and no one is win draw() function will be called. if anyone wins their value will be changed to 1. 
        }
    }
    
    public void xWins(int a,int b,int c)//if 'X' wins
    {
        xwins=1;//sets the xwins value to 1 to not to call draw function.
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        textField.setText("X Won");
        t_panel.setBackground(Color.white);
        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        
    }
    
    public void oWins(int a,int b,int c)//if 'O' wins
    {
        owins=1;//sets the owins value to 1 to not to call draw function.
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        textField.setText("O Won");
        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
    }
    
    public void draw()//if its a draw. if all values reached and neither xwins nor owins are 1's.
    {
        textField.setText("Draw");
        for(int i=0;i<9;i++)
        {
            buttons[i].setBackground(Color.gray);
            buttons[i].setEnabled(false);
        }
    }
    
    public static void main(String[] args)
    {
        TicTacToe tc=new TicTacToe();
    }
}
