import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Publisher implements Subject {
    private List<Observer> observers;

    //constructor
    public Publisher() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(int caseNumber,int storenum, String name, int number) throws IOException {
        for (Observer observer:observers){observer.update(caseNumber,storenum,name,number);
        }

    }

}
