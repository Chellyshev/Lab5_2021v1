package Commands;

import CollectionControl.CollectionControl;
/**
 * A class for displaying all the elements of the collection.
 *
 */
public class Show {
    /**
     * Method for displaying all the elements of the collection.
     *
     */
    public static void showCollection(){

        if (CollectionControl.getCollectionSize() == 0)
            System.out.println("No elements");
        else System.out.println(CollectionControl.getCollection());


    }
}
