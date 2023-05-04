package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.Combase;

public class TreePage extends Combase{

	WebDriver driver;

	// Homepage
	@FindBy(xpath = "//a[@href='data-structures-introduction']") WebElement getstart_datastructures;
	@FindBy(xpath = "//a[@href='tree']") WebElement getstart_tree;
	@FindBy(xpath = "//*[@id=\"navbarCollapse\"]//a[contains(text(), 'Data Structures')]") WebElement dropdown;
	@FindBy(xpath = "//*[@id='navbarCollapse']//a[contains(@href, '/tree')]") WebElement dropdown_tree;

	@FindBy(xpath = "//*[@href='overview-of-trees']") WebElement overviewOfTreesLink; //1
	@FindBy(xpath = "//*[@href='terminologies']") WebElement terminologiesLink; //2
	@FindBy(xpath = "//*[@href='types-of-trees']") WebElement typesoftreesLink; //3
	@FindBy(xpath = "//*[@href='tree-traversals']") WebElement treetraversalsLink; //4
	@FindBy(xpath = "//*[@href='traversals-illustration']") WebElement trav_illustrationsLink; //5
	@FindBy(xpath = "//*[@href='binary-trees']") WebElement binarytreesLink; //6
	@FindBy(xpath = "//*[@href='types-of-binary-trees']") WebElement typesofBinaryTreesLink; //7
	@FindBy(xpath = "//a[@href='implementation-in-python']") WebElement implementationInPythonLink; //8
	@FindBy(xpath = "//a[@href='binary-tree-traversals']") WebElement binaryTreeTraversalsLink; //9
	@FindBy(xpath = "//a[@href='implementation-of-binary-trees']") WebElement implementationOfBinaryTreesLink; //10
	@FindBy(xpath = "//a[@href='applications-of-binary-trees']") WebElement applicationsOfBinaryTreesLink; //11
	@FindBy(xpath = "//a[@href='binary-search-trees']") WebElement binarySearchTreesLink; //12
	@FindBy(xpath = "//a[@href='implementation-of-bst']") WebElement implementationOfBSTLink; //13
	@FindBy(xpath = "//a[@href='/tree/practice']") WebElement practiceQuestionLink; //14

	@FindBy(xpath = "//a[@href='/tryEditor']") WebElement TryHereLink;
	@FindBy(xpath = "//textarea[@tabindex='0']") WebElement editorInput;
	@FindBy(xpath = "//*[@id='answer_form']/button") WebElement runButton;
	@FindBy(id = "output") static WebElement output;

	public TreePage() {
		PageFactory.initElements(driver, this);
	}

	public void dropdown_Tree() {
		dropdown.click();
		dropdown_tree.click();
	}

	public String getTreePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnoverviewOfTreesPage() { //1
		overviewOfTreesLink.click();
	}

	public void click_Tryhere() {
		TryHereLink.click();
	}

	public void userInput(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun() {
		runButton.click();
	}
	
	public static String output()
	{
		return output.getText();	
	}

	public void clickOnTerminologiesLink() { //2
		terminologiesLink.click();
	}
	
	public void click_Tryhere_tl() {
		TryHereLink.click();
	}

	public void userInput_tl(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_tl() {
		runButton.click();
	}

	public void clickOnTypesOfTreesPage() { //3
		typesoftreesLink.click();
	}
	
	public void click_Tryhere_ttp() {
		TryHereLink.click();
	}

	public void userInput_ttp(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_ttp() {
		runButton.click();
	}

	public void clickOnTreeTraversalsLink() { //4
		treetraversalsLink.click();
	}
	
	public void click_Tryhere_ttl() {
		TryHereLink.click();
	}

	public void userInput_ttl(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_ttl() {
		runButton.click();
	}

	public void clickOnTrav_illus_Link() { //5
		trav_illustrationsLink.click();
	}
	
	public void click_Tryhere_ti() {
		TryHereLink.click();
	}

	public void userInput_ti(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_ti() {
		runButton.click();
	}

	public void clickOnBinaryTreesLink() { //6
		binarytreesLink.click();
	}
	
	public void click_Tryhere_btl() {
		TryHereLink.click();
	}

	public void userInput_btl(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_btl() {
		runButton.click();
	}

	public void clickOnTypesOfBTLink() { //7
		typesofBinaryTreesLink.click();
	}
	
	public void click_Tryhere_tbt() {
		TryHereLink.click();
	}

	public void userInput_tbt(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_tbt() {
		runButton.click();
	}

	public void click_implementationinPython() { //8
		implementationInPythonLink.click();
	}
	
	public void click_Tryhere_ip() {
		TryHereLink.click();
	}

	public void userInput_ip(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_ip() {
		runButton.click();
	}

	public void click_binaryTreeTraversals() { //9
		binaryTreeTraversalsLink.click();
	}
	
	public void click_Tryhere_btt() {
		TryHereLink.click();
	}

	public void userInput_btt(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_btt() {
		runButton.click();
	}

	public void click_implementationOfBinaryTrees() { //10
		implementationOfBinaryTreesLink.click();
	}
	
	public void click_Tryhere_ibt() {
		TryHereLink.click();
	}

	public void userInput_ibt(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_ibt() {
		runButton.click();
	}

	public void click_applicationsOfBinaryTrees() { //11
		applicationsOfBinaryTreesLink.click();
	}
	
	public void click_Tryhere_abt() {
		TryHereLink.click();
	}

	public void userInput_abt(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_abt() {
		runButton.click();
	}

	public void click_binarySearchTrees() { //12
		binarySearchTreesLink.click();
	}
	
	public void click_Tryhere_bst() {
		TryHereLink.click();
	}

	public void userInput_bst(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_bst() {
		runButton.click();
	}

	public void click_implementationOfBST() { //13
		implementationOfBSTLink.click();
	}
	
	public void click_Tryhere_ibst() {
		TryHereLink.click();
	}

	public void userInput_ibst(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_ibst() {
		runButton.click();
	}

	public void click_practiceQuestion() { //14
		practiceQuestionLink.click();
	}
	
	public void click_Tryhere_pq() {
		TryHereLink.click();
	}

	public void userInput_pq(String code, String output) {
		editorInput.sendKeys(code);
	}

	public void clickOnRun_pq() {
		runButton.click();
	}



}
