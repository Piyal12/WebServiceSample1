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
public class GetSalesDashboardNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetSalesDashboardNegative. class);
    public static final String SERVICE_NAME = "getSalesDashboard";


    @Test(enabled = true,dataProviderClass = TestDataProvider.class,dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Null values to check get dashboard list for a time period")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD, serviceName = GetSalesDashboardNegative.SERVICE_NAME, testName = "getSalesDashboard", testGroup = "p0",dataType=DataType.ALPHA_NUMERIC, dataConstraint=DataConstraint.ONE_BY_ONE)
    public void PassNullValue(HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetSalesDashboardNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
       // Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Sales Dashboard is failed");
    }


    @Test(enabled = true,dataProviderClass = TestDataProvider.class,dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Numberic values to check get dashboard list for a time period")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD, serviceName = GetSalesDashboardNegative.SERVICE_NAME, testName = "getSalesDashboard", testGroup = "p0",dataType=DataType.NUMERIC, dataConstraint=DataConstraint.FOR_SPECIFIED, attributeName="month")
    public void PassNumericValue(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetSalesDashboardNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Sales Dashboard is failed");
    }
    @Test(enabled = true,dataProviderClass = TestDataProvider.class,dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Blank values to check get dashboard list for a time period")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD, serviceName = GetSalesDashboardNegative.SERVICE_NAME, testName = "getSalesDashboard", testGroup = "p0",dataType=DataType.BLANK, dataConstraint=DataConstraint.FOR_SPECIFIED, attributeName="month")
    public void PassBlankValue(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetSalesDashboardNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        // Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Sales Dashboard is failed");
    }
    @Test(enabled = true,dataProviderClass = TestDataProvider.class,dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Unassigned values to check get dashboard list for a time period")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD, serviceName = GetSalesDashboardNegative.SERVICE_NAME, testName = "getSalesDashboard", testGroup = "p0",dataType=DataType.UNASSIGNED, dataConstraint=DataConstraint.FOR_SPECIFIED, attributeName="month")
    public void PassUnassignedValue(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetSalesDashboardNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        // Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Sales Dashboard is failed");
    }
    @Test(enabled = true,dataProviderClass = TestDataProvider.class,dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Unassigned values to check get dashboard list for a time period")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD, serviceName = GetSalesDashboardNegative.SERVICE_NAME, testName = "getSalesDashboard", testGroup = "p0",dataType=DataType.ALPHA_NUMERIC, dataConstraint=DataConstraint.FOR_SPECIFIED, attributeName="month")
    public void PassAlphanumericValue(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetSalesDashboardNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        // Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Sales Dashboard is failed");
    }

}