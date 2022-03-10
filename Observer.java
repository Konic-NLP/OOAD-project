import java.io.IOException;
import java.io.OutputStreamWriter;

interface Observer{
//    OutputStreamWriter out = null;
//    public void update(int caseNumber,String name, int number) throws IOException;
    public void update(int caseNumber,int storeName, String name, int number) throws IOException;
//    public OutputStreamWriter getOut();
}


