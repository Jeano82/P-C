package producerConsumer;

public class Consumer extends Thread {
	private Buffer sharedLocation;

	public Consumer(Buffer sharedLocation) {
		super("Consumer");
		this.sharedLocation = sharedLocation;

	}

	@Override
	public void run() {
		int sum = 0;
		for (int count = 1; count <= 4; count++) {
			try {
				Thread.sleep(1000);
				sum += sharedLocation.get();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.err.println(getName() + "read values totaling: " + sum + "\nTerminatet. " + getName());
	}

}
