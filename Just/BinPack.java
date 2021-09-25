package Just;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinPack {

    public List<Integer> m() {
        List<Integer> wei = new ArrayList<Integer>();
        try {
            Scanner s = new Scanner(new FileReader("/Users/arina/Downloads/Проектирование/gen/src/main/java/Just/Just/in.txt"));

            while (s.hasNextInt()) {
                wei.add(s.nextInt());
            }
            System.out.println(wei.size() + ", " + wei);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return wei;
    }
}


