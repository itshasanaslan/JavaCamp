package Day5Homework1.entities.concretes;

public class ServerResponse implements Day5Homework1.entities.abstracts.ServerResponse{
	private String message;
	private boolean connectionSuccess;
	private boolean operationSuccess;
	
	public ServerResponse() {
		super();
		this.connectionSuccess = true; //simulation
		this.operationSuccess = false;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isConnectionSuccess() {
		return connectionSuccess;
	}

	public void setConnectionSuccess(boolean connectionSuccess) {
		this.connectionSuccess = connectionSuccess;
	}

	public boolean isOperationSuccess() {
		return operationSuccess;
	}

	public void setOperationSuccess(boolean operationSuccess) {
		this.operationSuccess = operationSuccess;
	}
	
}
