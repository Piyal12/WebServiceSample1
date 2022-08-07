package primary.kyc;

import com.google.gson.Gson;
import com.im.service.common.Annotation;
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
*/

public class CreateKycTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateKycTest.class);
    public static final String SERVICE_NAME = "createKyc";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description = "Create KYC ID for a gst document")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = CreateKycTest.SERVICE_NAME, testName = "createKyc", testGroup = "p0")
    public void createKyc(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, CreateKycTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Create KYC failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
