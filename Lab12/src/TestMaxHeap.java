import static org.junit.Assert.*;

import java.io.FileWriter;
import java.util.Arrays;

import org.junit.Test;

public class TestMaxHeap {

	@Test
	public void test() throws Exception {
		int[] x = { 20, 40, 10, 5, 100, 79, 26, 30 };
		Heap h = new MaxIntHeap();
		for (int i = 0; i < x.length; i++)
			h.add(x[i]);
		assertEquals(100, h.pop());
		assertEquals(79, h.pop());
		assertEquals(40, h.pop());
		int[] size = { 100, 10000, 1000000 };

		FileWriter writer = new FileWriter("./count.csv");
		for (int i : size) {
			long[] time = calculateTime(i);
			writer.append(String.format("%d,%f,%f\n", i, (double) time[0], (double) time[1]));
		}
		writer.close();
	}

	public long[] calculateTime(int size) throws Exception {
		long[] interval = new long[2];
		int[] data = new int[size];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 10e6);
		}
		Heap check = new Heap();
		long a = 0;
		long b = 0;
		long start = System.currentTimeMillis();
		for (int i : data) {
			check.add(i);
		}
		long time = System.currentTimeMillis() - start;
		a += time;
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < data.length - 1; i++) {
			check.pop();
		}
		long time2 = System.currentTimeMillis() - start2;
		b += time2;
		interval[0] = a;
		interval[1] = b;
		return interval;
	}

}
