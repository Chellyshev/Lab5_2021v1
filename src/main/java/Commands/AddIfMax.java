package Commands;
import CollectionControl.CollectionControl;
import WorkPackage.Organization;
import WorkPackage.OrganizationGenerator;
/**
 * A class for adding items to a collection if the input element is the largest.
 *
 */
public class AddIfMax {
    /**
     * A method for adding items to a collection if the input item is the largest.
     *
     */
    public static void AddGreater()
    {
        Organization startUp = new Organization();
        startUp = OrganizationGenerator.generate();
        int lower = 1;
        for(Organization organization: CollectionControl.getCollection()){
            if(organization.compareTo(startUp) < 0) lower*=1;
            else lower*=0;
        }
        if(lower == 1) CollectionControl.getCollection().add(startUp);
        else System.out.println("Мы нашли элемент больше заданного");
    }
}
