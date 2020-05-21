import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

//import javax.swing.ImageIcon;

public class login {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
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
    public login() {

        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Introduceti datele:");
        lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel.setBounds(31, 26, 134, 75);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("USER");
        lblNewLabel_1.setBounds(96, 115, 69, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("PASSWORD");
        lblNewLabel_2.setBounds(96, 150, 69, 14);
        frame.getContentPane().add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(161, 112, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(171, 147, 100, 20);
        frame.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.setBounds(96, 196, 89, 23);
        frame.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

                String nume = textField.getText();
                String parola = passwordField.getText();
                ArrayList<Student> studenti= creareJSON.getDriver();
                Iterator<Student> it=studenti.iterator();
                while(it.hasNext())
                {
                    Student s=it.next();
                    if(s.getUsername().equals(nume) && s.getPassword().equals(parola))
                    {
                        new Meniu();
                        frame.setVisible(false);
                    }
                }

            }

        });
        frame.setVisible(true);


        JButton btnNewButton_1 = new JButton("CREARE CONT");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreareCont();
                frame.setVisible(false);
            }
        });
        btnNewButton_1.setBounds(205, 196, 134, 23);
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_3 = new JLabel("STUDENT login");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_3.setForeground(Color.BLUE);

        lblNewLabel_3.setBounds(221, 26, 134, 41);
        frame.getContentPane().add(lblNewLabel_3);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLUE));
        panel.setForeground(Color.BLUE);
        panel.setBounds(10, 11, 395, 239);
        frame.getContentPane().add(panel);
    }
}