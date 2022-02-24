import java.util.Random;


abstract class tuneAlgorithms {

    public abstract boolean operation(String name,Items items);

}


class haphazard extends tuneAlgorithms {


    @Override
    public boolean operation(String name,Items items) {
        Random random = new Random();
        int chance=random.nextInt(101);


            if (items.getProperty() !=null){
                if (chance<50){
                if(items.getProperty().getValue()==false){
                    // change the property
                    items.getProperty().setValue(true);
                    System.out.format("%s using haphard tunealgorithm change a %s from not %s to %s %n",name,items.getItemType(),items.getProperty().getName(),items.getProperty().getName());
                    return false; // to signal whether is true to false
                }else{
                    items.getProperty().setValue(false);
                    System.out.format("%s using haphard tunealgorithm change a %s from  %s to not %s %n",name,items.getItemType(),items.getProperty().getName(),items.getProperty().getName());
                    return true;

                }

            }

        }
            return false;
    }

}
class Mannual extends tuneAlgorithms{

    public boolean operation(String name, Items items) {

        Random random =new Random();
        int chance=random.nextInt(101);

        if (items.getProperty() !=null){
            if (chance<80 ){
                if(items.getProperty().getValue()==false){
                    items.getProperty().setValue(true);
                    System.out.format("%s using mannual tunealgorithm change a %s from not %s to %s %n",name,items.getItemType(),items.getProperty().getName(),items.getProperty().getName());

                    return false;

                }

            }else{
                if (items.getProperty().getValue()==true){
                    items.getProperty().setValue(false);
                    System.out.format("%s using haphard tunealgorithm change a %s from  %s to not %s %n",name,items.getItemType(),items.getProperty().getName(),items.getProperty().getName());
                    return true;
                }
            }
        }


    return false;}}
class Electronic extends tuneAlgorithms{
    public boolean operation(String name, Items items) {
        if  (items.getProperty() !=null){
            if (items.getProperty().getValue() ==false){
                items.getProperty().setValue(true);
                System.out.format("%s using Manual tunealgorithm change a %s from not %s to %s %n",name,items.getItemType(),items.getProperty().getName(),items.getProperty().getName());
                return false;
            }
            return false;


        }return  false;}}

