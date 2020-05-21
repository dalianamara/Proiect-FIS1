import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.sql.*;
//import javax.swing.JOptionPane;

public class CreareCont {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreareCont window = new CreareCont();
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


    public CreareCont() {

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

        JLabel lblNume = new JLabel("User");
        lblNume.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNume.setBounds(75, 58, 46, 14);
        frame.getContentPane().add(lblNume);

        JLabel lblPrenume = new JLabel("Nume");
        lblPrenume.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblPrenume.setBounds(75, 83, 75, 14);
        frame.getContentPane().add(lblPrenume);

        JLabel lblAdresaDeEmail = new JLabel("Email");
        lblAdresaDeEmail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblAdresaDeEmail.setBounds(75, 108, 122, 14);
        frame.getContentPane().add(lblAdresaDeEmail);

        JLabel lblParola = new JLabel("Parola");
        lblParola.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblParola.setBounds(75, 133, 75, 14);
        frame.getContentPane().add(lblParola);

        JLabel lblTelefon = new JLabel("Telefon");
        lblTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblTelefon.setBounds(75, 158, 75, 14);
        frame.getContentPane().add(lblTelefon);

        textField = new JTextField();
        textField.setBounds(232, 107, 131, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(232, 82, 131, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(232, 57, 131, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(232, 132, 131, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(232, 157, 131, 20);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        JButton btnNewButton = new JButton("CREEAZA");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                String user= textField_2.getText();
                String nume = textField_1.getText();
                String email = textField.getText();
                String parola = textField_3.getText();
                String telefon = textField_4.getText();

                creareJSON2.uppdate(new StudentNou(user,nume,email,parola,telefon));
                creareJSON.uppdate(new Student(user,parola));


            }
        });
        btnNewButton.setBounds(75, 210, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("INAPOI");
        btnNewButton_1.setBounds(232, 210, 89, 23);
        btnNewButton_1.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                new login();
            }
        });

        frame.getContentPane().add(btnNewButton_1);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
        panel.setBounds(10, 11, 396, 239);
        frame.getContentPane().add(panel);

        JLabel lblCreareCont = new JLabel("CREARE CONT");
        panel.add(lblCreareCont);
        lblCreareCont.setFont(new Font("Century Gothic", Font.BOLD, 18));
    }

}
