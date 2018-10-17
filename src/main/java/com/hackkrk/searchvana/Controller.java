package com.hackkrk.searchvana;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(path = "/**", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String response(@RequestBody JsonNode body) {
        System.out.println(body);
        String text = body.get("text").asText();

        final long number = body.get("number").asLong();

        if (number == 1) {
            String decoded = decode(text);
            while (!decoded.contains(" ")) {
                decoded = decode(decoded);
            }
            System.out.println(decoded);
            return decoded;
        }

        if (number == 2) {
            String decoded = decode(text);
            while (!decoded.contains(" ")) {
                decoded = decode(decoded);
            }
            System.out.println(decoded);
            return decoded;
        }

        throw new IllegalStateException("New number!");
    }

    private String decode(String text) {
        try {
            return new String(Base64.decode(text));
        } catch (Exception e) {
            return text;
        }
    }

}
