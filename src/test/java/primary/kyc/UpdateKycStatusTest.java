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

public class UpdateKycStatusTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateKycStatusTest.class);
    public static final String SERVICE_NAME = "updateKycStatus";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description = "Update KYC status for a document")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = UpdateKycStatusTest.SERVICE_NAME, testName = "updateKycStatus", testGroup = "p0")
    public void updateKycStatus(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.GROUP5, UpdateKycStatusTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Update KYC Status failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
