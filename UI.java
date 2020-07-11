import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame implements ActionListener {
   JPanel panel;
   JLabel user_label, password_label, message;
   JTextField userName_text;
   JPasswordField password_text;
   JButton submit, cancel;
   
   UI() {
	  //username label
      user_label = new JLabel();
      user_label.setText("User Name :");
      userName_text = new JTextField();
      
      //password label
      password_label = new JLabel();
      password_label.setText("Password :");
      password_text = new JPasswordField();
      
      //submit label
      submit = new JButton("Submit");
      
      //Panel
      panel = new JPanel(new GridLayout(3, 1));
      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);
      
      message = new JLabel();
      panel.add(message);
      panel.add(submit);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //adding listener
      submit.addActionListener(this);
      
      add(panel, BorderLayout.CENTER);
      setTitle("Login Screen");
      setSize(500,300);
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae) {
      String userName = userName_text.getText();
      String password = password_text.getText();
      if (userName.trim().equals("apple") && password.trim().equals("orange")) {
         message.setText(" Hello " + userName);
      } else {
         message.setText(" Invalid username or password ");
      }
   }
   
   public static void main(String[] args) {
	      new UI();
	   }
}