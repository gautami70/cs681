package hw1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
	private String make, model;
	private int mileage, year;
	private int price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, int price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public int getMileage() {
		return mileage;
	}
	public int getYear() {
		return year;
	}
	public int getPrice() {
		return price;
	}
	public void setDominationCount(ArrayList<Car> cars) {
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--;
	}
	public int getDominationCount() {
		return this.dominationCount;
	}
	@Override
	public String toString() {
		return this.make +" "+ this.model+" "+ this.mileage+" "+this.year+" "+this.price;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("Cadenza", "Kia", 400, 2020, 40000 ));
		carList.add(new Car("Altima", "Nissan", 600, 2021, 20000 ));
		carList.add(new Car("Audi", "A5", 800, 2022, 12000));
		carList.add(new Car("Accord Hybrid", "Honda", 1000, 2021, 50000));
		carList.add(new Car("C40 Recharge", "Volvo", 1200, 2022, 80000));
		carList.add(new Car("Compass", "Jeep", 300, 2023, 30000));
		
		ArrayList<Car> cars = new ArrayList<>();
		System.out.println("by Year:");
		List<Car> sortedYearWise=carList.stream().sorted(Comparator.comparingInt(Car::getYear)).collect(Collectors.toList());
		sortedYearWise.forEach(System.out::println);
		System.out.println("\n");

		System.out.println("by Mileage:");
		List<Car> sortedMileageWise=carList.stream().sorted(Comparator.comparingInt(Car::getMileage)).collect(Collectors.toList());
		sortedMileageWise.forEach(System.out::println);
		System.out.println("\n");

		System.out.println("by Price:");
		List<Car> sortedPriceWise=carList.stream().sorted(Comparator.comparingInt(Car::getPrice)).collect(Collectors.toList());
		sortedPriceWise.forEach(System.out::println);
		System.out.println("\n");

		System.out.println("Domination Count:");
		List<Car> sortedDominationCountWise=carList.stream().sorted(Comparator.comparingInt(Car::getDominationCount)).collect(Collectors.toList());
		sortedDominationCountWise.forEach(System.out::println);
		System.out.println("\n");
	}

}
