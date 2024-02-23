package ec.edu.utpl.complexivo.api;

import ec.edu.utpl.complexivo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportsApi {

    @Autowired
    private ReportService reportService;

    @GetMapping(path = "/downloadOrder")
    public ResponseEntity<?> downloadFile (){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", MediaType.APPLICATION_PDF_VALUE);
        headers.set("Content-Disposition","attachment; filename=\"orden.pdf\""); // to view in browser change attachment to inline
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reportService.getOrdenes());
    }

}
