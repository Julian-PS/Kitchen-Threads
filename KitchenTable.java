public class KitchenTable {
	public static int limit = 5;

	/**
	 * Method to add burgers and fries to the table. It is synchronized so only one thread can access at a time
	 *
	 * @param food String name of the food to be added (burger or fries)
	 * @param foodCounter int counter to keep track of burgers and fries already on the table
	 */
	public synchronized static void addFood(String food, int foodCounter){

		// check if we have reached the limit of food permitted, if not add food to table
		if(foodCounter < limit){
			System.out.println("[Action] " + Thread.currentThread().getName() + " adds " + food + " on the kitchen table");

			// check which thread added food and update its respective counter
			if (food.equals("burger")){
				BurgerChef.burgerCounter++;
				System.out.println("[Status] burgers left: " + BurgerChef.burgerCounter);
			}
			if (food.equals("fries")){
				FriesChef.friesCounter++;
				System.out.println("[Status] fries left: " + FriesChef.friesCounter);
			}
		}
	}
}
