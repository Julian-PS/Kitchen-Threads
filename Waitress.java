public class Waitress implements Runnable{
	private String name = "Waitress";
	private int WAIT_TIME = 1000;

	private int SERVE_TIME = 10000; // 10 second

	/**
	 * Runnable method for thread, it runs forever
	 * It implements mealReady method  from the ReadyTable
	 *
	 * No return value
	 */
	@Override
	public void run() {
		while (true){

			// Check if there is a meal ready, if true implement the mealReady method to serve it and then sleep 10 sec (serve time)
			if (ReadyTable.limit < 3) {

				ReadyTable.mealReady();
				try {
					Thread.sleep(SERVE_TIME);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

			// If no meal ready, wait 1 second (wait time)
			else{
				try {
					Thread.sleep(WAIT_TIME);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

		}
	}
}
