public class ReadyTable {
	public static int limit = 3;

	/**
	 * Method to prepare and add a meal to the table. Synchronized to allow only one thread at a time
	 *
	 * No return value
	 */
	public synchronized static void addMeal(){

		// check if we have space on the table for a meal, and if we have at least one set of burger and fries
		// if true, one of the threads will add a combo meal and counters will be updated
		if(limit > 0 && limit <= 3 && BurgerChef.burgerCounter > 0 && FriesChef.friesCounter > 0){
			System.out.println("[Action] " + Thread.currentThread().getName() + " makes a combo meal and puts it on the table");
			System.out.println("[Status] burgers left: " + --BurgerChef.burgerCounter + ", fries left: " + --FriesChef.friesCounter + ", meals left: " +
					(3 - --limit));
			System.out.println("================================================================");
		}
	}

	/**
	 * Method to serve a meal and update counter
	 *
	 * No return value
	 */
	public synchronized static void mealReady(){
			System.out.println("[Action] Waitress serves a meal\n[Status] meals left: " + (3 - ++ReadyTable.limit));
     		System.out.println("---------------------------------------------------------------");
	}
}
