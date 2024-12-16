package runner.basicAppiumSteps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DeleteUpdateSteps {

    AppiumDriver android;


    @Given("que tenemos la app abierta")
    public void queTenemosLaAppAbierta() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","ANDROID9");
        capabilities.setCapability("appium:platformVersion","9.0");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");
        android = new AndroidDriver(new URL("http://192.168.18.13:4723/"),capabilities);

        //Espera máximo 30 segundos por cada localizador
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @And("agregamos una tarea")
    public void agregamosUnaTarea() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
    }

    @And("ingresamos titulo de tarea {string}")
    public void ingresamosTituloDeTarea(String titulo) {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
    }

    @And("ingresamos una descripcion de tarea {string}")
    public void ingresamosUnaDescripcionDeTarea(String nota) {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(nota);
    }

    @And("guardamos la tarea")
    public void guardamosLaTarea() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
    }

    @And("verificamos que la tarea se creo correctamente como {string}")
    public void verificamosQueLaTareaSeCreoCorrectamenteComo(String expectedResult) {
        String actualResult =android.findElement(By.xpath("//android.widget.TextView[@text='"+expectedResult+"']")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR ! la tarea no se creo correctamente");

    }

    @When("Ingreso a la tarea {string}")
    public void ingresoALaTarea(String tarea1) {
        android.findElement(By.xpath("//android.widget.TextView[@text='"+tarea1+"']")).click();
    }

    @And("doy click en eliminar")
    public void doyClickEnEliminar() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/deleteItem")).click();
    }

    @And("confirmo la eliminacion")
    public void confirmoLaEliminacion() {
        android.findElement(By.xpath("//android.widget.Button[@text=\"DELETE\"]")).click();
    }

    @Then("tengo que visualizar el texto {string}")
    public void tengoQueVisualizarElTexto(String noTaskAded) {
        Assertions.assertTrue(android.findElement(By.xpath("//android.widget.TextView[@text='"+noTaskAded+"']")).isDisplayed());
    }

    @And("limpio la caja de texto del titulo")
    public void limpioLaCajaDeTextoDelTitulo() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).clear();
    }

    @And("editamos el titulo {string}")
    public void editamosElTitulo(String tarea2) {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(tarea2);
    }

    @And("limpiamos la caja de texto notas")
    public void limpiamosLaCajaDeTextoNotas() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).clear();
    }

    @And("editamos la nota a {string}")
    public void editamosLaNotaA(String notaEditada) {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(notaEditada);
    }

    @Then("verificamos que la {string} se haya editado correctamente")
    public void verificamosQueLaSeHayaEditadoCorrectamente(String nuevaTarea) {
        String actualResult =android.findElement(By.xpath("//android.widget.TextView[@text='"+nuevaTarea+"']")).getText();
        Assertions.assertEquals(nuevaTarea,actualResult,"ERROR ! la tarea no se creo correctamente");
    }
}
