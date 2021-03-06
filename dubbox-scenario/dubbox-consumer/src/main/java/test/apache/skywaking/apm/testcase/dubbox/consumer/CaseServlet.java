package test.apache.skywalking.apm.testcase.dubbox.consumer;

import test.apache.skywalking.apm.testcase.dubbox.services.GreetService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:dubbo-consumer.xml");
        GreetService greetService = applicationContext.getBean(GreetService.class);
        greetService.doBusiness();
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("success");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
