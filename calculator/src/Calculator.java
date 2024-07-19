import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton []numbers= new JButton[10];
    JButton []function=new JButton[7];
    JButton add,sub,mul,div;
    JButton equal,clr,dec;
    JPanel panel;

    Font font=new Font("Ink Free",Font.BOLD,30);

    double num1=0,num2=0,res=0;
    char oper;
    Calculator(){
        frame= new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setLayout(null);
        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("x");
        div = new JButton("/");
        equal = new JButton("=");
        clr = new JButton("C");
        dec=new JButton(".");
        function[0]=add;
        function[1]=sub;
        function[2]=mul;
        function[3]=div;
        function[4]=equal;
        function[5]=clr;
        function[6]=dec;
        for(int i=0;i<7;i++){
            function[i].addActionListener(this);
            function[i].setFont(font);
            function[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numbers[i]=new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }
        clr.setBounds(50,430,250,50);
        frame.add(clr);

        panel =new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numbers[0]);
        panel.add(div);
        panel.add(equal);

        frame.add(panel);
        frame.add(clr);
        frame.add(textField);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Calculator cal=new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numbers[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==add){
            num1=Double.parseDouble(textField.getText());
            oper='+';
            textField.setText("");
        }
        if(e.getSource()==sub){
            num1=Double.parseDouble(textField.getText());
            oper='-';
            textField.setText("");
        }
        if(e.getSource()==mul){
            num1=Double.parseDouble(textField.getText());
            oper='*';
            textField.setText("");
        }
        if(e.getSource()==div){
            num1=Double.parseDouble(textField.getText());
            oper='/';
            textField.setText("");
        }
        if(e.getSource()==dec){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==equal){
            num2=Double.parseDouble(textField.getText());
            switch (oper){
                case '+':
                    res=num1+num2;
                    break;
                case '-':
                    res=num1-num2;
                    break;
                case '*':
                    res=num1*num2;
                    break;
                case '/':
                    res=num1/num2;
                    break;

            }
            textField.setText(String.valueOf(res));
            num1=res;

        }
        if(e.getSource()==clr){
            textField.setText("");
        }
    }
}