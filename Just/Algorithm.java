package Just;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    /*
    final long startTime = System.currentTimeMillis();
for (int i = 0; i < length; i++) {
  // Do something
}
final long endTime = System.currentTimeMillis();

System.out.println("Total execution time: " + (endTime - startTime));
     */
    private int initialTemperature;
    private double coolingRate;
    private final double MIN_TEMP = 0.00001;

    private List<Integer> list =new ArrayList<>();

    public Algorithm(int initialTemperature, double coolingRate) {
        this.initialTemperature = initialTemperature;
        this.coolingRate = coolingRate;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime =System.currentTimeMillis();
        long endTime;
        int initialTemperature = 10000;
        double coolingRate = 0.1;
        Algorithm a = new Algorithm(initialTemperature,coolingRate);
        a.run();
        endTime=System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
    public void run() throws FileNotFoundException {
        Just.BestFit b = new Just.BestFit();

        File file = new File("/Users/arina/Downloads/Проектирование/gen/src/main/java/Just/Just/out.txt");
        PrintWriter out = new PrintWriter(file);
        int numIterations=0;
        int res=0,newRes= b.numItems;
        int totalWeight =0;
        double temperature = initialTemperature;



        while (temperature>MIN_TEMP){
//            out.println(numIterations+" "+newRes);
//            out.println(temperature);

            int newR = b.getEnergy(totalWeight, res);
            if (newR<newRes){
            newRes=newR;
        }
            //закон понижения температуры Больцама
//            temperature=(temperature/(Math.log(1+numIterations)));
//            Коши
//            temperature=(temperature/(numIterations+1));
//        temperature*=coolingRate;
//                temperature = (Math.log(1+numIterations))/((1+numIterations));
//        if(numIterations % 1000 == 0){
            temperature *= coolingRate;
//        }

            numIterations++;
         }
        out.close();

        line();
        System.out.println("\n!!! ANSWER: Number of BEST bins required is "+newRes);
        System.out.println("\n"+"numIterations: "+numIterations);
        System.out.println("кол-во предметов: "+b.numBins);
        System.out.println("binCapacity: "+b.binCapacity);

    }

    public void NolforY(int[] y){
        for(int i=0;i<y.length;i++){
            y[i]=0;
        }
    }

    public void line(){
        System.out.println("\n");
        for (int i=0;i!=50;i++){
        System.out.print("=");
        }
        System.out.println("\n");
    }

}
