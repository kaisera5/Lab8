import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {

JTextField userGuess; 
JButton aGuess;
JButton playAgain;
JLabel jenterGuess;
JLabel jhighLow;
JLabel jlastGuess;
Random r = new Random(); 
int randomNum = r.nextInt(100); 

GuessingGame() {
  int randomNum = r.nextInt(100) + 1; 

  JFrame frame = new JFrame("Guessing Game");

  frame.setLayout(new FlowLayout());

  frame.setSize(240, 120);

  userGuess = new JTextField(10); 

  userGuess.setActionCommand("myTF");

  aGuess = new JButton("Guess");

  playAgain = new JButton("Play Again"); 

  userGuess.addActionListener(this);
  aGuess.addActionListener(this);
  playAgain.addActionListener(this);

  jenterGuess = new JLabel("Enter your guess: ");
  jhighLow = new JLabel("");
  jlastGuess = new JLabel("");

  frame.add(jenterGuess);
  frame.add(userGuess);
  frame.add(aGuess);
  frame.add(jhighLow);
  frame.add(jlastGuess);
  frame.add(playAgain);

  frame.setVisible(true);
}


public void actionPerformed(ActionEvent ae) 
{
  if(ae.getActionCommand().equals("Guess")) 
  {
     int guess = Integer.parseInt(userGuess.getText());

    if(guess>randomNum)
    {
      jhighLow.setText("Too High!");
    }
    else if(guess<randomNum)
    {
      jhighLow.setText("Too Low!");
    }
    else
    {
      jhighLow.setText("You got it!");
    }
    jlastGuess.setText("Last Guess Was " + jlastGuess);
     
  }
  else if(ae.getActionCommand().equals("Play Again"))
  {
    Random r = new Random(); 
    int randomNum = r.nextInt(100) + 1; 
    jenterGuess = new JLabel("Enter your guess: ");
    jhighLow = new JLabel("");
    jlastGuess = new JLabel("");
    userGuess.setText("");
  }
  else
  {
    jhighLow.setText("You pressed enter. Please press the guess button");

  }
}
}
