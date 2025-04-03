/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rotation Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse necessaria per serializzare la posizione di rotazione degli elementi che sono stati definiti come "ruotabili". 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.RotationPosition#getRotationPosition <em>Rotation Position</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getRotationPosition()
 * @model abstract="true"
 * @generated
 */
public interface RotationPosition extends EObject {
	/**
	 * Returns the value of the '<em><b>Rotation Position</b></em>' attribute.
	 * The literals are from the enumeration {@link MetaEditor.MetaEditorConfiguration.RotationPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Memorizza la posizione di rotazione dell'oggetto. Gli elementi non ruotabili, invece, mantengono settata a null la posizione di rotazione.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rotation Position</em>' attribute.
	 * @see MetaEditor.MetaEditorConfiguration.RotationPosition
	 * @see #setRotationPosition(MetaEditor.MetaEditorConfiguration.RotationPosition)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getRotationPosition_RotationPosition()
	 * @model
	 * @generated
	 */
	MetaEditor.MetaEditorConfiguration.RotationPosition getRotationPosition();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.RotationPosition#getRotationPosition <em>Rotation Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation Position</em>' attribute.
	 * @see MetaEditor.MetaEditorConfiguration.RotationPosition
	 * @see #getRotationPosition()
	 * @generated
	 */
	void setRotationPosition(MetaEditor.MetaEditorConfiguration.RotationPosition value);

} // RotationPosition
