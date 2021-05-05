
public class GameManager implements IGameManager{
	MernisController mernisController;
	
	
	public GameManager() {
		
	}
	
	public GameManager(MernisController mernisController) {
		this.mernisController = mernisController;
	}
	public MernisController getMernisController() {
		return mernisController;
	}

	public void setMernisController(MernisController mernisController) {
		this.mernisController = mernisController;
	}

	@Override
	public void add(Game game, User user) {
		if (this.mernisController.validatePerson(user)) {
			System.out.println("Game is added: " + game.getName());
		}else {
			System.out.println("Couldn't add the game: "  + game.getName());
		}
	}

	@Override
	public void remove(Game game, User user) {
		System.out.println("Game is removed: " + game.getName());
		
	}

	@Override
	public void update(Game game) {
		System.out.println("Game is updated: " + game.getName());
		
	}

}
