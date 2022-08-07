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
 * This class will fetch all supplier details from KYC
 * @author Yashas
 * */
public class GetSupplierDataFromKyc extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetSupplierDataFromKyc.class);
    public static final String SERVICE_NAME = "getSupplierDataFromKyc";
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"regression","sanity","positive"},description = "GetSupplierDataFromKyc with all valid params")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = GetSupplierDataFromKyc.SERVICE_NAME, testName = "getSupplierDataFromKyc", testGroup = "p0")
    public void GetSupplierDataFromKyc_test(HashMap<String, String> data) throws Exception {
        try {
            WebService rest = Ws.get(ServiceGroup.SUPPLIER, GetSupplierDataFromKyc.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
            LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
            LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
            LOG.info("Status:" + rest.getStatus());
            Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
            Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Get supplier details from KYC details failed");
            MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
            LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        } catch (Exception e) {
            throw new Exception("Error in getSupplierDetails_test() " + e.getMessage());
        }
    }
}
