import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {

    static  final Dimension FRAME_DIMENSION = new Dimension(320,320);
    static  final Dimension FIELD_DIMENSION = new Dimension(285,80);
    static  final Dimension BUTTON_DIMENSION = new Dimension(60,30);
    static  final Dimension PANEL_DIMENSION = new Dimension(160,100);

    //Создание объектов
    public Calculator objCalculator = new Calculator();
    public static JTextField numberOneField = new JTextField();

     static double[] a = new double[2];
     static int[] actions = new int[7];
     static String nums="";

     //Панели
     JPanel panelUp = new JPanel();
     JPanel panelCenterLeft = new JPanel();
     JPanel panelCenterRight = new JPanel();

    public CalculatorFrame() throws HeadlessException {

        setTitle(("Calculator"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(FRAME_DIMENSION);
        setVisible(true);

        //Панели
        setComponentSize(panelUp,PANEL_DIMENSION);
        setComponentSize(panelCenterRight,PANEL_DIMENSION);
        setComponentSize(panelCenterLeft,PANEL_DIMENSION);

        //TextField
        setComponentSize(numberOneField,FIELD_DIMENSION);


        //Сложение
        JButton buttonPlus= createJButton("+");//Кнопка плюс, Действие №0
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] =Double.parseDouble(numberOneField.getText());
                numberOneField.setText("");
                nums="";
                actions[0] +=1;
            }
        });

        //Разность
        JButton minesButton= createJButton("-");//Кнопка минус, Действие №1
        minesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] =Double.parseDouble(numberOneField.getText());
                numberOneField.setText("");
                nums="";
                actions[1] +=1;
            }
        });

        //Умножение
        JButton multiplicationButton = createJButton("*");//Кнопка умножения, Действие №2
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] =Double.parseDouble(numberOneField.getText());
                numberOneField.setText("");
                nums="";
                actions[2] +=1;
            }
        });

        //Деление
        JButton splitedButton = createJButton("/");//Кнопка деления, Действие №3
        splitedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] =Double.parseDouble(numberOneField.getText());
                numberOneField.setText("");
                nums="";
                actions[3] +=1;
            }
        });

        //Факториал
        JButton factorialButton = createJButton("n!");//Кнопка факториала (отдельное)
        factorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] =Double.parseDouble(numberOneField.getText());
                numberOneField.setText(String.valueOf(objCalculator.factorialing(a[0])));
                nums="";
            }
        });

        //Степень
        JButton degreeButton = createJButton("a(n)");//Кнопка степени, Действие №4
        degreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] =Double.parseDouble(numberOneField.getText());
                numberOneField.setText("");
                nums="";
                actions[4] +=1;
            }
        });
        //Процент
        JButton parcentButton = createJButton("%");//Кнопка процента, Действие №5
        parcentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] =Double.parseDouble(numberOneField.getText());
                numberOneField.setText("");
                nums="";
                actions[5] +=1;
            }
        });

        JButton commaButton = createJButton(".");//Кнопка точки
        commaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums+=".";
                numberOneField.setText(nums);
            }
        });

        JButton dropButton = createJButton("C");//Кнопка сброс!
        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums ="";
                numberOneField.setText(nums);
            }
        });

        //Равно
        JButton ravnoButton= new JButton("=");
        setComponentSize(ravnoButton, BUTTON_DIMENSION);
        ravnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[1]=Double.parseDouble(numberOneField.getText());
                if(actions[0] >0){
                    numberOneField.setText(String.valueOf(objCalculator.summing(a[0],a[1])));
                    nums="";
                    actions[0]=0;
                }
                if(actions[1] >0){
                    numberOneField.setText(String.valueOf(objCalculator.raznosting(a[0],a[1])));
                    nums="";
                    actions[1]=0;
                }
                if(actions[2] >0){
                    numberOneField.setText(String.valueOf(objCalculator.multing(a[0],a[1])));
                    nums="";
                    actions[2]=0;
                }
                if(actions[3] >0){
                    numberOneField.setText(String.valueOf(objCalculator.spliting(a[0],a[1])));
                    nums="";
                    actions[3]=0;
                }
                if(actions[4] >0){
                    numberOneField.setText(String.valueOf(objCalculator.degreeting(a[0],a[1])));
                    nums="";
                    actions[4]=0;
                }
                if(actions[5] >0){
                    numberOneField.setText(String.valueOf(objCalculator.parceing(a[0],a[1])));
                    nums="";
                    actions[5]=0;
                }
            }
        });

        //Создание цифр и добавление их в panelCentreLeft
        panelCenterLeft.setLayout(new MigLayout());//Создание цифр идобавление в
        int countStrok=1;//Количество элементов в строке
        for (int i = 0; i <= 9; i++) {
            String name =String.valueOf(i);
            if(countStrok<2) {
                panelCenterLeft.add(createButtonNumber(name, 50, 30));
                countStrok += 1;
            }
            else{
                panelCenterLeft.add(createButtonNumber(name, 50, 30),"wrap");
                countStrok-=1;
            }
        }

        //Добавление на панель
        panelUp.setLayout(new MigLayout());//Верхняя панель
        panelUp.add(CalculatorFrame.numberOneField,"gaptop 10, gapleft 2");

        panelCenterRight.add(buttonPlus);//Центральная правая панель
        panelCenterRight.add(minesButton);
        panelCenterRight.add(multiplicationButton);
        panelCenterRight.add(splitedButton);
        panelCenterRight.add(factorialButton);
        panelCenterRight.add(degreeButton);
        panelCenterRight.add(parcentButton);
        panelCenterRight.add(commaButton);
        panelCenterRight.add(dropButton);
        panelCenterRight.add(ravnoButton);

        //Добавление в графическое поле
        add(panelUp,BorderLayout.NORTH);
        add(panelCenterRight,BorderLayout.EAST);
        add(panelCenterLeft,BorderLayout.WEST);
        setVisible(true);
    }

    public static void setComponentSize(JComponent component, Dimension dimension){
        component.setMaximumSize(dimension);
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setSize(dimension);
    }
    public double getNumber(){
        return Double.parseDouble(numberOneField.getText());
    }
    public JButton createJButton(String name){
        JButton button=new JButton(name);
        setComponentSize(button, BUTTON_DIMENSION);
        return button;
    }

    //Кнопоки чисел, ввод
    public static JButton createButtonNumber(String name,int w,int h){
        JButton button= new JButton(name);
        setComponentSize(button, BUTTON_DIMENSION);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums +=name;
                numberOneField.setText(nums);

            }
        });
        return button;
    }
}