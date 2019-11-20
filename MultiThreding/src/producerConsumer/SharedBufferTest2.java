package producerConsumer;

public class SharedBufferTest2 {

	public static void main(String[] args) {

		synchronizedBuffer sharedLocation = new synchronizedBuffer();

		StringBuffer columnHeads = new StringBuffer("Operation");
		columnHeads.setLength(40);
		columnHeads.append("Buffer\t\tOccupied Count");
		System.err.println(columnHeads);
		System.err.println();
		sharedLocation.DisplayState("initial State");

		Producer producer = new Producer(sharedLocation);
		producerConsumer.Consumer consumer = new producerConsumer.Consumer(sharedLocation);
		producer.start();
		consumer.start();

	}

}
