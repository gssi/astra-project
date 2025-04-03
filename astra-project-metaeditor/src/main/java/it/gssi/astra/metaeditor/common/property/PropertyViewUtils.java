package it.gssi.astra.metaeditor.common.property;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import org.controlsfx.property.BeanProperty;

import it.gssi.astra.metaeditor.common.property.impl.CustomBeanProperty;

/**
 * Allows the instantiation of a property item using a property of java bean.
 *
 */
public class PropertyViewUtils {

	/**
	 * Create a property item using a property of java bean
	 * 
	 * @param bean                  The bean with a Property to show
	 * @param property              The name of the Property variable
	 * @param displayName           The name to show in the property view
	 * @param category				The category of the property inside the view
	 * @param propertyDescription	A description of the property
	 * @param isEditable			Whether the property field should be disabled
	 * @return
	 */
	public static CustomBeanProperty createPropertyField(Object bean, String property, String displayName, String category,
			String propertyDescription, boolean isEditable, Object defaultValue) {
		if (bean != null) {
			PropertyDescriptor propertyDescriptor = null;

			try {
				propertyDescriptor = new PropertyDescriptor(property, bean.getClass());

				propertyDescriptor.setDisplayName(displayName);
				propertyDescriptor.setShortDescription(propertyDescription);
				// then provide a custom category
				propertyDescriptor.setValue(BeanProperty.CATEGORY_LABEL_KEY, category);

				return new CustomBeanProperty(bean, propertyDescriptor, defaultValue) {
					{
						setEditable(isEditable);
					}
				};

			} catch (IntrospectionException e) {
				System.err.println(property + "property not found on " + bean);
			}

		}

		return null;
	}
}
