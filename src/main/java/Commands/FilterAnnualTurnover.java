package Commands;

import CollectionControl.CollectionControl;
import WorkPackage.Organization;
/**
 * A class for displaying elements with an Annual Turnover less than the specified one.
 *
 */
public class FilterAnnualTurnover {
    /**
     * A method for displaying elements with an Annual Turnover less than the specified one.
     * @param turnover input value of Annual Turnover
     */
    public static void Filter(Float turnover)
    {
        boolean show = false;
        for(Organization organization: CollectionControl.getCollection()){
            show = true;
            if(organization.getAnnualTurnover().compareTo(turnover) < 0) System.out.println(organization);
        }
        if (!show) System.out.println("Нет элемента с меньшим Annual Turnover");


    }
}
