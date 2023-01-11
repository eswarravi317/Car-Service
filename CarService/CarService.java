package CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
	String carName;
	List<String> serviceCode = new ArrayList<String>();
	List<String> serviceName = new ArrayList<String>();
	List<Double> serviceCharges = new ArrayList<Double>();
	
	public CarService(String carName, String[] serviceCode, String[] serviceName, Double[] serviceCharges) {
		this.carName = carName;
		this.serviceCode = Arrays.asList(serviceCode);
		this.serviceName = Arrays.asList(serviceName);
		this.serviceCharges = Arrays.asList(serviceCharges);
	}	
}