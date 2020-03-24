package objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryAndDetailPage extends PageObjectSuperClass {
	
	@FindBy(css=".first_item  .footable-toggle")
	private WebElement expandFirstOrderDetail;
	
	@FindBy(css="#order-list > tbody > tr.footable-row-detail > td > div > div:nth-child(2) > div.footable-row-detail-value > a")
	private WebElement DownloadPDFButton;
	
	private String dir;
	private File file;
	private String fileName;

	public OrderHistoryAndDetailPage(WebDriver driverInstance) {
		super(driverInstance);
	}

	public OrderHistoryAndDetailPage clickDownloadPDF() {
		driver.manage().window().setSize(new Dimension(1024,768));
		expandFirstOrderDetail.click();
		DownloadPDFButton.click();
		return this;
	}

	public OrderHistoryAndDetailPage waitTillDownloaded(String downloadLocation) throws Exception {
		dir = downloadLocation;
		
		do {
			Thread.sleep(1000);
			file = getLatestFilefromDir(dir);
			fileName = file.getName();
		} while(!fileName.endsWith(".pdf"));

		return this;
	}
	
	public String getnameofPDFDownloaded() {
		deleteDownloadedFile();
		return fileName;
	}
	
	private File getLatestFilefromDir(String dirPath){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	private void deleteDownloadedFile() {
		String filesToDelete = dir + "\\" + fileName;

		try { 
            Files.deleteIfExists(Paths.get(filesToDelete)); 
        } catch(NoSuchFileException e) { 
            System.out.println("No such file/directory exists");
        } catch(DirectoryNotEmptyException e) { 
            System.out.println("Directory is not empty.");
        } catch(IOException e) { 
            System.out.println("Invalid permissions.");
        }
		
	}
}
