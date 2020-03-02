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
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.Uom;

public class UomPdfView extends AbstractPdfView{
protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
	//download file
	response.addHeader("Content-Disposition","attachment;filename=uom.pdf");
	//create element
	Paragraph p=new Paragraph("WELCOME TO UOM");
	//add element to document
	document.add(p);
	//read data from model
	List<Uom> list=(List<Uom>)model.get("list");
	//creating table with number of columns
	PdfPTable t=new PdfPTable(4);
	t.addCell("ID");
	t.addCell("TYPE");
	t.addCell("MODEL");
	t.addCell("NOTE");
	//adding data to table
	for(Uom um:list) {
		t.addCell(um.getUomId().toString());
		t.addCell(um.getUomType());
		t.addCell(um.getUomModel());
		t.addCell(um.getUomDesc());
	}
	//add table to document
	document.add(t);
	//print date and time
	document.add(new Paragraph(new Date().toString()));
	
}
}
