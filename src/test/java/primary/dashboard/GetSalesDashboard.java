package primary.dashboard;

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

import java.util.HashMap;

/*
 *
 * This class will fetch Sales Dashboard
 * @author Dharini H M
 */
public class GetSalesDashboard extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetSalesDashboard. class);
    public static final String SERVICE_NAME = "getSalesDashboard";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description = "Get dashboard list for a particular time period" )
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD, serviceName = GetSalesDashboard.SERVICE_NAME, testName = "getSalesDashboard", testGroup = "p0")
    public void getSalesDashboardListTest(HashMap<String, String> data) throws Exception {


        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetSalesDashboard.SERVICE_NAME, TestBase.ENV,data);
       LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
       LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Sales Dashboard is failed");
    }
}