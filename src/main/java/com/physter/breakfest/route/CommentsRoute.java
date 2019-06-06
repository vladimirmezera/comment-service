package com.physter.breakfest.route;

import com.physter.breakfest.dto.CommentDto;
import com.physter.breakfest.service.CommentService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  Comment route
 */
@Component
public class CommentsRoute extends RouteBuilder {

    @Autowired
    private CommentService commentService;

    @Override
    public void configure() throws Exception {

        from("direct:getComments").process(exchange -> {
            exchange.getIn().setBody(commentService.getCommentList());
        }).routeId("getComments");

        from("direct:saveComment").process(exchange -> {
            System.out.println("Process" + exchange.getIn().getBody());
           commentService.saveDto(exchange.getIn().getBody(CommentDto.class));
        }).routeId("saveComment");

    }
}
