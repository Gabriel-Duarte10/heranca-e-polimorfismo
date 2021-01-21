package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sb = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i +" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char op = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(op == 'c')
			{
				Product product = new Product(name, price);
				list.add(product);
			}
			else
			{
				if(op == 'u') {
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date date = sb.parse(sc.next());
					UsedProduct imp = new UsedProduct(name, price, date);
					list.add(imp);
				}
				else {
					if(op == 'i') {
						System.out.print("Customs fee: ");
						double taxa = sc.nextDouble();
						ImportedProduct imp = new ImportedProduct(name, price, taxa);
						list.add(imp);
					}
				}
					
			}
		}
		
		for(Product c : list) {
			System.out.println(c.PriceTag());
		}
		
		sc.close();
	}

}
