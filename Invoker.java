import java.util.ArrayList;
import java.util.Scanner;

public class Invoker {

    Scanner scanner=new Scanner(System.in);
    Command[] NCommandlist= new Command[6];
    Command[] SCommandlist= new Command[6];
    public void setCommand(int side, int i, Command command){
        if (side==0){
        this.NCommandlist[i]=command;
    }else if (side==1){
        this.SCommandlist[i]=command;
    }}
    public Command[] chooseStore(int i){
        if (i ==1){
            return this.SCommandlist;
        }else if(i==0) {
            return this.NCommandlist;

        }else{
            return null;
        }



    }
    public void setCommandlist(int code,ArrayList<Command> commandlist){
        for(int num=1;num<6;num++){
            this.setCommand(code,num,commandlist.get(num-1));
        }

    }
    public void request(int i,Command[] commandlist){
        commandlist[i].execute();
    }
    public void interaction(){
        System.out.println("what can I do for you");
        System.out.println("'0' for North store and '1' for South store");
        if (scanner.hasNext()){
            int input=scanner.nextInt();
            if(input==1 |input==0 ){
//                while(chooseStore(scanner.next())==null){
//                    System.out.println("please re-choose the store");
//                }
                Command[] currentcommandlist=chooseStore(input);
                System.out.println("what do you want to do?");
                System.out.println(" 1: ask the name of the staff \n 2: ask the current time \n 3: buy an item \n " +
                        "4:sell an item \n 5:buy an guitar kit \n 9: end our conversation \n 0: restart ");
                int option =scanner.nextInt();

                while (option !=9){
                while(option ==0){
                    System.out.println("'0' for North store and '1' for South store");
                    currentcommandlist=chooseStore(scanner.nextInt());
                    System.out.println(" 1: ask the name of the staff \n 2: ask the current time \n 3: buy an item \n " +
                            "4:sell an item \n 5:buy an guitar kit \n 9: end our conversation \n 0: restart ");
                    option=scanner.nextInt();

                }


//                    while(option!= 9){
                    if(option==9){
                        break;
                    }
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




