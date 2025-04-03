/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse astratta che viene estesa dalle varie metaclassi del metamodello di configurazione che necessitano (ciascuna per ragioni diverse) di un attributo "name" di tipo stringa.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.NamedElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attributo stringa ereditato dalle varie sottoclassi.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getNamedElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // NamedElement
