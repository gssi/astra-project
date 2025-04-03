/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse che definisce gli attributi di un element position.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.ElementPosition#getElement <em>Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.ElementPosition#isVisible <em>Visible</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.ElementPosition#isMagnetizable <em>Magnetizable</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.ElementPosition#isPinned <em>Pinned</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getElementPosition()
 * @model
 * @generated
 */
public interface ElementPosition extends Position, BendableElementPosition, RotationPosition {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore all'istanza di dominio di un graphical element: l'istanza di element position serializza quindi le caratteristiche di layout e funzionalità di editing di una particolare istanza di un graphical element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getElementPosition_Element()
	 * @model required="true"
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.ElementPosition#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attributo che permette la memorizzazione della visibilità di una istanza: se true l'elemento è visibile, se è false l'elemento esiste ma non è visibile nel canvas.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Visible</em>' attribute.
	 * @see #setVisible(boolean)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getElementPosition_Visible()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isVisible();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.ElementPosition#isVisible <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible</em>' attribute.
	 * @see #isVisible()
	 * @generated
	 */
	void setVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Magnetizable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attributo che permette la memorizzazione della magnetizzabilità di una istanza: se true l'elemento è magnetizzabile (agli oggetti a cui è semanticamente magnetizzabile), altrimenti se false per quell'elemento è disabilitata la funzione di magnete.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Magnetizable</em>' attribute.
	 * @see #setMagnetizable(boolean)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getElementPosition_Magnetizable()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isMagnetizable();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.ElementPosition#isMagnetizable <em>Magnetizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Magnetizable</em>' attribute.
	 * @see #isMagnetizable()
	 * @generated
	 */
	void setMagnetizable(boolean value);

	/**
	 * Returns the value of the '<em><b>Pinned</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attributo che permette la memorizzazione della funzionalità di pinning di una istanza: se true l'elemento è "pinnato" (ovvero bloccato in una posizione non modificabile del canvas), altrimenti se false quell'elemento è regolarmente possibile spostarlo mediante il classico drag and drop.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pinned</em>' attribute.
	 * @see #setPinned(boolean)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getElementPosition_Pinned()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPinned();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.ElementPosition#isPinned <em>Pinned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pinned</em>' attribute.
	 * @see #isPinned()
	 * @generated
	 */
	void setPinned(boolean value);

} // ElementPosition
