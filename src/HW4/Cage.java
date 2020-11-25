// 318247822 Idan Hur
package HW4;

import java.io.PrintWriter;
import java.util.Scanner;

public class Cage {

	private static final int MAXWEIGHT = 100;
	private static final int MAXDOGS = 4;
	private static int cageCount = 1;

	private Dog[] dog;
	private boolean hasMale;
	private int currantWeight;
	private int count;
	private int cageNumber;

	public Cage() {
		hasMale = false;
		currantWeight = 0;
		count = 0;
		cageNumber = cageCount++;
		dog = new Dog[MAXDOGS];
	}

	public Cage(Scanner scan) {
		cageNumber = scan.nextInt();
		currantWeight = 0;
		count = scan.nextInt();
		hasMale = false;
		cageCount = cageNumber;
		dog = new Dog[MAXDOGS];
		for (int i = 0; i < dog.length; i++) {
			dog[i] = null;
		}
		for (int i = 0; i < count; i++) {
			dog[i] = new Dog(scan);

		}

	}

	public boolean addDogToCage(Dog dog) {
		Dog temp;
		if (hasMale == dog.isMale() && hasMale == true) {
			return false;
		}
		if (count == MAXDOGS) {
			return false;
		}
		if ((currantWeight + dog.getWeight()) > MAXWEIGHT) {
			return false;
		}
		for (int i = 0; i < this.dog.length; i++) {
			if (this.dog[i] == null) {
				this.dog[i] = dog;
				currantWeight = currantWeight + dog.getWeight();
				dog.setCageNum(cageNumber);
				count++;
				if (dog.isMale()) {
					hasMale = true;
				}
				for (int j = i; j < this.dog.length; j++) {
					for (int j2 = (j + 1); j2 < this.dog.length; j2++) {
						if (this.dog[j] != null && this.dog[j2] != null) {
							if (this.dog[j].getId() > this.dog[j2].getId()) {
								temp = this.dog[j];
								this.dog[j] = this.dog[j2];
								this.dog[j2] = temp;
							}

						}
					}
				}
				return true;
			}
		}
		System.out.println("something went wrong when adding the dog to cage");
		return false;
	}

	public boolean romoveDog(Dog dog) {
		if (count == 0) {
			return false;
		}
		for (int i = 0; i < this.dog.length; i++) {
			if (this.dog[i].getId() == dog.getId()) {
				if (dog.isMale()) {
					hasMale = false;
				}
				count--;
				currantWeight = currantWeight - dog.getWeight();
				this.dog[i] = null;
				if (this.dog[i + 1] != null) {
					for (int j = i; j < this.dog.length; j++) {
						for (int j2 = i + 1; j2 < this.dog.length; j2++) {
							if (this.dog[j] == null && this.dog[j2] != null) {
								this.dog[j] = this.dog[j2];
								this.dog[j2] = null;
							}
						}
					}
				}
				return true;
			}
		}
		return false;
	}

	public Dog findDogById(int id) {
		for (int i = 0; i < dog.length; i++) {
			if (dog[i] != null) {
				if (dog[i].getId() == id) {
					return dog[i];
				}
			}
		}
		return null;
	}

	public static int getCageCount() {
		return cageCount;
	}

	public boolean isHasMale() {
		return hasMale;
	}

	public int getCount() {
		return count;
	}

	public int getCageNumber() {
		return cageNumber;
	}

	public void save(PrintWriter writer) {
		writer.println(cageNumber);
		writer.println(count);
		for (int i = 0; i < dog.length; i++) {
			dog[i].save(writer);
		}
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < dog.length; i++) {
			if (dog[i] != null) {
				str.append(dog[i]);
				str.append(" is in cage number " + cageNumber + "\n ");
			}
		}
		return str.toString();
	}

}
