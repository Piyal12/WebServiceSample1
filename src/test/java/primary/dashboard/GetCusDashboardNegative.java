package primary.dashboard;

import com.im.service.common.Annotation;
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

public class GetCusDashboardNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCusDashboardNegative.class);
    public static final String SERVICE_NAME = "getCusDashboard";

    @Annotation.TestData(attributeName = "customerAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass alphaNumeric customer ID to fetch dashboard details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD,  serviceName = GetCusDashboardNegative.SERVICE_NAME,dataType = DataType.ALPHA_NUMERIC)
    public void PassAlphaNumeric (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetCusDashboardNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());

        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Order details fetched");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "customerAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Numeric customer ID to fetch dashboard details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD,  serviceName = GetCusDashboardNegative.SERVICE_NAME,dataType = DataType.NUMERIC)
    public void PassNumeric (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetCusDashboardNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());

        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Order details fetched");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "customerAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Null customer ID to fetch dashboard details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD,  serviceName = GetCusDashboardNegative.SERVICE_NAME,dataType = DataType.NULL)
    public void PassNullValue (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetCusDashboardNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());

        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Order details fetched");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "customerAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Unassigned customer ID to fetch dashboard details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD,  serviceName = GetCusDashboardNegative.SERVICE_NAME,dataType = DataType.UNASSIGNED)
    public void PassUnassigned (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetCusDashboardNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());

        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Order details fetched");
        LOG.info(rest.getResponse().asString());
    }

}
