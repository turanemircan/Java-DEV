package StructuralDP.CompositeDP;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        //tüm çalışanları listele
        Finance finance=new Finance();
        Sales sales=new Sales();
        //yeni bir department oluşturduk
        Arge arge=new Arge();

        List<String> allEmployees=new ArrayList<>();

        finance.getEmployees().forEach(t->allEmployees.add(t));
        sales.getEmployees().forEach(t->allEmployees.add(t));
        //yeni bir department oluşturduk
        arge.getEmployees().forEach(t->allEmployees.add(t));

        System.out.println(allEmployees);


        System.out.println("------------------Composite DP--------------------------------");

        //tüm çalışanları listele
        HeadDepartment head=new HeadDepartment();
        head.addDepartment(finance);
        head.addDepartment(sales);
        //yeni bir department oluşturduk
        head.addDepartment(arge);


        System.out.println("Tüm departmanlar : "+head.getName());
        System.out.println("Tüm çalışanlar : "+head.getEmployees());


    }
}
