package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestJobSearchFeature extends TestBase {

	@BeforeClass
	public void classSetUp() {

		menuBar.jobSearchPageLink.click();

	}

	@Test
	public void testJobSearchWithoutSelectingJobCategory() {
		jobSearchPage.searchButton.click();

		String resultSummary = jobSearchResultPage.searchResultSummary.getText();

		Assert.assertTrue(jobSearchResultPage.getCurrentUrl().contains("?JobCategory=-Please+Select-&submit=Search"));
		
		Assert.assertEquals(resultSummary, "Please Select Job Category");

	}

	@Test
	public void testJobSearchWithRandomlySelectedJobCategory() {
		String SelectedJobCategory = jobSearchPage.processDropdownList(jobSearchPage.jobCategoryDropdownList);

		String resultSummary = jobSearchResultPage.searchResultSummary.getText();

		int totalJobs = jobSearchPage.getNumFromString(resultSummary);

		if (totalJobs == 0) {
			Assert.assertTrue(jobSearchResultPage.getCurrentUrl().contains("/jobsearch"));
		} else if (totalJobs > 0) {

			int maxIndex = jobSearchPage.jobTitleLinkList.size() - 1;
			int rendomIndex = jobSearchPage.getRandomNumber(0, maxIndex);

			jobSearchPage.jobTitleLinkList.get(rendomIndex).click();
			String jobOverview = jobDetailPage.jobOverview.getText();
			Assert.assertTrue(jobOverview.contains("SelectedJobCategory"));
		}

	}

	@AfterMethod
	public void classTearDown() {
		menuBar.jobSearchPageLink.click();
	}
}
