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

public class UpdateCreditInfoTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(UpdateCreditInfoTest.class);
    public static final String SERVICE_NAME = "creditInfo";
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"positive","sanity","regression"},description ="Update credit info by ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT,  serviceName = UpdateCreditInfoTest.SERVICE_NAME, testName="creditinfo", testGroup="p0")
    public void update_credit_info_test (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.CREDIT, UpdateCreditInfoTest.SERVICE_NAME, TestBase.ENV,data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("status :"+rest.getStatus());
        LOG.info("\n" + rest.getResponse().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Updating Credit Info failed");

    }
}
