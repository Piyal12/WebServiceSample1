package primary.inquiry;

import com.im.service.common.Annotation;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.session.Session;
import com.im.service.session.SessionProperties;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import primary.kyc.CreateKycTest;

import java.util.HashMap;

public class CreateInquiryTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateInquiryTest.class);
    public static final String SERVICE_NAME = "createInquiry";

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = CreateInquiryTest.SERVICE_NAME, testName="createInquiryTest", testGroup="p0")
    public void createInquiryTest (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.GROUP1, CreateInquiryTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Inquiry failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
