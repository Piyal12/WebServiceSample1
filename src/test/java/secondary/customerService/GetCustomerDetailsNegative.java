package secondary.customerService;

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
 *
 * This class will provides Negative Scenarios for Get customer Details using customer ID
 * @author Dharini H M
 */
public class GetCustomerDetailsNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerDetailsNegative.class);
    public static final String SERVICE_NAME = "getCustomerDetails";


    //Pass Invalid Http method to fetch customer details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Http method to fetch customer details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerDetailsNegative.SERVICE_NAME, testName = "getCustomerDetails", testGroup = "p0")
    public void getCustomerDetailsByIdForInvalidHttpMethodTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.delete(ServiceGroup.CUSTOMER, GetCustomerDetailsNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Status code: " + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 405, "The expected status is " + 405 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass Invalid Relationship datatype to fetch customer details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Relationship datatype to fetch customer details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerDetailsNegative.SERVICE_NAME,
            testName = "getCustomerDetailsForInvalidRelshipDatatype", testGroup = "p1")
    public void getCustomerDetailsForInvalidRelshipDatatypeTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerDetailsNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Customer details for Invalid Relationship datatype");
    }

    //Pass Invalid Relationship data to fetch customer details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid Relationship data to fetch customer details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerDetailsNegative.SERVICE_NAME,
            testName = "getCustomerDetailsForInvalidRelshipData", testGroup = "p1")
    public void getCustomerDetailsForInvalidRelshipDataTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerDetailsNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Customer details for Invalid Relationship data");
    }


    //Pass null Relationship data to fetch customer details
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass null Relationship data to fetch customer details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetCustomerDetailsNegative.SERVICE_NAME,
            testName = "getCustomerDetailsForInvalidRelshipData", testGroup = "p1", attributeName = "relationshipType", dataConstraint = DataConstraint.FOR_SPECIFIED,
            dataType = DataType.NULL)
    public void getCustomerDetailsForRelshipNullTest(HashMap<String, String> data) throws Exception {
        WebService rest = Ws.get(ServiceGroup.CUSTOMER, GetCustomerDetailsNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Actual Status code: " + rest.getStatus());
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "getting Customer details for Invalid Relationship data");
    }
}