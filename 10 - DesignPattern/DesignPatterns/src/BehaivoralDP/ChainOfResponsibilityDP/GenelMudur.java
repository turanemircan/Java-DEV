package BehaivoralDP.ChainOfResponsibilityDP;

public class GenelMudur extends Approver{

    public GenelMudur() {
        super(null);
    }

    @Override
    boolean approveLoan(int amount) {//limit sınırsız

        System.out.println("Genel Müdür talebi onayladı...");
        System.out.println("******************************");

        return false;
    }
}
