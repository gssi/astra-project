/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse astratta che raggruppa alcune opzioni di configurazione di un graphical element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isBendableElement <em>Bendable Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#getRotationPositions <em>Rotation Positions</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isSelectWithParent <em>Select With Parent</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#getZIndexDefault <em>ZIndex Default</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getConfigurationOptions()
 * @model abstract="true"
 * @generated
 */
public interface ConfigurationOptions extends EObject {
	/**
	 * Returns the value of the '<em><b>Bendable Element</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Se true, il graphical element viene creato come "bendable" element, ovvero una linea/segmento "spezzata" a cui possono essere aggiunti bendable point. Viene assunto che per i graphical element che sono di tipo bendable, l'fxml associato è tipo polyline in JavaFX.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bendable Element</em>' attribute.
	 * @see #setBendableElement(boolean)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getConfigurationOptions_BendableElement()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isBendableElement();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isBendableElement <em>Bendable Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bendable Element</em>' attribute.
	 * @see #isBendableElement()
	 * @generated
	 */
	void setBendableElement(boolean value);

	/**
	 * Returns the value of the '<em><b>Rotation Positions</b></em>' attribute list.
	 * The list contents are of type {@link MetaEditor.MetaEditorConfiguration.RotationPosition}.
	 * The literals are from the enumeration {@link MetaEditor.MetaEditorConfiguration.RotationPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attributo che serve per definire i graphical element "ruotabili". L'insieme dei valori puntati da questo attributo definiscono l'insieme discreto dei gradi di rotazione che il graphical element può assumere.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rotation Positions</em>' attribute list.
	 * @see MetaEditor.MetaEditorConfiguration.RotationPosition
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getConfigurationOptions_RotationPositions()
	 * @model
	 * @generated
	 */
	EList<RotationPosition> getRotationPositions();

	/**
	 * Returns the value of the '<em><b>Select With Parent</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Se true, il graphical element verrà selezionato e spostato insieme al graphical element padre. L'utente può eventualmente deselezionare il figlio durante l'editing nel caso voglia spostare soltando il padre. Il true di questo attributo descrive soltanto il comportamento di default: ovvero se selezionare il figlio insieme al padre, oppure lasciare la selezione indipendente.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Select With Parent</em>' attribute.
	 * @see #setSelectWithParent(boolean)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getConfigurationOptions_SelectWithParent()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isSelectWithParent();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isSelectWithParent <em>Select With Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Select With Parent</em>' attribute.
	 * @see #isSelectWithParent()
	 * @generated
	 */
	void setSelectWithParent(boolean value);

	/**
	 * Returns the value of the '<em><b>ZIndex Default</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Serve per inizializzare e resettare ad un determinato valore la coordinata Z di tutte le istanze di uno specifico tipo di GraphicalElement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ZIndex Default</em>' attribute.
	 * @see #setZIndexDefault(int)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getConfigurationOptions_ZIndexDefault()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getZIndexDefault();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#getZIndexDefault <em>ZIndex Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZIndex Default</em>' attribute.
	 * @see #getZIndexDefault()
	 * @generated
	 */
	void setZIndexDefault(int value);

} // ConfigurationOptions
