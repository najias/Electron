package base;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase extends Driver {
	// (Driver-parents===PageBase- child / polimorphysom)

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static String randomlySelectFromDropdownList(WebElement dropdownList) {
		Select select = new Select(dropdownList);
		List<WebElement> optionsList = select.getOptions();

		int minIndex = 1;
		int maxIndex = optionsList.size() - 1;
		Random random = new Random();
		int randomIndex = random.nextInt(maxIndex - minIndex + 1) + minIndex;

		select.selectByIndex(randomIndex);
		
		
		return select.getFirstSelectedOption().getText();

	}

	public int getNumFromString(String text) {
		int num = 0;
		String[] wordArray = text.split(" ");
		for (int i = 0; i < wordArray.length; i++) {
			if (wordArray[i].matches("[0-9]+")) {
				num = Integer.valueOf(wordArray[i]);
			}

		}
		return num;
	}

	public static int getRandomNumber(int min, int max) {
		int randomIndex = 0;
		Random random = new Random();
		randomIndex = random.nextInt(max - min + 1) + min;

		return randomIndex;
	}

}
