package secondary.supplier;

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
* This class will create the new Supplier office
*  @author Yashas
*/

public class CreateSupplierOfficeTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSupplierOfficeTest.class);
    public static final String SERVICE_NAME = "createSupplierOffice";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierOfficeTest with name as Blank")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierOfficeTest.SERVICE_NAME, testName = "nameAsBlank", testGroup = "p1")
    public void nameAsBlank_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierOfficeTest with invalid Ph No")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierOfficeTest.SERVICE_NAME, testName = "invalidPhNo", testGroup = "p2")
    public void invalidPhNo_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierOfficeTest with invalid Mail Id")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierOfficeTest.SERVICE_NAME, testName = "invalidMailId", testGroup = "p3")
    public void invalidMailId_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierOfficeTest with GST as blank")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierOfficeTest.SERVICE_NAME, testName = "createSupplierOffice", testGroup = "p0",attributeName = "kycIdGST",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.BLANK)
    public void blankKycId_test(HashMap<String, String> data) {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "CreateSupplierOfficeTest with invalid http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierOfficeTest.SERVICE_NAME, testName = "createSupplierOffice", testGroup = "p0")
    public void invalidHttpMethod_test(HashMap<String, String> data) {
        WebService rest = Ws.put(ServiceGroup.SUPPLIER, CreateSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
}
