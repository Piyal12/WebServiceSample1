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

public class UpdateCreditApplicationTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(UpdateCreditApplicationTest.class);
    public static final String SERVICE_NAME = "creditApplication";

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass credit info as special character for update credit application by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditApplicationTest.SERVICE_NAME, testName="credit_info_special_character", testGroup="p0")
    public void credit_info_special_character (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditApplicationTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass proposed credit along with special character for update credit application by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditApplicationTest.SERVICE_NAME, testName="proposed_credit_with_special_character", testGroup="p0")
    public void proposed_credit_with_special_character (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditApplicationTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass credit group name with one double quote for update credit application by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditApplicationTest.SERVICE_NAME, testName="group_name_with_one_double_quote", testGroup="p0")
    public void group_name_with_one_double_quote (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditApplicationTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass all the values as blank for update credit application by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditApplicationTest.SERVICE_NAME, testName="blank_values", testGroup="p0")
    public void blank_values (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditApplicationTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(POST) for update credit application by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditApplicationTest.SERVICE_NAME, testName="update_credit_application", testGroup="p0")
    public void wrong_http_method (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateCreditApplicationTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is "+405+". But actual is "+rest.getStatus()+".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
}
