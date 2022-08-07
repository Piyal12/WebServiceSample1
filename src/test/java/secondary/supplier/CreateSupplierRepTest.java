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
/*
* This class will create the new Supplier Rep details
*  @author Piyal
*/

public class CreateSupplierRepTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSupplierRepTest.class);
    public static final String SERVICE_NAME = "createSupplierRep";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierRepTest with invalid http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierRepTest.SERVICE_NAME, testName = "createSupplierRep_valid_data_test", testGroup = "p0")
    public void invalidHttpMethod_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, CreateSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierRepTest with invalid mail id")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierRepTest.SERVICE_NAME, testName = "invalidMailId", testGroup = "p1")
    public void invalidMailId_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierRepTest with name as blank")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierRepTest.SERVICE_NAME, testName = "createSupplierRep_valid_data_test", testGroup = "p0",attributeName = "firstName",includeAttributeNames = "lastName",dataConstraint = DataConstraint.ONE_BY_ONE,dataType = DataType.BLANK)
    public void blankName_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierRepTest with invalid department name not in enum")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierRepTest.SERVICE_NAME, testName = "createSupplierRep_valid_data_test", testGroup = "p0",attributeName = "department",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.ALPHABET)
    public void invalidDept_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 450 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
}
