import org.openqa.selenium.WebDriver;

public class SubmarinoPage {

	private DSL dsl;
	
	public SubmarinoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setSite() {
		dsl.acessarURL("https://www.submarino.com.br/");
	}
	
	public void validaSite() {
		dsl.validarPagina("Submarino - Sua história começa aqui");
	}
	
	public void clicaComIdAceitar() {
		dsl.clicarId("lgpd-accept");
	}
	
	public void insereTexto() {
		dsl.escrever("h_search-input", "Samsung Smart TV 55 Crystal UHD 55TU8000");
	}
	
	public void clicaComIdBuscar() {
		dsl.clicarId("h_search-btn");
	}
	
	public void validaBusca() {
		dsl.validarTrueXpath("//*[@class='row product-grid no-gutters main-grid']", 
				"Samsung Smart TV 55\" Crystal UHD 55TU8000 4K, Wi-fi, Borda Infinita, Alexa built in, Controle Único, Visual Livre de Cabos, Modo Ambiente Foto e Processador Crystal 4K");
	}
	
	public void selecionaProduto() {
		dsl.clicarXpath("//*[@class='TitleUI-sc-1f5n3tj-13 dTabgr TitleH2-sc-1wh9e1x-1 fINzxm']");
	}
	
	public void validaProduto() {
		dsl.validarEquals("Samsung Smart TV 55\" Crystal UHD 55TU8000 4K, Wi-fi, Borda Infinita, Alexa built in, Controle Único, Visual Livre de Cabos, Modo Ambiente Foto e Processador Crystal 4K no Submarino.com");
	}
	
	public void clicaComprar() {
		dsl.clicarXpath("//*[@id='btn-buy']");
	}
	
	public void clicaIncluir() {
		dsl.clicarXpath("//*[@id='btn-continue']");
	}
	
	public void validaCarrinho() {
		dsl.validarTrueTag("body", "Meu carrinho");
	}
	
	public void validaProdutoCarrinho() {
		dsl.validarTrueXpath("//*[@class='link-default clearfix']", 
				"Samsung Smart TV 55\" Crystal UHD 55TU8000 4K, Wi-fi, Borda Infinita, Alexa built in, Controle Único, Visual Livre de Cabos, Modo Ambiente Foto e Processador Crystal 4K");
	}
}
