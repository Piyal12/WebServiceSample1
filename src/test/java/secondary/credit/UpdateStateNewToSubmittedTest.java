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

public class UpdateStateNewToSubmittedTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(UpdateStateNewToSubmittedTest.class);
    public static final String SERVICE_NAME = "updatestatenewtoSubmitted";

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass from_state as Submitted and to_state as new for update credit application state from New to Submitted")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateNewToSubmittedTest.SERVICE_NAME, testName="credit_status_submitted_to_new", testGroup="p0")
    public void credit_status_submitted_to_new (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateNewToSubmittedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Status from New to Submitted failed");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass from_state with invalid data for update credit application state from New to Submitted")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateNewToSubmittedTest.SERVICE_NAME, testName="from_state_invalid_data", testGroup="p0")
    public void from_state_invalid_data (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateNewToSubmittedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass to_state with special characters for update credit application state from New to Submitted")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateNewToSubmittedTest.SERVICE_NAME, testName="to_state_special_characters", testGroup="p0")
    public void to_state_special_characters (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateNewToSubmittedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(GET) for update credit application state from New to Submitted")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateNewToSubmittedTest.SERVICE_NAME, testName="credit_status_new_to_submitted", testGroup="p0")
    public void wrong_http_method (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, UpdateStateNewToSubmittedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is "+405+". But actual is "+rest.getStatus()+".");
    }
}
