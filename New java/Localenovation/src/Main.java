import java.sql.SQLOutput;

public class Main{
    public static void main(String[]args){

        int [][] makeover = {
                {8,2,5},//January
                {7,4,5},//February
                {5,5,2},//March
                {2,2,3},//April
                {7,7,9},//May
                {7,8,5}//June
        };

        String[] months = {"January","February","March","April","May","June"};


        System.out.println("----------------------------------------------");
        System.out.println("HOME MAKEOVER REPORT");
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s%-12s%-12s%-10s\n","","Bathroom","Kitchens","Garden");

        for(int i = 0; i<months.length;i++){
            System.out.printf("%-10s%-12s%-12s%-10s\n", months[i],makeover[i][0],makeover[i][1],makeover[0][2]);
        }
        System.out.println("----------------------------------------------");
        System.out.println("MONTHLY TOTALS\n");

        for(int i = 0; i < months.length;i++){
            int total = makeover[i][0] + makeover[i][1] + makeover[i][2];
            System.out.printf("%-10s%5d",months[i],total);

            if(total>=15){
                System.out.println(" ***");
            }
            System.out.println();
        }
    }
}