package primary.trip;

import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.HashMap;

public class FetchTrackingTestNegative extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(FetchTrackingTestNegative.class);
    public static final String SERVICE_NAME = "trackingList";
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.TRIP,  serviceName = FetchTrackingTestNegative.SERVICE_NAME)
    @Annotation.TestData(attributeName = "fulfilmentOrder",value = "")
    public void passEmptyValue (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.TRIP, FetchTrackingTestNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Fetching failed");

    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestData(attributeName = "fulfilmentOrder",value = "")
    @Annotation.TestRun(serviceGroup = ServiceGroup.TRIP,  serviceName = FetchTrackingTestNegative.SERVICE_NAME,dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "fulfilmentOrder")
    public void passNumericValue (HashMap<String, String> data) throws Exception
    {

        WebService rest = Ws.post(ServiceGroup.TRIP, FetchTrackingTestNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Fetching failed");

    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestData(attributeName = "fulfilmentOrder",value = "")
    @Annotation.TestRun(serviceGroup = ServiceGroup.TRIP,  serviceName = FetchTrackingTestNegative.SERVICE_NAME,dataType = DataType.UNASSIGNED, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "fulfilmentOrder")
    public void passUnassignedValue (HashMap<String, String> data) throws Exception
    {

        WebService rest = Ws.post(ServiceGroup.TRIP, FetchTrackingTestNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Fetching failed");

    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestData(attributeName = "fulfilmentOrder",value = "")
    @Annotation.TestRun(serviceGroup = ServiceGroup.TRIP,  serviceName = FetchTrackingTestNegative.SERVICE_NAME,dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "fulfilmentOrder")
    public void passAlphaNumericValue (HashMap<String, String> data) throws Exception
    {

        WebService rest = Ws.post(ServiceGroup.TRIP, FetchTrackingTestNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Fetching failed");

    }
}
