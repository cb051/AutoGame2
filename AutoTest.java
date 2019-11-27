public class AutoTest
{
	public static void main(String[] args)
	{
		GasTank tank = new GasTank(10);
		tank.setLevel(20);
		System.out.printf("Tank level: %.2f\n\n", tank.getLevel());

		Engine engine1 = new Engine("V6", 20, 120);
		System.out.println("Engine1: " + engine1.getDescription() + "\n");

		Auto auto1 = new Auto("Auto1", 15, engine1);
		System.out.println("Auto1: " + auto1.getDescription() + "\n");

		Auto auto2 = new Auto("", -1, null);
		System.out.println("Auto2: " + auto2.getDescription() + "\n");

		Auto auto3 = new Auto("Auto3", 50, engine1);
		System.out.println("Auto3: " + auto3.getDescription());
		auto3.fillUp();
		System.out.println("Auto3: " + auto3.getDescription());
		double milesDriven = 0;
		double totalMilesDriven = 0;

		double [][] foo = {{600, -4.0, -3.0}, {300, 3.0, 2.0}, {400, 4.0, 0}};
		for (double [] arr : foo) {
			milesDriven = auto3.drive((int)arr[0], arr[1], arr[2]);
			totalMilesDriven = totalMilesDriven + milesDriven;
			System.out.printf("Auto3 drove %.2f miles\n", milesDriven);
			System.out.println("Auto3: " + auto3.getDescription());
			//auto3.fillUp();
		}
		System.out.printf("Auto3 drove a total of %.2f miles.\n\n", totalMilesDriven);
		totalMilesDriven = 0;

		System.out.println("");
		Auto auto4 = new Auto("Auto4", 30, new Engine("V4", 30, 100));
		System.out.println("Auto4: " + auto4.getDescription());
		auto4.fillUp();
		System.out.println("Auto4: " + auto4.getDescription());

		double [][] foo2 = {{100, 1.0, 1.0}, {200, -2.5, 1.0}, {300, 1.0, 0.5}, {400, 0.25, -0.5}, {500, 2.0, 2.0}};
		for (double [] arr : foo2) {
			milesDriven = auto4.drive((int)arr[0], arr[1], arr[2]);
			totalMilesDriven = totalMilesDriven + milesDriven;
			System.out.printf("Auto4 drove %.2f miles\n", milesDriven);
			System.out.println("Auto4: " + auto4.getDescription());
			//auto4.fillUp();
		}
		System.out.printf("Auto4 drove a total of %.2f miles.\n\n", totalMilesDriven);
		totalMilesDriven = 0;
	}
}
