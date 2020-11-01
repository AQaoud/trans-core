package com.pos.transValidator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pos.transValidator.com.pos.transValidator.ValidationManager;
import com.pos.transValidator.com.pos.transValidator.bean.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

class TransValidatorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test_validation() throws IOException {
        String json = "{\n" +
				"    \"_id\" : \"589c493e5f2687111bb6d800\",\n" +
                "    \"business_id\" : \"3f522ee8-7e69-4d78-aeb5-5278aaf21558\",\n" +
                "    \"location_id\" : \"96e9975b-b1bf-47ee-aeaf-63518022e95e\",\n" +
                "    \"transaction_id\" : \"37a5f57a-48bc-483d-91b7-88c8b1b9509c\",\n" +
                "    \"receipt_id\" : \"Cj9uohMQNVflSq7taYtVRk\",\n" +
                "    \"serial_number\" : \"C1-498\",\n" +
                "    \"dining_option\" : \"In-House\",\n" +
                "    \"creation_time\" : \"2017-02-09T10:49:34.000Z\",\n" +
                "    \"discount_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"additive_tax_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"inclusive_tax_money\" : {\n" +
                "        \"amount\" : 483,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"refunded_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"tax_money\" : {\n" +
                "        \"amount\" : 483,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"tip_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"total_collected_money\" : {\n" +
                "        \"amount\" : 3500,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"creator\" : {\n" +
                "        \"id\" : \"00000000-0000-0000-0000-000000000000\",\n" +
                "        \"name\" : \"John Doe\",\n" +
                "        \"email\" : \"anonymous@example.com\"\n" +
                "    },\n" +
                "    \"tender\" : {\n" +
                "        \"type\" : \"CASH\",\n" +
                "        \"name\" : \"CASH\",\n" +
                "        \"total_money\" : {\n" +
                "            \"amount\" : 3500,\n" +
                "            \"currency\" : \"JOD\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"taxes\" : [ \n" +
                "        {\n" +
                "            \"id\" : \"cfc92a12-f847-4942-b6ec-1454d194c9ba\",\n" +
                "            \"name\" : \"Sales Tax\",\n" +
                "            \"rate\" : 0.16,\n" +
                "            \"inclusion_type\" : \"INCLUSIVE\",\n" +
                "            \"is_custom_amount\" : true,\n" +
                "            \"applied_money\" : {\n" +
                "                \"amount\" : 483,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"itemization\" : [ \n" +
                "        {\n" +
                "            \"id\" : \"788cb9cb-106f-4d32-ac48-df9e8433ff50\",\n" +
                "            \"name\" : \"Boneless Chicken Wings\",\n" +
                "            \"quantity\" : 1,\n" +
                "            \"total_money\" : {\n" +
                "                \"amount\" : 3500,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"single_quantity_money\" : {\n" +
                "                \"amount\" : 3500,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"gross_sales_money\" : {\n" +
                "                \"amount\" : 3017,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"discount_money\" : {\n" +
                "                \"amount\" : 0,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"net_sales_money\" : {\n" +
                "                \"amount\" : -3017,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"category\" : {\n" +
                "                \"id\" : \"a9895c94-15cc-4db1-bbad-fe62d218c931\",\n" +
                "                \"name\" : \"Appetizers\"\n" +
                "            },\n" +
                "            \"variation\" : {\n" +
                "                \"id\" : \"37b64192-6b0f-479d-aeee-3c382a0671b9\",\n" +
                "                \"name\" : \"Plate\",\n" +
                "                \"pricing_type\" : \"FIXED\",\n" +
                "                \"price_money\" : {\n" +
                "                    \"amount\" : 3500,\n" +
                "                    \"currency\" : \"JOD\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"taxes\" : [ \n" +
                "                {\n" +
                "                    \"id\" : \"cfc92a12-f847-4942-b6ec-1454d194c9ba\",\n" +
                "                    \"name\" : \"Sales Tax\",\n" +
                "                    \"rate\" : 0.16,\n" +
                "                    \"inclusion_type\" : \"INCLUSIVE\",\n" +
                "                    \"is_custom_amount\" : true,\n" +
                "                    \"applied_money\" : {\n" +
                "                        \"amount\" : 483,\n" +
                "                        \"currency\" : \"JOD\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"discounts\" : [],\n" +
                "            \"modifiers\" : [ \n" +
                "                {\n" +
                "                    \"id\" : \"7424ae3d-36bc-4c0c-b790-310614905aed\",\n" +
                "                    \"name\" : \"6 Pieces\",\n" +
                "                    \"quantity\" : 1,\n" +
                "                    \"applied_money\" : {\n" +
                "                        \"amount\" : 0,\n" +
                "                        \"currency\" : \"JOD\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        Transaction trans = mapper.readValue(json, Transaction.class);
        Set<ConstraintViolation<Transaction>> constraintViolations = ValidationManager.validate(trans);
        if (!constraintViolations.isEmpty()) {
            constraintViolations.stream().forEach(v ->
                    System.out.println(v)


            );
        }
    }


}
