import java.awt.*;
import java.awt.event.*;

class CalculatorAWT extends Frame implements ActionListener
{
    TextField tf;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button add, sub, mul, div, eq, clr;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    CalculatorAWT()
    {
        tf = new TextField();
        tf.setBounds(30,50,240,30);
        add(tf);

        b0 = new Button("0");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        eq  = new Button("=");
        clr = new Button("C");

        Button buttons[] = 
        {
            b7,b8,b9,add,
            b4,b5,b6,sub,
            b1,b2,b3,mul,
            b0,eq,clr,div
        };

        int x = 30, y = 100;

        for(int i = 0; i < buttons.length; i++)
        {
            buttons[i].setBounds(x,y,50,40);
            add(buttons[i]);
            buttons[i].addActionListener(this);

            x += 60;
            if((i+1) % 4 == 0)
            {
                x = 30;
                y += 50;
            }
        }

        setSize(320,350);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        // If number pressed -
        if (Character.isDigit(s.charAt(0)))
        {
            tf.setText(tf.getText() + s);
        }

        // Clear button pressed
        else if (s.equals("C"))
        {
            tf.setText("");
            num1 = num2 = result = 0;
        }

        // Operator pressed
        else if (s.equals("+") || s.equals("-") ||
                 s.equals("*") || s.equals("/"))
        {
            num1 = Double.parseDouble(tf.getText());
            operator = s.charAt(0);
            tf.setText("");
        }

        // Equal pressed
        else if (s.equals("="))
        {
            num2 = Double.parseDouble(tf.getText());

            if (operator == '+')
                result = num1 + num2;
            else if (operator == '-')
                result = num1 - num2;
            else if (operator == '*')
                result = num1 * num2;
            else if (operator == '/')
                result = num1 / num2;
            
            tf.setText(String.valueOf(result));
        }
    }

    public static void main(String args[])
    {
        new CalculatorAWT();
    }
}