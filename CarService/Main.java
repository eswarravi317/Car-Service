package CarService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<CarService> cars = new ArrayList<CarService>();
	
	public void initialize() {
		for(int i=1; i<=3; i++) {
			String carName = null;
			String[] serviceCode = {"BS01", "EF01", "CF01", "BF01", "GF01"};
			String[] serviceName = {"Basic Servicing", "Engine Fixing", "Clutch Fixing", "Brake Fixing", "Gear Fixing"};
			Double[] serviceCharges = new Double[5];
			if(i==1) {
				carName = "Hatchback";
				serviceCharges = new Double[]{(double) 2000, (double) 5000, (double) 2000, (double) 1000, (double) 3000};
			}
			if(i==2) {
				carName = "Sedan";
				serviceCharges = new Double[]{(double) 4000, (double) 8000, (double) 4000, (double) 1500, (double) 6000};
			}
			if(i==3) {
				carName = "SUV";
				serviceCharges = new Double[]{(double) 5000, (double) 10000, (double) 6000, (double) 2500, (double) 8000};
			}
			CarService car = new CarService(carName, serviceCode, serviceName, serviceCharges);
			cars.add(car);
		}
		if(cars.size() != 0) {
			mainMenu();
		}
	}
	
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---Car Service Station---");
		boolean loop = true;
		while(loop) {
			System.out.println("1. Get Details\n2. Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter type of car: ");
				String carName = sc.next();
				System.out.println("Available services: \n"
						+ "Service Code        Service Name\n"
						+" --------------------------------\n"
						+ "   BS01            Basic Servicing\n"
						+ "   EF01            Engine Fixing\n"
						+ "   CF01            Clutch Fixing\n"
						+ "   BF01            Brake Fixing\n"
						+ "   GF01            Gear Fixing");
				System.out.print("Enter number of services you want: ");
				int n = sc.nextInt();
				String[] serviceCodes = new String[n];
				for(int i=0; i<n; i++) {
					System.out.print("Enter Service Code "+(i+1)+": ");
					serviceCodes[i] = sc.next();
				}
				getDetails(carName, serviceCodes);
				break;
			case 2:
			default:
				System.out.println("Application exited");
				loop = false;
				break;
			}
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
	}
	
	public void getDetails(String carName, String[] serviceCodes) {
		for(CarService car: cars) {
			if(carName.equalsIgnoreCase(car.carName)) {
				double sum = 0;
				for(int i=0; i<serviceCodes.length; i++) {
					int index = car.serviceCode.indexOf(serviceCodes[i]);
					sum += car.serviceCharges.get(index);
					System.out.println("Charges for "+car.serviceName.get(index)+" - "+ car.serviceCharges.get(index));
				}
				System.out.println("------------------------------------------\nTotal Bill - "+ sum
						+"\n------------------------------------------");
				if(sum > 10000) {
					System.out.println("Complimentary cleaning provided free for you...\n");
				}
			}
		}
	}
}