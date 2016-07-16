package cn.shhuifu.analyse.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/tool")
@Scope("prototype")
public class ToolController {

    /**
     * 文件送回
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/file_send_back", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseEntity<byte[]> sendBack(HttpServletRequest httpServletRequest) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "my-data.csv");
        String data = httpServletRequest.getParameter("CSV_TEXT");
        return new ResponseEntity(data.getBytes(), headers, HttpStatus.CREATED);
    }
}
