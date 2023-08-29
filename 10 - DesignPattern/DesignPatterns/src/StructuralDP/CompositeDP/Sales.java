package StructuralDP.CompositeDP;

import java.util.Arrays;
import java.util.List;

public class Sales implements Department{

    @Override
    public String getName() {
        return "Sales";
    }

    @Override
    public List<String> getEmployees() {
        return Arrays.asList("S1","S2","S3","S4");
    }
}
