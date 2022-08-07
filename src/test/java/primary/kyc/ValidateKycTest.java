package primary.kyc;

import com.google.gson.Gson;
import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
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
*This class will fetch only particular Supplier Rep details
* */
public class ValidateKycTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(ValidateKycTest.class);
    public static final String SERVICE_NAME = "validateKyc";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description = "To check if the kyc ID is valid")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = ValidateKycTest.SERVICE_NAME, testName = "validateKyc", testGroup = "p0")
    public void validateKyc(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.GROUP5, ValidateKycTest.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Validate KYC Test failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
