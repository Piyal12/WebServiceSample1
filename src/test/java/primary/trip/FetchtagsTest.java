package primary.trip;

import com.im.service.common.Annotation;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class FetchtagsTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(FetchtagsTest.class);
    public static final String SERVICE_NAME = "fetchTags";
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.TRIP,  serviceName = FetchtagsTest.SERVICE_NAME, testName="fetchtags", testGroup="p0")
    public void fetch_tracking_test (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.TRIP, FetchtagsTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Fetching failed");

    }
}
