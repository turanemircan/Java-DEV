import java.util.ArrayList;
import java.util.List;

public class Practice02 {
    public List<String> devList=new ArrayList<>();

    public void remove(String name){
        devList.remove(name);
    }

    public void add(String name){
        devList.add(name);
    }

    public void removeAll(){
        devList.clear();
    }

    public int sizeOfDevs(){
        return devList.size();
    }

}
