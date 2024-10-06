import java.lang.*;
public class Start{
	public static void main(String[] args){
		Customers cs =new Customers();
		Supershop sp = new Supershop();
		Login lg = new Login(cs,sp);
		lg.setVisible(true);
	}
}