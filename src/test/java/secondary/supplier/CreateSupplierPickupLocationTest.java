package secondary.supplier;

import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
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

public class CreateSupplierPickupLocationTest extends TestBase {
        private static final Logger LOG = LoggerFactory.getLogger(CreateSupplierPickupLocationTest.class);
        public static final String SERVICE_NAME = "createPickupLocation";

        @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierPickupLocationTest with invalid http method")
        @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierPickupLocationTest.SERVICE_NAME, testName = "aut_login", testGroup = "p0")
        public void invalidHttpMethod_Test(HashMap<String, String> data) throws Exception {
            WebService rest = Ws.put(ServiceGroup.SUPPLIER, CreateSupplierPickupLocationTest.SERVICE_NAME, TestBase.ENV, data);
            LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
            LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
            Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
            LOG.info("\n" + rest.getResponse().prettyPeek());
        }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierPickupLocationTest with invalid Ph No")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierPickupLocationTest.SERVICE_NAME, testName = "invalidPhNo", testGroup = "p1")
    public void invalidPhNo_Test(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierPickupLocationTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierPickupLocationTest with invalid mail id")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierPickupLocationTest.SERVICE_NAME, testName = "invalidEmailId", testGroup = "p2")
    public void invalidEmailId_Test(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierPickupLocationTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierPickupLocationTest with KYC ID as alpha numeric")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierPickupLocationTest.SERVICE_NAME, testName = "aut_login", testGroup = "p0",attributeName = "kycID",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.ALPHA_NUMERIC)
    public void invalidKycId_test(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierPickupLocationTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
        }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierPickupLocationTest with KYC type as alpha numeric")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierPickupLocationTest.SERVICE_NAME, testName = "aut_login", testGroup = "p0",attributeName = "kyc_type",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.ALPHA_NUMERIC)
    public void invalidKycType_test(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierPickupLocationTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
}
