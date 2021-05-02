package Day4Homework2;

import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager manager = new StarbucksCustomerManager(new MernisService());
		@SuppressWarnings("deprecation")
		Customer customer = new Customer(1, "Hasan", "Aslan", "48182372635", new Date(1998, 31, 03));
		manager.save(customer);

	}

}
