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
 * This class will provide Negative scenarios for update customer Rep details
 * @author Dharini H M
 */
public class EditCustomerRepNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(EditCustomerRepNegative.class);
    public static final String SERVICE_NAME = "editCustomerRep";

    //Pass Mandatory fields as empty for edit customer
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Mandate fields as empty for edit customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = EditCustomerRepNegative.SERVICE_NAME, testName = "editCustomerWithMandateFieldEmpty", testGroup = "p1",
            attributeName = "customerAliasId",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void editCustomerRepWithMandateFieldEmptyTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.CUSTOMER,EditCustomerRepNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass Mandatory fields as Invalid data for edit customer
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass Mandate fields as empty for edit customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = EditCustomerRepNegative.SERVICE_NAME, testName = "editCustomerWithMandateFieldInvalidData", testGroup = "p1")
    public void editCustomerWithMandateFieldInvalidDataTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.CUSTOMER,EditCustomerRepNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }
}