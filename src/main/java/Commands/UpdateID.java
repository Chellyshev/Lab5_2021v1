package Commands;

import CollectionControl.CollectionControl;
import WorkPackage.Organization;
import WorkPackage.OrganizationGenerator;
/**
 * A class for updating an element by its id.
 *
 */
public class UpdateID {
    /**
     * Method for updating an element by its id.
     * @param id id of the item to update.
     */
    public static void update(int id)
    {
        boolean replace = false;
        for (Organization organization:CollectionControl.getCollection())
        {
            if(organization.getId() == id)
            {
                replace = true;
                CollectionControl.getCollection().remove(organization);
                organization = OrganizationGenerator.generate();
                organization.setId(id);
                CollectionControl.getCollection().add(organization);
                System.out.println("Ёлемент успешно заменен");

            }
        }
        if (replace == false) System.out.println("Ёлемента с данным id не существует");
    }
}