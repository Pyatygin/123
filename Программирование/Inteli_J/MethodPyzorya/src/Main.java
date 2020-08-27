import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Метод пузырька наглядно");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(new FlowLayout());

//---------------------------------------------------------------
        JCheckBox box = new JCheckBox("Правильно?");

        JButton button= new JButton("Начать работу");
        button.setSize(50,50);
        button.setMaximumSize(new Dimension(150,150));
        button.setMinimumSize(new Dimension(150,150));
        button.setPreferredSize(new Dimension(150,150));

        JTextField field= new JTextField();
        setComponentSize(field,150,50);

        JTextArea area = new JTextArea(10,40);
        area.setLineWrap(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(String.valueOf(box.isSelected()));
              BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
               System.out.println("Введите колво элементов");
             int kolvo= 0;
                try {
                   kolvo = Integer.parseInt(read.readLine());
               } catch (IOException ioException) {
                   ioException.printStackTrace();
             }
                System.out.println("Введите эллементы");
               int[] masChisel = new int[kolvo];
               for(int i=0;i< masChisel.length;i++){
                   try {
                       masChisel[i]= Integer.parseInt(read.readLine());
                   } catch (IOException ioException) {
                     ioException.printStackTrace();
                 }
              }
             System.out.println("Неотсортированный массив");
             for(int i=0;i< masChisel.length;i++){
                 System.out.println(masChisel[i]);
              }

               for(int i= masChisel.length-1;i>0;i--) {
                    for (int l = 0; l < i; l++) {
                        if (masChisel[l] > masChisel[l + 1]) {
                         int prom = masChisel[l];
                          masChisel[l] = masChisel[l + 1];
                          masChisel[l + 1] = prom;
                       }
                    }
              }
               System.out.println("Отсортированный массив");
               for(int i=0;i< masChisel.length;i++){
                   System.out.println(masChisel[i]);
               }
            }
        });
        //---------------------------------------
        JPanel panel = new JPanel();
        setComponentSize(panel,500,200);
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(button);
        panel.add(field);
        //panel.add(area);
        panel.add(box);
        frame.add(panel);
        frame.setVisible(true);
    }
    public  static void setComponentSize(JComponent component, int w,int h){
        component.setMaximumSize(new Dimension(w,h));
        component.setMinimumSize(new Dimension(w,h));
        component.setPreferredSize(new Dimension(w,h));
        component.setSize(w,h);
    }
}
