import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

//import java.util.logging.Logger;
public class Logger implements Observer {
    private Subject subject;
    OutputStreamWriter out;

    public Logger(Subject subject,String days) throws FileNotFoundException {
        this.subject=subject;
        this.subject.registerObserver(this);
        Path path= Paths.get("D:\\CLASIC课程\\2022 spring\\CSCI5448OOAD\\",days+".txt");
        File f= new File(String.valueOf(path));
        FileOutputStream fileou= new FileOutputStream(f);
        this.out=new OutputStreamWriter(fileou);

    }
    public  OutputStreamWriter getOut(){
        return this.out;
    }
    @Override
    public void update(int caseNumber,String name, int number) throws IOException {
        switch (caseNumber) {
            case 0: writeToFile(String.format("Publisher:%s has arrived at the store.%n",name));break;
            case 1: writeToFile(String.format("Publisher:%d items has added to inventory.%n",number));break;
            case 2: writeToFile(String.format("Publisher:$%d is in the register.%n", number));break;
            case 3: writeToFile(String.format("Publisher:$%d is in the register after withdraw.%n", number));break;
            case 4: writeToFile(String.format("Publisher:%d items are in the inventory in total.%n", number));break;
            case 5: writeToFile(String.format("Publisher:The total value in the inventory is $%d.%n", number));break;
            case 6: writeToFile(String.format("Publisher:%d items has been damaged in the process of tuning.%n", number));break;
            case 7: writeToFile(String.format("Publisher:%d items has been ordered.%n", number));break;
            case 8: writeToFile(String.format("Publisher:%d items has been sold.%n", number));break;
            case 9: writeToFile(String.format("Publisher:%d items has been purchased.%n", number));break;
            case 10:writeToFile(String.format("Publisher:%d items has been damaged in the process of cleaning.%n", number));break;
            case 11: writeToFile(String.format("Publisher:%s has left the store.%n",name));break;


        }


    }
    public void writeToFile(String string) throws IOException {

        this.out.write(string);
    }
    public void CCGlogger() throws IOException {
     this.subject.removeObserver(this);
     this.out.close();
    }

}
