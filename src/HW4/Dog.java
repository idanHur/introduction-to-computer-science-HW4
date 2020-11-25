// 318247822 Idan Hur
package HW4;

import java.awt.Component.BaselineResizeBehavior;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dog {
	public enum BreedEnum {
		Wolf, Poodle, Malinois, Pitbull
	};

	private MyDate dateIn;
	private static int idCounter = 100;
	private boolean isMale;
	private int id;
	private String name;
	private BreedEnum breed;
	private int weight;
	private int cageNum;
	private String temp;
	private BreedEnum Breed;

	public Dog(String name, String breed, int weight, Boolean isMale, MyDate in) {
		this.isMale = isMale;
		setName(name);
		this.weight = weight;
		setBreed(breed);
		dateIn = in;
		id = idCounter++;
	}

	public Dog(Scanner scan) {
		setName(scan.next());
		temp = scan.next();
		temp = temp.replace(",", "");
		weight = Integer.parseInt(temp);

		String isMaleCheack = scan.next();
		isMaleCheack = isMaleCheack.replace(", ", "");
		if (isMaleCheack == "true") {
			isMale = true;
		}
		if (isMaleCheack == "false") {
			isMale = false;
		}
		temp = scan.next();
		temp = temp.replace(", ", "");
		setBreed(temp);
		;
		temp = scan.next();
		temp = temp.replace(", ", "");
		id = Integer.parseInt(temp);
		dateIn = new MyDate(scan);

	}

	public static void setIdCounter(int idCounter) {
		Dog.idCounter = idCounter;
	}

	public int getCageNum() {
		return cageNum;
	}

	public void setCageNum(int cageNum) {
		this.cageNum = cageNum;
	}

	public MyDate getDateIn() {
		return dateIn;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!StringUtil.isLegalName(name)) {
			this.name = "TheD";
		}
		this.name = name;
	}

	public String getBreed() {
		return breed.name();
	}

	public void setBreed(String breed) {
		char toCapitalL = Character.toUpperCase(breed.charAt(0));
		breed = breed.toLowerCase();
		String breedWithCap = toCapitalL + breed.substring(1);
		Breed = BreedEnum.valueOf(breedWithCap);

	}

	public int getWeight() {
		return weight;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public void save(PrintWriter writer) {
		writer.println(name + ", " + weight + ", " + isMale + ", " + breed + ", " + id);
		dateIn.save(writer);
	}

	public String toString() {
		if (isMale) {
			return "dog id " + id + " " + name + " of type " + breed + " weights " + weight
					+ " male enter to dog house on " + dateIn.toString();
		} else {
			return "dog id " + id + " " + name + " of type " + breed + " weights " + weight
					+ " female enter to dog house on " + dateIn.toString();
		}
	}

}
