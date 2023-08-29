package StructuralDP.FacadeDP;

public class MD5_Enc {

    public void encrypt(String text, String key, boolean isComplex){

        if (isComplex){
            System.out.println("****<MD5>"+text+key+"<MD5/>****");
        }else {
            System.out.println("<MD5>"+text+key+"<MD5/>");
        }
    }


}
