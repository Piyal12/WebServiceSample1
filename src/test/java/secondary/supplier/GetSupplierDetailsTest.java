package secondary.supplier;

import com.im.service.common.Annotation;
import com.im.service.common.Environment;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.session.Session;
import com.im.service.session.SessionProperties;
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

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "GetSupplierDetailsTest with invalid supplier Id")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = GetSupplierDetailsTest.SERVICE_NAME, testName = "invalidSupplierDetails", testGroup = "p1")
    public void invalid_SupplierID_test(HashMap<String, String> data) throws Exception {
        try {
            WebService rest = Ws.get(ServiceGroup.SUPPLIER, GetSupplierDetailsTest.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
            LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
            LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
            LOG.info("Status:" + rest.getStatus());
            Assert.assertEquals(rest.getStatus(), 404, "The expected status is " + 404 + ". But actual is " + rest.getStatus() + ".");
            LOG.info("\n" + rest.getResponse().body().prettyPeek());
        } catch (Exception e) {
            throw new Exception("Error in GetSupplierDetailsTest() " + e.getMessage());
        }
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "GetSupplierDetailsTest with invalid http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER,serviceName = GetSupplierDetailsTest.SERVICE_NAME,testName = "getSupplierDetails", testGroup = "p0")
    public void invalid_httpMethod_test(HashMap<String, String> data) throws Exception {
        try {
            WebService rest = Ws.post(ServiceGroup.SUPPLIER, GetSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
            LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
            LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
            Assert.assertEquals(rest.getStatus(), 412, "The expected status is " + 412 + ". But actual is " + rest.getStatus() + ".");
            LOG.info("\n" + rest.getResponse().body().prettyPeek());
        } catch (Exception e) {
            throw new Exception("Error in GetSupplierDetailsTest() " + e.getMessage());
        }
    }
}
