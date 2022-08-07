package secondary.customerService;

import com.google.gson.Gson;
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
 * This class will provides Negative Scenarios for create New Customer Representative APIs
 * @author Dharini H M
 */
public class CreateCustomerRepresentativeNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerRepresentativeNegative. class);
    public static final String SERVICE_NAME = "createCustomerRepresentative";

    //Pass existing phone number for customer representative creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass existing phone number for customer representative creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerRepresentativeNegative.SERVICE_NAME, testName = "createCustomerRepWithExistingPh", testGroup = "p1")
    public void createCustomerRepWithExistingPhTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerRepresentativeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "customer representative is created with existing phone number");
    }

    //Pass Invalid customer ID for customer representative creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid customer ID for customer representative creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerRepresentativeNegative.SERVICE_NAME, testName = "createCustomerRepWithInvalidCustAliasId", testGroup = "p1",
    attributeName = "phoneNumber",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NUMERIC)
    public void createCustomerRepWithInvalidCustAliasIdTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerRepresentativeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass Invalid customer site ID for customer representative creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid customer site ID for customer representative creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerRepresentativeNegative.SERVICE_NAME, testName = "createCustomerRepWithInvalidCustSiteAliasId", testGroup = "p1",
            attributeName = "phoneNumber",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NUMERIC)
    public void createCustomerRepWithInvalidCustSiteAliasIdTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerRepresentativeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass Invalid customer Office ID for customer representative creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Invalid customer Office ID for customer representative creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerRepresentativeNegative.SERVICE_NAME, testName = "createCustomerRepWithInvalidCustBranchAliasId", testGroup = "p1",
            attributeName = "phoneNumber",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NUMERIC)
    public void createCustomerRepWithInvalidCustBranchAliasIdTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerRepresentativeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass Mandatory fields as empty for customer representative creation
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Mandatory fields as empty for customer representative creation")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerRepresentativeNegative.SERVICE_NAME, testName = "createCustomerRepresentative", testGroup = "p0",
            attributeName = "phoneNumber",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void createCustomerRepWithMandateFieldEmptyTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerRepresentativeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }

/* //Pass Invalid datatype as phone number for Customer rep creation
 //accepting characters as phone number and getting 200 (defect)
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator" )
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = CreateCustomerRepresentativeNegative.SERVICE_NAME, testName = "createCustomerRepresentative", testGroup = "p0",
            attributeName = "phoneNumber",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.ALPHABET)
    public void createCustomerRepWithMandateFieldWithInvalidDataTest(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.CUSTOMER, CreateCustomerRepresentativeNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }*/
}