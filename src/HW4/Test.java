package HW4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("C:\\house.txt"));
		DogHouse D = new DogHouse(scan);
		System.out.println(D.toString());
		

	}

}
