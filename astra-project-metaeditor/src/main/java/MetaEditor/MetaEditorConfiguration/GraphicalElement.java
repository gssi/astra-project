/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphical Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Metaclasse per la definizione dei graphical element che faranno parte dell'editor generato. L'insieme dei graphical element definiscono la sintassi concreta del linguaggio.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getElement <em>Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getFxmlPath <em>Fxml Path</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getAnchorPoints <em>Anchor Points</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getIconPath <em>Icon Path</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getNameAttribute <em>Name Attribute</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getContainmentRef <em>Containment Ref</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getGraphicalElement()
 * @model
 * @generated
 */
public interface GraphicalElement extends NamedElement, UneditableFeaturesElement, ConfigurationOptions {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore alla metaclasse del metamodello di dominio. Questo puntatore rappresenta il reale binding fra la sintassi astratta e la sintassi concreta, ovvero il binding fra la metaclasse di dominio e il graphical element dell'editor. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EClass)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getGraphicalElement_Element()
	 * @model required="true"
	 * @generated
	 */
	EClass getElement();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EClass value);

	/**
	 * Returns the value of the '<em><b>Fxml Path</b></em>' attribute.
	 * The default value is <code>"TBD"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Path del file fxml associato ad uno specifico graphical element. Questo fxml definisce la rappresentazione di default in fase di inizializzazione del graphical element. La rappresentazione di default potrà poi essere modificata mediante codice custom da inserire nel codice generato dal processo di generazione dell'editor specifico. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fxml Path</em>' attribute.
	 * @see #setFxmlPath(String)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getGraphicalElement_FxmlPath()
	 * @model default="TBD" required="true"
	 * @generated
	 */
	String getFxmlPath();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getFxmlPath <em>Fxml Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fxml Path</em>' attribute.
	 * @see #getFxmlPath()
	 * @generated
	 */
	void setFxmlPath(String value);

	/**
	 * Returns the value of the '<em><b>Anchor Points</b></em>' containment reference list.
	 * The list contents are of type {@link MetaEditor.MetaEditorConfiguration.AnchorPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore alla definizione degli anchor point associati ad un particolare graphical element. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Anchor Points</em>' containment reference list.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getGraphicalElement_AnchorPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnchorPoint> getAnchorPoints();

	/**
	 * Returns the value of the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Path dell'icona in palette del pulsante per la creazione di nuove istanze dello specifico graphical element mediante l'editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icon Path</em>' attribute.
	 * @see #setIconPath(String)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getGraphicalElement_IconPath()
	 * @model
	 * @generated
	 */
	String getIconPath();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getIconPath <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Path</em>' attribute.
	 * @see #getIconPath()
	 * @generated
	 */
	void setIconPath(String value);

	/**
	 * Returns the value of the '<em><b>Name Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore all'attributo della metaclasse di dominio che si vuole utilizzare come label identificativa delle istanze.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name Attribute</em>' reference.
	 * @see #setNameAttribute(EAttribute)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getGraphicalElement_NameAttribute()
	 * @model
	 * @generated
	 */
	EAttribute getNameAttribute();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getNameAttribute <em>Name Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Attribute</em>' reference.
	 * @see #getNameAttribute()
	 * @generated
	 */
	void setNameAttribute(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Containment Ref</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore alla reference del metamodello di dominio che rappresenta il "container" delle istanze. Questa reference può avere come source il domain root (e quindi le istanze saranno contenute direttamente all'interno del canvas) oppure può avere come source un'altra domain class, e quindi le istanze saranno "child" delle istanze di quella domain class. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Containment Ref</em>' reference list.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getGraphicalElement_ContainmentRef()
	 * @model required="true"
	 * @generated
	 */
	EList<EReference> getContainmentRef();

} // GraphicalElement
