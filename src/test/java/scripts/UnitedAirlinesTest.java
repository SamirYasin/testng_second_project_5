package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;

import java.util.stream.IntStream;

public class UnitedAirlinesTest extends UnitedAirlinesBase {
@BeforeMethod
    public void setPage(){
    unitedBasePage = new UnitedBasePage();
}

@Test(priority = 1, description = "Test Case 1: Validate \"Main menu\" navigation items")
    public void validateMainMenuNavigationItems(){
    String[] items = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP" };
    IntStream.range(0, unitedBasePage.mainMenuNavigationItems.size()).forEach(i ->
            Assert.assertEquals(unitedBasePage.mainMenuNavigationItems.get(i).getText(), items[i]));

}
@Test(priority = 2, description = "Test Case 2: Validate \"Book travel menu\" navigation items")
    public void validateBookTravelMenuNavigationItems(){
    String[] items = {"Book", "Flight status", "Check-in", "My trips"};
    IntStream.range(0, unitedBasePage.bookTravelMenuNavigationItems.size()).forEach(i ->
            Assert.assertEquals(unitedBasePage.bookTravelMenuNavigationItems.get(i).getText(), items[i]));
}
@Test(priority = 3, description = "Test Case 3: Validate \"Round-trip\" and \"One-way\" radio buttons")
    public void validateRadioButtons(){
    Assert.assertTrue(unitedBasePage.roundTripButtonLabel.isDisplayed());
    Assert.assertTrue(unitedBasePage.roundTripButton.isEnabled());
    Assert.assertTrue(unitedBasePage.roundTripButton.isSelected());
    unitedBasePage.oneWayButton.click();
    Assert.assertTrue(unitedBasePage.oneWayButton.isSelected());
    Assert.assertFalse(unitedBasePage.roundTripButton.isSelected());
}@Test(priority = 4, description = "Test Case 4: Validate \"Book with miles\" and \"Flexible dates\" checkboxes")
    public void validateCheckboxes(){
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckbox.isDisplayed());
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckbox.isEnabled());
        Assert.assertFalse(unitedBasePage.getBookWithMilesLabel.isSelected());
        Assert.assertTrue(unitedBasePage.flexibleDatesCheckbox.isDisplayed());
        Assert.assertTrue(unitedBasePage.flexibleDatesCheckbox.isEnabled());
        Assert.assertFalse(unitedBasePage.getFlexibleDatesLabel.isSelected());
        unitedBasePage.flexibleDatesCheckbox.click();
        unitedBasePage.bookWithMilesCheckbox.click();
        Assert.assertTrue(unitedBasePage.getFlexibleDatesLabel.isSelected());
        Assert.assertTrue(unitedBasePage.getBookWithMilesLabel.isSelected());
        unitedBasePage.bookWithMilesCheckbox.click();
        unitedBasePage.flexibleDatesCheckbox.click();
        Assert.assertFalse(unitedBasePage.getFlexibleDatesLabel.isSelected());
        Assert.assertFalse(unitedBasePage.getBookWithMilesLabel.isSelected());
    }
    @Test(priority = 5,description = "Test Case 5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”")
        public void validateOneWayTicketSearch(){
        unitedBasePage.fromInput.click();
        unitedBasePage.fromInput.clear();
        unitedBasePage.fromInput.sendKeys("Chicago, IL, US (ORD)");
        unitedBasePage.oneWayButton.click();
        unitedBasePage.destinationInput.click();
        unitedBasePage.destinationInput.clear();
        unitedBasePage.destinationInput.sendKeys("Miami, FL, US (MIA)");
        unitedBasePage.travelersButton.click();
        unitedBasePage.adults.sendKeys("2");
        unitedBasePage.date.click();
        unitedBasePage.date.clear();
        unitedBasePage.date.sendKeys("Feb 28");
        unitedBasePage.cabinTypeDropdown.click();
        unitedBasePage.businessOrFirstClassOption.click();
        unitedBasePage.findFlightsButton.click();
        Assert.assertEquals(unitedBasePage.departDate.getText(), "DEPART ON: February 28");

    }
}
