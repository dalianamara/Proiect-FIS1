import javax.swing.*;
import java.awt.*;

public class AdaugaCarte {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdaugaCarte window = new AdaugaCarte();
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
    public AdaugaCarte() {
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

        JLabel lblNewLabel = new JLabel("Adaugare CARTE");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel.setBounds(37, 34, 157, 27);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Titlu");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel_1.setBounds(58, 86, 46, 23);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Autor");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel_2.setBounds(58, 120, 46, 14);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Categorie");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel_3.setBounds(58, 145, 73, 26);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Data publicarii");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel_4.setBounds(58, 174, 107, 27);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Disponibilitate");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel_5.setBounds(58, 202, 126, 31);
        frame.getContentPane().add(lblNewLabel_5);

        textField = new JTextField();
        textField.setBounds(163, 83, 126, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(163, 117, 126, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(162, 151, 127, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setBounds(165, 210, 97, 23);
        frame.getContentPane().add(chckbxNewCheckBox);

        textField_3 = new JTextField();
        textField_3.setBounds(163, 179, 126, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("ADAUGA");
        btnNewButton.setBounds(268, 208, 89, 23);
        frame.getContentPane().add(btnNewButton);
    }
}
