package tests.dropdown;

import tests.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption (){
        var dropdownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1, "incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "option not selected");
    }
    @Test
    public void testMultipleSelectOption (){
        var dropdownPage = homePage.clickDropdown();
        dropdownPage.addMultipleAttribute();
        String option1 = "Option 1";
        String option2 = "Option 2";
        dropdownPage.selectFromDropdown(option1);
        dropdownPage.selectFromDropdown(option2);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),2, "incorrect number of selections");
        assertTrue(selectedOptions.contains(option1), "option 1 not selected");
        assertTrue(selectedOptions.contains(option2), "option 2 not selected");
    }
}
