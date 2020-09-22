package project1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {	 
		HangmanGame hangmanGame = new HangmanGame();
		ArrayList<JButton> bs=new ArrayList<>();
		
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        //input fields
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        JTextField textWord = new JTextField();
        textWord.setForeground(Color.RED);
        JTextField textProgress = new JTextField();
        panel1.add(textWord);
        panel1.add(textProgress);
               
        //text   
        JPanel panel7 = new JPanel();  
        panel7.setPreferredSize(new Dimension(500,500));
        panel7.setLayout(new BoxLayout(panel7, BoxLayout.PAGE_AXIS));
        JLabel text1 = new JLabel("");  
        text1.setFont(new Font("Verdana", Font.PLAIN, 18));
        text1.setForeground(Color.RED);
        JLabel text2 = new JLabel("Press <New> to Start");   
        text2.setFont(new Font("Verdana", Font.PLAIN, 18));
        text2.setForeground(Color.BLUE);
        text2.setHorizontalTextPosition(JLabel.LEFT);
        panel7.add(text1);
        panel7.add(text2);
        Drawing d = new Drawing();
        panel7.add(d);

        //keyboard  	
        JPanel panel5 = new JPanel(new GridLayout(4,7));
        for (char c = 'a'; c <= 'z'; c++) {          	
            JButton button = new JButton(String.valueOf(c));            
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                	if(hangmanGame.getWord().length()==0)
                		return;
                	if (hangmanGame.reset==true)
                		return;                	
                	System.out.println(button.getText());
                	hangmanGame.pressKey(button.getText());
                	textProgress.setText(hangmanGame.getProgress());             
                	button.setEnabled(false);   
                	bs.add(button);
                	System.out.println(hangmanGame.wordString());
                	if(hangmanGame.wordFound()) {
                		text1.setText("YOU WON!!!");
                		text2.setText("Press <New> to Start");
                		System.out.println("\n!!!reset!!!\n");
                		d.redraw(0);               
            	    	hangmanGame.resetWord();
                	}else if( HangmanGame.MAX_LEVEL > hangmanGame.getErrorCount()) {
                		text2.setText("health level");  
                		d.redraw(HangmanGame.MAX_LEVEL- hangmanGame.getErrorCount());             		
               	     	System.out.println("Remain: " + (HangmanGame.MAX_LEVEL - hangmanGame.getErrorCount())+"\n");              	     	
            	    } else {    
            	    	text1.setText("YOU LOSE!!!");
            	    	text2.setText("Press <New> to Start");
            	    	System.out.println("\n!!!reset!!!\n");
            	    	d.redraw(0);
            	    	hangmanGame.resetWord();
            	    	textWord.setText("");
                    	textProgress.setText("");
        		   }
                }
            });
            panel5.add(button);
        }
       
        JButton bNew = new JButton("New");
        bNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){            	
            	hangmanGame.newGame();
            	for(JButton b: bs) 
    	    		b.setEnabled(true);           	
            	textWord.setText(hangmanGame.getWord());
            	textProgress.setText(hangmanGame.getProgress());
            	text1.setText("");
            	text2.setText("health level");  
            	d.redraw(HangmanGame.MAX_LEVEL);
            	
            }
        });
        panel5.add(bNew);
        
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(panel1);   
        panel.add(panel7);     
        panel.add(panel5);
       
        int res= JOptionPane.showOptionDialog(frame, panel,"Word Guess Game", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, new Object[]{}, null);
        if (res == -1)
        	System.exit(0);	
	}
}
