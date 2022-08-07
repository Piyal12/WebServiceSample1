package primary.dashboard;

import com.im.service.common.Annotation;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.session.Session;
import com.im.service.session.SessionProperties;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GetCusDashboardTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCusDashboardTest.class);
    public static final String SERVICE_NAME = "getCusDashboard";

    @Annotation.TestData(attributeName = "customerAliasId",value = "CUST2324")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"positive","sanity","regression"},description = "Get dashboard details for a customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD,  serviceName = GetCusDashboardTest.SERVICE_NAME)
    public void getCusDashboardTest (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetCusDashboardTest.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Order details fetched");
        LOG.info(rest.getResponse().asString());
    }
}
