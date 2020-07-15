package com.physter.breakfest.camel;

import com.physter.breakfest.model.Comment;
import com.physter.breakfest.service.CommentService;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCamelExampleTests {

	@Produce(uri = "direct:getComments")
	private ProducerTemplate producerGetInfo;

	@Produce(uri = "direct:saveComment")
	private ProducerTemplate saveComment;

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private CommentService commentService;

	@Test
	public void testBasicInformation() {
		Exchange exchange = producerGetInfo.send(new DefaultExchange(camelContext));
		Assert.assertEquals(0, exchange.getIn().getBody(List.class).size());

		Comment commentDto = new Comment();
		commentDto.setName("Test User");
		commentDto.setComment("Comment");
		commentService.saveDto(commentDto);
		exchange = producerGetInfo.send(new DefaultExchange(camelContext));
		Assert.assertEquals(1, exchange.getIn().getBody(List.class).size());

		Exchange saveCommentExchange = new DefaultExchange(camelContext);
		saveCommentExchange.getIn().setBody(commentDto);
		saveComment.send(saveCommentExchange);
		//GET data
		exchange = producerGetInfo.send(new DefaultExchange(camelContext));
		Assert.assertEquals(1, exchange.getIn().getBody(List.class).size());


	}

	

}
