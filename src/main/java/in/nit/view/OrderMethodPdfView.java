package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.OrderMethod;
import in.nit.model.ShipmentType;

public class OrderMethodPdfView extends AbstractPdfView{

	
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition","attachment;filename=order.pdf");
		//create element
		Paragraph p=new Paragraph("WELCOME TO ORDER METHOD");
		//add element to document
		document.add(p);
		//read data from model
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		//creating table with number of columns
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
	    t.addCell("MODE");
	    t.addCell("CODE");
		t.addCell("TYPE");
		t.addCell("ACCEPT");
		t.addCell("NOTE");
		
		//adding data to table
		for(OrderMethod om:list) {
			t.addCell(om.getOrderId().toString());
			t.addCell(om.getOrderMode());
			t.addCell(om.getOrderCode());
			t.addCell(om.getOrderType());
			t.addCell(om.getOrderAcpt().toString());
			t.addCell(om.getDescription());

		}
		//add table to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));

		
	}

}

