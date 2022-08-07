package primary.product;

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

public class CreateProductGroupTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateProductGroupTest.class);
    public static final String SERVICE_NAME = "createProductGroup";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.PRODUCT, serviceName = CreateProductGroupTest.SERVICE_NAME, testName = "createProductGroup", testGroup = "p0")
    public void createProductGroup(HashMap<String, String> data) {
        System.out.println(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.PRODUCT, CreateProductGroupTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Product Group failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
