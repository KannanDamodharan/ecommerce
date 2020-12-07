package com.example.demo;



import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@Data
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DemoApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getOrderTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/order/1")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        log.info("test log getOrderTest - " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void cancelOrderTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/cancelOrder/1")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        log.info("test log cancelOrderTest - " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void sampleOrderTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/createData")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        log.info("test log sampleOrderTest - " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void createOrderTest() throws Exception {
        String str = "{\"orderId\":null,\"orderStatus\":\"Order Received\",\"orderCustomerId\":1234,\"orderShippingCharges\":74.6,\"orderTotal\":1294.55,\"itemEntityList\":[{\"itemId\":1,\"orderItemName\":\"Ipad\",\"orderItemQty\":10,\"orderSubtotal\":3223.2,\"orderTax\":212.9,\"updatedTime\":null,\"isCancel\":null},{\"itemId\":2,\"orderItemName\":\"Ipad2\",\"orderItemQty\":3,\"orderSubtotal\":333.2,\"orderTax\":26.9,\"updatedTime\":null,\"isCancel\":null}],\"addressEntity\":[{\"addressId\":1,\"orderShippingAddressline1\":\"4 Mozart Street\",\"orderShippingAddressline2\":\"\",\"orderCity\":\"Binghamton\",\"orderState\":\"New York\",\"orderZip\":\"13905\",\"addressType\":\"shipping\",\"updatedTime\":null},{\"addressId\":2,\"orderShippingAddressline1\":\"4 Mozart Street\",\"orderShippingAddressline2\":\"\",\"orderCity\":\"Binghamton\",\"orderState\":\"New York\",\"orderZip\":\"13905\",\"addressType\":\"billing\",\"updatedTime\":null}],\"paymentEntityList\":[{\"paymentId\":1,\"orderPaymentMethod\":null,\"orderPaymentDate\":null,\"orderPaymentConfirmationNumber\":1231},{\"paymentId\":2,\"orderPaymentMethod\":null,\"orderPaymentDate\":null,\"orderPaymentConfirmationNumber\":74665}]}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/createOrder")
                .contentType(MediaType.APPLICATION_JSON).content(str))
                .andExpect(status().isCreated()).andReturn();

        log.info("test log createOrderTest - " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void updateOrderTest() throws Exception {
        String str = "{\"orderId\":null,\"orderStatus\":\"Order Received\",\"orderCustomerId\":1234,\"orderShippingCharges\":74.6,\"orderTotal\":1294.55,\"itemEntityList\":[{\"itemId\":1,\"orderItemName\":\"Ipad\",\"orderItemQty\":10,\"orderSubtotal\":3223.2,\"orderTax\":212.9,\"updatedTime\":null,\"isCancel\":null},{\"itemId\":2,\"orderItemName\":\"Ipad2\",\"orderItemQty\":3,\"orderSubtotal\":333.2,\"orderTax\":26.9,\"updatedTime\":null,\"isCancel\":null}],\"addressEntity\":[{\"addressId\":1,\"orderShippingAddressline1\":\"4 Mozart Street\",\"orderShippingAddressline2\":\"\",\"orderCity\":\"Binghamton\",\"orderState\":\"New York\",\"orderZip\":\"13905\",\"addressType\":\"shipping\",\"updatedTime\":null},{\"addressId\":2,\"orderShippingAddressline1\":\"4 Mozart Street\",\"orderShippingAddressline2\":\"\",\"orderCity\":\"Binghamton\",\"orderState\":\"New York\",\"orderZip\":\"13905\",\"addressType\":\"billing\",\"updatedTime\":null}],\"paymentEntityList\":[{\"paymentId\":1,\"orderPaymentMethod\":null,\"orderPaymentDate\":null,\"orderPaymentConfirmationNumber\":1231},{\"paymentId\":2,\"orderPaymentMethod\":null,\"orderPaymentDate\":null,\"orderPaymentConfirmationNumber\":74665}]}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/update")
                .contentType(MediaType.APPLICATION_JSON).content(str))
                .andExpect(status().isCreated()).andReturn();

        log.info("test log updateOrderTest - " + mvcResult.getResponse().getContentAsString());
    }


}