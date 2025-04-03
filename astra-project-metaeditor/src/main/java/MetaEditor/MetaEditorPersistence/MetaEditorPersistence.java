/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Editor Persistence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Root della persistenza di una istanza (modello) creata con un editor generato con il processo del metaeditor. Una istanza di questa classe conterrà tutte le informazioni di persistenza dei graphical element definiti nel file di configurazione (che è conforme al metamodello Configuration presente nel relativo package).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getElementPositions <em>Element Positions</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasWidth <em>Canvas Width</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasHeight <em>Canvas Height</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasSections <em>Canvas Sections</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getMetaEditorPersistence()
 * @model
 * @generated
 */
public interface MetaEditorPersistence extends EObject {
	/**
	 * Returns the value of the '<em><b>Element Positions</b></em>' containment reference list.
	 * The list contents are of type {@link MetaEditor.MetaEditorPersistence.ElementPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore a tutti gli element position, ovvero agli oggetti di persistenza delle istanze dei graphical element istanziate mediante l'editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element Positions</em>' containment reference list.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getMetaEditorPersistence_ElementPositions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementPosition> getElementPositions();

	/**
	 * Returns the value of the '<em><b>Canvas Width</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attributo per la memorizzazione della larghezza del canvas, che l'utente può modificare mediante il relativo menù accessibile dal menu degli strumenti dell'editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Canvas Width</em>' attribute.
	 * @see #setCanvasWidth(int)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getMetaEditorPersistence_CanvasWidth()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCanvasWidth();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasWidth <em>Canvas Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Canvas Width</em>' attribute.
	 * @see #getCanvasWidth()
	 * @generated
	 */
	void setCanvasWidth(int value);

	/**
	 * Returns the value of the '<em><b>Canvas Height</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attributo per la memorizzazione dell'altezza del canvas, che l'utente può modificare mediante il relativo menù accessibile dal menu degli strumenti dell'editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Canvas Height</em>' attribute.
	 * @see #setCanvasHeight(int)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getMetaEditorPersistence_CanvasHeight()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCanvasHeight();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasHeight <em>Canvas Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Canvas Height</em>' attribute.
	 * @see #getCanvasHeight()
	 * @generated
	 */
	void setCanvasHeight(int value);

	/**
	 * Returns the value of the '<em><b>Canvas Sections</b></em>' containment reference list.
	 * The list contents are of type {@link MetaEditor.MetaEditorPersistence.CanvasSection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore alle sezioni (sections) in cui è possibile suddividere il canvas.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Canvas Sections</em>' containment reference list.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getMetaEditorPersistence_CanvasSections()
	 * @model containment="true"
	 * @generated
	 */
	EList<CanvasSection> getCanvasSections();

} // MetaEditorPersistence
