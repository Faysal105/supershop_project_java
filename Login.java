import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JLabel userLabel, passwordLabel, signUpLabel, imgLabel;
    JTextField userTF;
    JPasswordField passwordTF;
    JButton lgnBtn, exitBtn, signUpBtn;
    Font font1, font2, font3;
    ImageIcon img1;
    Customers cs;
    Supershop sp;

    public Login(Customers cs, Supershop sp) {
        super("Login");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        this.sp = sp;

        font1 = new Font("Serif", Font.BOLD, 19); 
        font2 = new Font("Serif", Font.ITALIC, 19); 
        font3 = new Font("Arial", Font.PLAIN, 16); 


        panel = new JPanel();
        panel.setLayout(null);

        userLabel = new JLabel("Customer:");
        userLabel.setBounds(270, 250, 100, 30);
        userLabel.setForeground(Color.BLACK);
        userLabel.setFont(font1);
        panel.add(userLabel);

        userTF = new JTextField("ohi");
        userTF.setBounds(425, 250, 250, 30);
        userTF.setOpaque(false);
        userTF.setBorder(null);
        userTF.setFont(font2);
        panel.add(userTF);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(270, 310, 100, 30);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(font1);
        panel.add(passwordLabel);

        passwordTF = new JPasswordField("123");
        passwordTF.setBounds(425, 306, 250, 30);
        passwordTF.setOpaque(false);
        passwordTF.setBorder(null);
        passwordTF.setFont(font2);
        panel.add(passwordTF);

        lgnBtn = new JButton("Login");
        lgnBtn.setBounds(460, 380, 70, 25);
        lgnBtn.setBackground(Color.WHITE);
        lgnBtn.setForeground(Color.BLACK); 
        lgnBtn.setOpaque(false);
        lgnBtn.setBorder(null);
        lgnBtn.addMouseListener(this);
        lgnBtn.addActionListener(this);
        panel.add(lgnBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(620, 380, 70, 25);
        exitBtn.setBackground(Color.WHITE);
        exitBtn.setForeground(Color.BLACK); 
        exitBtn.setOpaque(false);
        exitBtn.setBorder(null);
        exitBtn.addMouseListener(this);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        signUpLabel = new JLabel("Haven't created an account yet?");
        signUpLabel.setBounds(390, 450, 290, 30);
        signUpLabel.setForeground(Color.BLACK);
        signUpLabel.setFont(font3);
        panel.add(signUpLabel);

        signUpBtn = new JButton("Sign up");
        signUpBtn.setBounds(655, 452, 100, 20);
        signUpBtn.setBackground(Color.WHITE);
        signUpBtn.setForeground(Color.BLACK); 
        signUpBtn.addActionListener(this);
        signUpBtn.setOpaque(false);
        signUpBtn.setBorder(null);
        panel.add(signUpBtn);

        img1 = new ImageIcon("Image/login.png");
        imgLabel = new JLabel(img1);
        imgLabel.setBounds(0, 0, 800, 600);
        panel.add(imgLabel);

        this.add(panel);
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        
        if (signUpBtn.getText().equals(command)) {
            SignUp si = new SignUp(cs, sp);
            si.setVisible(true);
            this.setVisible(false);
        } else if (lgnBtn.getText().equals(command)) {
            String name = userTF.getText();
            String pass = new String(passwordTF.getPassword()); 
            
            if (!name.isEmpty() && !pass.isEmpty()) {
                int index = cs.customerExists(name);
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "User doesn't exist.");
                    userTF.setText("");
                    passwordTF.setText("");
                } else {
                    Customer c = cs.checkPassword(index, pass);
                    if (c == null) {
                        JOptionPane.showMessageDialog(this, "Incorrect password.");
                    } else {
                        ProductList pl = new ProductList(sp);
                        pl.setVisible(true);
                        this.setVisible(false);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username/password required!");
            }
        } else if (exitBtn.getText().equals(command)) {
            System.exit(0);
        }
    }
}
