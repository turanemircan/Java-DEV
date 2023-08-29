package StructuralDP.CompositeDP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeadDepartment implements Department{

    //bütün departmanları bir field ile tutalım
    public List<Department> subDepartments=new ArrayList<>();

    //alt departmanları bu listeye ekleyelim

    public void addDepartment(Department department){
        this.subDepartments.add(department);
    }

    @Override
    public String getName() {//firmadaki tüm departmanların isimlerini döndürsün
        return this.subDepartments.stream().
                                   map(d->d.getName()).//Finance Sales
                                   collect(Collectors.joining(","));// "Finance, Sales"
    }

    @Override
    public List<String> getEmployees() {//firmadaki tüm çalışanların isimlerini listelesin
        return this.subDepartments.stream().//department streami
                                  flatMap(d->d.getEmployees().stream()).// F1 F2 F3 S1 S2 S3 S4
                                  collect(Collectors.toList());

        //aynı işlemi for each ile de yapabilirdik.
    }




}
