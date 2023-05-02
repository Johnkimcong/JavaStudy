import javax.swing.*;
import java.awt.event.*;
import model.*;
public class CalculatorWindow extends JFrame
{
    private Calculator calculator = new Calculator(); //declare the model object first!
    private MyPanel panel = new MyPanel();
    public CalculatorWindow()
    {
       super("Calculator");
       setup();
       build();
       setVisible(true);
    }
    private void setup()
    {
        setSize(300, 100);
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void build()
    {
        add(panel);
    }
    private class MyPanel extends JPanel implements MyObserver //step 3
    {
        
        private JTextField textId1 = new JTextField(5);
        private JTextField textId2 = new JTextField(5);
        private JTextField textId3 = new JTextField(5);
        private JButton setPlus = new JButton("+");
        private JButton setMinus = new JButton("-");
        private JButton setTimes = new JButton("*");
        private JButton setDivision = new JButton("/");
        private JButton setClear = new JButton("Clear");
        
        public MyPanel()
        {
            setup();
            build();
            calculator.attach(this);//step 4
        }
        private void setup()
        {
            setPlus.addActionListener(new PlusListener());
            setMinus.addActionListener(new MinusListener());
            setTimes.addActionListener(new TimesListener());
            setDivision.addActionListener(new DivisionListener());
        }
        private void build()
        {
            add(textId1);
            add(textId2);
            add(textId3);
            add(setPlus);
            add(setMinus);
            add(setTimes);
            add(setDivision);
            add(setClear);
        }
        public void update() //step 3
        {
            textId3.setText("Total: " + calculator.getTotal());
        }
        private class PlusListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                double numOne = Double.parseDouble(textId1.getText());
                double numTwo = Double.parseDouble(textId2.getText());
                calculator.plus(numOne, numTwo);
            }
        }
        private class MinusListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                double numOne = Double.parseDouble(textId1.getText());
                double numTwo = Double.parseDouble(textId2.getText());
                calculator.minus(numOne, numTwo);
            }
        }
        private class TimesListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                double numOne = Double.parseDouble(textId1.getText());
                double numTwo = Double.parseDouble(textId2.getText());
                calculator.times(numOne, numTwo);
            }
        }
        private class DivisionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                double numOne = Double.parseDouble(textId1.getText());
                double numTwo = Double.parseDouble(textId2.getText());
                calculator.division(numOne, numTwo);
            }
        }
    }
    
}
