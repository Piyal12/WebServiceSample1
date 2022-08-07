package primary.credit;

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
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"positive","sanity","regression"},description ="Update credit application state from Submitted to Approved/Rejected")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, testName="credit_status_submitted_to_approved_rejected", testGroup="p0")
    public void credit_status_submitted_to_approved_test (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.CREDIT, UpdateStateSubmittedToApprovedRejectedTest.SERVICE_NAME, TestBase.ENV,data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Status from Submitted to Approved/Rejected failed");

    }
}
