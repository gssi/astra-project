/**
 */
package MetaEditor.MetaEditorConfiguration.impl;

import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;

import MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl#getUneditableFeatures <em>Uneditable Features</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl#getRootElement <em>Root Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl#getGraphicalElements <em>Graphical Elements</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl#getInitCanvasWidth <em>Init Canvas Width</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl#getInitCanvasHeight <em>Init Canvas Height</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl#getModelFileExtension <em>Model File Extension</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationImpl#getEditorIconPath <em>Editor Icon Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaEditorConfigurationImpl extends NamedElementImpl implements MetaEditorConfiguration {
	/**
	 * The cached value of the '{@link #getUneditableFeatures() <em>Uneditable Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUneditableFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> uneditableFeatures;

	/**
	 * The cached value of the '{@link #getRootElement() <em>Root Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootElement()
	 * @generated
	 * @ordered
	 */
	protected EClass rootElement;

	/**
	 * The cached value of the '{@link #getGraphicalElements() <em>Graphical Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalElements()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphicalElement> graphicalElements;

	/**
	 * The default value of the '{@link #getInitCanvasWidth() <em>Init Canvas Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitCanvasWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int INIT_CANVAS_WIDTH_EDEFAULT = 1000;

	/**
	 * The cached value of the '{@link #getInitCanvasWidth() <em>Init Canvas Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitCanvasWidth()
	 * @generated
	 * @ordered
	 */
	protected int initCanvasWidth = INIT_CANVAS_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitCanvasHeight() <em>Init Canvas Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitCanvasHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int INIT_CANVAS_HEIGHT_EDEFAULT = 500;

	/**
	 * The cached value of the '{@link #getInitCanvasHeight() <em>Init Canvas Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitCanvasHeight()
	 * @generated
	 * @ordered
	 */
	protected int initCanvasHeight = INIT_CANVAS_HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelFileExtension() <em>Model File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFileExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_FILE_EXTENSION_EDEFAULT = "xmi";

	/**
	 * The cached value of the '{@link #getModelFileExtension() <em>Model File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFileExtension()
	 * @generated
	 * @ordered
	 */
	protected String modelFileExtension = MODEL_FILE_EXTENSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditorIconPath() <em>Editor Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorIconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITOR_ICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditorIconPath() <em>Editor Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorIconPath()
	 * @generated
	 * @ordered
	 */
	protected String editorIconPath = EDITOR_ICON_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaEditorConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorConfigurationPackage.Literals.META_EDITOR_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EStructuralFeature> getUneditableFeatures() {
		if (uneditableFeatures == null) {
			uneditableFeatures = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES);
		}
		return uneditableFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRootElement() {
		if (rootElement != null && rootElement.eIsProxy()) {
			InternalEObject oldRootElement = (InternalEObject)rootElement;
			rootElement = (EClass)eResolveProxy(oldRootElement);
			if (rootElement != oldRootElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__ROOT_ELEMENT, oldRootElement, rootElement));
			}
		}
		return rootElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetRootElement() {
		return rootElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRootElement(EClass newRootElement) {
		EClass oldRootElement = rootElement;
		rootElement = newRootElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__ROOT_ELEMENT, oldRootElement, rootElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GraphicalElement> getGraphicalElements() {
		if (graphicalElements == null) {
			graphicalElements = new EObjectContainmentEList<GraphicalElement>(GraphicalElement.class, this, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS);
		}
		return graphicalElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInitCanvasWidth() {
		return initCanvasWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitCanvasWidth(int newInitCanvasWidth) {
		int oldInitCanvasWidth = initCanvasWidth;
		initCanvasWidth = newInitCanvasWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH, oldInitCanvasWidth, initCanvasWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInitCanvasHeight() {
		return initCanvasHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitCanvasHeight(int newInitCanvasHeight) {
		int oldInitCanvasHeight = initCanvasHeight;
		initCanvasHeight = newInitCanvasHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT, oldInitCanvasHeight, initCanvasHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelFileExtension() {
		return modelFileExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelFileExtension(String newModelFileExtension) {
		String oldModelFileExtension = modelFileExtension;
		modelFileExtension = newModelFileExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION, oldModelFileExtension, modelFileExtension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEditorIconPath() {
		return editorIconPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEditorIconPath(String newEditorIconPath) {
		String oldEditorIconPath = editorIconPath;
		editorIconPath = newEditorIconPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH, oldEditorIconPath, editorIconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS:
				return ((InternalEList<?>)getGraphicalElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES:
				return getUneditableFeatures();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__ROOT_ELEMENT:
				if (resolve) return getRootElement();
				return basicGetRootElement();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS:
				return getGraphicalElements();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH:
				return getInitCanvasWidth();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT:
				return getInitCanvasHeight();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION:
				return getModelFileExtension();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH:
				return getEditorIconPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES:
				getUneditableFeatures().clear();
				getUneditableFeatures().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__ROOT_ELEMENT:
				setRootElement((EClass)newValue);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS:
				getGraphicalElements().clear();
				getGraphicalElements().addAll((Collection<? extends GraphicalElement>)newValue);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH:
				setInitCanvasWidth((Integer)newValue);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT:
				setInitCanvasHeight((Integer)newValue);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION:
				setModelFileExtension((String)newValue);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH:
				setEditorIconPath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES:
				getUneditableFeatures().clear();
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__ROOT_ELEMENT:
				setRootElement((EClass)null);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS:
				getGraphicalElements().clear();
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH:
				setInitCanvasWidth(INIT_CANVAS_WIDTH_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT:
				setInitCanvasHeight(INIT_CANVAS_HEIGHT_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION:
				setModelFileExtension(MODEL_FILE_EXTENSION_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH:
				setEditorIconPath(EDITOR_ICON_PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES:
				return uneditableFeatures != null && !uneditableFeatures.isEmpty();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__ROOT_ELEMENT:
				return rootElement != null;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS:
				return graphicalElements != null && !graphicalElements.isEmpty();
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH:
				return initCanvasWidth != INIT_CANVAS_WIDTH_EDEFAULT;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT:
				return initCanvasHeight != INIT_CANVAS_HEIGHT_EDEFAULT;
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION:
				return MODEL_FILE_EXTENSION_EDEFAULT == null ? modelFileExtension != null : !MODEL_FILE_EXTENSION_EDEFAULT.equals(modelFileExtension);
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH:
				return EDITOR_ICON_PATH_EDEFAULT == null ? editorIconPath != null : !EDITOR_ICON_PATH_EDEFAULT.equals(editorIconPath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == UneditableFeaturesElement.class) {
			switch (derivedFeatureID) {
				case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES: return MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == UneditableFeaturesElement.class) {
			switch (baseFeatureID) {
				case MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES: return MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION__UNEDITABLE_FEATURES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (initCanvasWidth: ");
		result.append(initCanvasWidth);
		result.append(", initCanvasHeight: ");
		result.append(initCanvasHeight);
		result.append(", modelFileExtension: ");
		result.append(modelFileExtension);
		result.append(", editorIconPath: ");
		result.append(editorIconPath);
		result.append(')');
		return result.toString();
	}

} //MetaEditorConfigurationImpl
