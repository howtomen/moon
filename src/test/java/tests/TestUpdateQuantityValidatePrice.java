package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.CartContentPageTUQVP;
import objects.PageObjectSuperClass;
import objects.TileObjectSuperClass;

public class TestUpdateQuantityValidatePrice extends TestSuperClass {
	@Test
	public void canIBuyLots() {
		String Tile1 = "//*[@id=\"homefeatured\"]/li[1]";

		//arrange
		String expectedTotalPrice = new String("$181.61");

		//act
		new PageObjectSuperClass(driver).navigate();

		new TileObjectSuperClass(driver).addToCart(Tile1).checkout();

		for (int i = 0; i < 10; i++) {
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/div/a[2]/span")).click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		String actualTotalPrice = new CartContentPageTUQVP(driver).totalPrice();

		//assert
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total prices do not match!");
	}
}
