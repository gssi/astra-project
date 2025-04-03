/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse che rappresenta un set di coordinate di una posizione, in termine di X, Y e Z-index. Questa metaclasse è ereditata sia da BendPoint (per la posizione di un bend point) sia da ElementPosition (per la posizione di una istanza di graphical element).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.Position#getX <em>X</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.Position#getY <em>Y</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.Position#getZ <em>Z</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getPosition()
 * @model abstract="true"
 * @generated
 */
public interface Position extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Distanza in pixel dal margine sinistro del canvas lungo l'asse delle X.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getPosition_X()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.Position#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Distanza in pixel dal margine in alto del canvas lungo l'asse delle Y.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getPosition_Y()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.Position#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Z</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Livello dello z-Index. A ciascuna istanza di graphical element è associato un "livello", ovvero un valore di z-Index, che mediante l'editor può essere incrementato e decrementato. Questo attributo serializza il livello attuale dello z-Index per una determinata istanza.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Z</em>' attribute.
	 * @see #setZ(int)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getPosition_Z()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getZ();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.Position#getZ <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Z</em>' attribute.
	 * @see #getZ()
	 * @generated
	 */
	void setZ(int value);

} // Position
