package Commands;

import CollectionControl.CollectionControl;
import WorkPackage.Organization;
/**
 * A class for removing from the collection all elements whose id field value is equivalent to the specified one.
 *
 */
public class RemoveById {
    /**
     * A method for removing from the collection all elements whose id field value is equivalent to the specified one.
     * @param id the input value of the id field.
     */
    public static void remove(int id)
    {
        boolean remove = false;
        for (Organization organization: CollectionControl.getCollection())
        {
            if(organization.getId() == id)
            {
                remove = true;
                CollectionControl.getCollection().remove(organization);
                System.out.println("Ёлемент успешно удален");

            }
        }
        if (remove == false) System.out.println("Ёлемента с данным id не существует");
    }
}
