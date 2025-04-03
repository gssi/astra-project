/**
 */
package MetaEditor.MetaEditorConfiguration.impl;

import MetaEditor.MetaEditorConfiguration.AnchorPoint;
import MetaEditor.MetaEditorConfiguration.ConfigurationOptions;
import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;
import MetaEditor.MetaEditorConfiguration.RotationPosition;

import MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphical Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getUneditableFeatures <em>Uneditable Features</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#isBendableElement <em>Bendable Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getRotationPositions <em>Rotation Positions</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#isSelectWithParent <em>Select With Parent</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getZIndexDefault <em>ZIndex Default</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getElement <em>Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getFxmlPath <em>Fxml Path</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getAnchorPoints <em>Anchor Points</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getIconPath <em>Icon Path</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getNameAttribute <em>Name Attribute</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.GraphicalElementImpl#getContainmentRef <em>Containment Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicalElementImpl extends NamedElementImpl implements GraphicalElement {
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
	 * The default value of the '{@link #isBendableElement() <em>Bendable Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBendableElement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BENDABLE_ELEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBendableElement() <em>Bendable Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBendableElement()
	 * @generated
	 * @ordered
	 */
	protected boolean bendableElement = BENDABLE_ELEMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRotationPositions() <em>Rotation Positions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotationPositions()
	 * @generated
	 * @ordered
	 */
	protected EList<RotationPosition> rotationPositions;

	/**
	 * The default value of the '{@link #isSelectWithParent() <em>Select With Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelectWithParent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SELECT_WITH_PARENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSelectWithParent() <em>Select With Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelectWithParent()
	 * @generated
	 * @ordered
	 */
	protected boolean selectWithParent = SELECT_WITH_PARENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getZIndexDefault() <em>ZIndex Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZIndexDefault()
	 * @generated
	 * @ordered
	 */
	protected static final int ZINDEX_DEFAULT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getZIndexDefault() <em>ZIndex Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZIndexDefault()
	 * @generated
	 * @ordered
	 */
	protected int zIndexDefault = ZINDEX_DEFAULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EClass element;

	/**
	 * The default value of the '{@link #getFxmlPath() <em>Fxml Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFxmlPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FXML_PATH_EDEFAULT = "TBD";

	/**
	 * The cached value of the '{@link #getFxmlPath() <em>Fxml Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFxmlPath()
	 * @generated
	 * @ordered
	 */
	protected String fxmlPath = FXML_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnchorPoints() <em>Anchor Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnchorPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<AnchorPoint> anchorPoints;

	/**
	 * The default value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconPath()
	 * @generated
	 * @ordered
	 */
	protected String iconPath = ICON_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNameAttribute() <em>Name Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute nameAttribute;

	/**
	 * The cached value of the '{@link #getContainmentRef() <em>Containment Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainmentRef()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> containmentRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorConfigurationPackage.Literals.GRAPHICAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBendableElement() {
		return bendableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBendableElement(boolean newBendableElement) {
		boolean oldBendableElement = bendableElement;
		bendableElement = newBendableElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__BENDABLE_ELEMENT, oldBendableElement, bendableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RotationPosition> getRotationPositions() {
		if (rotationPositions == null) {
			rotationPositions = new EDataTypeUniqueEList<RotationPosition>(RotationPosition.class, this, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ROTATION_POSITIONS);
		}
		return rotationPositions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSelectWithParent() {
		return selectWithParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelectWithParent(boolean newSelectWithParent) {
		boolean oldSelectWithParent = selectWithParent;
		selectWithParent = newSelectWithParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__SELECT_WITH_PARENT, oldSelectWithParent, selectWithParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getZIndexDefault() {
		return zIndexDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZIndexDefault(int newZIndexDefault) {
		int oldZIndexDefault = zIndexDefault;
		zIndexDefault = newZIndexDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ZINDEX_DEFAULT, oldZIndexDefault, zIndexDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (EClass)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement(EClass newElement) {
		EClass oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFxmlPath() {
		return fxmlPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFxmlPath(String newFxmlPath) {
		String oldFxmlPath = fxmlPath;
		fxmlPath = newFxmlPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__FXML_PATH, oldFxmlPath, fxmlPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AnchorPoint> getAnchorPoints() {
		if (anchorPoints == null) {
			anchorPoints = new EObjectContainmentEList<AnchorPoint>(AnchorPoint.class, this, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ANCHOR_POINTS);
		}
		return anchorPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIconPath() {
		return iconPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIconPath(String newIconPath) {
		String oldIconPath = iconPath;
		iconPath = newIconPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ICON_PATH, oldIconPath, iconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNameAttribute() {
		if (nameAttribute != null && nameAttribute.eIsProxy()) {
			InternalEObject oldNameAttribute = (InternalEObject)nameAttribute;
			nameAttribute = (EAttribute)eResolveProxy(oldNameAttribute);
			if (nameAttribute != oldNameAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__NAME_ATTRIBUTE, oldNameAttribute, nameAttribute));
			}
		}
		return nameAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetNameAttribute() {
		return nameAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNameAttribute(EAttribute newNameAttribute) {
		EAttribute oldNameAttribute = nameAttribute;
		nameAttribute = newNameAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__NAME_ATTRIBUTE, oldNameAttribute, nameAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EReference> getContainmentRef() {
		if (containmentRef == null) {
			containmentRef = new EObjectResolvingEList<EReference>(EReference.class, this, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__CONTAINMENT_REF);
		}
		return containmentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EStructuralFeature> getUneditableFeatures() {
		if (uneditableFeatures == null) {
			uneditableFeatures = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES);
		}
		return uneditableFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ANCHOR_POINTS:
				return ((InternalEList<?>)getAnchorPoints()).basicRemove(otherEnd, msgs);
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
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES:
				return getUneditableFeatures();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__BENDABLE_ELEMENT:
				return isBendableElement();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ROTATION_POSITIONS:
				return getRotationPositions();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__SELECT_WITH_PARENT:
				return isSelectWithParent();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ZINDEX_DEFAULT:
				return getZIndexDefault();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__FXML_PATH:
				return getFxmlPath();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ANCHOR_POINTS:
				return getAnchorPoints();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ICON_PATH:
				return getIconPath();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__NAME_ATTRIBUTE:
				if (resolve) return getNameAttribute();
				return basicGetNameAttribute();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__CONTAINMENT_REF:
				return getContainmentRef();
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
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES:
				getUneditableFeatures().clear();
				getUneditableFeatures().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__BENDABLE_ELEMENT:
				setBendableElement((Boolean)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ROTATION_POSITIONS:
				getRotationPositions().clear();
				getRotationPositions().addAll((Collection<? extends RotationPosition>)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__SELECT_WITH_PARENT:
				setSelectWithParent((Boolean)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ZINDEX_DEFAULT:
				setZIndexDefault((Integer)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ELEMENT:
				setElement((EClass)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__FXML_PATH:
				setFxmlPath((String)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ANCHOR_POINTS:
				getAnchorPoints().clear();
				getAnchorPoints().addAll((Collection<? extends AnchorPoint>)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ICON_PATH:
				setIconPath((String)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__NAME_ATTRIBUTE:
				setNameAttribute((EAttribute)newValue);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__CONTAINMENT_REF:
				getContainmentRef().clear();
				getContainmentRef().addAll((Collection<? extends EReference>)newValue);
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
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES:
				getUneditableFeatures().clear();
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__BENDABLE_ELEMENT:
				setBendableElement(BENDABLE_ELEMENT_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ROTATION_POSITIONS:
				getRotationPositions().clear();
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__SELECT_WITH_PARENT:
				setSelectWithParent(SELECT_WITH_PARENT_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ZINDEX_DEFAULT:
				setZIndexDefault(ZINDEX_DEFAULT_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ELEMENT:
				setElement((EClass)null);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__FXML_PATH:
				setFxmlPath(FXML_PATH_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ANCHOR_POINTS:
				getAnchorPoints().clear();
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ICON_PATH:
				setIconPath(ICON_PATH_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__NAME_ATTRIBUTE:
				setNameAttribute((EAttribute)null);
				return;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__CONTAINMENT_REF:
				getContainmentRef().clear();
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
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES:
				return uneditableFeatures != null && !uneditableFeatures.isEmpty();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__BENDABLE_ELEMENT:
				return bendableElement != BENDABLE_ELEMENT_EDEFAULT;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ROTATION_POSITIONS:
				return rotationPositions != null && !rotationPositions.isEmpty();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__SELECT_WITH_PARENT:
				return selectWithParent != SELECT_WITH_PARENT_EDEFAULT;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ZINDEX_DEFAULT:
				return zIndexDefault != ZINDEX_DEFAULT_EDEFAULT;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ELEMENT:
				return element != null;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__FXML_PATH:
				return FXML_PATH_EDEFAULT == null ? fxmlPath != null : !FXML_PATH_EDEFAULT.equals(fxmlPath);
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ANCHOR_POINTS:
				return anchorPoints != null && !anchorPoints.isEmpty();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ICON_PATH:
				return ICON_PATH_EDEFAULT == null ? iconPath != null : !ICON_PATH_EDEFAULT.equals(iconPath);
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__NAME_ATTRIBUTE:
				return nameAttribute != null;
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__CONTAINMENT_REF:
				return containmentRef != null && !containmentRef.isEmpty();
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
				case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES: return MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == ConfigurationOptions.class) {
			switch (derivedFeatureID) {
				case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__BENDABLE_ELEMENT: return MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__BENDABLE_ELEMENT;
				case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ROTATION_POSITIONS: return MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ROTATION_POSITIONS;
				case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__SELECT_WITH_PARENT: return MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__SELECT_WITH_PARENT;
				case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ZINDEX_DEFAULT: return MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ZINDEX_DEFAULT;
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
				case MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES: return MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__UNEDITABLE_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == ConfigurationOptions.class) {
			switch (baseFeatureID) {
				case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__BENDABLE_ELEMENT: return MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__BENDABLE_ELEMENT;
				case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ROTATION_POSITIONS: return MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ROTATION_POSITIONS;
				case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__SELECT_WITH_PARENT: return MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__SELECT_WITH_PARENT;
				case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ZINDEX_DEFAULT: return MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT__ZINDEX_DEFAULT;
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
		result.append(" (bendableElement: ");
		result.append(bendableElement);
		result.append(", rotationPositions: ");
		result.append(rotationPositions);
		result.append(", selectWithParent: ");
		result.append(selectWithParent);
		result.append(", zIndexDefault: ");
		result.append(zIndexDefault);
		result.append(", fxmlPath: ");
		result.append(fxmlPath);
		result.append(", iconPath: ");
		result.append(iconPath);
		result.append(')');
		return result.toString();
	}

} //GraphicalElementImpl
