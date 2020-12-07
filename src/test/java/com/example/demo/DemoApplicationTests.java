package com.example.demo;



import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
        String str = "{\"orderId\":null,\"orderStatus\":\"Received\",\"orderCustomerId\":1234,\"orderShippingCharges\":74.6,\"orderTotal\":1294.55,\"itemEntityList\":[{\"itemId\":null,\"orderItemName\":\"Ipad\",\"orderItemQty\":10,\"orderSubtotal\":3223.2,\"orderTax\":212.9,\"updatedTime\":null,\"isCancel\":null},{\"itemId\":null,\"orderItemName\":\"Ipad2\",\"orderItemQty\":3,\"orderSubtotal\":333.2,\"orderTax\":26.9,\"updatedTime\":null,\"isCancel\":null}],\"addressEntity\":[{\"addressId\":null,\"orderShippingAddressline1\":\"4 Mozart Street\",\"orderShippingAddressline2\":\"\",\"orderCity\":\"Binghamton\",\"orderState\":\"New York\",\"orderZip\":\"13905\",\"addressType\":\"shipping\",\"updatedTime\":null},{\"addressId\":null,\"orderShippingAddressline1\":\"4 Mozart Street\",\"orderShippingAddressline2\":\"\",\"orderCity\":\"Binghamton\",\"orderState\":\"New York\",\"orderZip\":\"13905\",\"addressType\":\"billing\",\"updatedTime\":null}],\"paymentEntityList\":[{\"paymentId\":null,\"orderPaymentMethod\":null,\"orderPaymentDate\":null,\"orderPaymentConfirmationNumber\":1231},{\"paymentId\":null,\"orderPaymentMethod\":null,\"orderPaymentDate\":null,\"orderPaymentConfirmationNumber\":74665}]}";
        /*MvcResult mvcResult = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.post("/createOrder")
                .contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());*/

        MvcResult mvcResult =  (MvcResult) mockMvc.perform(
                MockMvcRequestBuilders.post("/createOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(str))
                .andExpect(status().isCreated());


        log.info("test log createOrderTest - " + mvcResult.getResponse().getContentAsString());
    }


}
    /*@LocalServerPort
    private int port;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    private OrderController orderController;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private JpaRepository<OrderEntity, Integer> repo;

    @Test
    public void testGetOrderId() throws Exception{
        log.info("inside testGet");
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/order/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "null ";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void addCourse() {
        //JSONAssert.assertEquals(1, , false);
       *//* OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
        HttpEntity<OrderDetailsDTO> entity = new HttpEntity<OrderDetailsDTO>(orderDetailsDTO, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/createOrder"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("createOrder"));*//*
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }*/

