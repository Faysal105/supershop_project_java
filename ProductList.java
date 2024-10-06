import java.lang.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class ProductList extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
    JLabel imgLabel, productList, cartLabel; 
    Color color1, color2;
    ImageIcon img, img1, img2, img3, img4, img5, img6, img7, img8, img9;
    JButton imgBtn1, imgBtn2, imgBtn3, imgBtn4, imgBtn5, imgBtn6, imgBtn7, imgBtn8, imgBtn9, cartBtn , ;
    Font font1, font2;
	Supershop sp;
	
    public ProductList(Supershop sp){
		super("Product List");
		this.setBounds(100,50,800,700); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.sp = sp;
		
		color1 = new Color(78,92,255);
		color2 = new Color(236,235,232);
		font1 = new Font("Times New Roman",Font.BOLD, 19);
		font2 = new Font("Times New Roman",Font.ITALIC | Font.BOLD, 25);
	
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		//img = new ImageIcon("products/download.jpg");
		//imgLabel = new JLabel(img);
		//imgLabel.setBounds(0,0,800,600);
		//panel.add(imgLabel);
		
		img1 = new ImageIcon("Image/Egg.png");
		imgBtn1 = new JButton(img1);
		imgBtn1.setBounds(50,75,200,150);
		imgBtn1.addActionListener(this);
		panel.add(imgBtn1);
		
		img2 = new ImageIcon("Image/oil.png");
		imgBtn2 = new JButton(img2);
		imgBtn2.setBounds(300,75,200,150);
		imgBtn2.addActionListener(this);
		panel.add(imgBtn2);
		
		img3 = new ImageIcon("Image/chicken.png");
		imgBtn3 = new JButton(img3);
		imgBtn3.setBounds(550,75,200,150);
		imgBtn3.addActionListener(this);
		panel.add(imgBtn3);
		
		img4 = new ImageIcon("Image/sugar.png");
		imgBtn4 = new JButton(img4);
		imgBtn4.setBounds(50,245,200,150);
		imgBtn4.addActionListener(this);
		panel.add(imgBtn4);
		
		img5 = new ImageIcon("Image/fish.png");
		imgBtn5 = new JButton(img5);
		imgBtn5.setBounds(300,245,200,150);
		imgBtn5.addActionListener(this);
		panel.add(imgBtn5);
		
		img6 = new ImageIcon("Image/salt.png");
		imgBtn6 = new JButton(img6);
		imgBtn6.setBounds(550,245,200,150);
		imgBtn6.addActionListener(this);
		panel.add(imgBtn6);
		
		img7 = new ImageIcon("Image/atta.png");
		imgBtn7 = new JButton(img7);
		imgBtn7.setBounds(50,415,200,150);
		imgBtn7.addActionListener(this);
		panel.add(imgBtn7);
		
		img8 = new ImageIcon("Image/rice.png");
		imgBtn8 = new JButton(img8);
		imgBtn8.setBounds(300,415,200,150);
		imgBtn8.addActionListener(this);
		panel.add(imgBtn8);
		
		img9 = new ImageIcon("Image/beef.png");
		imgBtn9 = new JButton(img9);
		imgBtn9.setBounds(550,415,200,150);
		imgBtn9.addActionListener(this);
		panel.add(imgBtn9);
		
		productList = new JLabel("Product List");
		productList.setBounds(330,10,200,30);
		productList.setFont(font2);
		productList.setForeground(Color.BLACK);
		panel.add(productList);
		
		cartBtn = new JButton("Go to cart");
		cartBtn.setBounds(300,600,200,30);
		cartBtn.setFont(font2);
		cartBtn.setBackground(color1);
		cartBtn.setForeground(Color.BLACK);
		cartBtn.addActionListener(this);
		panel.add(cartBtn);
		
		this.add(panel);
		this.setVisible(true);
	}

    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
	
	public void addProductToCart(String productName){
		Object[] options = { "add", "cancel"};
		JPanel dialogPanel = new JPanel();
		dialogPanel.add(new JLabel("Enter quantity 1-10: "));
		JTextField textField = new JTextField(10);
		textField.setText("0");
		dialogPanel.add(textField);
		
		int result = JOptionPane.showOptionDialog(null, dialogPanel, "Quantity", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		if (result == 0){ //0=add button, 1=cancel
			String quantityInput = textField.getText();
			if(!quantityInput.isEmpty()){ 
				int quantity = Integer.parseInt(quantityInput);
				if(quantity <= 0 || quantity > 10){
					JOptionPane.showMessageDialog(this, "Quantity should be between 1-10");
				}else{
					Product p = sp.searchProduct(productName);
					p.setQuantity(quantity);
					sp.addToCart(p);
				}
			}else{
				JOptionPane.showMessageDialog(this, "Quantity should not be empty");
			}
		}else{
			//do nothing
		}
	}
	
    public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == imgBtn1){
			
			
			//egg 
			addProductToCart("Egg");

		}else if(ae.getSource() == imgBtn2){
			//oil
			addProductToCart("Oil");
			
		}else if(ae.getSource() == imgBtn3){
			//chicken
			addProductToCart("Chicken");
			
		}else if(ae.getSource() == imgBtn4){
			//suger
			addProductToCart("Sugar");
			
		}else if(ae.getSource() == imgBtn5){
			//fish
			addProductToCart("Hilsha Fish");
			
		}else if(ae.getSource() == imgBtn6){
			//salt
			addProductToCart("Salt");
			
		}else if(ae.getSource() == imgBtn7){
			//atta
			addProductToCart("Atta");
			
		}else if(ae.getSource() == imgBtn8){
			//rice
			addProductToCart("Rice");
			
		}else if(ae.getSource() == imgBtn9){
			//beef
			addProductToCart("Beef");
			
		}else if(ae.getSource() == cartBtn){
			//go to cart frame and show the recipt there
			double bill = sp.calculateBill();
			JOptionPane.showMessageDialog(this, "Total bill: "+bill);		
		}
	}
}

