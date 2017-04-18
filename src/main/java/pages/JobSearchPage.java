package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class JobSearchPage extends PageBase {
    // search feature
	
	@FindBy(name = "JobCategory")
	public WebElement jobCategoryDropdownList;

	@FindBy(name = "submit")
	public WebElement searchButton;
	
	
	
	// New jobs feature
	
	@FindBy(xpath=".//*[@id='job_field_display_style1']/a")
	public List<WebElement> jobTitleLinkList;

	public String processDropdownList(WebElement element) {
		String category = randomlySelectFromDropdownList(element);
		//System.out.println(category);
		searchButton.click();
		return category;
	}

}
