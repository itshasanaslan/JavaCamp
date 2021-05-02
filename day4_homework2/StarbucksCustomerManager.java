package Day4Homework2;

public class StarbucksCustomerManager extends BaseCustomerManager{
	ICustomerCheckService _checkService;

	public StarbucksCustomerManager(ICustomerCheckService _checkService) {
		this._checkService = _checkService;
	}
	
	@Override
	public void save(Customer customer) {
		if (this._checkService.checkIfRealPerson(customer)) {
			super.save(customer);
		}else {
			System.out.println("Not a real person!");
		}
	}
	
	

}
