package StructuralDP.FacadeDP;

public class EncryptorFacade {

    private AES_Enc aesEnc=new AES_Enc();

    private SHA_Enc shaEnc=new SHA_Enc();

    private MD5_Enc md5Enc=new MD5_Enc();



    public void encrypt(String text,EncryptorType type){

        switch (type){
            case AES:
                aesEnc.encrypt(text);
                break;
            case SHA:
                shaEnc.encrypt(text,"techpro");
                break;
            case MD5:
                md5Enc.encrypt(text,"techpro",true);
                break;

        }

    }


}
