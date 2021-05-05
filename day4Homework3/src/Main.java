public class Main {
	
	public static void main(String[] args) {
		GameManager gameManager = new GameManager(new MernisController());
		CampaignManager campaignManager = new CampaignManager();
		User user1 = new User(0, "90837670224", "Hasan", "Aslan", 1998);
		
		
		Game game1 = new Game(0, "Counter Strike - Global Offensive", 29.99f, "FPS", "A modern version of a classic game.");
		Game game2 = new Game(1, "Grand Theft Auto 5", 69.99f, "TPS-ROLEPLAY", "Get ready for the adventure!");

		
		Campaign campaign1 = new Campaign(0, "Christmas Campaign!", 24f);
		
		
		campaignManager.add(campaign1, game1);
		campaignManager.add(campaign1, game2);
		gameManager.add(game1, user1);
		gameManager.add(game2, user1);
		
	}

}
