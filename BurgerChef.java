public class BurgerChef implements Runnable {
	private String name = "BurgerChef";
	private int WAIT_TIME = 1000;
	private int MAKE_TIME = 3000;
	public static int burgerCounter = 0; // to keep track of how many burgers we have on the kitchen table

	/**
	 * Runnable method for thread, it runs forever
	 * It implements addFood method  from the KitchenTable and the addMeal method from the ReadyTable
	 * Methods explained in their respective classes
	 *
	 * No return value
	 */
	@Override
	public void run() {

		while (true) {

			// check if both tables are at full capacity, if true wait 1 second and check again
			if (burgerCounter == KitchenTable.limit && ReadyTable.limit == 0) {
				try {
					Thread.sleep(WAIT_TIME);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				continue;
			}

			// sleep for 3 seconds (preparation time) and then call the addFood method  from the KitchenTable and
			//the addMeal method from the ReadyTable. Both methods explained in their respective classes
			try {
				Thread.sleep(MAKE_TIME);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			KitchenTable.addFood("burger", BurgerChef.burgerCounter);
			ReadyTable.addMeal();
		}
	}
}
