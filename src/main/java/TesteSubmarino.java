import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteSubmarino {
	
	private WebDriver driver;
	private SubmarinoPage page;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "\\driver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        page = new SubmarinoPage(driver);
	}

	@Test
	public void test() {
		
		// Acessar o site do Submarino.com
		page.setSite();
		page.validaSite();
		
		// Fechar o pop-up dos cookies
		page.clicaComIdAceitar();
		
		// Buscar pelo produto desejado no campo de busca
		page.insereTexto();
		
		// Clicar no botão para efetuar a busca do produto
		page.clicaComIdBuscar();
		
		// Validar que o produto buscado foi exibido
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.validaBusca();
		
		// Clicar no produto buscado
		page.selecionaProduto();
	
		// Confirmar que foi direcionado para a página do produto
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.validaProduto();
	
		// Clicar no botão para comprar
		page.clicaComprar();

		// Clicar no botão para incluir no carrinho de compras
		page.clicaIncluir();

		// Confirmar que foi direcionado para a página do carrinho de compras 
		// e que há o produto escolhido no carrinho
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.validaCarrinho();
		page.validaProdutoCarrinho();
		
		driver.quit();
	}
}

	
