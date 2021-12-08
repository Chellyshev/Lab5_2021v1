package Commands;

import CollectionControl.CollectionControl;
import WorkPackage.Organization;
import WorkPackage.OrganizationGenerator;

import java.util.LinkedList;
import java.util.Objects;

/**
 * A class for removing from the collection all elements whose annual Turnover field value is equivalent to the specified one.
 *
 */
public class RemoveAllByAnnualTurnover {
    /**
     * A method for removing from the collection all items whose annual Turnover field value is equivalent to the specified one.
     * @param turnover the entered value of the Annual Turnover field.
     */
    public static void Remove(Float turnover)
    {
        int startSize = CollectionControl.getCollectionSize();
        for(Organization organization: CollectionControl.getCollection()){
            if(Objects.equals(organization.getAnnualTurnover(), turnover)) CollectionControl.getCollection().remove(organization);
        }
        if (CollectionControl.getCollection().size() == startSize) System.out.println("Не найдено элементов с заданным Annual Turnover");
        else System.out.println("Элементы успешно удалены");

    }
}
