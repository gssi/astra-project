/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Canvas Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Il canvas può essere suddiviso in sezioni. Una sezione è quindi una sotto-parte di un canvas.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.CanvasSection#getName <em>Name</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.CanvasSection#getSectionWidth <em>Section Width</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.CanvasSection#getSectionHeight <em>Section Height</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getCanvasSection()
 * @model
 * @generated
 */
public interface CanvasSection extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"TBD"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Nome della sezione.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getCanvasSection_Name()
	 * @model default="TBD" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.CanvasSection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Section Width</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Larghezza della sezione.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Section Width</em>' attribute.
	 * @see #setSectionWidth(int)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getCanvasSection_SectionWidth()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getSectionWidth();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.CanvasSection#getSectionWidth <em>Section Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Width</em>' attribute.
	 * @see #getSectionWidth()
	 * @generated
	 */
	void setSectionWidth(int value);

	/**
	 * Returns the value of the '<em><b>Section Height</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Altezza della sezione.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Section Height</em>' attribute.
	 * @see #setSectionHeight(int)
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getCanvasSection_SectionHeight()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getSectionHeight();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorPersistence.CanvasSection#getSectionHeight <em>Section Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Height</em>' attribute.
	 * @see #getSectionHeight()
	 * @generated
	 */
	void setSectionHeight(int value);

} // CanvasSection
