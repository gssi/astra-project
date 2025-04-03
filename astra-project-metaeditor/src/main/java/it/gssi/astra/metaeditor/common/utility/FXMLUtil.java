package it.gssi.astra.metaeditor.common.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EAttributeImpl;

import com.sun.javafx.fxml.BeanAdapter;

import it.gssi.astra.metaeditor.common.ente.customNode.CustomRectangle;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class FXMLUtil {

	public static <T> FXMLLoader loadFXML(T component, String path) {

		if (path == " " || path == "" || !(component.getClass().getResource(path) != null)) {
			path = EditorProperties.get("default.fxml");
		}
		
		FXMLLoader fxmlLoader = new FXMLLoader(component.getClass().getResource(path));

		fxmlLoader.setRoot(component);
		fxmlLoader.setController(component);
		fxmlLoader.setClassLoader(component.getClass().getClassLoader());

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		return fxmlLoader;
	}

	public static List<FXMLeAttribute> addChangeHandler(EObject model, FXMLLoader fxmlLoader) {

		
		if(fxmlLoader != null) {
			List<FXMLeAttribute> ecoreAttributes = parseFXML(fxmlLoader.getLocation(), fxmlLoader.getRoot());
			

			EClass metaclass = model.eClass();
			EList<EStructuralFeature> featuresList = metaclass.getEStructuralFeatures();
			if (!featuresList.isEmpty()) {
				for (EStructuralFeature feature : featuresList) {
					if (feature instanceof EAttributeImpl) {
						setBeanAttributes(ecoreAttributes, feature.getName(), model.eGet(feature));
					}
				}
			}

			model.eAdapters().add(new AdapterImpl() {
				public void notifyChanged(Notification notification) {

					if (notification.getFeature() instanceof EAttributeImpl) {

						String changedField = ((EAttributeImpl) notification.getFeature()).getName();
						Object newValue = notification.getNewValue();

						setBeanAttributes(ecoreAttributes, changedField, newValue);
					}
				}

			});	
			return ecoreAttributes;
		}
		return new ArrayList<FXMLeAttribute>();		
		
	}

	public static void setBeanAttributes(List<FXMLeAttribute> ecoreAttributes, String changedField, Object newValue) {

		FXMLeAttribute eAttribute = new FXMLeAttribute(changedField);

		if (ecoreAttributes.contains(eAttribute)) {
			Map<Node, List<String>> nodes = ecoreAttributes.get(ecoreAttributes.indexOf(eAttribute)).getFXMLNodes();

			if (nodes != null) {
				for (Node node : nodes.keySet()) {
					
					for (String propertyName : nodes.get(node)) {

						BeanAdapter targetAdapter = new BeanAdapter(node);

						Class<?> type = targetAdapter.getType(propertyName);

						if (newValue instanceof Enum)
							newValue = ((Enum<?>) newValue).toString();

						Object newPropertyValue = BeanAdapter.coerce(newValue, type);

						targetAdapter.put(propertyName, newPropertyValue);
					}
				}
			}
		}
	}

	private static void addAllDescendents(Parent parent, List<Node> nodes) {
		for (Node node : parent.getChildrenUnmodifiable()) {
			nodes.add(node);
			if (node instanceof Parent && !(node instanceof CustomRectangle))
				addAllDescendents((Parent) node, nodes);
		}
	}

	public static List<FXMLeAttribute> parseFXML(URL location, Parent root) {

		List<FXMLeAttribute> FXMLecoreAttributes = new ArrayList<>();

		List<Node> nodes = new ArrayList<Node>();
		nodes.add(root);
		addAllDescendents(root, nodes);

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		xmlInputFactory.setProperty("javax.xml.stream.isCoalescing", true);

		InputStream inputStream;
		try {
			inputStream = location.openStream();

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

			xmlStreamReader = new StreamReaderDelegate(xmlInputFactory.createXMLStreamReader(inputStreamReader)) {
				@Override
				public String getPrefix() {
					String prefix = super.getPrefix();

					if (prefix != null && prefix.length() == 0) {
						prefix = null;
					}

					return prefix;
				}

				@Override
				public String getAttributePrefix(int index) {
					String attributePrefix = super.getAttributePrefix(index);

					if (attributePrefix != null && attributePrefix.length() == 0) {
						attributePrefix = null;
					}

					return attributePrefix;
				}
			};

			int counter = 0;

			while (xmlStreamReader.hasNext()) {
				int event = xmlStreamReader.next();

				switch (event) {
				case XMLStreamReader.START_ELEMENT:

					if (xmlStreamReader.getLocalName().equals("root")) {
						counter++;
						break;
					}

					if (root.lookup(xmlStreamReader.getLocalName()) != null) {

						for (int i = 0, n = xmlStreamReader.getAttributeCount(); i < n; i++) {

							String localName = xmlStreamReader.getAttributeLocalName(i);
							String value = xmlStreamReader.getAttributeValue(i);

							if (isBindingExpression(value)) {
								value = value.substring(BINDING_EXPRESSION_PREFIX.length(), value.length() - 1);
								value = value.replace("Color", "");
								FXMLeAttribute fea = new FXMLeAttribute(value);

								// Associate ecore model attributes to FXML properties
								if (!FXMLecoreAttributes.contains(fea)) {
									fea.addNodeProperty(nodes.get(counter), localName);
									FXMLecoreAttributes.add(fea);
								} else {
									int index = FXMLecoreAttributes.indexOf(fea);
									FXMLecoreAttributes.get(index).addNodeProperty(nodes.get(counter), localName);
								}

								// Clear default JavaFX binding
								BeanAdapter targetAdapter = new BeanAdapter(nodes.get(counter));
								ObservableValue<Object> p = targetAdapter.getPropertyModel(localName);
								Property<Object> property = (Property<Object>) p;
								property.unbind();
							}
						}

						counter++;
					}

					break;
				}
			}

		} catch (IOException | XMLStreamException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return FXMLecoreAttributes;
	}

	public static String getId(XMLStreamReader xmlStreamReader) {
		for (int i = 0, n = xmlStreamReader.getAttributeCount(); i < n; i++) {
			if (xmlStreamReader.getAttributeLocalName(i) == "id") {
				return xmlStreamReader.getAttributeValue(i);
			}
		}
		return null;
	}
	
	/**
	 * Helper to toggle visibility of subcomponents of the FXML.
	 * 
	 * @param node
	 * @param value
	 */
	public static void nodeVisibility(Node node, boolean value) {
		node.setVisible(value);
		node.setManaged(value);
	}

	private static XMLStreamReader xmlStreamReader;

	private static boolean isBindingExpression(String aValue) {
		return aValue.startsWith(BINDING_EXPRESSION_PREFIX) && aValue.endsWith(BINDING_EXPRESSION_SUFFIX);
	}

	public static final String BINDING_EXPRESSION_PREFIX = "${";

	public static final String BINDING_EXPRESSION_SUFFIX = "}";
}