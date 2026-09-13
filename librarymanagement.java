import java.util.Scanner;
class library{
    int roll_num;
    String name;
    String Scholar;
    String Campus;
    int days;
library(){
   this.roll_num = 0;
   this.name = "none";
   this.Scholar = "none";
   this.Campus = "none";
   this.days = 0;
}
library(int a,String b,String c,String d,int e){
    this.roll_num = a;
    this.name = b;
    this.Scholar = c;
    this.Campus = d;
    this.days = e;
}
void Fine(String category ,int days){
    if(category.equals("UG")){
        if(days>15 && days<=25){
            int fine;
            fine = days - 15;
            fine = fine*5;
            System.out.println("Pay rs "+fine+"/-");
            return;
    }


     else if(days>25 && days<=40){
        int fine;
        fine = days - 15;
        fine = fine*10;
        System.out.println("Pay rs "+fine+"/-");
        return;
    }
     if(days>40){
        int fine;
        fine = days - 15;
        fine = fine*15;
        System.out.println("Pay rs "+fine+"/-");
        return;
    }
    else{
        System.out.println("No fine");
    }
}
else if(category.equals("PG")){
    if(days>30 && days<=60){
        int fine;
        fine = days - 30;
        fine = fine*10;
        System.out.println("pay rs"+fine+"/-");
        return;
    }
    else if(days>60){
        int fine;
        fine = days - 30;
        fine = fine*15;
        System.out.println("pay rs "+fine+" /-");
        return;
    }
    else{
        System.out.println("No fine");
    }
}
else if(category.equals("RS")){
    if(days>60 && days<=90){
        int fine;
        fine = days - 60;
        fine = fine*10;
        System.out.println("Pay rs "+fine+" /-");
        return;
    }
    else if(days>90){
        int fine;
        fine = days - 60;
        fine = fine*15;
        System.out.println("Pay rs "+fine+" /-");
        return;
    }
    else{
        System.out.println("No fine");
    }
}
else if(category.equals("staffs")){
    if(days>180){
        int fine = days - 180;
        fine = fine*15;
        System.out.println("pay rs "+fine+"/-");
        return;
    }
    else{
        System.out.println("No fine");
    }
}}
void print(){
    System.out.println("\nTHE STUDENTS DETAILS: ");
    System.out.println("Roll Number : "+roll_num );
    System.out.println("Name: "+name);
    System.out.println("Scholar: "+Scholar);
    System.out.println("Campus: "+Campus);
}
};
public class librarymanagement{
    public static void main(String[] args){
        int a,days;
        String n, c, S;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details: ");
        System.out.print("roll number:");
        a = sc.nextInt();
        System.out.print("days: ");
        days = sc.nextInt();
        System.out.print("Name: ");
        n = sc.next();
        System.out.print("Scholar: ");
        S = sc.next();
        System.out.print("Campus: ");
        c = sc.next();
        library l1 = new library(a,n,S,c,days);
        l1.print();
        l1.Fine(S, days);
}
}