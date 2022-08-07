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
* This class will fetch all pickup location Product services details
* @author Piyal
* */
public class GetPickupLocationProductServicesTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetPickupLocationProductServicesTest.class);
    public static final String SERVICE_NAME = "getPickupLocationProductServices";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "GetPickupLocationProductServicesTest with invalid http method")
    @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = GetPickupLocationProductServicesTest.SERVICE_NAME, testName = "pickuplocationproductservice_valid_data_test", testGroup = "p0")
    public void invalid_HttpMethod_test(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.post(ServiceGroup.SUPPLIER, GetSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 412, "The expected status is " + 412 + ". But actual is " + rest.getStatus() + ".");
        LOG.info("\n" + rest.getResponse().body().prettyPeek());
    }
}
