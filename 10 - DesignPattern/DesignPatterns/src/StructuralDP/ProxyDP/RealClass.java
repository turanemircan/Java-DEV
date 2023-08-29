package StructuralDP.ProxyDP;

public class RealClass implements ImageGenerator{

    public String fullpath;

    public String name;

    public RealClass(String fullpath) {
        this.fullpath = fullpath;
        this.name="resim";
        loadImage(); //obje oluşturulduğunda databaseden image yüklensin
    }

    @Override
    public void showImage() {
        System.out.println(this.name+ " gösteriliyor... path: "+this.fullpath);
    }

    public void loadImage(){
        System.out.println("resim yükleniyor....");
    }

    //ekstra diğer metodlar
    public void changeFormat(){
        //burada bağımlı diğer objeler kullanılıyor
    }


}
