package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InfoServletTest {

    @Test
    public void testDoGet_returnsGroupInfo() throws Exception {
        // Mock request and response
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Capture the output written to response
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        // Call the servlet
        InfoServlet servlet = new InfoServlet();
        servlet.doGet(request, response);

        writer.flush(); // flush to make sure all data is written

        String output = stringWriter.toString();

        // Basic assertions
        assertTrue(output.contains("Thông tin nhóm"));
        assertTrue(output.contains("Nguyễn Thị A"));
        assertTrue(output.contains("Trần Thị B"));
        assertTrue(output.contains("Lê Văn C"));
    }
}