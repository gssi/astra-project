/**
 */
package MetaEditor.MetaEditorConfiguration.impl;

import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;
import MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uneditable Features Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.UneditableFeaturesElementImpl#getUneditableFeatures <em>Uneditable Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class UneditableFeaturesElementImpl extends MinimalEObjectImpl.Container implements UneditableFeaturesElement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UneditableFeaturesElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorConfigurationPackage.Literals.UNEDITABLE_FEATURES_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EStructuralFeature> getUneditableFeatures() {
		if (uneditableFeatures == null) {
			uneditableFeatures = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES);
		}
		return uneditableFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES:
				return getUneditableFeatures();
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
			case MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES:
				getUneditableFeatures().clear();
				getUneditableFeatures().addAll((Collection<? extends EStructuralFeature>)newValue);
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
			case MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES:
				getUneditableFeatures().clear();
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
			case MetaEditorConfigurationPackage.UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES:
				return uneditableFeatures != null && !uneditableFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UneditableFeaturesElementImpl
