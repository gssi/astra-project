/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Anchor Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse per la definizione degli anchor point da associare ad un graphical element. Gli anchor point devono avere un corrispettivo tag (associato by-name) all'interno dell'fxml del graphical element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#getRef <em>Ref</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#getConnectableAnchorPoints <em>Connectable Anchor Points</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#isFullAnchorPoint <em>Full Anchor Point</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getAnchorPoint()
 * @model
 * @generated
 */
public interface AnchorPoint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Se uguale a null, l'anchor point funge da solo magnete a livello grafico. Se invece questo puntatore viene associato ad una ref del domain element del graphical element, insieme alla magnetizzazione grafica delle istanze del graphical element, viene anche settata la relativa ref dell'istanza.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(EReference)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getAnchorPoint_Ref()
	 * @model
	 * @generated
	 */
	EReference getRef();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(EReference value);

	/**
	 * Returns the value of the '<em><b>Connectable Anchor Points</b></em>' reference list.
	 * The list contents are of type {@link MetaEditor.MetaEditorConfiguration.AnchorPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Definisce l'insieme degli anchor point che semanticamente possono essere connessi/magnetizzati allo specifico anchor point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connectable Anchor Points</em>' reference list.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getAnchorPoint_ConnectableAnchorPoints()
	 * @model
	 * @generated
	 */
	EList<AnchorPoint> getConnectableAnchorPoints();

	/**
	 * Returns the value of the '<em><b>Full Anchor Point</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Se true, l'anchor point definito non è un singolo punto del graphical element, ma lo stesso graphical element nel suo insieme è interamente un anchor point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Full Anchor Point</em>' attribute.
	 * @see #setFullAnchorPoint(boolean)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getAnchorPoint_FullAnchorPoint()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFullAnchorPoint();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#isFullAnchorPoint <em>Full Anchor Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Anchor Point</em>' attribute.
	 * @see #isFullAnchorPoint()
	 * @generated
	 */
	void setFullAnchorPoint(boolean value);

} // AnchorPoint
