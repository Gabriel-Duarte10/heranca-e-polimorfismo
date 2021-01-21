package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	private Date ManufactureDate;
	
	SimpleDateFormat sb = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		ManufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return ManufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		ManufactureDate = manufactureDate;
	}
	
	@Override
	public String PriceTag() {
		return name + " $ " + String.format("%.2f", price) + " (Manufacture date: " + sb.format(ManufactureDate) + ") " ;
	}
	
	
	
	
}
