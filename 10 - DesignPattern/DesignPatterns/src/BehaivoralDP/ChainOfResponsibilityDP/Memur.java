package BehaivoralDP.ChainOfResponsibilityDP;

public class Memur extends Approver{


    public Memur(Approver chief) {
        super(chief);
    }

    @Override
    boolean approveLoan(int amount) {//5000

        if (amount<=5000){
            System.out.println("Memur talebi onayladı.");
            System.out.println("*************************");
            return true;
        } else if (chief!=null) {
            System.out.println("Miktar memurun limitini aşıyor, talep müdüre yönlendiriliyor.");
            return chief.approveLoan(amount);
        }
        return false;
    }
}
