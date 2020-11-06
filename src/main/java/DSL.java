import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
	
	WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void acessarURL(String url){
		driver.get(url);
	}
	
	public void validarPagina(String texto) {
		Assert.assertEquals(texto, driver.getTitle());
	}

	public void escrever(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public void clicarId(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void validarTrueXpath(String xpath, String texto) {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).getText().contains(texto)); 
	}
	
	public void clicarXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void validarEquals(String texto) {
		Assert.assertEquals(texto, driver.getTitle());
	}
	
	public void validarTrueTag(String tag, String texto) {
		Assert.assertTrue(driver.findElement(By.tagName(tag)).getText().contains(texto)); 
	}	
}
