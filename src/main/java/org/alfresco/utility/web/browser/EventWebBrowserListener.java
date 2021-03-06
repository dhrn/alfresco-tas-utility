package org.alfresco.utility.web.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger class for {@link WebDriver}
 * 
 * @author Paul.Brodner
 */
public class EventWebBrowserListener implements WebDriverEventListener
{
    private static final Logger LOG = LoggerFactory.getLogger(EventWebBrowserListener.class);

    private String oldValue;

    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1)
    {
        oldValue = arg0.getAttribute("value");
    }

    public void afterChangeValueOf(WebElement arg0, WebDriver arg1)
    {
        String elementName = getElementName(arg0);
        try
        {
            String newValue = arg0.getAttribute("value");
            if (!newValue.equals(oldValue))
            {
                if (newValue.length() == 0)
                {
                    LOG.info("[{}] - cleared value", elementName);
                }
                else
                {
                    LOG.info("[{}] - changed value to '{}'", elementName, newValue);
                }
            }
        }
        catch (Exception e)
        {
            LOG.debug("[{}] - changed value", elementName);
        }
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1)
    {
        LOG.info("Clicked on element '{}'", arg0);
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2)
    {
        LOG.debug("'{}' - found", arg0);
    }

    @Override
    public void afterNavigateBack(WebDriver arg0)
    {
        LOG.info("Navigated Back");
    }

    @Override
    public void afterNavigateForward(WebDriver arg0)
    {
        LOG.info("Navigated Forward");
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1)
    {
        LOG.info("Navigate to '{}'", arg0);
    }

    @Override
    public void afterScript(String arg0, WebDriver arg1)
    {
        LOG.info("Ran script '{}'", arg0);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver)
    {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver)
    {

    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1)
    {
        LOG.debug("Trying to click '{}'", getElementName(arg0));
    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2)
    {
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0)
    {
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0)
    {
    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1)
    {
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1)
    {

    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1)
    {
        LOG.error(arg0.getClass().getName(), arg0);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType)
    {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x)
    {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }

    private String getElementName(WebElement arg0)
    {
        String foundBy = arg0.toString();
        if (foundBy != null)
        {
            int arrowIndex = foundBy.indexOf("->");
            if (arrowIndex >= 0)
            {
                return "By." + foundBy.substring(arrowIndex + 3, foundBy.length() - 1);
            }
        }
        return "unknown";
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver)
    {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver)
    {

    }

    @Override
    public void afterAlertAccept(WebDriver arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterAlertDismiss(WebDriver arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeAlertAccept(WebDriver arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeAlertDismiss(WebDriver arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2)
    {
        // TODO Auto-generated method stub
        
    }
}
