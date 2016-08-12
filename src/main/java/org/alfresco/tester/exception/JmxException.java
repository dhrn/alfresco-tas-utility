package org.alfresco.tester.exception;

public class JmxException extends Exception
{
    private static final long serialVersionUID = 1L;

    public JmxException(String message)
    {
        super(String.format("JMX exception encountered with the following message: %s", message));
    }
}