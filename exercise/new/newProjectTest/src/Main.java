import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       String[][] data= {{"128km","135km","139km"},{"155km","129km","175km"},{"129km","130km","185km"},{"195km","155km","221km"}};
       String[] city={"JHB","DBN","CTN","PE"};

        System.out.println("**************************************");
        System.out.println("SPEEDING FINES REPORT");
        System.out.println("**************************************");
        System.out.printf("%-4s %-10s %-10s %-10s%n"," ","JAN","FEB","MAR");

        for(int i=0;i< city.length;i++){
            System.out.printf("%-4s", city[i]);

            for(int d=0;i< data[i].length;d++){
                System.out.printf("%-10s",data[i][d]);
            }
            System.out.println();
        }

        System.out.println("*************************************");
        System.out.println("SPEEDING FINES,STATICS");
        System.out.println("*************************************");


    }
}