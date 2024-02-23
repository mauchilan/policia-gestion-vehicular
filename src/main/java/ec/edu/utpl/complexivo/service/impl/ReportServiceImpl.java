package ec.edu.utpl.complexivo.service.impl;

import ec.edu.utpl.complexivo.reports.OrdenReport;
import ec.edu.utpl.complexivo.service.ReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public byte[] getOrdenes() {
        return OrdenReport.build();
    }
}
