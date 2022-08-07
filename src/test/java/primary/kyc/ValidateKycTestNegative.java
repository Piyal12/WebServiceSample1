package primary.kyc;

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
*This class will fetch only particular Supplier Rep details
* */
public class ValidateKycTestNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(ValidateKycTestNegative.class);
    public static final String SERVICE_NAME = "validateKyc";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "To check if a random number as kyc type to check if it is valid KYC")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = ValidateKycTestNegative.SERVICE_NAME, testName = "validateKyc", testGroup = "p0",dataType= DataType.ALPHA_NUMERIC, dataConstraint= DataConstraint.FOR_SPECIFIED, attributeName="kycType")
    public void PassRandomNumberKycType(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.GROUP5, ValidateKycTestNegative.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Validate KYC Test failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }


    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "To check if a random alphaNumeric as kyc type to check if it is valid KYC")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = ValidateKycTestNegative.SERVICE_NAME, testName = "validateKyc", testGroup = "p0",dataType= DataType.ALPHA_NUMERIC, dataConstraint= DataConstraint.FOR_SPECIFIED, attributeName="kycType")
    public void PassAlphaNumberKycType(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.GROUP5, ValidateKycTestNegative.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Validate KYC Test failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "To check if a random alphanumber is valid KYC")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = ValidateKycTestNegative.SERVICE_NAME, testName = "validateKyc", testGroup = "p0",dataType= DataType.ALPHA_NUMERIC, dataConstraint= DataConstraint.FOR_SPECIFIED, attributeName="$kycIdentificationNo")
    public void PassAlphaNumberKycNumber(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.GROUP5, ValidateKycTestNegative.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Validate KYC Test failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "To check if a random number is valid KYC")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = ValidateKycTestNegative.SERVICE_NAME, testName = "validateKyc", testGroup = "p0",dataType= DataType.NUMERIC, dataConstraint= DataConstraint.FOR_SPECIFIED, attributeName="$kycIdentificationNo")
    public void PassRandomNumberKycNumber(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.GROUP5, ValidateKycTestNegative.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Validate KYC Test failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Passing null values")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = ValidateKycTestNegative.SERVICE_NAME, testName = "validateKyc", testGroup = "p0",dataType= DataType.NUMERIC, dataConstraint= DataConstraint.ONE_BY_ONE)
    public void PassNullValue(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.GROUP5, ValidateKycTestNegative.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Validate KYC Test failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Passing unassigned values")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP5, serviceName = ValidateKycTestNegative.SERVICE_NAME, testName = "validateKyc", testGroup = "p0",dataType= DataType.NUMERIC, dataConstraint= DataConstraint.ONE_BY_ONE)
    public void PassUnassignedValue(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.get(ServiceGroup.GROUP5, ValidateKycTestNegative.SERVICE_NAME, TestBase.ENV, TestBase.TOKEN, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Validate KYC Test failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
