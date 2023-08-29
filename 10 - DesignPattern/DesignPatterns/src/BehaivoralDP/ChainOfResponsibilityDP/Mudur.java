package BehaivoralDP.ChainOfResponsibilityDP;

public class Mudur extends Approver{

    public Mudur(Approver chief) {
        super(chief);
    }

    @Override
    boolean approveLoan(int amount) {//10000
        if (amount<=10000){
            System.out.println("Müdür talebi onayladı...");
            System.out.println("***********************");
        } else if (chief!=null) {

            System.out.println("Miktar müdürün onay limitini aşıyor, talep genel müdüre yönlendirliyor.");

        }
        return false;
    }
}
