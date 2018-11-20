package maventest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sneaker {
	
	
	public Sneaker(String brand, String model, int releaseYear,
			String description) {
		super();
		//this.id = count++;
		this.brand = brand;
		this.model = model;
		this.releaseYear = releaseYear;
		this.description = description;
	}
	private static int count = 5;
	private int id;
	private String brand;
	private String model;
	private int releaseYear;
	private String description;
	
	@Override
	public String toString() {
		return "Sneaker [id=" + id + ", brand=" + brand + ", model=" + model
				+ ", releaseYear=" + releaseYear + ", description="
				+ description + "]" + "____";
	}
}
