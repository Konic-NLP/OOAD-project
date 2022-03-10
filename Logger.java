import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

//import java.util.logging.Logger;

//Apply Singleton Patter for Logger
//Lazy Instantiation
public class Logger implements Observer {
    // two static methods that relates lazy instantiation of the singleton patter
    private static Logger uniqueInstance;
    Subject subject;
    OutputStreamWriter Nout;
    OutputStreamWriter Sout;
    int days;
    public static Logger getInstance (Subject subject,String days) throws FileNotFoundException {
        if (uniqueInstance == null){
            uniqueInstance = new Logger(subject,days);
        }
        return uniqueInstance;
    }
    public void setout(int days) throws FileNotFoundException {
        Path path= Paths.get("./output","NLogger"+days+".txt"); // get the output filestream
        File f= new File(String.valueOf(path));
        FileOutputStream fileou= new FileOutputStream(f);
        this.Nout=new OutputStreamWriter(fileou);
        Path path1= Paths.get("./output","SLogger"+days+".txt"); // get the output filestream
        File f1= new File(String.valueOf(path1));
        FileOutputStream fileout= new FileOutputStream(f1);
        this.Sout=new OutputStreamWriter(fileout);

    }


    private Logger(Subject subject,String days) throws FileNotFoundException {
        this.subject=subject;
        this.subject.registerObserver(this); // add to the observer list
        Path path= Paths.get("./output","NLogger"+days+".txt"); // get the output filestream
        File f= new File(String.valueOf(path));
        FileOutputStream fileou= new FileOutputStream(f);
        this.Nout=new OutputStreamWriter(fileou);
        Path path1= Paths.get("./output","SLogger"+days+".txt"); // get the output filestream
        File f1= new File(String.valueOf(path1));
        FileOutputStream fileout= new FileOutputStream(f1);
        this.Sout=new OutputStreamWriter(fileout);

    }
//    public  OutputStreamWriter getOut(){
//        return this.out;
//    }
//    @Override
//    public void update(int caseNumber,String name,int number) throws IOException{
//    }
    @Override
    public void update(int caseNumber,int storeNumber, String name,int number) throws IOException {
        String storeName = null;
        OutputStreamWriter writer=null;
        switch(storeNumber){
            case 0: storeName = "North Store";
             writer=this.Nout;
            break;
            case 1: storeName = "South Store";
            writer=this.Sout;
            break;
        }
        // update would be called inside the notify method of the subject, and do different action based on the code
        switch (caseNumber) {
            case 0: writeToFile(writer,String.format("%s:%s has arrived at the store.%n",storeName,name));break;
            case 1: writeToFile(writer,String.format("%s:%d items has added to inventory.%n",storeName,number));break;
            case 2: writeToFile(writer,String.format("%s:$%d is in the register.%n",storeName,number));break;
            case 3: writeToFile(writer,String.format("%s:$%d is in the register after withdraw.%n",storeName,number));break;
            case 4: writeToFile(writer,String.format("%s:%d items are in the inventory in total.%n",storeName,number));break;
            case 5: writeToFile(writer,String.format("%s::The total value in the inventory is $%d.%n",storeName,number));break;
            case 6: writeToFile(writer,String.format("%s:%d items has been damaged in the process of tuning.%n",storeName,number));break;
            case 7: writeToFile(writer,String.format("%s:%d items has been ordered.%n",storeName,number));break;
            case 8: writeToFile(writer,String.format("%s:%d items has been sold.%n",storeName,number));break;
            case 9: writeToFile(writer,String.format("%s:%d items has been purchased.%n",storeName,number));break;
            case 10:writeToFile(writer,String.format("%s:%d items has been damaged in the process of cleaning.%n",storeName,number));break;
            case 11: writeToFile(writer,String.format("%s:%s has left the store.%n",storeName,name));break;
        }


    }
    public void writeToFile(OutputStreamWriter writer,String string) throws IOException {

        writer.write(string);
    }
    public void CCGlogger() throws IOException { // at the end of day, close the file stream
     this.subject.removeObserver(this);
     this.Nout.close();
     this.Sout.close();
    }

}
