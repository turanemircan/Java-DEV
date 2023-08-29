package StructuralDP.CompositeDP;

import java.util.Arrays;
import java.util.List;

public class Arge implements Department{

    @Override
    public String getName() {
        return "Arge";
    }

    @Override
    public List<String> getEmployees() {
        return Arrays.asList("A1","A2");
    }
}
