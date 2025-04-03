/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * Questo package racchiude tutti gli elementi (meclassi/attributi/reference) necessari al meccanismo di persistenza del layout/posizione delle istanze create con uno specifico editor generato con il processo di generazione del metaeditor. Nello specifico, il file di persistenza del layout, sarà un xmi istanza di questo metamodello.
 * <!-- end-model-doc -->
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory
 * @model kind="package"
 * @generated
 */
public interface MetaEditorPersistencePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "MetaEditorPersistence";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://ermes-project.org/MetaEditorPersistence";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MetaEditorPersistence";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetaEditorPersistencePackage eINSTANCE = MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl.init();

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl <em>Meta Editor Persistence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getMetaEditorPersistence()
	 * @generated
	 */
	int META_EDITOR_PERSISTENCE = 0;

	/**
	 * The feature id for the '<em><b>Element Positions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS = 0;

	/**
	 * The feature id for the '<em><b>Canvas Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_PERSISTENCE__CANVAS_WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Canvas Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_PERSISTENCE__CANVAS_HEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Canvas Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_PERSISTENCE__CANVAS_SECTIONS = 3;

	/**
	 * The number of structural features of the '<em>Meta Editor Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_PERSISTENCE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Meta Editor Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EDITOR_PERSISTENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorPersistence.impl.PositionImpl <em>Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorPersistence.impl.PositionImpl
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getPosition()
	 * @generated
	 */
	int POSITION = 5;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__Y = 1;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION__Z = 2;

	/**
	 * The number of structural features of the '<em>Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl <em>Element Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getElementPosition()
	 * @generated
	 */
	int ELEMENT_POSITION = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__X = POSITION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__Y = POSITION__Y;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__Z = POSITION__Z;

	/**
	 * The feature id for the '<em><b>Bend Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__BEND_POINTS = POSITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rotation Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__ROTATION_POSITION = POSITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__ELEMENT = POSITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__VISIBLE = POSITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Magnetizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__MAGNETIZABLE = POSITION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Pinned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION__PINNED = POSITION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Element Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION_FEATURE_COUNT = POSITION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Element Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_POSITION_OPERATION_COUNT = POSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorPersistence.impl.BendableElementPositionImpl <em>Bendable Element Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorPersistence.impl.BendableElementPositionImpl
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getBendableElementPosition()
	 * @generated
	 */
	int BENDABLE_ELEMENT_POSITION = 2;

	/**
	 * The feature id for the '<em><b>Bend Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDABLE_ELEMENT_POSITION__BEND_POINTS = 0;

	/**
	 * The number of structural features of the '<em>Bendable Element Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDABLE_ELEMENT_POSITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Bendable Element Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDABLE_ELEMENT_POSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorPersistence.impl.RotationPositionImpl <em>Rotation Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorPersistence.impl.RotationPositionImpl
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getRotationPosition()
	 * @generated
	 */
	int ROTATION_POSITION = 3;

	/**
	 * The feature id for the '<em><b>Rotation Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATION_POSITION__ROTATION_POSITION = 0;

	/**
	 * The number of structural features of the '<em>Rotation Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATION_POSITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rotation Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATION_POSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorPersistence.impl.BendPointImpl <em>Bend Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorPersistence.impl.BendPointImpl
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getBendPoint()
	 * @generated
	 */
	int BEND_POINT = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEND_POINT__X = POSITION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEND_POINT__Y = POSITION__Y;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEND_POINT__Z = POSITION__Z;

	/**
	 * The number of structural features of the '<em>Bend Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEND_POINT_FEATURE_COUNT = POSITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bend Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEND_POINT_OPERATION_COUNT = POSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link MetaEditor.MetaEditorPersistence.impl.CanvasSectionImpl <em>Canvas Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MetaEditor.MetaEditorPersistence.impl.CanvasSectionImpl
	 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getCanvasSection()
	 * @generated
	 */
	int CANVAS_SECTION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_SECTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Section Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_SECTION__SECTION_WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Section Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_SECTION__SECTION_HEIGHT = 2;

	/**
	 * The number of structural features of the '<em>Canvas Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_SECTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Canvas Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_SECTION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence <em>Meta Editor Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Editor Persistence</em>'.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistence
	 * @generated
	 */
	EClass getMetaEditorPersistence();

	/**
	 * Returns the meta object for the containment reference list '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getElementPositions <em>Element Positions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Positions</em>'.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getElementPositions()
	 * @see #getMetaEditorPersistence()
	 * @generated
	 */
	EReference getMetaEditorPersistence_ElementPositions();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasWidth <em>Canvas Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Canvas Width</em>'.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasWidth()
	 * @see #getMetaEditorPersistence()
	 * @generated
	 */
	EAttribute getMetaEditorPersistence_CanvasWidth();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasHeight <em>Canvas Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Canvas Height</em>'.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasHeight()
	 * @see #getMetaEditorPersistence()
	 * @generated
	 */
	EAttribute getMetaEditorPersistence_CanvasHeight();

	/**
	 * Returns the meta object for the containment reference list '{@link MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasSections <em>Canvas Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Canvas Sections</em>'.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistence#getCanvasSections()
	 * @see #getMetaEditorPersistence()
	 * @generated
	 */
	EReference getMetaEditorPersistence_CanvasSections();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorPersistence.ElementPosition <em>Element Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Position</em>'.
	 * @see MetaEditor.MetaEditorPersistence.ElementPosition
	 * @generated
	 */
	EClass getElementPosition();

	/**
	 * Returns the meta object for the reference '{@link MetaEditor.MetaEditorPersistence.ElementPosition#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see MetaEditor.MetaEditorPersistence.ElementPosition#getElement()
	 * @see #getElementPosition()
	 * @generated
	 */
	EReference getElementPosition_Element();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.ElementPosition#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see MetaEditor.MetaEditorPersistence.ElementPosition#isVisible()
	 * @see #getElementPosition()
	 * @generated
	 */
	EAttribute getElementPosition_Visible();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.ElementPosition#isMagnetizable <em>Magnetizable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Magnetizable</em>'.
	 * @see MetaEditor.MetaEditorPersistence.ElementPosition#isMagnetizable()
	 * @see #getElementPosition()
	 * @generated
	 */
	EAttribute getElementPosition_Magnetizable();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.ElementPosition#isPinned <em>Pinned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pinned</em>'.
	 * @see MetaEditor.MetaEditorPersistence.ElementPosition#isPinned()
	 * @see #getElementPosition()
	 * @generated
	 */
	EAttribute getElementPosition_Pinned();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorPersistence.BendableElementPosition <em>Bendable Element Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bendable Element Position</em>'.
	 * @see MetaEditor.MetaEditorPersistence.BendableElementPosition
	 * @generated
	 */
	EClass getBendableElementPosition();

	/**
	 * Returns the meta object for the containment reference list '{@link MetaEditor.MetaEditorPersistence.BendableElementPosition#getBendPoints <em>Bend Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bend Points</em>'.
	 * @see MetaEditor.MetaEditorPersistence.BendableElementPosition#getBendPoints()
	 * @see #getBendableElementPosition()
	 * @generated
	 */
	EReference getBendableElementPosition_BendPoints();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorPersistence.RotationPosition <em>Rotation Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rotation Position</em>'.
	 * @see MetaEditor.MetaEditorPersistence.RotationPosition
	 * @generated
	 */
	EClass getRotationPosition();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.RotationPosition#getRotationPosition <em>Rotation Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation Position</em>'.
	 * @see MetaEditor.MetaEditorPersistence.RotationPosition#getRotationPosition()
	 * @see #getRotationPosition()
	 * @generated
	 */
	EAttribute getRotationPosition_RotationPosition();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorPersistence.BendPoint <em>Bend Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bend Point</em>'.
	 * @see MetaEditor.MetaEditorPersistence.BendPoint
	 * @generated
	 */
	EClass getBendPoint();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorPersistence.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position</em>'.
	 * @see MetaEditor.MetaEditorPersistence.Position
	 * @generated
	 */
	EClass getPosition();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.Position#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see MetaEditor.MetaEditorPersistence.Position#getX()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_X();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.Position#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see MetaEditor.MetaEditorPersistence.Position#getY()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_Y();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.Position#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see MetaEditor.MetaEditorPersistence.Position#getZ()
	 * @see #getPosition()
	 * @generated
	 */
	EAttribute getPosition_Z();

	/**
	 * Returns the meta object for class '{@link MetaEditor.MetaEditorPersistence.CanvasSection <em>Canvas Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas Section</em>'.
	 * @see MetaEditor.MetaEditorPersistence.CanvasSection
	 * @generated
	 */
	EClass getCanvasSection();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.CanvasSection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see MetaEditor.MetaEditorPersistence.CanvasSection#getName()
	 * @see #getCanvasSection()
	 * @generated
	 */
	EAttribute getCanvasSection_Name();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.CanvasSection#getSectionWidth <em>Section Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Section Width</em>'.
	 * @see MetaEditor.MetaEditorPersistence.CanvasSection#getSectionWidth()
	 * @see #getCanvasSection()
	 * @generated
	 */
	EAttribute getCanvasSection_SectionWidth();

	/**
	 * Returns the meta object for the attribute '{@link MetaEditor.MetaEditorPersistence.CanvasSection#getSectionHeight <em>Section Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Section Height</em>'.
	 * @see MetaEditor.MetaEditorPersistence.CanvasSection#getSectionHeight()
	 * @see #getCanvasSection()
	 * @generated
	 */
	EAttribute getCanvasSection_SectionHeight();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetaEditorPersistenceFactory getMetaEditorPersistenceFactory();

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
		 * The meta object literal for the '{@link MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl <em>Meta Editor Persistence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceImpl
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getMetaEditorPersistence()
		 * @generated
		 */
		EClass META_EDITOR_PERSISTENCE = eINSTANCE.getMetaEditorPersistence();

		/**
		 * The meta object literal for the '<em><b>Element Positions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS = eINSTANCE.getMetaEditorPersistence_ElementPositions();

		/**
		 * The meta object literal for the '<em><b>Canvas Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_EDITOR_PERSISTENCE__CANVAS_WIDTH = eINSTANCE.getMetaEditorPersistence_CanvasWidth();

		/**
		 * The meta object literal for the '<em><b>Canvas Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_EDITOR_PERSISTENCE__CANVAS_HEIGHT = eINSTANCE.getMetaEditorPersistence_CanvasHeight();

		/**
		 * The meta object literal for the '<em><b>Canvas Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_EDITOR_PERSISTENCE__CANVAS_SECTIONS = eINSTANCE.getMetaEditorPersistence_CanvasSections();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl <em>Element Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getElementPosition()
		 * @generated
		 */
		EClass ELEMENT_POSITION = eINSTANCE.getElementPosition();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_POSITION__ELEMENT = eINSTANCE.getElementPosition_Element();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_POSITION__VISIBLE = eINSTANCE.getElementPosition_Visible();

		/**
		 * The meta object literal for the '<em><b>Magnetizable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_POSITION__MAGNETIZABLE = eINSTANCE.getElementPosition_Magnetizable();

		/**
		 * The meta object literal for the '<em><b>Pinned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_POSITION__PINNED = eINSTANCE.getElementPosition_Pinned();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorPersistence.impl.BendableElementPositionImpl <em>Bendable Element Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorPersistence.impl.BendableElementPositionImpl
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getBendableElementPosition()
		 * @generated
		 */
		EClass BENDABLE_ELEMENT_POSITION = eINSTANCE.getBendableElementPosition();

		/**
		 * The meta object literal for the '<em><b>Bend Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BENDABLE_ELEMENT_POSITION__BEND_POINTS = eINSTANCE.getBendableElementPosition_BendPoints();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorPersistence.impl.RotationPositionImpl <em>Rotation Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorPersistence.impl.RotationPositionImpl
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getRotationPosition()
		 * @generated
		 */
		EClass ROTATION_POSITION = eINSTANCE.getRotationPosition();

		/**
		 * The meta object literal for the '<em><b>Rotation Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROTATION_POSITION__ROTATION_POSITION = eINSTANCE.getRotationPosition_RotationPosition();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorPersistence.impl.BendPointImpl <em>Bend Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorPersistence.impl.BendPointImpl
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getBendPoint()
		 * @generated
		 */
		EClass BEND_POINT = eINSTANCE.getBendPoint();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorPersistence.impl.PositionImpl <em>Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorPersistence.impl.PositionImpl
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getPosition()
		 * @generated
		 */
		EClass POSITION = eINSTANCE.getPosition();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__X = eINSTANCE.getPosition_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__Y = eINSTANCE.getPosition_Y();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION__Z = eINSTANCE.getPosition_Z();

		/**
		 * The meta object literal for the '{@link MetaEditor.MetaEditorPersistence.impl.CanvasSectionImpl <em>Canvas Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see MetaEditor.MetaEditorPersistence.impl.CanvasSectionImpl
		 * @see MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl#getCanvasSection()
		 * @generated
		 */
		EClass CANVAS_SECTION = eINSTANCE.getCanvasSection();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CANVAS_SECTION__NAME = eINSTANCE.getCanvasSection_Name();

		/**
		 * The meta object literal for the '<em><b>Section Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CANVAS_SECTION__SECTION_WIDTH = eINSTANCE.getCanvasSection_SectionWidth();

		/**
		 * The meta object literal for the '<em><b>Section Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CANVAS_SECTION__SECTION_HEIGHT = eINSTANCE.getCanvasSection_SectionHeight();

	}

} //MetaEditorPersistencePackage
