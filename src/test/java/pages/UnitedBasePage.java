package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedBasePage {
    public UnitedBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[role='tablist'] > a")
    public List<WebElement> mainMenuNavigationItems;

    @FindBy(css = ".app-components-BookTravel-bookTravel__travelNav--3RNBj > li")
    public List<WebElement> bookTravelMenuNavigationItems;

    @FindBy(css = "#roundtrip")
    public WebElement roundTripButton;

    @FindBy(css = "#oneway")
    public WebElement oneWayButton;

    @FindBy(css = ".app-components-BookFlightForm-bookFlightForm__radioBtnContainer--VrnUD:nth-of-type(1)")
    public WebElement roundTripButtonLabel;

    @FindBy(id = "award")
    public WebElement getBookWithMilesLabel;

    @FindBy(id = "flexibleDates")
    public WebElement getFlexibleDatesLabel;

    @FindBy(css = "[for='award']")
    public WebElement bookWithMilesCheckbox;

    @FindBy(css = "#flexDatesLabel")
    public WebElement flexibleDatesCheckbox;

    @FindBy(css = "#bookFlightOriginInput")
    public WebElement fromInput;

    @FindBy(css = "#bookFlightDestinationInput")
    public WebElement destinationInput;

    @FindBy(css = "#DepartDate")
    public WebElement date;

    @FindBy(css = ".app-components-BookFlightForm-bookFlightForm__animatedButton--1UzDj.app-components-PassengerSelector-passengers__passengerButton--w8CX7")
    public WebElement travelersButton;

    @FindBy(css = ".app-components-PassengerSelector-passengers__passengerRow__controls--2Occ- > .app-components-PassengerSelector-passengers__passengerRow__input--13_Gq")
    public WebElement adults;

    @FindBy(css = "#cabinType")
    public WebElement cabinTypeDropdown;

    @FindBy(css = ".app-components-BookFlightForm-bookFlightForm__optionFieldsContainer--2LeaB ul[role='listbox'] > li:nth-of-type(3)")
    public WebElement businessOrFirstClassOption;

    @FindBy(css = "[aria-label='Find flights']")
    public WebElement findFlightsButton;

    @FindBy(xpath = "(//div[@class=\"app-components-Shopping-ColumnSortResultHeader-styles__detailHeading--2d8nC\"])[2]")
    public WebElement departDate;

}
