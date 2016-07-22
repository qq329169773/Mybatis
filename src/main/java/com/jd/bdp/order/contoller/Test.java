package com.jd.bdp.order.contoller;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

 
public class Test {

	public static final String userInfo = "userInfo.vm";
	public static void main(String[] args) {
		/*VelocityEngine ve = new VelocityEngine();
		ve.init();

		Template template = ve.getTemplate(userInfo);
		VelocityContext velocityContext = new VelocityContext();
		Users user = new Users();
		velocityContext.put("users", user);
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);

		System.out.println(stringWriter.toString());*/
	}
}
