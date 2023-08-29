package StructuralDP.CompositeDP;

import java.util.Arrays;
import java.util.List;

public class Finance implements Department{


    @Override
    public String getName() {
        return "Finance";
    }

    @Override
    public List<String> getEmployees() {
        return Arrays.asList("F1","F2","F3");
    }
}
