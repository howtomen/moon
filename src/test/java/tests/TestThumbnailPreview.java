package tests;
import org.testng.annotations.Test;

import objects.ThumbnailPreviewObject;
import support.PageException;

public class TestThumbnailPreview extends TestSuperClass {

	@Test
	public void canPreviewItem() throws InterruptedException, PageException {
		new ThumbnailPreviewObject(driver)
		.goToPage()
		.openPreview("Printed Chiffon Dress")
		.waitForPopup()
		.hoverOverThumbnails()
		.closePreview()
		.openPreview("Blouse")
		.waitForPopup()
		.hoverOverThumbnails();
	}

}
