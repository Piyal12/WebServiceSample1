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

public class GetCreditApplicationListEnterpriseTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(GetCreditApplicationListEnterpriseTest.class);
    public static final String SERVICE_NAME = "creditlistEnterprise";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid customer alias ID for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "invalid_customer_alias_id", testGroup = "p0")
    public void invalid_customer_alias_id(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass customer alias ID as null for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "null_customer_alias_id", testGroup = "p0")
    public void null_customer_alias_id(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass group name as null for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "null_group_name", testGroup = "p0")
    public void null_group_name(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Getting Credit Enterprise List failed");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass group name as Retail for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "retail_group_name", testGroup = "p0")
    public void retail_group_name(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Getting Credit Enterprise List failed");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass page size as negative number for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "negative_page_size", testGroup = "p0")
    public void negative_page_size(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass order by as updated_ for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "invalid_order_by", testGroup = "p0")
    public void invalid_order_by(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass invalid order type for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "invalid_order_type", testGroup = "p0")
    public void invalid_order_type(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(DELETE) for get credit application list enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditApplicationListEnterpriseTest.SERVICE_NAME, testName = "get_credit_list_enterprise", testGroup = "p0")
    public void wrong_http_method(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.delete(ServiceGroup.CREDIT, GetCreditApplicationListEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
}
