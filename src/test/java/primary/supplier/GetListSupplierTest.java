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
 * This class will fetch List of all suppliers
 * @author Yashas
 * */
public class GetListSupplierTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetListSupplierTest.class);
    public static final String SERVICE_NAME = "getListSupplier";

//    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
    //@Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = GetListSupplierTest.SERVICE_NAME, testName = "GetListSupplierTest", testGroup = "p0")
    @Test(groups = {"regression","sanity","positive"},description = "GetListSupplierTest with all valid param")
    public void getListSupplier_test() throws Exception {
        try {
            WebService rest = Ws.get(ServiceGroup.SUPPLIER, GetListSupplierTest.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN);
            LOG.info("Status:" + rest.getStatus());
            Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
            Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Get suppliers Test failed");
            MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
            LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        } catch (Exception e) {
            throw new Exception("Error in GetListSupplierTest() " + e.getMessage());
        }
    }
}
