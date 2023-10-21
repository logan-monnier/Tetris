import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Color;


//1ère étape
public class StartupForm implements ActionListener
{

	JFrame frame;
    JButton btn;
    JButton quitBtn;
	public StartupForm(){
        frame = new JFrame("Tetris");
        frame.setLayout(null);

		btn = new JButton("Play");
		btn.setBounds(200,200,100,30);
        quitBtn = new JButton("Quit");
        quitBtn.setBounds(200,250,100,30);

        btn.addActionListener(this);
		quitBtn.addActionListener(this);

		frame.add(btn);
        
        frame.setLocationRelativeTo(null);
        frame.add(quitBtn);
		frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.PINK);
		frame.setVisible(true);	
    } 
	

	//3ème étape
	public void actionPerformed(ActionEvent e){
        if(e.getSource()== btn){
            frame.setVisible(false);
            System.out.println("start");
            fenetre.start();
        }
        else if(e.getSource() == quitBtn){
            System.exit(0);
        }
	}
}