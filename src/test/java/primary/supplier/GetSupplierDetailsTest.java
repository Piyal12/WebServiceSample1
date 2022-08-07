package primary.supplier;

import com.google.gson.Gson;
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
/*
 * This class will fetch all supplier details
 * @author Yashas
 * */
public class GetSupplierDetailsTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetSupplierDetailsTest.class);
    public static final String SERVICE_NAME = "getSupplierDetails";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"regression","sanity","positive"},description = "GetSupplierDetailsTest with all valid params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = GetSupplierDetailsTest.SERVICE_NAME, testName = "getSupplierDetails", testGroup = "p0")
    public void getSupplierDetails_test(HashMap<String, String> data) throws Exception {
        try {
            WebService rest = Ws.get(ServiceGroup.SUPPLIER, GetSupplierDetailsTest.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
            LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
            LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
            LOG.info("Status:" + rest.getStatus());
            MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
            Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
            Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Get supplier details Test failed");
            LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        } catch (Exception e) {
            throw new Exception("Error in GetSupplierDetailsTest() " + e.getMessage());
        }
    }
}