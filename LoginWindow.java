import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class LoginWindow extends JFrame
{
    private MyPanel panel = new MyPanel();
    private JLabel label;
    private String LOGIN_ID, PASSWORD;

    public LoginWindow()
    {
        super("Login");
        setup();
        build();
        setVisible(true);
        
        this.LOGIN_ID = "Hello";
        this.PASSWORD = "World";
    }

    private void setup()
    {
        super.setSize(300, 150);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        label = new JLabel(); // initialize the label
        add(label, BorderLayout.SOUTH); // add the label to the bottom of the frame
    }

    private void build()
    {
        super.add(panel);
    }
    
    
    public class MyPanel extends JPanel
    {   
        private JLabel loginID = new JLabel("Login ID:");
        private JTextField loginField = new JTextField(5);
        private JLabel passwordID = new JLabel("Password:");
        private JTextField passwordField = new JTextField(5);
        private JButton button = new JButton("Login");
        
       
        public MyPanel()
        {
            button.addActionListener(new LoginListener()); 
            add(loginID);
            add(loginField);
            add(passwordID);
            add(passwordField);
            add(button);
        }
        
        private class LoginListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e) // events can be: button clicks, typing, mouse click
            {
                System.out.println("Login Clicked");
                
                String enteredLoginID = loginField.getText();
                String enteredPassword = passwordField.getText();
                
                if(enteredLoginID.equals(LOGIN_ID) && enteredPassword.equals(PASSWORD))
                {
                    System.out.println("Login Successful");
                    label.setText("Login Successful");
                }
                else {
                    System.out.println("Login Failed");
                    label.setText("Login Failed");
                }
            }
        }
    }
} // End of LoginWindow
