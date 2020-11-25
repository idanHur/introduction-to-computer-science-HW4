// 318247822 Idan Hur
package HW4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DogHouse {
	private static String nameOfHouse;
	private Cage[] cages;
	private int cageCount;
	private int dogCount;
	private int overallDogCount;

	public DogHouse(String name) {
		nameOfHouse = name;
		cages = new Cage[20];
		cageCount = 0;
		dogCount = 0;
		overallDogCount = 0;
		for (int i = 0; i < cages.length; i++) {
			cages[i] = null;
		}
	}

	public DogHouse(Scanner scan) {
		nameOfHouse = scan.next();
		Dog.setIdCounter(scan.nextInt());
		cageCount = scan.nextInt();
		cages = new Cage[20];
		for (int i = 0; i < cages.length; i++) {
			cages[i] = null;
		}
		for (int i = 0; i < cageCount; i++) {
			cages[i] = new Cage(scan);
			dogCount += cages[i].getCount();
		}
		overallDogCount = (Dog.getIdCounter() - 100);
	}

	public void addDogCount(int dogCount) {
		dogCount++;
	}

	public boolean addDogToDogHouse(Dog dog) {
		boolean sucssesAdd = false;
		for (int i = 0; i < cages.length; i++) {
			if (cages[i] != null) {
				sucssesAdd = cages[i].addDogToCage(dog);
				if (sucssesAdd) {
					dogCount++;
					overallDogCount++;
					return true;
				}
			}
		}
		for (int i = 0; i < cages.length; i++) {
			if (cages[i] == null) {
				cages[i] = new Cage();
				cages[i].addDogToCage(dog);
				cageCount++;
				dogCount++;
				overallDogCount++;
				return true;
			}
		}
		return false;
	}

	public int outDog(int id, MyDate outDate) {
		Dog dog;
		int daysOfStay = 0;
		for (int i = 0; i < cages.length; i++) {
			if (cages[i].findDogById(id) != null) {
				dog = cages[i].findDogById(id);
				daysOfStay = dog.getDateIn().daysCount(outDate);
				cages[i].romoveDog(dog);
				dogCount--;
				if (cages[i].getCount() == 0) {
					cages[i] = null;
					cageCount--;
					if (cages[i + 1] != null) {
						for (int j = i; j < cages.length; j++) {
							for (int j2 = (i + 1); j2 < cages.length; j2++) {
								if (cages[j] == null && cages[j2] != null) {
									cages[j] = cages[j2];
									cages[j2] = null;
								}
							}
						}
					}
				}
				return daysOfStay;
			}

		}
		return -1;
	}

	public static String getNameOfHouse() {
		return nameOfHouse;
	}

	public int getCageCount() {
		return cageCount;
	}

	public int getDogCount() {
		return dogCount;
	}

	public void makePriceStatment(Dog dog, int days) {
		double priceForDayPerKilo = 0.8;
		int minPayPerDay = 30;
		double payForStay;

		if ((dog.getWeight() * priceForDayPerKilo) < minPayPerDay) {
			payForStay = minPayPerDay * days;
			System.out.println(dog + " is in cage number " + dog.getCageNum());
			System.out.println("Need to pay " + payForStay + " IS");
			return;
		} else {
			payForStay = (dog.getWeight() * priceForDayPerKilo) * days;
			System.out.println(dog + " is in cage number " + dog.getCageNum());
			System.out.println("Need to pay " + payForStay + " IS");
			return;
		}
	}

	public void save(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		PrintWriter writer = new PrintWriter(f);
		writer.println(nameOfHouse);
		writer.println(Dog.getIdCounter());
		writer.println(cageCount);
		for (int i = 0; i < cages.length; i++) {
			cages[i].save(writer);
		}
		writer.close();

	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("In house " + nameOfHouse + " there are " + dogCount + " dogs\n");
		for (int i = 100; i < (100 + overallDogCount); i++) {
			for (int k = 0; k < cages.length; k++) {
				if (cages[k] != null) {
					if (cages[k].findDogById(i) != null) {
						str.append(cages[k].findDogById(i) + " is in cage number " + cages[k].getCageNumber() + "\n");
					}
				}
			}
		}
		str.append("There are " + cageCount + " cages\n");
		for (int j = 0; j < cages.length; j++) {
			if (cages[j] != null) {
				str.append("In cage " + cages[j].getCageNumber() + " there are " + cages[j].getCount() + " dogs\n");
				str.append(cages[j].toString());
				str.append("\n");
			}
		}
		return str.toString();

	}
}
