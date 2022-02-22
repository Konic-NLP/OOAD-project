import java.util.Random;


abstract class tuneAlgorithms {
    boolean T2F;
    public abstract void operation(Items items);

}


class haphazard extends tuneAlgorithms {

    boolean T2F;
    @Override
    public void operation(Items items) {
        Random random = new Random();
        int chance=random.nextInt(101);

        if (chance<50){
            if (items.getProperty() !=null){
                if(items.getProperty().getValue()==false){
                    items.getProperty().setValue(true);
                    T2F=false;
                }else{
                    items.getProperty().setValue(false);

                    T2F=true;

                }

            }

        }
    }

}
class Mannual extends tuneAlgorithms{

    public void operation(Items items) {

        Random random =new Random();
        int chance=random.nextInt(101);

        if (items.getProperty() !=null){
            if (chance<80 ){
                if(items.getProperty().getValue()==false){
                    items.getProperty().setValue(true);
                    T2F=false;

                }

            }else{
                if (items.getProperty().getValue()==true){
                    items.getProperty().setValue(false);
                    T2F=true;
                }
            }
        }


    }}
class Electronic extends tuneAlgorithms{
    public void operation(Items items) {
        if  (items.getProperty() !=null){
            if (items.getProperty().getValue() ==false){
                items.getProperty().setValue(true);
                T2F=false;
            }


        }}}

