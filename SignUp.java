import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {
    JPanel panel;
    JLabel imgLabel, userLabel, passwordLabel, numberLabel, addressLabel, confirmpasswordLabel;
    JTextField userTF, numberTF, addressTF;
    JPasswordField passwordTF, confirmpasswordTF;
    JButton signUpBtn, returnBtn;
    Font font1, font2;
	ImageIcon img2;
    Customers cs;
    Supershop sp;

    public SignUp(Customers cs, Supershop sp) {
        super("Sign UP");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        this.sp = sp;

        panel = new JPanel();
        panel.setLayout(null);
        //panel.setBackground(Color.WHITE);
		
		


        font1 = new Font("Serif", Font.BOLD, 19);
        font2 = new Font("Serif", Font.ITALIC, 19);

        userLabel = new JLabel("Customer Name:");
        userLabel.setBounds(270, 100, 150, 35);
        userLabel.setForeground(Color.BLACK);
        userLabel.setFont(font1);
        panel.add(userLabel);

        numberLabel = new JLabel("Number:");
        numberLabel.setBounds(270, 180, 100, 35);
        numberLabel.setForeground(Color.BLACK);
        numberLabel.setFont(font1);
        panel.add(numberLabel);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(270, 260, 100, 35);
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(font1);
        panel.add(addressLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(270, 330, 100, 35);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(font1);
        panel.add(passwordLabel);

        confirmpasswordLabel = new JLabel("Confirm Password:");
        confirmpasswordLabel.setBounds(270, 408, 170, 35);
        confirmpasswordLabel.setForeground(Color.BLACK);
        confirmpasswordLabel.setFont(font1);
        panel.add(confirmpasswordLabel);

        userTF = new JTextField();
        userTF.setBounds(525, 100, 250, 30);
		userTF.setOpaque(false);
		userTF.setBorder(null);
        userTF.setFont(font2);
        panel.add(userTF);

        numberTF = new JTextField();
        numberTF.setBounds(525, 180, 250, 30);
		numberTF.setOpaque(false);
		numberTF.setBorder(null);
        numberTF.setFont(font2);
        panel.add(numberTF);

        addressTF = new JTextField();
        addressTF.setBounds(525, 260, 250, 30);
		addressTF.setOpaque(false);
		addressTF.setBorder(null);
        addressTF.setFont(font2);
        panel.add(addressTF);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(525, 330, 250, 30);
		passwordTF.setOpaque(false);
		passwordTF.setBorder(null);
        passwordTF.setFont(font2);
        panel.add(passwordTF);

        confirmpasswordTF = new JPasswordField();
        confirmpasswordTF.setBounds(528, 408, 250, 30);
		confirmpasswordTF.setOpaque(false);
		confirmpasswordTF.setBorder(null);
        confirmpasswordTF.setFont(font2);
        panel.add(confirmpasswordTF);

        signUpBtn = new JButton("Sign up");
        signUpBtn.setBounds(600, 500, 100, 20);
		signUpBtn.setBackground(Color.WHITE);
        signUpBtn.setForeground(Color.WHITE);
		signUpBtn.setOpaque(false);
		signUpBtn.setBorder(null);
        signUpBtn.addActionListener(this);
        panel.add(signUpBtn);

        returnBtn = new JButton("Return");
        returnBtn.setBounds(400, 500, 100, 20);
		returnBtn.setBackground(Color.WHITE);
        returnBtn.setForeground(Color.WHITE);
		returnBtn.setOpaque(false);
		returnBtn.setBorder(null);
        returnBtn.addActionListener(this);
        panel.add(returnBtn);
		
		img2 = new ImageIcon("Image/signup.png");
        imgLabel = new JLabel(img2);
        imgLabel.setBounds(0, 0, 800, 600);
        panel.add(imgLabel);

        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (returnBtn.getText().equals(command)) {
            Login lg = new Login(cs, sp);
            lg.setVisible(true);
            this.setVisible(false);
        } else if (signUpBtn.getText().equals(command)) {
            String name = userTF.getText();
            String number = numberTF.getText();
            String address = addressTF.getText();
            String pass = new String(passwordTF.getPassword());
            String confirmpass = new String(confirmpasswordTF.getPassword());

            if (!name.isEmpty() && !number.isEmpty() && !address.isEmpty() && !pass.isEmpty() && !confirmpass.isEmpty()) {
                if (pass.equals(confirmpass)) {
                    Customer c = new Customer(name, number, address, pass);
                    cs.addCustomer(c);

                    Login lg = new Login(cs, sp);
                    lg.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Passwords do not match!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Some fields are empty!");
            }
        }
    }
}
