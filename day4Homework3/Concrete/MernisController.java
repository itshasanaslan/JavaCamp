
public class MernisController implements IMernisController {

	@Override
	public boolean validatePerson(User user) {
		if (this.tcValidate(user.nationalityId)) {
			System.out.println("Kullanıcı gerçek bir kisi.");
			return true;
		}
		
		System.out.println("Geçersiz T.C. vatandasi!");
		return false;
	
	}
	
	  public boolean tcValidate(String tc) {

	        int teklerToplam = 0;
	        int ciftlerToplam = 0;

	        for (int x = 0; x <= 8; x += 2) {
	            teklerToplam+= (Integer.valueOf(tc.substring(x, x + 1)));
	        }
	        for (int x = 1; x <= 7; x += 2) {
	            ciftlerToplam+= (Integer.valueOf(tc.substring(x, x + 1)));
	        }


	        int haneOn = (teklerToplam * 7 - ciftlerToplam) % 10;
	        int haneOnBir = (teklerToplam + ciftlerToplam + haneOn)%10;

	        return (haneOn == Integer.valueOf(tc.substring(9, 10)) && haneOnBir == Integer.valueOf(tc.substring(10, 11)));
	    }
}
