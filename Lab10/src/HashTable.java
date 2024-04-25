import java.io.FileWriter;
import java.util.Arrays;

class OpenAddressHashing {
    private final int[] table;
    private final int size;
    private final int EMPTY = -1;
    private int CollisionCount = 0;

    public OpenAddressHashing(int size) {
        this.size = size;
        table = new int[size];
        Arrays.fill(table, EMPTY);
    }

    // Hash function using linear probing
    private int linearProbe(int key, int i) {
        return (key + i) % size;
    }

    // Hash function using quadratic probing
    private int quadraticProbe(int key, int i) {
        return (key + i * i) % size;
    }

    // Insertion operation with linear probing
    public void insertLinear(int key) {
        int index = key % size;
        int i = 1;
        while (table[index] != EMPTY) {
            index = linearProbe(key, i);
            i++;
            CollisionCount++;
        }
        table[index] = key;
    }

    // Insertion operation with quadratic probing
    public void insertQuadratic(int key) {
        int index = key % size;
        int i = 1;
        while (table[index] != EMPTY) {
            index = quadraticProbe(key, i);
            i++;
            CollisionCount++;
        }
        table[index] = key;
    }

    public static void main(String[] args) {
        int tableSize = 10000;
        String fileName = "Table1.csv";
        try (FileWriter fileWriter = new FileWriter(fileName)) {

            for (int n = 100; n <= 9900; n += 100) {
                OpenAddressHashing linearHashing = new OpenAddressHashing(tableSize);
                OpenAddressHashing quadraticHashing = new OpenAddressHashing(tableSize);
                int[] data = new int[n];
                for (int i = 0; i < data.length; i++) {
                    data[i] = (int) (Math.random() * 10e6);
                    // Insert data into the hash table
                    linearHashing.insertLinear(data[i]);
                    quadraticHashing.insertQuadratic(data[i]);
                }
                System.out.println("n is " + n);
                System.out.println("Linear collision is " + linearHashing.CollisionCount);
                System.out.println("Quadratic collision is " + quadraticHashing.CollisionCount);
                float a = n;
                float b = tableSize;
                float loadFactor = a / b;
                System.out.println("Load factor is " + loadFactor);

                fileWriter
                        .append(String.format("%.2f,%d,%d\n", loadFactor, linearHashing.CollisionCount,
                                quadraticHashing.CollisionCount));
                System.out.println("Data is written to " + fileName);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
