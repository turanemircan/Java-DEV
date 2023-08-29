package BehaivoralDP.ChainOfResponsibilityDP;

public abstract class Approver {

    public Approver chief;

    public Approver(Approver chief) {
        this.chief = chief;
    }

    //onaylanabilecek kredi limitine göre
    //krediyi onaylarsa true aksi false döndüren metod

    abstract boolean approveLoan(int amount);
}
