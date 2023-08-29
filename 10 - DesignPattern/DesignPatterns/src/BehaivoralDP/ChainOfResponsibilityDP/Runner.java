package BehaivoralDP.ChainOfResponsibilityDP;

public class Runner {
    public static void main(String[] args) {

        Approver genelMudur=new GenelMudur();
        Approver mudur=new Mudur(genelMudur);
        Approver memur=new Memur(mudur);

        System.out.println("Kredi onaylama limitleri: ");
        System.out.println("Memur max. : 5000");
        System.out.println("Müdür max. : 10000");
        System.out.println("Genel müdür : limit yok");

        System.out.println("---------------------------------");
        System.out.println("Müşterinin memurdan talep ettiği miktar : 1000");
        memur.approveLoan(1000);


        System.out.println("---------------------------------");
        System.out.println("Müşterinin memurdan talep ettiği miktar : 7000");
        memur.approveLoan(7000);


        System.out.println("---------------------------------");
        System.out.println("Müşterinin memurdan talep ettiği miktar : 17000");
        memur.approveLoan(17000);

        //DP kullanmamış olsaydık tek tek objelerimize talepte bulunmak zorunda kalacaktık..
//        memur.approveLoan(17000);//memurun limitini aşar
//        mudur.approveLoan(17000);//müdürün limitini aşar
//        genelMudur.approveLoan(17000);//onayladı




    }
}
