import java.util.Scanner;
import java.io.File;

public class Lab1_Cardenas{
    public static void main(String[] args){
            File file = new File("input.txt");
            
            dailySpent(file);//adds all the categories in a day
            moneyPer(file);//contains daily averages and the highest category

    }

    public static void dailySpent(File file){
        try{
            Scanner fScanner = new Scanner(file);
            System.out.println("----- Daily Spending -----");
            for(int i=1;i<=14;i++){
                double totalSpent = 0.0;
                int tick = 0;
                while(tick<3){//goes through three .next in order to stay in the same day
                    int temp = fScanner.nextInt();
                    double addTo = temp;
                    totalSpent += addTo;
                    tick++;
                }
                tick=0;
                System.out.println("Day "+i+": Total spending $"+totalSpent);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void Avgs(File file){//basically the same as the daily but this time it checks which is max and min
        try{
            Scanner fScanner = new Scanner(file);
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;
            int maxDay= 0;
            int minDay= 0;
            for(int i=1;i<=14;i++){
                double totalSpent = 0.0;
                int tick = 0;
                while(tick<3){
                    int temp = fScanner.nextInt();
                    double addTo = temp;
                    totalSpent += addTo;
                    tick++;
                }
                if(totalSpent>max){
                    max=totalSpent;
                    maxDay=i;
                }
                if(totalSpent<min){
                    min=totalSpent;
                    minDay=i;
                }
                tick=0;
            }
            System.out.println("----- Highest and Lowest Daily Spending -----");
            System.out.println("Highest daily spending: Day "+maxDay+": $"+max);
            System.out.println("Lowest daily spending: Day "+minDay+": $"+min);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void moneyPer(File file){//contains the avgs method becauswe wanted to keep the same format
        try{
            Scanner fScanner = new Scanner(file);
            double avgOffice=0.0;
            double avgMark=0.0;
            double avgTrav=0.0;

            for(int i=1;i<=14;i++){
                int tick = 0;
                if(tick==0){
                    double addTo = fScanner.nextInt();
                    avgOffice+=addTo;
                    tick++;
                }
                if(tick==1){
                    double addTo = fScanner.nextInt();
                    avgMark+=addTo;
                    tick++;
                }
                if(tick==2){
                    double addTo = fScanner.nextInt();
                    avgTrav+=addTo;
                    tick=0;
                }
            }
            avgOffice=avgOffice/14.0;
            avgMark=avgMark/14.0;
            avgTrav=avgTrav/14.0;
            System.out.println(" ----- Category Average -----");
            System.out.println("Average spent on office supplies: $"+Math.round(avgOffice * 100.0) / 100.0);//Math.round( * 100.0) / 100.0) rouds two the second decimal point
            System.out.println("Average spent on marketing: $"+Math.round(avgMark * 100.0) / 100.0);//Math.round( * 100.0) / 100.0) rouds two the second decimal point
            System.out.println("Average spent on travel: $"+Math.round( avgTrav* 100.0) / 100.0);//Math.round( * 100.0) / 100.0) rouds two the second decimal point

            Avgs(file);//run cause order

            double hAvg=avgOffice;
            double lAvg=avgOffice;
            String hDay = "Office Supplies";
            String lDay = "Office Supplies";
            if(avgMark>hAvg){
                hAvg=avgMark;
                hDay="Marketing";
            }
            if(avgTrav>hAvg){
                hAvg=avgTrav;
                hDay="Travel";
            }
            if(avgMark<lAvg){
                lAvg=avgMark;
                lDay="Marketing";
            }
            if(avgTrav<lAvg){
                lAvg=avgTrav;
                lDay="Travel";
            }

            System.out.println("----- Category Spending Extremes -----");
            System.out.println("Category with the highest average spending: "+hDay+": "+Math.round( hAvg* 100.0) / 100.0);//Math.round( * 100.0) / 100.0) rouds two the second decimal point
            System.out.println("Category with the lowest average spending: "+lDay+": "+Math.round( lAvg* 100.0) / 100.0);//Math.round( * 100.0) / 100.0) rouds two the second decimal point

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

   
    
}