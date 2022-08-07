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

public class VehiclelistTest extends TestBase
{

    private static final Logger LOG = LoggerFactory.getLogger(VehiclelistTest.class);
    public static final String SERVICE_NAME = "vehicleList";
   @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")

    @Annotation.TestRun(serviceGroup = ServiceGroup.TRIP, serviceName = VehiclelistTest.SERVICE_NAME, testName="vehiclelist", testGroup="p0")
    public void vehicle_list_test (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.TRIP, VehiclelistTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Vehicle List failed");
    }
}
