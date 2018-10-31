/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mii.cvonlinerestserver.models.Lain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nande
 */
public class getData {
    
    final static String REST_SERVICE_URI = "http://localhost:8080/CvOnline/lains";
    
    public static void main(String[] args) {
        getAll();
    }
    
    public static void getAll() {
        try {

            RestTemplate restTemplate = new RestTemplate();
//            List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);

            List<HttpMessageConverter<?>> messageConverterList = restTemplate
                    .getMessageConverters();

            // Add MappingJackson2HttpMessageConverter and MarshallingHttpMessageConverter to the messageConverterList
            MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
            XStreamMarshaller marshaller = new XStreamMarshaller();
            MarshallingHttpMessageConverter marshallingConverter = new MarshallingHttpMessageConverter(marshaller);
            messageConverterList.add(jsonMessageConverter);
            messageConverterList.add(marshallingConverter);
            restTemplate.setMessageConverters(messageConverterList);

            // Prepare HTTPHeaders
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            /* headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML)); */

            // Prepare HttpEntity
            HttpEntity<String> entity = new HttpEntity<String>(headers);

            // Invoke the REST service
            ResponseEntity<String> result = restTemplate.exchange(REST_SERVICE_URI,
                    HttpMethod.GET, entity, String.class, "Rajesh");

//            System.out.println("\n\ndari normal \n"+ result.getBody() + "\n\n");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Lain> items = objectMapper.readValue(
                    result.getBody(),
                    objectMapper.getTypeFactory().constructParametricType(List.class, Lain.class)
            );
//            System.out.println(items.size());
            for (Lain lain : items) {
                System.out.println("id : " + lain.getIdLain());
                System.out.println("nama : " + lain.getKandidat().getNamaKandidat());
                System.out.println("pertanyaan : " + lain.getPertanyaan().getPertanyaan());
                System.out.println("jawaban : " + lain.getJawaban());
                System.out.println("");
            }
        } catch (Exception e) {
            String msg = e.getMessage();
            String err = msg;
        }
    }
}

