/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Questo package racchiude tutti gli elementi (meclassi/attributi/reference) necessari per la definizione della configurazione di un editor specifico. La configurazione definita sarà input del processo di generazione dell'editor specifico mediante il processo di generazione del metaeditor.
 * <!-- end-model-doc -->
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface MetaEditorConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "MetaEditorConfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://ermes-project.org/MetaEditorConfiguration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MetaEditorConfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetaEditorConfigurationPackage eINSTANCE = MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorConfiguration.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorConfiguration.impl.NamedElementImpl
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorConfiguration.impl.UneditableFeaturesElementImpl <em>Uneditable Features Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorConfiguration.impl.UneditableFeaturesElementImpl
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getUneditableFeaturesElement()
	 * @generated
	 */
	int UNEDITABLE_FEATURES_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Uneditable Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES = 0;

	/**
	 * The number of structural features of the '<em>Uneditable Features Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEDITABLE_FEATURES_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Uneditable Features Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEDITABLE_FEATURES_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl <em>Meta Editor Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getMetaEditorConfiguration()
	 * @generated
	 */
	int META_EDITOR_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Uneditable Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__ROOT_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Graphical Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Init Canvas Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Init Canvas Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Model File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Editor Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Meta Editor Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Meta Editor Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_CONFIGURATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl <em>Graphical Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getGraphicalElement()
	 * @generated
	 */
	int GRAPHICAL_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Uneditable Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bendable Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__BENDABLE_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rotation Positions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__ROTATION_POSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Select With Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__SELECT_WITH_PARENT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>ZIndex Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__ZINDEX_DEFAULT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Fxml Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__FXML_PATH = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Anchor Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__ANCHOR_POINTS = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__ICON_PATH = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__NAME_ATTRIBUTE = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Containment Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__CONTAINMENT_REF = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Graphical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of operations of the '<em>Graphical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorConfiguration.impl.AnchorPointImpl <em>Anchor Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorConfiguration.impl.AnchorPointImpl
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getAnchorPoint()
	 * @generated
	 */
	int ANCHOR_POINT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANCHOR_POINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANCHOR_POINT__REF = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connectable Anchor Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Full Anchor Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANCHOR_POINT__FULL_ANCHOR_POINT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Anchor Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANCHOR_POINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Anchor Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANCHOR_POINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl <em>Configuration Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getConfigurationOptions()
	 * @generated
	 */
	int CONFIGURATION_OPTIONS = 5;

	/**
	 * The feature id for the '<em><b>Bendable Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIONS__BENDABLE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Rotation Positions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIONS__ROTATION_POSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Select With Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIONS__SELECT_WITH_PARENT = 2;

	/**
	 * The feature id for the '<em><b>ZIndex Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIONS__ZINDEX_DEFAULT = 3;

	/**
	 * The number of structural features of the '<em>Configuration Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIONS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Configuration Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPTIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorConfiguration.RotationPosition <em>Rotation Position</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorConfiguration.RotationPosition
	 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getRotationPosition()
	 * @generated
	 */
	int ROTATION_POSITION = 6;


	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorConfiguration.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement <em>Uneditable Features Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uneditable Features Element</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement
	 * @generated
	 */
	EClass getUneditableFeaturesElement();

	/**
	 * Returns the meta object for the reference list '{@link MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement#getUneditableFeatures <em>Uneditable Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uneditable Features</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement#getUneditableFeatures()
	 * @see #getUneditableFeaturesElement()
	 * @generated
	 */
	EReference getUneditableFeaturesElement_UneditableFeatures();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration <em>Meta Editor Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Editor Configuration</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration
	 * @generated
	 */
	EClass getMetaEditorConfiguration();

	/**
	 * Returns the meta object for the reference '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getRootElement <em>Root Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Element</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getRootElement()
	 * @see #getMetaEditorConfiguration()
	 * @generated
	 */
	EReference getMetaEditorConfiguration_RootElement();

	/**
	 * Returns the meta object for the containment reference list '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getGraphicalElements <em>Graphical Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Graphical Elements</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getGraphicalElements()
	 * @see #getMetaEditorConfiguration()
	 * @generated
	 */
	EReference getMetaEditorConfiguration_GraphicalElements();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasWidth <em>Init Canvas Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Canvas Width</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasWidth()
	 * @see #getMetaEditorConfiguration()
	 * @generated
	 */
	EAttribute getMetaEditorConfiguration_InitCanvasWidth();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasHeight <em>Init Canvas Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Canvas Height</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getInitCanvasHeight()
	 * @see #getMetaEditorConfiguration()
	 * @generated
	 */
	EAttribute getMetaEditorConfiguration_InitCanvasHeight();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getModelFileExtension <em>Model File Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model File Extension</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getModelFileExtension()
	 * @see #getMetaEditorConfiguration()
	 * @generated
	 */
	EAttribute getMetaEditorConfiguration_ModelFileExtension();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getEditorIconPath <em>Editor Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editor Icon Path</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration#getEditorIconPath()
	 * @see #getMetaEditorConfiguration()
	 * @generated
	 */
	EAttribute getMetaEditorConfiguration_EditorIconPath();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement <em>Graphical Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphical Element</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement
	 * @generated
	 */
	EClass getGraphicalElement();

	/**
	 * Returns the meta object for the reference '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement#getElement()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EReference getGraphicalElement_Element();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getFxmlPath <em>Fxml Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fxml Path</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement#getFxmlPath()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EAttribute getGraphicalElement_FxmlPath();

	/**
	 * Returns the meta object for the containment reference list '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getAnchorPoints <em>Anchor Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Anchor Points</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement#getAnchorPoints()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EReference getGraphicalElement_AnchorPoints();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement#getIconPath()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EAttribute getGraphicalElement_IconPath();

	/**
	 * Returns the meta object for the reference '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getNameAttribute <em>Name Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name Attribute</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement#getNameAttribute()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EReference getGraphicalElement_NameAttribute();

	/**
	 * Returns the meta object for the reference list '{@link MetaEditor.MetaEditorConfiguration.GraphicalElement#getContainmentRef <em>Containment Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Containment Ref</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.GraphicalElement#getContainmentRef()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EReference getGraphicalElement_ContainmentRef();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorConfiguration.AnchorPoint <em>Anchor Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Anchor Point</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.AnchorPoint
	 * @generated
	 */
	EClass getAnchorPoint();

	/**
	 * Returns the meta object for the reference '{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.AnchorPoint#getRef()
	 * @see #getAnchorPoint()
	 * @generated
	 */
	EReference getAnchorPoint_Ref();

	/**
	 * Returns the meta object for the reference list '{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#getConnectableAnchorPoints <em>Connectable Anchor Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connectable Anchor Points</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.AnchorPoint#getConnectableAnchorPoints()
	 * @see #getAnchorPoint()
	 * @generated
	 */
	EReference getAnchorPoint_ConnectableAnchorPoints();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.AnchorPoint#isFullAnchorPoint <em>Full Anchor Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Anchor Point</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.AnchorPoint#isFullAnchorPoint()
	 * @see #getAnchorPoint()
	 * @generated
	 */
	EAttribute getAnchorPoint_FullAnchorPoint();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions <em>Configuration Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Options</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.ConfigurationOptions
	 * @generated
	 */
	EClass getConfigurationOptions();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isBendableElement <em>Bendable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bendable Element</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isBendableElement()
	 * @see #getConfigurationOptions()
	 * @generated
	 */
	EAttribute getConfigurationOptions_BendableElement();

	/**
	 * Returns the meta object for the attribute list '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#getRotationPositions <em>Rotation Positions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Rotation Positions</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.ConfigurationOptions#getRotationPositions()
	 * @see #getConfigurationOptions()
	 * @generated
	 */
	EAttribute getConfigurationOptions_RotationPositions();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isSelectWithParent <em>Select With Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Select With Parent</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.ConfigurationOptions#isSelectWithParent()
	 * @see #getConfigurationOptions()
	 * @generated
	 */
	EAttribute getConfigurationOptions_SelectWithParent();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorConfiguration.ConfigurationOptions#getZIndexDefault <em>ZIndex Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ZIndex Default</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.ConfigurationOptions#getZIndexDefault()
	 * @see #getConfigurationOptions()
	 * @generated
	 */
	EAttribute getConfigurationOptions_ZIndexDefault();

	/**
	 * Returns the meta object for enum '{@link MetaEditor.MetaEditorConfiguration.RotationPosition <em>Rotation Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rotation Position</em>'.
	 * @see MetaEditor.MetaEditorConfiguration.RotationPosition
	 * @generated
	 */
	EEnum getRotationPosition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetaEditorConfigurationFactory getMetaEditorConfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorConfiguration.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorConfiguration.impl.NamedElementImpl
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorConfiguration.impl.UneditableFeaturesElementImpl <em>Uneditable Features Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorConfiguration.impl.UneditableFeaturesElementImpl
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getUneditableFeaturesElement()
		 * @generated
		 */
		EClass UNEDITABLE_FEATURES_ELEMENT = eINSTANCE.getUneditableFeaturesElement();

		/**
		 * The meta object literal for the '<em><b>Uneditable Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES = eINSTANCE.getUneditableFeaturesElement_UneditableFeatures();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl <em>Meta Editor Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getMetaEditorConfiguration()
		 * @generated
		 */
		EClass META_EDITOR_CONFIGURATION = eINSTANCE.getMetaEditorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Root Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_EDITOR_CONFIGURATION__ROOT_ELEMENT = eINSTANCE.getMetaEditorConfiguration_RootElement();

		/**
		 * The meta object literal for the '<em><b>Graphical Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS = eINSTANCE.getMetaEditorConfiguration_GraphicalElements();

		/**
		 * The meta object literal for the '<em><b>Init Canvas Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH = eINSTANCE.getMetaEditorConfiguration_InitCanvasWidth();

		/**
		 * The meta object literal for the '<em><b>Init Canvas Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT = eINSTANCE.getMetaEditorConfiguration_InitCanvasHeight();

		/**
		 * The meta object literal for the '<em><b>Model File Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION = eINSTANCE.getMetaEditorConfiguration_ModelFileExtension();

		/**
		 * The meta object literal for the '<em><b>Editor Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH = eINSTANCE.getMetaEditorConfiguration_EditorIconPath();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl <em>Graphical Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getGraphicalElement()
		 * @generated
		 */
		EClass GRAPHICAL_ELEMENT = eINSTANCE.getGraphicalElement();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_ELEMENT__ELEMENT = eINSTANCE.getGraphicalElement_Element();

		/**
		 * The meta object literal for the '<em><b>Fxml Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHICAL_ELEMENT__FXML_PATH = eINSTANCE.getGraphicalElement_FxmlPath();

		/**
		 * The meta object literal for the '<em><b>Anchor Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_ELEMENT__ANCHOR_POINTS = eINSTANCE.getGraphicalElement_AnchorPoints();

		/**
		 * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHICAL_ELEMENT__ICON_PATH = eINSTANCE.getGraphicalElement_IconPath();

		/**
		 * The meta object literal for the '<em><b>Name Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_ELEMENT__NAME_ATTRIBUTE = eINSTANCE.getGraphicalElement_NameAttribute();

		/**
		 * The meta object literal for the '<em><b>Containment Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_ELEMENT__CONTAINMENT_REF = eINSTANCE.getGraphicalElement_ContainmentRef();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorConfiguration.impl.AnchorPointImpl <em>Anchor Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorConfiguration.impl.AnchorPointImpl
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getAnchorPoint()
		 * @generated
		 */
		EClass ANCHOR_POINT = eINSTANCE.getAnchorPoint();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANCHOR_POINT__REF = eINSTANCE.getAnchorPoint_Ref();

		/**
		 * The meta object literal for the '<em><b>Connectable Anchor Points</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS = eINSTANCE.getAnchorPoint_ConnectableAnchorPoints();

		/**
		 * The meta object literal for the '<em><b>Full Anchor Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANCHOR_POINT__FULL_ANCHOR_POINT = eINSTANCE.getAnchorPoint_FullAnchorPoint();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl <em>Configuration Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getConfigurationOptions()
		 * @generated
		 */
		EClass CONFIGURATION_OPTIONS = eINSTANCE.getConfigurationOptions();

		/**
		 * The meta object literal for the '<em><b>Bendable Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_OPTIONS__BENDABLE_ELEMENT = eINSTANCE.getConfigurationOptions_BendableElement();

		/**
		 * The meta object literal for the '<em><b>Rotation Positions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_OPTIONS__ROTATION_POSITIONS = eINSTANCE.getConfigurationOptions_RotationPositions();

		/**
		 * The meta object literal for the '<em><b>Select With Parent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_OPTIONS__SELECT_WITH_PARENT = eINSTANCE.getConfigurationOptions_SelectWithParent();

		/**
		 * The meta object literal for the '<em><b>ZIndex Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_OPTIONS__ZINDEX_DEFAULT = eINSTANCE.getConfigurationOptions_ZIndexDefault();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorConfiguration.RotationPosition <em>Rotation Position</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorConfiguration.RotationPosition
		 * @see MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl#getRotationPosition()
		 * @generated
		 */
		EEnum ROTATION_POSITION = eINSTANCE.getRotationPosition();

	}

} //MetaEditorConfigurationPackage
