package hryciuk.learningGroup.servletsFirst.domain;

public class SystemUser {
	
	private long idUser;
	
	private String loginUser;
	
	private String passwordUser;
	
	
	public SystemUser() {
	}


	public long getIdUser() {
		return idUser;
	}


	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}


	public String getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	public String getPasswordUser() {
		return passwordUser;
	}


	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	
	
}
