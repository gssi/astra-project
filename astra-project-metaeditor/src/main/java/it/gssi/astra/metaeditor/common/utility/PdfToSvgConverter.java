package it.gssi.astra.metaeditor.common.utility;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;


public class PdfToSvgConverter {
	
	
	public  void extractBookSvg(File pdfFile, String path) throws Exception {
	    // ... preliminary business actions

	    SVGGeneratorContext ctx = createContext();
	    SVGGraphics2D g = null;

	    try (PDDocument document = PDDocument.load(pdfFile, MemoryUsageSetting.setupMixed(2147483648l))) {
	        PDFRenderer renderer = new PDFRenderer(document);

	        long startTime = System.currentTimeMillis();
	        int pageNr = 0;
	        for (PDPage page : document.getPages()) {
	            long startTimeForPage = System.currentTimeMillis();

	            g = createGraphics(ctx);
	            renderer.renderPageToGraphics(pageNr, g, 3.47222f);

	            pageNr++;
	            try (OutputStream os = new ByteArrayOutputStream();
	            		OutputStream outputStream = new FileOutputStream(new File(path+"Image.svg"));
	                    Writer out= new OutputStreamWriter(outputStream, "UTF-8");) {

	                g.stream(out, true);
	         

	                //... do other business actions 
	            }
	        }
	    }
	    finally {
	       

	        if (g != null) {
	            g.finalize();
	            g.dispose();
	        }
	    }
	}

	private SVGGraphics2D createGraphics(SVGGeneratorContext ctx) {
	    SVGGraphics2D g2d = new CustomSVGGraphics2D(ctx, false);
	    return g2d;
	}

	private SVGGeneratorContext createContext() {
	    DOMImplementation impl = GenericDOMImplementation.getDOMImplementation();
	    String svgNS = "http://www.w3.org/2000/svg";
	    Document myFactory = impl.createDocument(svgNS, "svg", null);

	    SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(myFactory);
	    return ctx;
	}

	public static class CustomSVGGraphics2D extends SVGGraphics2D {

	    public CustomSVGGraphics2D(SVGGeneratorContext generatorCtx, boolean textAsShapes) {
	        super(generatorCtx, textAsShapes);
	    }

	    @Override
	    public GraphicsConfiguration getDeviceConfiguration() {
	        return new CustomGraphicsConfiguration();
	    }
	}

	private static final class CustomGraphicsConfiguration extends GraphicsConfiguration {

	    @Override
	    public AffineTransform getNormalizingTransform() {
	        return null;
	    }

	    @Override
	    public GraphicsDevice getDevice() {
	        return new CustomGraphicsDevice();
	    }

	    @Override
	    public AffineTransform getDefaultTransform() {
	        return null;
	    }

	    @Override
	    public ColorModel getColorModel(int transparency) {
	        return null;
	    }

	    @Override
	    public ColorModel getColorModel() {
	        return null;
	    }

	    @Override
	    public java.awt.Rectangle getBounds() {
	        return null;
	    }
	}

	private static final class CustomGraphicsDevice extends GraphicsDevice {
	    @Override
	    public int getType() {
	        return 0;
	    }

	    @Override
	    public String getIDstring() {
	        return null;
	    }

	    @Override
	    public GraphicsConfiguration[] getConfigurations() {
	        return null;
	    }

	    @Override
	    public GraphicsConfiguration getDefaultConfiguration() {
	        return null;
	    }
	}
}
