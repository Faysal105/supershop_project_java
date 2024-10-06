public class Supershop{
	public Product productList[] = new Product[10];
	public Product cart[] = new Product[10];
	public static int productCount=0;
	public static int cartCount=0;
	
	public Supershop(){
		Product p1 = new Product("Egg",120,0); 
		productList[productCount++] = p1; 
		Product p2 = new Product("Oil",750,0);
		productList[productCount++] = p2;
		Product p3 = new Product("Chicken",250,0);
		productList[productCount++] = p3;
		Product p4 = new Product("Sugar",135,0);
		productList[productCount++] = p4;
		Product p5 = new Product("Hilsha Fish",300,0);
		productList[productCount++] = p5;
		Product p6 = new Product("Salt",42,0);
		productList[productCount++] = p6;
		Product p7 = new Product("Atta",130,0);
		productList[productCount++] = p7;
		Product p8 = new Product("Rice",350,0);
		productList[productCount++] = p8;
		Product p9 = new Product("Beef",700,0);
		productList[productCount++] = p9;
	}
	public void addToCart(Product p){
		cart[cartCount++] = p;
		System.out.println("Adding to cart: "+p.getName()+"\t"+p.getPrice()+"\t"+p.getQuantity());
	}
	
	public Product searchProduct(String name){
		Product p = null;
		for(int i = 0; i<productCount; i++){
			if(productList[i].getName().equals(name)){
				p = productList[i]; break;
			}
		}
		return p;
	}
	
	public double calculateBill(){
		double bill = 0;
		for(int i=0; i<cartCount; i++){
			bill = bill + cart[i].getPrice()*cart[i].getQuantity();
		}
		return  bill;
	}
}