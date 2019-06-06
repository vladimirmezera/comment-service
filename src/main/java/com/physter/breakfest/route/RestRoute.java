package com.physter.breakfest.route;

import com.physter.breakfest.dto.CommentDto;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 *  Basic rest route.
 */
@Component
public class RestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        //basic rest configuration
        restConfiguration()
                .contextPath("/").apiContextPath("/api-doc")
                .apiProperty("api.title", "Spring boot camel example REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .bindingMode(RestBindingMode.json);

        rest("").description("Get comments")
                 .consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
                .get("/comments").description("Get comments").to("direct:getComments")
                .post("/comments").description("Save comment").type(CommentDto.class).to("direct:saveComment");



    }
}
