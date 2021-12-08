package CollectionControl;

import WorkPackage.Organization;

import java.util.LinkedList;

public class CollectionControl {
    /**
     * A class for working with a collection.
     */
    public static LinkedList<Organization> organization = new LinkedList<>();

    /**
     * The method that returns the collection.
     * @return Collection.
     */
    public static LinkedList<Organization> getCollection() {

        return organization;
    }

    /**
     * A method that returns the size of the collection.
     * @return The size of the collection.
     */
    public static int getCollectionSize() {

        return  organization.size();}

    /**
     * A method that allows you to set a collection.
     */
    public static void setCollection (LinkedList<Organization> organization) {

        CollectionControl.organization = organization;
    }

}
