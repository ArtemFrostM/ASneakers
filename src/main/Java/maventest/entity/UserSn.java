package maventest.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserSn {
	
	

	public List<Sneaker> getSneakers() {
		if(this.sneakers == null){
			this.sneakers = new ArrayList<Sneaker>();
		}
		return sneakers;
	}




	private int id;
	private String nickname;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private List<Sneaker> sneakers;
	
	public UserSn(int id, String nickname, String firstName, String lastName,
			String password, String email) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.sneakers = new ArrayList<Sneaker>();
	}
	
	public UserSn(String nickname, String firstName, String lastName,
			String password, String email) {
		super();
		this.nickname = nickname;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.sneakers = new ArrayList<Sneaker>();
	}
	
	

	@Override
	public String toString() {
		return "UserSn [id=" + id + ", nickname=" + nickname + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password="
				+ password + ", email=" + email + "]";
	}

}
