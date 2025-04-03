/**
 */
package MetaEditor.MetaEditorConfiguration.impl;

import MetaEditor.MetaEditorConfiguration.ConfigurationOptions;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;
import MetaEditor.MetaEditorConfiguration.RotationPosition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl#isBendableElement <em>Bendable Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl#getRotationPositions <em>Rotation Positions</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl#isSelectWithParent <em>Select With Parent</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.ConfigurationOptionsImpl#getZIndexDefault <em>ZIndex Default</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConfigurationOptionsImpl extends MinimalEObjectImpl.Container implements ConfigurationOptions {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationOptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorConfigurationPackage.Literals.CONFIGURATION_OPTIONS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__BENDABLE_ELEMENT, oldBendableElement, bendableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RotationPosition> getRotationPositions() {
		if (rotationPositions == null) {
			rotationPositions = new EDataTypeUniqueEList<RotationPosition>(RotationPosition.class, this, MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ROTATION_POSITIONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__SELECT_WITH_PARENT, oldSelectWithParent, selectWithParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ZINDEX_DEFAULT, oldZIndexDefault, zIndexDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__BENDABLE_ELEMENT:
				return isBendableElement();
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ROTATION_POSITIONS:
				return getRotationPositions();
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__SELECT_WITH_PARENT:
				return isSelectWithParent();
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ZINDEX_DEFAULT:
				return getZIndexDefault();
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
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__BENDABLE_ELEMENT:
				setBendableElement((Boolean)newValue);
				return;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ROTATION_POSITIONS:
				getRotationPositions().clear();
				getRotationPositions().addAll((Collection<? extends RotationPosition>)newValue);
				return;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__SELECT_WITH_PARENT:
				setSelectWithParent((Boolean)newValue);
				return;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ZINDEX_DEFAULT:
				setZIndexDefault((Integer)newValue);
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
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__BENDABLE_ELEMENT:
				setBendableElement(BENDABLE_ELEMENT_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ROTATION_POSITIONS:
				getRotationPositions().clear();
				return;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__SELECT_WITH_PARENT:
				setSelectWithParent(SELECT_WITH_PARENT_EDEFAULT);
				return;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ZINDEX_DEFAULT:
				setZIndexDefault(ZINDEX_DEFAULT_EDEFAULT);
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
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__BENDABLE_ELEMENT:
				return bendableElement != BENDABLE_ELEMENT_EDEFAULT;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ROTATION_POSITIONS:
				return rotationPositions != null && !rotationPositions.isEmpty();
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__SELECT_WITH_PARENT:
				return selectWithParent != SELECT_WITH_PARENT_EDEFAULT;
			case MetaEditorConfigurationPackage.CONFIGURATION_OPTIONS__ZINDEX_DEFAULT:
				return zIndexDefault != ZINDEX_DEFAULT_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(')');
		return result.toString();
	}

} //ConfigurationOptionsImpl
