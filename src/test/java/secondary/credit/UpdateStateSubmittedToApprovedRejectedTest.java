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

public class UpdateStateSubmittedToApprovedRejectedTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(UpdateStateSubmittedToApprovedRejectedTest.class);
    public static final String SERVICE_NAME = "updatestatesubmittedtoApprovedRejected";

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass approved_credit value as null for update credit application state from Submitted to Approved/Rejected")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, testName="approved_credit_null_value", testGroup="p0")
    public void approved_credit_null_value (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass approved_credit value as invalid data type for update credit application state from Submitted to Approved/Rejected")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, testName="approved_credit_invalid_data_type", testGroup="p0")
    public void approved_credit_invalid_data_type (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass credit days with one double quote for update credit application state from Submitted to Approved/Rejected")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, testName="credit_days_with_one_double_quote", testGroup="p0")
    public void credit_days_with_one_double_quote (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
       Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass from_state as Submitted and to_state as new for update credit application state from Submitted to Approved/Rejected")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, testName="credit_status_submitted_to_new", testGroup="p0")
    public void credit_status_submitted_to_new (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Status from Submitted to Approved/Rejected failed");
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass wrong HTTP method(GET) for update credit application state from Submitted to Approved/Rejected")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, testName="credit_status_submitted_to_approved_rejected", testGroup="p0")
    public void wrong_http_method (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is "+405+". But actual is "+rest.getStatus()+".");
    }
}
