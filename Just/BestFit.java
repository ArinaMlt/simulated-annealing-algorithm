package Just;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class BestFit {

        //START PROGRAM


    public  final Just.BinPack data =new Just.BinPack();
    public List<Integer> list =data.m();
    public int numItems = list.size();
    public int y[]=new int[numItems];
    public int numBins = list.size();
    public int binCapacity = 20;


    /**
     * берем рандомный из мешка
     * @return индекс элемента
     */
    public int rand(){
     int k = (int)(Math.random()*(numItems));
//        System.out.println(k);
        if(prov(k)){
           k=rand();
        }
        return k;
    }

    /**
     * ВЕРОЯТНОСТЬ ПРИНЯТИЯ
     *
     * проверка на использование
     * @param i рандомный элемент
     * @return true - если элемент использовался
     * false - если элемент не использовался
     */
    public boolean prov(int i){
        return y[i]!=0?true:false;
    }

    /**
     * ФУНКЦИЯ ЭНЕРГИИ
     * @param totalWeight
     * @param res
     */
    public int getEnergy(int totalWeight,int res) throws FileNotFoundException {
        int []pred = new int[numItems];
        System.out.println("\n-----------------");

        while (sum(y)!=numItems){
            int k=rand();
            y[k]=1;
           int[] result = bin(k,pred,totalWeight, res);
            res =result[0];
            totalWeight = result[1];
        }
        System.out.println("\nTotal packed weight: " + totalWeight);
        System.out.print("Number of bins required is : "
                + res);
        NolforY(y);
        return res;
    }

    /**
     *
     * @param x массив
     * @return сумму всех элементов входного массива
     */
    public int sum(int[] x){
        int sum=0;
        for (int i=0;i<x.length;i++){
            sum+=x[i];
        }
        return sum;
    }

    /**
     *
     * @param y массив
     *          метод печатает массив
     */
    public void printY(int[] y){
        System.out.print("y: ");
        for (int i=0;i<y.length;i++){
            System.out.print(y[i]);
        }
        System.out.println(" ");
    }

    /**
     *
     * @param i найденное рандомное значение предмета
     * @param pred массив
     *             метод ищет место для предметов в бункере
     */
    public int[] bin(int i, int[] pred, int totalWeight,int res) throws FileNotFoundException {
        File file = new File("/Users/arina/Downloads/Проектирование/gen/src/main/java/Just/Just/out.txt");
        PrintWriter out = new PrintWriter(file);
        int[] result = new int[2];
            int min = binCapacity + 1;
            int bi = 0;
            if (list.get(i)>binCapacity){
                Just.MyException mx =new Just.MyException();
                System.out.println("Exception: "+mx.toString());
            }
            for (int j = 0; j < res; j++) {
                if (pred[j] >= list.get(i) &&
                        pred[j] - list.get(i) < min) {
                    bi = j;
                    min = pred[j] - list.get(i);
                }
            }
            if (min == binCapacity + 1) {
//                System.out.println("\n"+"Bin: " + res+"\n");
                pred[res] = binCapacity - list.get(i);
//                System.out.println("Item " + i + " - weight: " + list.get(i));
                totalWeight+=list.get(i);
                out.println(totalWeight);

//                System.out.println("total weight (if new bin): "+totalWeight);
                res++;
            } else {
//                System.out.println("Item " + i + " - weight: " + list.get(i));
                totalWeight+=list.get(i);
                pred[bi] -= list.get(i);
            }
//        System.out.println("total weight: "+totalWeight);
            result[0]=res;
            result[1]=totalWeight;
        out.close();
        return result;
    }

    public void NolforY(int[] y){
        for(int i=0;i<y.length;i++){
            y[i]=0;
        }
    }

}
