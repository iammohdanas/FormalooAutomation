# How to run the Test #

**Prerequisite**
1. Java environment 
2. Maven 
3. Selenium
4. Chrome WebBrowser version 17
5. Chrome WebDriver 17

**Note: Configure web-driver path and test email address.**
	

- Configure webdriver.
    - I used ChromeDriver but you can choose other webdriver eg. Mozilla GeckoDriver 
    - So first download ChromeDriver from [http://chromedriver.chromium.org/downloads](http://chromedriver.chromium.org/downloads).
    - Copy your downloaded **chromedriver.exe** file path.
    - Go to `src\test\java\testcases\FormalooAutomationbyAnas\AppTest.java` file.
    - Paste the copied file path in `System.setProperty("webdriver.chrome.driver","Paste path here")`.


- Configure test email address.
    - Change the value of emailField.sendKeys in \src\main\java\variables\FormalooAutomationbyAnas\AppTest.java` 
    - Note: with same email address you can not create account.

	
Project is ready to run. Execute following commands and enjoy the automatic web-driver test.
- Go to project path in IDE and run testng.xml file

