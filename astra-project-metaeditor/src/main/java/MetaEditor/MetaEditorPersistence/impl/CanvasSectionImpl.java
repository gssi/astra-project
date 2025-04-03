/**
 */
package MetaEditor.MetaEditorPersistence.impl;

import MetaEditor.MetaEditorPersistence.CanvasSection;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Canvas Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.CanvasSectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.CanvasSectionImpl#getSectionWidth <em>Section Width</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.CanvasSectionImpl#getSectionHeight <em>Section Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CanvasSectionImpl extends MinimalEObjectImpl.Container implements CanvasSection {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "TBD";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSectionWidth() <em>Section Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSectionWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int SECTION_WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSectionWidth() <em>Section Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSectionWidth()
	 * @generated
	 * @ordered
	 */
	protected int sectionWidth = SECTION_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSectionHeight() <em>Section Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSectionHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int SECTION_HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSectionHeight() <em>Section Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSectionHeight()
	 * @generated
	 * @ordered
	 */
	protected int sectionHeight = SECTION_HEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CanvasSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorPersistencePackage.Literals.CANVAS_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.CANVAS_SECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSectionWidth() {
		return sectionWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSectionWidth(int newSectionWidth) {
		int oldSectionWidth = sectionWidth;
		sectionWidth = newSectionWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_WIDTH, oldSectionWidth, sectionWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSectionHeight() {
		return sectionHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSectionHeight(int newSectionHeight) {
		int oldSectionHeight = sectionHeight;
		sectionHeight = newSectionHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_HEIGHT, oldSectionHeight, sectionHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorPersistencePackage.CANVAS_SECTION__NAME:
				return getName();
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_WIDTH:
				return getSectionWidth();
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_HEIGHT:
				return getSectionHeight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetaEditorPersistencePackage.CANVAS_SECTION__NAME:
				setName((String)newValue);
				return;
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_WIDTH:
				setSectionWidth((Integer)newValue);
				return;
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_HEIGHT:
				setSectionHeight((Integer)newValue);
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
			case MetaEditorPersistencePackage.CANVAS_SECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_WIDTH:
				setSectionWidth(SECTION_WIDTH_EDEFAULT);
				return;
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_HEIGHT:
				setSectionHeight(SECTION_HEIGHT_EDEFAULT);
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
			case MetaEditorPersistencePackage.CANVAS_SECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_WIDTH:
				return sectionWidth != SECTION_WIDTH_EDEFAULT;
			case MetaEditorPersistencePackage.CANVAS_SECTION__SECTION_HEIGHT:
				return sectionHeight != SECTION_HEIGHT_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", sectionWidth: ");
		result.append(sectionWidth);
		result.append(", sectionHeight: ");
		result.append(sectionHeight);
		result.append(')');
		return result.toString();
	}

} //CanvasSectionImpl
