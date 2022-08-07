package secondary.credit;

import com.im.service.common.Annotation;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class GetCreditInfoDataByFilterEnterpriseTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(GetCreditInfoDataByFilterEnterpriseTest.class);
    public static final String SERVICE_NAME = "creditinfofilterEnterprise";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid customer alias ID for get credit info data filter by Enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, testName = "invalid_customer_alias_id", testGroup = "p0")
    public void invalid_customer_alias_id(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass customer alias ID as blank for get credit info data filter by Enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, testName = "blank_customer_alias_id", testGroup = "p0")
    public void blank_customer_alias_id(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass credit group name as retailer for get credit info data filter by Enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, testName = "credit_group_name_retailer", testGroup = "p0")
    public void credit_group_name_retailer(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Getting Customer Credit Enterprise List failed");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid Site ID for get credit info data filter by Enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, testName = "invalid_site_id", testGroup = "p0")
    public void invalid_site_id(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass product id with special character for get credit info data filter by Enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, testName = "product_id_with_special_character", testGroup = "p0")
    public void product_id_with_special_character(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(DELETE) for get credit info data filter by Enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, testName = "credit_info_filter_enterprise", testGroup = "p0")
    public void wrong_http_method(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.delete(ServiceGroup.CREDIT, GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
}
