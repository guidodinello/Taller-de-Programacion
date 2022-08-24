package logica.clases;

import java.util.List;

public class Usuario {

	private String nickname;
	private String email;
	
	public String getNickname() {
		return nickname;
	}
	
	public String getEmail() {
		return email;
	}

	public List<String> getKey() {
		return List.of(nickname, email);
	}

}
