/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uneditable Features Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse astratta che viene estesa dalle varie metaclassi del metamodello di configurazione per rendere non editabili delle structural features.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement#getUneditableFeatures <em>Uneditable Features</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getUneditableFeaturesElement()
 * @model abstract="true"
 * @generated
 */
public interface UneditableFeaturesElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Uneditable Features</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Insieme di puntatori a structural features del metamodello di dominio che non si vuole poter editare all'interno della property view dell'editor generato. Queste features saranno visualizzate ma non editabili. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uneditable Features</em>' reference list.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getUneditableFeaturesElement_UneditableFeatures()
	 * @model
	 * @generated
	 */
	EList<EStructuralFeature> getUneditableFeatures();

} // UneditableFeaturesElement
