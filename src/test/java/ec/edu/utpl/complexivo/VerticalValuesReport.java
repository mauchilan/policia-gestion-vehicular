package ec.edu.utpl.complexivo;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.Date;

import ec.edu.utpl.complexivo.util.Templates;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ComponentColumnBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class VerticalValuesReport {

    public VerticalValuesReport() {
        build();
    }

    private void build() {
        StyleBuilder nameStyle = stl.style().bold();
        StyleBuilder valueStyle = stl.style().setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);

        FieldBuilder<String> itemField = field("item", type.stringType());
        FieldBuilder<Integer> quantityField = field("quantity", type.integerType());
        FieldBuilder<BigDecimal> unitPriceField = field("unitprice", type.bigDecimalType());
        FieldBuilder<Date> orderDateField = field("orderdate", type.dateType());

        VerticalListBuilder nameList = cmp.verticalList(
                cmp.text("Item:").setStyle(nameStyle),
                cmp.text("Quantity:").setStyle(nameStyle),
                cmp.text("Unit price:").setStyle(nameStyle),
                cmp.text("Order date:").setStyle(nameStyle));
        VerticalListBuilder valueList = cmp.verticalList(
                cmp.text(itemField).setStyle(valueStyle),
                cmp.text(quantityField).setStyle(valueStyle),
                cmp.text(unitPriceField).setStyle(valueStyle),
                cmp.text(orderDateField).setStyle(valueStyle));

        ComponentColumnBuilder nameColumn = col.componentColumn("Name", nameList);
        ComponentColumnBuilder valueColumn = col.componentColumn("Value", valueList);

        AggregationSubtotalBuilder<BigDecimal> unitPriceSum = sbt.sum(unitPriceField, valueColumn)
                .setLabel("Unit price sum =");

        try {
            JasperPrint jasperPrint = report()
                    .setTemplate(Templates.reportTemplate)
                    .setPageFormat(PageType.A4)
                    .fields(itemField, quantityField, unitPriceField, orderDateField)
                    .columns(nameColumn, valueColumn)
                    .subtotalsAtSummary(unitPriceSum)
                    .title(Templates.createTitleComponent("Policia Nacional"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .toJasperPrint();
            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            JRPdfExporter jrPdfExporter = new JRPdfExporter();
            jrPdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrPdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, pdfOutputStream);
            jrPdfExporter.exportReport();
            System.out.println(pdfOutputStream.toByteArray());
        } catch (DRException | JRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("Notebook", new Date(), 1, new BigDecimal(500));
        dataSource.add("Book", new Date(), 4, new BigDecimal(25));
        dataSource.add("PDA", new Date(), 2, new BigDecimal(120));
        return dataSource;
    }

    public static void main(String[] args) {
        new VerticalValuesReport();
    }

}
