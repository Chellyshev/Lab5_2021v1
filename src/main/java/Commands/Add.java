package Commands;

import CollectionControl.CollectionControl;
import WorkPackage.OrganizationGenerator;
/**
 * A class for adding items to a collection.
 *
 */
public class Add {
    /**
     * A method for adding items to a collection.
     *
     */
    public static void AddElement()
    {
        int size = CollectionControl.getCollectionSize();
        CollectionControl.getCollection().add(OrganizationGenerator.generate());
        if (CollectionControl.getCollectionSize() == size) System.out.println("Ошибка добавления элемента");
        else System.out.println("Элемент успешно добавлен");
    }
}
