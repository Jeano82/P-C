package producerConsumer;

public class Producer extends Thread {
	private Buffer sharedLocation;

	public Producer(Buffer sharedLocation) {
		super("Producer");
		this.sharedLocation = sharedLocation;

	}

	@Override
	public void run() {
		for (int count = 1; count <= 4; count++) {
			try {
				Thread.sleep(1000);
				sharedLocation.set(count);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.err.println(getName() + "done pro \nTerminate" + getName());
	}

}
