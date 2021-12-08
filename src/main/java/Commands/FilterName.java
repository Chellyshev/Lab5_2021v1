package Commands;

import CollectionControl.CollectionControl;
import WorkPackage.Organization;
/**
 * A class for displaying elements starting with a given substring.
 *
 */
public class FilterName {
    /**
     * A method for displaying elements starting with a given substring.
     * @param name input substring.
     */
    public static void FilterName(String name)
    {
        boolean show = false;
        for(Organization organization: CollectionControl.getCollection()){
            if(organization.getName().startsWith(name)) {
                System.out.println(organization);
                show = true;
            }
            if (!show) System.out.println("Нет элементов начинающихся на "+name);
        }


    }
}
