package Day4Homework2;

public abstract class BaseCustomerManager implements ICustomerService {

	@Override
	public void save(Customer customer) {
		System.out.println("Saved user to db: " + customer.id);
		
	}

}
