import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Invoker {
    // get the input from the command line via scanner, and hold two command list for each side of stores
    Scanner scanner=new Scanner(System.in);
    Command[] NCommandlist= new Command[6];
    Command[] SCommandlist= new Command[6];
    // based on the side number to set the command at the index i in the array.
    public void setCommand(int side, int i, Command command){
        if (side==0){
        this.NCommandlist[i]=command;
    }else if (side==1){
        this.SCommandlist[i]=command;
    }}
    // get the current store to manipulate
    public Command[] chooseStore(int i){
        if (i ==1){
            return this.SCommandlist;
        }else if(i==0) {
            return this.NCommandlist;

        }else{
            return null;
        }



    }
    // set the command on a batch
    public void setCommandlist(int code,ArrayList<Command> commandlist){
        for(int num=1;num<6;num++){
            this.setCommand(code,num,commandlist.get(num-1));
        }

    }
    // call the execute() method of the command based on the option
    // which is equal to the index of the command in the array
    public void request(int i,Command[] commandlist) throws IOException {
        commandlist[i].execute();
    }

    public void interaction() throws IOException {
        System.out.println("what can I do for you");
        System.out.println("'0' for North store and '1' for South store");
        if (scanner.hasNext()){
            int input=scanner.nextInt();
            // first time to get the input, get the store to manipulate
            if(input==1 |input==0 ){
//                while(chooseStore(scanner.next())==null){
//                    System.out.println("please re-choose the store");
//                }

                Command[] currentcommandlist=chooseStore(input);
                System.out.println("what do you want to do?");
                System.out.println(" 1: ask the name of the staff \n 2: ask the current time \n 3: buy an item \n " +
                        "4:sell an item \n 5:buy an guitar kit \n 9: end our conversation \n 0: restart ");
                int option =scanner.nextInt();
                // unless the input is 9, which refers to end the interaction, the interaction will repeat
                while (option !=9){
                    // when the input is 0, which means re-choose the store.
                while(option ==0){
                    System.out.println("'0' for North store and '1' for South store");
                    currentcommandlist=chooseStore(scanner.nextInt());
                    System.out.println(" 1: ask the name of the staff \n 2: ask the current time \n 3: buy an item \n " +
                            "4:sell an item \n 5:buy an guitar kit \n 9: end our conversation \n 0: restart ");
                    option=scanner.nextInt();

                }


//                    while(option!= 9){
                    // quit
                    if(option==9){
                        break;
                    }
                    // otherwise, operate the command based on the option.
                    this.request(option, currentcommandlist);
                    System.out.println(" 1: ask the name of the staff \n 2: ask the current time \n 3: buy an item \n " +
                            "4:sell an item \n 5:buy an guitar kit \n 9: end our conversation \n 0: restart ");
                    option=scanner.nextInt();

                }
                  System.out.println("Thanks for you coming, see you next time");



                }

            }

        }





    }




