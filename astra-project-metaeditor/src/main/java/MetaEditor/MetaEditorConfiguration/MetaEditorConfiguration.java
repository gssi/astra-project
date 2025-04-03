/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Root della configurazione di un editor da generare con il processo del metaeditor. Una istanza di questa classe punterà a tutte le definizioni dei graphical element dell'editor. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getRootElement <em>Root Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getGraphicalElements <em>Graphical Elements</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasWidth <em>Init Canvas Width</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasHeight <em>Init Canvas Height</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getModelFileExtension <em>Model File Extension</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getEditorIconPath <em>Editor Icon Path</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getMetaEditorConfiguration()
 * @model
 * @generated
 */
public interface MetaEditorConfiguration extends NamedElement, UneditableFeaturesElement {
	/**
	 * Returns the value of the '<em><b>Root Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore alla classe root del metamodello di dominio. La root class del metamodello di dominio definisce l'istanza "container" associata al canvas, che conterrà tutti i graphical element che verranno istanziati mediante l'editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Root Element</em>' reference.
	 * @see #setRootElement(EClass)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getMetaEditorConfiguration_RootElement()
	 * @model required="true"
	 * @generated
	 */
	EClass getRootElement();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getRootElement <em>Root Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Element</em>' reference.
	 * @see #getRootElement()
	 * @generated
	 */
	void setRootElement(EClass value);

	/**
	 * Returns the value of the '<em><b>Graphical Elements</b></em>' containment reference list.
	 * The list contents are of type {@link MetaEditor.MetaEditorConfiguration.GraphicalElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore alle istanze di graphical element definiti dal progettista di un editor specifico. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Graphical Elements</em>' containment reference list.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getMetaEditorConfiguration_GraphicalElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<GraphicalElement> getGraphicalElements();

	/**
	 * Returns the value of the '<em><b>Init Canvas Width</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Valore della larghezza in pixel del canvas iniziale di un nuovo modello creato.  
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Init Canvas Width</em>' attribute.
	 * @see #setInitCanvasWidth(int)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getMetaEditorConfiguration_InitCanvasWidth()
	 * @model default="1000" required="true"
	 * @generated
	 */
	int getInitCanvasWidth();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasWidth <em>Init Canvas Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Canvas Width</em>' attribute.
	 * @see #getInitCanvasWidth()
	 * @generated
	 */
	void setInitCanvasWidth(int value);

	/**
	 * Returns the value of the '<em><b>Init Canvas Height</b></em>' attribute.
	 * The default value is <code>"500"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Valore dell'altezza in pixel del canvas iniziale di un nuovo modello creato.  
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Init Canvas Height</em>' attribute.
	 * @see #setInitCanvasHeight(int)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getMetaEditorConfiguration_InitCanvasHeight()
	 * @model default="500" required="true"
	 * @generated
	 */
	int getInitCanvasHeight();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasHeight <em>Init Canvas Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Canvas Height</em>' attribute.
	 * @see #getInitCanvasHeight()
	 * @generated
	 */
	void setInitCanvasHeight(int value);

	/**
	 * Returns the value of the '<em><b>Model File Extension</b></em>' attribute.
	 * The default value is <code>"xmi"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Estensione del file persistence che l'editor salva per fare persistenza delle istanze modellate dall'utente dell'editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model File Extension</em>' attribute.
	 * @see #setModelFileExtension(String)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getMetaEditorConfiguration_ModelFileExtension()
	 * @model default="xmi" required="true"
	 * @generated
	 */
	String getModelFileExtension();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getModelFileExtension <em>Model File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model File Extension</em>' attribute.
	 * @see #getModelFileExtension()
	 * @generated
	 */
	void setModelFileExtension(String value);

	/**
	 * Returns the value of the '<em><b>Editor Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Path dell'icona dell'eseguibile dell'editor generato.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Editor Icon Path</em>' attribute.
	 * @see #setEditorIconPath(String)
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getMetaEditorConfiguration_EditorIconPath()
	 * @model
	 * @generated
	 */
	String getEditorIconPath();

	/**
	 * Sets the value of the '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getEditorIconPath <em>Editor Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor Icon Path</em>' attribute.
	 * @see #getEditorIconPath()
	 * @generated
	 */
	void setEditorIconPath(String value);

} // MetaEditorConfiguration
