package framework.picocontainerdependency;

import framework.controllers.FileReaderController;
import framework.controllers.PageFactoryController;
import framework.controllers.WebDriverController;
import framework.webelementutility.WebElementUtil;

public class TestContext {

    private WebDriverController webDriverController;

    private PageFactoryController pageFactoryController;

    private FileReaderController fileReaderController;

    private WebElementUtil webElementUtil;

    public TestContext() {

        webDriverController = new WebDriverController();
        pageFactoryController = new PageFactoryController(webDriverController.getDriver());
        fileReaderController = new FileReaderController();
        webElementUtil = new WebElementUtil(webDriverController.getDriver());
    }

    public WebDriverController getWebDriverController() {

        return webDriverController;
    }

    public PageFactoryController getPageFactoryController() {

        return pageFactoryController;
    }

    public FileReaderController getFileReaderController() {

        return fileReaderController;
    }

    public WebElementUtil getWebElementUtil() {

        return webElementUtil;
    }
}
