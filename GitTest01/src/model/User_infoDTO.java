package model;

public class User_infoDTO {
  String user_id;
  String user_pw;
  String user_name;
  
	public User_infoDTO(String user_id, String user_pw, String user_name) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public String getUser_name() {
		return user_name;
	}
	  
  

}
