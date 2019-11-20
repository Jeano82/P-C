package producerConsumer;

public class synchronizedBuffer implements Buffer {

	private int buffer = -1;
	private int occupiedBuffers = 0;
	private boolean tranaction = false;

	@Override
	public synchronized void set(int value) {
		String name = Thread.currentThread().getName();

		while (occupiedBuffers == 1 && tranaction) {

			try {
				System.err.println(name + " tries to write ");
				DisplayState("buffer full " + name + "waits ");
				wait();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		buffer = value;

		occupiedBuffers++;
		DisplayState(name + "writes" + buffer);
		notifyAll();
	}

	@Override
	public synchronized int get() {

		String name = Thread.currentThread().getName();

		while (occupiedBuffers == 0) {

			try {
				System.err.println(name + "tries to read");
				DisplayState("buffer empty" + name + "waits");
				wait();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		occupiedBuffers--;
		DisplayState(name + "reads" + buffer);
		notifyAll();
		return buffer;
	}

	public synchronized boolean TranactionDone() {

		while (!tranaction) {
			try {
				System.err.println("tranacction Complete");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public void DisplayState(String operation) {

		StringBuffer outputLine = new StringBuffer(operation);
		outputLine.setLength(40);
		outputLine.append(buffer + "\t\t" + occupiedBuffers);
		System.err.println(outputLine);
		System.err.println();

	}

}
