
public class CampaignManager implements ICampaignService{

	@Override
	public void add(Campaign campaign, Game game) {
		System.out.println("Campaign is applied: " + campaign.getName() + " - %" + campaign.getDiscountRate() + " discount rate.");
		float newPrice = game.price - (campaign.discountRate * game.price) / 100;
		System.out.println(game.getName() + "-" + game.getPrice() + "  => [%" + campaign.getDiscountRate() + "] " + newPrice + "$");
	}

	@Override
	public void remove(Campaign campaign) {
		System.out.println("Campaign is removed: " + campaign.getName());
		
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Campaign is updated: " + campaign.getName());		
	}
}


