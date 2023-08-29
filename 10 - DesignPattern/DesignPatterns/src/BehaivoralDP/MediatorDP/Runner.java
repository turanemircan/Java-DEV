package BehaivoralDP.MediatorDP;

public class Runner {

    public static void main(String[] args) {

        //öncelikle arabulucu objemizi oluşturalım
        MessageMediator mediator=new MessageMediator();

        //katılımcıları oluşturalım
        Actor actor1=new Professor("Prof. Math",mediator);
        Actor actor2=new Professor("Prof. Chem",mediator);
        Actor actor3=new Professor("Prof. IT",mediator);

        //katılımcılar uzman oldukları konu ile kayıt olmalı
        mediator.register("Math",actor1);
        mediator.register("Chem",actor2);
        mediator.register("IT",actor3);

        //katılımcılar sorularını iletsin
        System.out.println("Prof. Math sorularını soruyor....");
        actor1.sendMessage("Chem","Kimya nedir?");
        actor1.sendMessage("IT","Yazılımcı olmak keyifli mi?");

        System.out.println();

        System.out.println("Prof. IT sorularını soruyor....");
        actor3.sendMessage("Math","Matematik gerçek hayatta ne işimize yarar??");



    }
}
