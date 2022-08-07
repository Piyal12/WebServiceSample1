package secondary.supplier;

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
*
* This class will edit the supplier rep details
* @author Piyal
* */
public class EditSupplierRepTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(EditSupplierRepTest.class);
    public static final String SERVICE_NAME = "editSupplierRep";
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierRepTest with invalid http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = EditSupplierRepTest.SERVICE_NAME, testName = "editSupplierRep_valid_data_test", testGroup = "p0")
    public void invalid_httpMethod_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, EditSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierRepTest with invalid email ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = EditSupplierRepTest.SERVICE_NAME, testName = "invalidemailID_test", testGroup = "p1")
    public void invalid_emailID_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, EditSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierRepTest with name as Blank")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = EditSupplierRepTest.SERVICE_NAME, testName = "blankName_test", testGroup = "p2")
    public void blank_name_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, EditSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierRepTest as invalid dept name")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = EditSupplierRepTest.SERVICE_NAME, testName = "invalid_DeptName_test", testGroup = "p3")
    public void invalid_DeptName_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, EditSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierRepTest without KYC Id")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = EditSupplierRepTest.SERVICE_NAME, testName = "without_KycId_test", testGroup = "p4")
    public void without_KycId_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, EditSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierRepTest Ph No as Blank")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = EditSupplierRepTest.SERVICE_NAME, testName = "blank_PhNo_test", testGroup = "p5")
    public void blank_PhNo_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, EditSupplierRepTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
}
