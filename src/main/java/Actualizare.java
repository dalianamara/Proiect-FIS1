import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Actualizare {

    private JFrame frame;
    private JTextField textField;//nr nou
    private JTextField textField_1;//email nou
    private JTextField textField_2;//user
    private JTextField textField_3;//nume
    private JTextField textField_4;//email
    private JTextField textField_5;//parola
    private JTextField textField_6;//telefon

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Actualizare window = new Actualizare();
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
    public Actualizare() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 583, 359);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblActualizareCont = new JLabel("ACTUALIZARE CONT");
        lblActualizareCont.setForeground(new Color(64, 64, 64));
        lblActualizareCont.setFont(new Font("Verdana Pro Light", Font.BOLD, 16));
        lblActualizareCont.setBounds(10, 11, 215, 26);
        frame.getContentPane().add(lblActualizareCont);

        JButton btnNewButton = new JButton("Schimba");
        btnNewButton.setBounds(317, 206, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {


                String telefon = textField_6.getText();//nr tel cel vechi
                String telefon1 = textField.getText();//nr tel cel nou
                ArrayList<StudentNou> studenti= creareJSON2.getDriver();
                Iterator<StudentNou> it=studenti.iterator();
                while(it.hasNext() ) {
                    StudentNou s=it.next();
                   /* System.out.println(s.getTelefon());
                    System.out.println(s.getEmail());
                    System.out.println(s.getNume());
                    System.out.println(s.getUser());
*/

                    if(s.getTelefon().equals(telefon))
                    {   studenti.remove(s);
                        StudentNou st = new StudentNou(null, null, null, null, null);

                        st.setUser(textField_2.getText());
                        st.setEmail(textField_3.getText());
                        st.setNume(textField_4.getText());
                        st.setParola(textField_5.getText());
                        st.setTelefon(telefon1);//telefon1
                        //la fel si pt email
                        studenti.add(st);
                       // creareJSON2.uppdate();

                    }
                }
            }
        });
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Schimba");
        btnNewButton_1.setBounds(317, 240, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        textField = new JTextField();
        textField.setBounds(150, 209, 120, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(150, 241, 120, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton_2 = new JButton("Inapoi");
        btnNewButton_2.setBounds(424, 268, 89, 23);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                new Meniu();
            }

        });
        frame.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel = new JLabel("Introduceti toate datele:");
        lblNewLabel.setBounds(64, 48, 136, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblUser = new JLabel("User");
        lblUser.setBounds(31, 73, 46, 14);
        frame.getContentPane().add(lblUser);

        JLabel lblNume = new JLabel("Nume");
        lblNume.setBounds(31, 103, 46, 14);
        frame.getContentPane().add(lblNume);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(31, 128, 46, 14);
        frame.getContentPane().add(lblEmail);

        JLabel lblParola = new JLabel("Parola");
        lblParola.setBounds(31, 159, 46, 14);
        frame.getContentPane().add(lblParola);

        JLabel lblTelefon = new JLabel("Telefon");
        lblTelefon.setBounds(31, 185, 46, 14);
        frame.getContentPane().add(lblTelefon);

        JLabel lblNewLabel_1 = new JLabel("Telefon NOU");
        lblNewLabel_1.setBounds(31, 219, 82, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Email NOU");
        lblNewLabel_2.setBounds(31, 244, 60, 14);
        frame.getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(150, 73, 120, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(150, 100, 120, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(150, 125, 120, 20);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(150, 156, 120, 20);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(150, 182, 120, 20);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);
    }
}
