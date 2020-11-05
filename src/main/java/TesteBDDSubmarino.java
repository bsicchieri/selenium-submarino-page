import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteBDDSubmarino {

	@Test
	public void test() {
		System.setProperty("webdriver.gecko.driver", "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Acessar o site do Submarino.com
		driver.get("https://www.submarino.com.br/");
		Assert.assertEquals("Submarino - Sua história começa aqui", driver.getTitle());
		
		// Buscar pelo produto desejado no campo de busca
		driver.findElement(By.id("h_search-input")).sendKeys("Samsung Smart TV 55 Crystal UHD 55TU8000");
		
		// Clicar no botão para efetuar a busca do produto
		driver.findElement(By.id("h_search-btn")).click();
		
		// Validar que o produto buscado foi exibido
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='row product-grid no-gutters main-grid']"))
				.getText().contains("Samsung Smart TV 55\" Crystal UHD 55TU8000 4K, Wi-fi, Borda Infinita, Alexa built in, Controle Único, Visual Livre de Cabos, Modo Ambiente Foto e Processador Crystal 4K")); 

		// Clicar no produto buscado
		driver.findElement(By.xpath("//*[@class='TitleUI-sc-1f5n3tj-13 dTabgr TitleH2-sc-1wh9e1x-1 fINzxm']")).click();
	
		// Confirmar que foi direcionado para a página do produto
		Assert.assertEquals("Samsung Smart TV 55\" Crystal UHD 55TU8000 4K, Wi-fi, Borda Infinita, Alexa built in, Controle Único, Visual Livre de Cabos, Modo Ambiente Foto e Processador Crystal 4K no Submarino.com", driver.getTitle());
	
		// Clicar no botão para comprar
		driver.findElement(By.xpath("//*[@class='TextUI-sc-1i9za0i-4 bmDUpk TextUI-sc-12tokcy-0 kYUvL']")).click();
		
		// Clicar no botão para incluir no carrinho de compras
		driver.findElement(By.xpath("//*[@id='btn-continue']")).click();
		
		// Confirmar que foi direcionado para a página do carrinho de compras 
		// e que há o produto escolhido no carrinho
		Assert.assertTrue(driver.findElement(By.tagName("body"))
				.getText().contains("Meu carrinho")); 
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='productsandfreight__wrapper']"))
				.getText().contains("Samsung Smart TV 55\" Crystal UHD 55TU8000 4K, Wi-fi, Borda Infinita, Alexa built in, Controle Único, Visual Livre de Cabos, Modo Ambiente Foto e Processador Crystal 4K")); 
		
		driver.close();
	}
}

	
