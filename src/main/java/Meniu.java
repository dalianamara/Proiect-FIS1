import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meniu {

    private JFrame frame;

    /**
     * Launch the apimport java.awt.Font;
     import java.awt.Color;

     public class Meniu {

     private JFrame frame;

     /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Meniu window = new Meniu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Meniu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("ALEGETI DIN URMATOARELE VARIANTE");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1.setBounds(10, 34, 371, 29);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Atualizare Cont");
        btnNewButton.setBounds(121, 123, 144, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Adauga carte");
        btnNewButton_1.setBounds(121, 170, 144, 23);
        frame.getContentPane().add(btnNewButton_1);


        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Actualizare();
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdaugaCarte();
                frame.setVisible(false);
            }
        });



    }
}
