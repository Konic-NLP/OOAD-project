import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(int caseNumber,int storecode,String name, int number) throws IOException;

}
