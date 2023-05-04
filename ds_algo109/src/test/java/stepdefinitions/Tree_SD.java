package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driversetup;
import PageObjects.TreePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class Tree_SD extends Combase{

	WebDriver driver = driversetup.getDriver();
	String excelpath = ".\\src/test/resources/ExcelData/code.xlsx";
	String output="";
	String expmsg;
	String actmsg;
	TreePage treepage = new TreePage();

	@When("The user selects Tree item from the drop down menu")
	public void the_user_selects_tree_item_from_the_drop_down_menu() {
		LoggerLoad.info("User click on Data Structure dropdown ");
		LoggerLoad.info("User select Tree from Data Structure dropdown ");
		treepage.dropdown_Tree();
	}

	@Then("The user should be directed to the {string} Page")
	public void the_user_should_be_directed_to_the_page(String pagename) {
		LoggerLoad.info("User redirected to Tree Page ");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks on the Overview of Trees link")
	public void the_user_clicks_on_the_overview_of_trees_link() {
		treepage.clickOnoverviewOfTreesPage();
	}

	@Then("The user should be directed to the {string} of tree Page")
	public void the_user_should_be_directed_to_the_of_tree_page(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks {string} button in a {string} page")
	public void the_user_clicks_button_in_a_page(String btnname, String dstname) {
		treepage.click_Tryhere();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_try_editor_with_a_run_button_to_test() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having an tryEditor with a Run button to test")
	public void the_user_is_in_trees_page_having_an_try_editor_with_a_run_button_to_test() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees")
	public void the_user_gets_input_from_sheet_and_in_trees(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor() {
		treepage.clickOnRun();
	}

	@Then("The user should be presented with Run output for trees")
	public void the_user_should_be_presented_with_run_output_for_trees() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput(code,output);

	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for overview")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_overview() {
		treepage.clickOnRun();
	}

	@Then("The user should get the alert message for trees")
	public void the_user_should_get_the_alert_message_for_trees() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
		Thread.sleep(3000);  
	}

	//2
	@When("The user clicks on the Terminologies button")
	public void the_user_clicks_on_the_terminologies_button() {
		treepage.clickOnTerminologiesLink();
	}
	
	@Then("The user should be directed to the terminologieslink {string} of tree Page")
	public void the_user_should_be_directed_to_the_terminologieslink_of_tree_page(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page")
	public void the_user_clicks_tryhere_button_in_a_page(String btnname, String dstname) {
		treepage.click_Tryhere_tl();
	}
	
	@Then("The user should be redirected to a page having tryEditor with a Run button to test for terminologies page")
	public void the_user_should_be_redirected_to_a_page_having_try_editor_with_a_run_button_to_test_for_terminologies_page() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test for terminologies page");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having an tryEditor with a Run button to test for terminologies page")
	public void the_user_is_in_trees_page_having_an_try_editor_with_a_run_button_to_test_for_terminologies_page() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test for terminologies page");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for terminologies page")
	public void the_user_gets_input_from_sheet_and_in_trees_for_terminologies_page(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_tl(code, output);
	}
	
	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for terminologies")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_tryEditor_for_terminologies() {
		treepage.clickOnRun_tl();
	}

	@Then("The user should be presented with Run output for trees in terminologies page")
	public void the_user_should_be_presented_with_run_output_for_trees_in_terminologies_page() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for terminologies page")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_terminologies_page(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_tl(code,output);

	}

	@When("user clicks on Run button after Entering invalid python code in trees tryEditor for terminologies page")
	public void user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_try_Editor_for_terminologies_page() {
		treepage.clickOnRun_tl();
	}

	@Then("The user should get the alert message for trees in terminologies")
	public void the_user_should_get_the_alert_message_for_trees_in_terminologies() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}


	//3
	@When("The user clicks on the Types of Trees button")
	public void the_user_clicks_on_the_types_of_trees_button() {
		treepage.clickOnTypesOfTreesPage();
	}
	
	@Then("The user should be directed to the typesOftreeslink {string} in tree Page")
	public void the_user_should_be_directed_to_the_typesOftreeslink_in_tree_page(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} link page")
	public void the_user_clicks_tryhere_button_in_a_link_page(String btnname, String dstname) {
		treepage.click_Tryhere_ttp();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for typesoftrees")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_typesoftrees() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for typesoftrees")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_typesoftrees() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for typesoftrees")
	public void the_user_gets_input_from_sheet_and_in_trees_for_typesoftrees(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ttp(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for typesoftrees")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_typesoftrees() {
		treepage.clickOnRun_ttp();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for ttp")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_ttp(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ttp(code,output);

	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for ttp")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_ttp() {
		treepage.clickOnRun_ttp();
	}

	@Then("The user should get the alert message for trees in ttp")
	public void the_user_should_get_the_alert_message_for_trees_in_ttp() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}

	//4
	@When("The user clicks on the Tree Traversals button")
	public void the_user_clicks_on_the_tree_traversals_button() {
		treepage.clickOnTreeTraversalsLink();
	}
	
	@Then("The user should be directed to the ttlink {string} in tree Page")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} ttlink page")
	public void the_user_clicks_tryhere_button_in_a_ttlink_page(String btnname, String dstname) {
		treepage.click_Tryhere_ttl();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for ttpage")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_ttpage() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for ttpage")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_ttpage() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for ttl")
	public void the_user_gets_input_from_sheet_and_in_trees_for_ttl(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ttl(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for ttl")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_ttl() {
		treepage.clickOnRun_ttl();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for ttl")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_ttl() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for ttl")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_ttl(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ttl(code,output);

	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for ttl")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_ttl() {
		treepage.clickOnRun_ttl();
	}

	@Then("The user should get the alert message for trees in ttl")
	public void the_user_should_get_the_alert_message_for_trees_in_ttl() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}

	
	//5
	@When("The user clicks on the Traversal illustration button")
	public void the_user_clicks_on_the_traversal_illustration_button() {
		treepage.clickOnTrav_illus_Link();
	}
	
	@Then("The user should be directed to the {string} in tree Page for ti")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_ti(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for ti")
	public void the_user_clicks_tryhere_button_in_a_page_for_ti(String btnname, String dstname) {
		treepage.click_Tryhere_ti();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for tipage")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_tipage() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for tipage")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_tipage() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for ti")
	public void the_user_gets_input_from_sheet_and_in_trees_for_ti(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ti(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for ti")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_ti() {
		treepage.clickOnRun_ti();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for ti")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_ti() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for ti")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_ti(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ti(code,output);

	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for ti")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_ti() {
		treepage.clickOnRun_ti();
	}

	@Then("The user should get the alert message for trees in ti")
	public void the_user_should_get_the_alert_message_for_trees_in_ti() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}

	
	//6
	@When("The user clicks on the binary trees button")
	public void the_user_clicks_on_the_binary_trees_button() {
		treepage.clickOnBinaryTreesLink();
	}
	
	@Then("The user should be directed to the {string} in tree Page for btl")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_btl(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for btl")
	public void the_user_clicks_tryhere_button_in_a_page_for_btl(String btnname, String dstname) {
		treepage.click_Tryhere_btl();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for btpage")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_btpage() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for btpage")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_btpage() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for bt")
	public void the_user_gets_input_from_sheet_and_in_trees_for_bt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_btl(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for bt")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_bt() {
		treepage.clickOnRun_btl();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for bt")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_bt() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for bt")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_bt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_btl(code,output);

	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for bt")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_bt() {
		treepage.clickOnRun_btl();
	}

	@Then("The user should get the alert message for trees in bt")
	public void the_user_should_get_the_alert_message_for_trees_in_bt() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//7
	@When("The user clicks on the types of binary trees button")
	public void the_user_clicks_on_the_types_of_binary_trees_button() {
		treepage.clickOnTypesOfBTLink();
	}
	
	@Then("The user should be directed to the {string} in tree Page for tbt")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_tbt(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for tbt")
	public void the_user_clicks_tryhere_button_in_a_page_for_tbt() {
		treepage.click_Tryhere_tbt();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for tbt")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_tbt() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for tbt")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_tbt() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for tbt")
	public void the_user_gets_input_from_sheet_and_in_trees_for_tbt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_tbt(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for tbt")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_tbt() {
		treepage.clickOnRun_btl();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for tbt")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_tbt() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for tbt")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_tbt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_tbt(code,output);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for tbt")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_tbt() {
		treepage.clickOnRun_tbt();
	}

	@Then("The user should get the alert message for trees in tbt")
	public void the_user_should_get_the_alert_message_for_trees_in_tbt() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//8
	@When("The user clicks on the Implementation in Python button")
	public void the_user_clicks_on_the_implementation_in_python_button() {
		treepage.click_implementationinPython();
	}
	
	@Then("The user should be directed to the {string} in tree Page for ip")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_ip(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for ip")
	public void the_user_clicks_tryhere_button_in_a_page_for_ip() {
		treepage.click_Tryhere_ip();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for ip")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_ip() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for ip")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_ip() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for ip")
	public void the_user_gets_input_from_sheet_and_in_trees_for_ip(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ip(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for ip")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_ip() {
		treepage.clickOnRun_ip();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for ip")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_ip() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for ip")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_ip(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ip(code,output);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for ip")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_ip() {
		treepage.clickOnRun_ip();
	}

	@Then("The user should get the alert message for trees in ip")
	public void the_user_should_get_the_alert_message_for_trees_in_ip() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//9
	@When("The user clicks on the binary tree traversals button")
	public void the_user_clicks_on_the_binary_tree_traversals_button() {
		treepage.click_binaryTreeTraversals();
	}
	
	@Then("The user should be directed to the {string} in tree Page for btt")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_btt(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for btt")
	public void the_user_clicks_tryhere_button_in_a_page_for_btt() {
		treepage.click_Tryhere_btt();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for btt")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_btt() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for btt")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_btt() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for btt")
	public void the_user_gets_input_from_sheet_and_in_trees_for_btt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_btt(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for btt")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_btt() {
		treepage.clickOnRun_btt();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for btt")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_btt() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for btt")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_btt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_btt(code,output);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for btt")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_btt() {
		treepage.clickOnRun_ip();
	}

	@Then("The user should get the alert message for trees in btt")
	public void the_user_should_get_the_alert_message_for_trees_in_btt() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//10
	@When("The user clicks on the Implementation of Binary Trees button")
	public void the_user_clicks_on_the_implementation_of_binary_trees_button() {
		treepage.click_implementationOfBinaryTrees();
	}
	
	@Then("The user should be directed to the {string} in tree Page for ibt")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_ibt(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for ibt")
	public void the_user_clicks_tryhere_button_in_a_page_for_ibt() {
		treepage.click_Tryhere_ibt();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for ibt")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_ibt() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for ibt")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_ibt() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for ibt")
	public void the_user_gets_input_from_sheet_and_in_trees_for_ibt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ibt(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for ibt")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_ibt() {
		treepage.clickOnRun_ibt();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for ibt")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_ibt() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for ibt")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_ibt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ibt(code,output);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for ibt")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_ibt() {
		treepage.clickOnRun_ibt();
	}

	@Then("The user should get the alert message for trees in ibt")
	public void the_user_should_get_the_alert_message_for_trees_in_ibt() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//11
	@When("The user clicks on the Applications of Binary Trees button")
	public void the_user_clicks_on_the_Applications_of_binary_trees_button() {
		treepage.click_applicationsOfBinaryTrees();
	}
	
	@Then("The user should be directed to the {string} in tree Page for abt")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_abt(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for abt")
	public void the_user_clicks_tryhere_button_in_a_page_for_abt() {
		treepage.click_Tryhere_abt();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for abt")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_abt() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for abt")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_abt() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for abt")
	public void the_user_gets_input_from_sheet_and_in_trees_for_abt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_abt(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for abt")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_abt() {
		treepage.clickOnRun_abt();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for abt")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_abt() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for abt")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_abt(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_abt(code,output);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for abt")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_abt() {
		treepage.clickOnRun_abt();
	}

	@Then("The user should get the alert message for trees in abt")
	public void the_user_should_get_the_alert_message_for_trees_in_abt() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//12
	@When("The user clicks on the Binary Search Trees button")
	public void the_user_clicks_on_the_binary_search_trees_button() {
		treepage.click_binarySearchTrees();
	}
	
	@Then("The user should be directed to the {string} in tree Page for bst")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_bst(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for bst")
	public void the_user_clicks_tryhere_button_in_a_page_for_bst() {
		treepage.click_Tryhere_bst();
	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for bst")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_bst() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for bst")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_bst() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for bst")
	public void the_user_gets_input_from_sheet_and_in_trees_for_bst(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_bst(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for bst")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_bst() {
		treepage.clickOnRun_bst();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for bst")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_bst() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for bst")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_bst(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_bst(code,output);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for bst")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_bst() {
		treepage.clickOnRun_bst();
	}

	@Then("The user should get the alert message for trees in bst")
	public void the_user_should_get_the_alert_message_for_trees_in_bst() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//13
	@When("The user clicks on the Implementation of BST button")
	public void the_user_clicks_on_the_implementation_of_bst_button() {
		treepage.click_implementationOfBST();
	}
	
	@Then("The user should be directed to the {string} in tree Page for ibst")
	public void the_user_should_be_directed_to_the_ttlink_in_tree_page_for_ibst(String pagename) {
		LoggerLoad.info("User redirected to " + pagename);
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}

	@When("The user clicks tryhere {string} button in a {string} page for ibst")
	public void the_user_clicks_tryhere_button_in_a_page_for_ibst() {
		treepage.click_Tryhere_ibst();

	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test for ibst")
	public void the_user_should_be_redirected_to_a_page_having_tryEditor_with_a_run_button_to_test_for_ibst() {
		LoggerLoad.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in trees page having tryEditor with a Run button to test for ibst")
	public void the_user_is_in_trees_page_having_tryEditor_with_a_run_button_to_test_for_ibst() {
		LoggerLoad.info("The user is in a page having an tryEditor with a Run button to test");
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees for ibst")
	public void the_user_gets_input_from_sheet_and_in_trees_for_ibst(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ibst(code, output);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor for ibst")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor_for_ibst() {
		treepage.clickOnRun_ibst();
	}

	@Then("The user should be presented with Run output for typesoftrees in trees for ibst")
	public void the_user_should_be_presented_with_run_output_for__typesoftrees_in_trees_for_ibst() {
		actmsg= TreePage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("The user gets invalid input from sheet {string} and {int} in trees for ibst")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees_for_ibst(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(rowNum).get("code"); // Column heading
		String output=testData.get(rowNum).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		treepage.userInput_ibst(code,output);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor for ibst")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_tryEditor_for_ibst() {
		treepage.clickOnRun_ibst();
	}

	@Then("The user should get the alert message for trees in ibst")
	public void the_user_should_get_the_alert_message_for_trees_in_ibst() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
	}
	
	//14
	@When("The user clicks on the Practice Questions in Overview of Trees")
	public void the_user_clicks_on_the_practice_questions_in_overview_of_trees() {
		treepage.click_practiceQuestion();
	}

	@Then("The user should be directed to Practice Questions of tree page Page")
	public void the_user_should_be_directed_to_practice_questions_of_tree_page_page() {
		String Title = treepage.getTreePageTitle();
		LoggerLoad.info("Title of current page is :" + Title);
		assertEquals(Title, "Practice Questions", "Title do not match");
		LoggerLoad.info("NO questions found ");
	}


}
