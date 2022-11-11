package logica.clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.GregorianCalendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ComprobanteInscripcion{
	
	public ComprobanteInscripcion(){
		
	}
	
	public byte[] generar(String nombre, String actividad, String salida, GregorianCalendar fechaSalida, int cantTuristas) throws DocumentException, IOException {
		
		// 1. Create document
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        // 2. Create PdfWriter
        PdfWriter.getInstance(document, new FileOutputStream(salida + ".pdf"));

        // 3. Open document
        document.open();

        // 4. Add content
        document.add(new Paragraph(nombre + actividad + salida));

        // 5. Close document
        document.close();
        
        // 6. Convert to byte[]
        Path pdfPath = Paths.get(salida + ".pdf");
        byte[] pdf = Files.readAllBytes(pdfPath);
        
        return pdf;
	}
}