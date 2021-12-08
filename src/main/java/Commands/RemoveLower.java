package Commands;

import CollectionControl.CollectionControl;
import WorkPackage.Organization;
import WorkPackage.OrganizationGenerator;
import java.util.LinkedList;
/**
 * A class for deleting all items less than the specified one from the collection.
 *
 */
public class RemoveLower {
    /**
     * A method for removing from the collection all items less than the specified one.
     *
     */
    public static void RemoveLower()
    {
        int startSize = CollectionControl.getCollectionSize();
        Organization inputorganization = OrganizationGenerator.generate();
        CollectionControl.getCollection().removeIf(n -> (n.compareTo(inputorganization) < 0));
        if (CollectionControl.getCollection().size() == startSize) System.out.println("Не найдено элементов меньше заданного");
        else System.out.println("Элементы успешно удалены");
    }
}
