package it.gssi.astra.metaeditor.common.utility;

import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.interfaces.IExport;
import it.gssi.astra.metaeditor.common.popup.Popup;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Export  implements IExport{

	static Export instance;
	
	public static void setInstance(Export instance) {
		Export.instance = instance;
	}
	
	public static Export getInstance() {

		if (instance == null) {
			instance = new Export();
		}

		return instance;
	}
	/**
	 * This function export the canvas in PNG, PDF and SVG format into a specific
	 * path
	 * 
	 * @param paths  to save file
	 * @param canvas to export
	 */
	@Override
	public void export() {
		List<String> paths = Popup.export(LayoutScene.getInstance());
		if (paths != null) {

			WritableImage wim = new WritableImage(
					(int) LayoutScene.getInstance().getCanvas().getBoundsInParent().getWidth(),
					(int) Math.ceil(LayoutScene.getInstance().getCanvas().getBoundsInParent().getHeight()));

			SnapshotParameters parameters = new SnapshotParameters();

			parameters.setFill(Color.TRANSPARENT);

			LayoutScene.getInstance().getCanvas().snapshot(parameters, wim);

			File filePNG = new File(paths.get(0) + File.separator + paths.get(1) + ".png");

			try {
				ImageIO.write(SwingFXUtils.fromFXImage(wim, null), "png", filePNG);
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}

			com.itextpdf.text.Rectangle l = new com.itextpdf.text.Rectangle(
					(int) LayoutScene.getInstance().getCanvas().getBoundsInParent().getWidth(),
					(int) LayoutScene.getInstance().getCanvas().getBoundsInParent().getHeight());
			com.itextpdf.text.Document doc = new com.itextpdf.text.Document(l, 0, 0, 0, 0);

			try {
				doc.newPage();
				PdfWriter.getInstance(doc, new FileOutputStream(paths.get(0) + File.separator + paths.get(1) + ".pdf"));
			} catch (FileNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (DocumentException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			doc.open();
			Image image = null;
			try {
				image = Image.getInstance(filePNG.getAbsolutePath());
			} catch (BadElementException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (MalformedURLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				doc.add(image);
			} catch (DocumentException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			doc.close();

			File filePDF = new File(paths.get(0) + File.separator + paths.get(1) + ".pdf");

			PDDocument document = null;
			try {
				document = PDDocument.load(filePDF);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			PDFPrintable p = new PDFPrintable(document);
			DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();

			// Create an instance of org.w3c.dom.Document.
			String svgNS = "http://www.w3.org/2000/svg";
			Document svgDocument = domImpl.createDocument(svgNS, "svg", null);

			SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(svgDocument);
			ctx.setEmbeddedFontsOn(true);

			// Ask the test to render into the SVG Graphics2D implementation.

			for (int i = 0; i < document.getNumberOfPages(); i++) {
				String svgFName = paths.get(0) + File.separator + paths.get(1) + ".svg";
				try {
					(new File(svgFName)).createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// Create an instance of the SVG Generator.
				SVGGraphics2D svgGenerator = new SVGGraphics2D(ctx, false);

				try {
					p.print(svgGenerator, new PageFormat(), i);
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					svgGenerator.stream(svgFName);
				} catch (SVGGraphics2DIOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			try {
				document.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
